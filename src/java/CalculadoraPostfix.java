public class CalculadoraPostfix {
    private Stack<Integer> stack;

    public CalculadoraPostfix(Stack<Integer> stack) {
        this.stack = stack;
    }

    public int evaluar(String expresion) {
        String[] tokens = expresion.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) { // Si es un número
                stack.push(Integer.parseInt(token));
            } else {
                if (stack.size() < 2) {
                    throw new RuntimeException("Error: Operandos insuficientes.");
                }
                int num2 = stack.pop();
                int num1 = stack.pop();

                switch (token) {
                    case "+": stack.push(num1 + num2); break;
                    case "-": stack.push(num1 - num2); break;
                    case "*": stack.push(num1 * num2); break;
                    case "/": 
                        if (num2 == 0) throw new ArithmeticException("División por cero");
                        stack.push(num1 / num2);
                        break;
                    case "%": stack.push(num1 % num2); break;
                    default: throw new IllegalArgumentException("Operador desconocido: " + token);
                }
            }
        }
        if (stack.size() != 1) {
            throw new RuntimeException("Error: Expresión inválida.");
        }
        return stack.pop();
    }
}
