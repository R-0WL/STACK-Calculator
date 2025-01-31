import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraPostfixTest {
    private CalculadoraPostfix calculadoraVector;
    private CalculadoraPostfix calculadoraArrayList;

    @BeforeEach
    void setUp() {
        calculadoraVector = new CalculadoraPostfix(new StackVector<>());
        calculadoraArrayList = new CalculadoraPostfix(new StackArrayList<>());
    }

    @Test
    void testSuma() {
        assertEquals(15, calculadoraVector.evaluar("1 2 + 4 * 3 +"));
        assertEquals(15, calculadoraArrayList.evaluar("1 2 + 4 * 3 +"));
    }

    @Test
    void testMultiplicacion() {
        assertEquals(30, calculadoraVector.evaluar("6 2 3 + *"));
        assertEquals(30, calculadoraArrayList.evaluar("6 2 3 + *"));
    }

    @Test
    void testModulo() {
        assertEquals(2, calculadoraVector.evaluar("8 3 %"));
        assertEquals(2, calculadoraArrayList.evaluar("8 3 %"));
    }

    @Test
    void testOperacionCompleja() {
        assertEquals(14, calculadoraVector.evaluar("5 1 2 + 4 * + 3 -"));
        assertEquals(14, calculadoraArrayList.evaluar("5 1 2 + 4 * + 3 -"));
    }

    @Test
    void testDivisionEntera() {
        assertEquals(4, calculadoraVector.evaluar("10 5 / 2 *"));
        assertEquals(4, calculadoraArrayList.evaluar("10 5 / 2 *"));
    }

    @Test
    void testRestaNegativa() {
        assertEquals(-10, calculadoraVector.evaluar("7 2 3 + - 5 *"));
        assertEquals(-10, calculadoraArrayList.evaluar("7 2 3 + - 5 *"));
    }

    @Test
    void testErrorDivCero() {
        Exception e = assertThrows(ArithmeticException.class, () -> {
            calculadoraVector.evaluar("5 0 /");
        });
        assertEquals("División por cero", e.getMessage());

        Exception e2 = assertThrows(ArithmeticException.class, () -> {
            calculadoraArrayList.evaluar("5 0 /");
        });
        assertEquals("División por cero", e2.getMessage());
    }

    @Test
    void testErrorOperandosInsuficientes() {
        Exception e = assertThrows(RuntimeException.class, () -> {
            calculadoraVector.evaluar("5 +");
        });
        assertEquals("Error: Operandos insuficientes.", e.getMessage());

        Exception e2 = assertThrows(RuntimeException.class, () -> {
            calculadoraArrayList.evaluar("5 +");
        });
        assertEquals("Error: Operandos insuficientes.", e2.getMessage());
    }

    @Test
    void testErrorExpresionInvalida() {
        Exception e = assertThrows(RuntimeException.class, () -> {
            calculadoraVector.evaluar("5 1 2 +");
        });
        assertEquals("Error: Expresión inválida.", e.getMessage());

        Exception e2 = assertThrows(RuntimeException.class, () -> {
            calculadoraArrayList.evaluar("5 1 2 +");
        });
        assertEquals("Error: Expresión inválida.", e2.getMessage());
    }

    @Test
    void testOperadorDesconocido() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            calculadoraVector.evaluar("5 1 &");
        });
        assertEquals("Operador desconocido: &", e.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> {
            calculadoraArrayList.evaluar("5 1 &");
        });
        assertEquals("Operador desconocido: &", e2.getMessage());
    }
}
