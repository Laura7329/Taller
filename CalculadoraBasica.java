import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Una calculadora básica que realiza operaciones de suma, resta, multiplicación y división.
 * Permite al usuario ingresar dos números y seleccionar una operación,
 * mostrando el resultado. El usuario puede realizar múltiples cálculos.
 */
public class CalculadoraBasica {

    /**
     * Suma dos números.
     * @param a El primer número.
     * @param b El segundo número.
     * @return La suma de a y b.
     */
    public static double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Resta el segundo número del primero.
     * @param a El primer número.
     * @param b El segundo número (a sustraer).
     * @return La diferencia entre a y b.
     */
    public static double restar(double a, double b) {
        return a - b;
    }

    /**
     * Multiplica dos números.
     * @param a El primer número.
     * @param b El segundo número.
     * @return El producto de a y b.
     */
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Divide el primer número por el segundo.
     * @param a El dividendo.
     * @param b El divisor.
     * @return El resultado de la división.
     * @throws IllegalArgumentException si el divisor (b) es cero.
     */
    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Error: No se puede dividir por cero.");
        }
        return a / b;
    }

    /**
     * Método principal para ejecutar la aplicación de calculadora.
     * Maneja la entrada del usuario para los números y la operación,
     * realiza el cálculo y muestra el resultado. Permite múltiples operaciones.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = 0, num2 = 0;
        String operacion;
        String continuar;

        System.out.println("Calculadora Basica");

        do {
            // Get first number
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Ingrese el primer número: ");
                    num1 = scanner.nextDouble();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    scanner.next(); // Consume the invalid input
                }
            }

            // Get second number
            validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Ingrese el segundo número: ");
                    num2 = scanner.nextDouble();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    scanner.next(); // Consume the invalid input
                }
            }

            // Get operation
            System.out.println("Seleccione la operación a realizar:");
            System.out.println("  + : Sumar");
            System.out.println("  - : Restar");
            System.out.println("  * : Multiplicar");
            System.out.println("  / : Dividir");
            System.out.print("Ingrese la operación (+, -, *, /): ");
            operacion = scanner.next();

            double resultado = 0;
            boolean operacionValida = true;

            try {
                switch (operacion) {
                    case "+":
                        resultado = sumar(num1, num2);
                        break;
                    case "-":
                        resultado = restar(num1, num2);
                        break;
                    case "*":
                        resultado = multiplicar(num1, num2);
                        break;
                    case "/":
                        resultado = dividir(num1, num2); 
                        break;
                    default:
                        System.out.println("Operación no válida.");
                        operacionValida = false;
                        break;
                }

                if (operacionValida) {
                    System.out.println("El resultado es: " + resultado);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Display the message from the exception
            }
            
            System.out.print("¿Desea realizar otra operación? (s/n): ");
            continuar = scanner.next();

        } while (continuar.equalsIgnoreCase("s"));
        
        System.out.println("Gracias por usar la Calculadora Basica.");
        scanner.close(); 
    }
}
