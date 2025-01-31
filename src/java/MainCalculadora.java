import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainCalculadora {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackVector<>(); // Cambia a StackArrayList<> si quieres
        CalculadoraPostfix calculadora = new CalculadoraPostfix(stack);

        try (Scanner scanner = new Scanner(new File("datos.txt"))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                try {
                    int resultado = calculadora.evaluar(linea);
                    System.out.println("Resultado: " + resultado);
                } catch (Exception e) {
                    System.err.println("Error al evaluar la expresión: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo datos.txt no encontrado.");
        }
    }
}
