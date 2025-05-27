import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Un programa simple para sumar dos números enteros ingresados por el usuario.
 */
public class Sumador {

    /**
     * Método principal para ejecutar el programa sumador.
     * Solicita dos números enteros al usuario, calcula su suma y muestra el resultado.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        boolean inputValido = false;

        System.out.println("Programa Sumador de dos números enteros");

        // Solicitar el primer número
        while (!inputValido) {
            try {
                System.out.print("Ingrese el primer número entero: ");
                num1 = scanner.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next(); // Consumir la entrada incorrecta para evitar un bucle infinito
            }
        }

        inputValido = false; // Resetear para el segundo número
        // Solicitar el segundo número
        while (!inputValido) {
            try {
                System.out.print("Ingrese el segundo número entero: ");
                num2 = scanner.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next(); // Consumir la entrada incorrecta
            }
        }

        // Calcular la suma
        int suma = num1 + num2;

        // Mostrar el resultado
        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + suma);

        // Cerrar el scanner
        scanner.close();
    }
}
