import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

/**
 * A program that allows users to input data entries and assign a color
 * (rojo, azul, morado) to each. It then displays the total count for each color.
 */
public class ColorCounter {

    /**
     * Represents a single data entry with an associated color.
     */
    private static class DataItem {
        private String data;
        private String color;

        /**
         * Constructs a DataItem with specified data and color.
         * @param data The data string.
         * @param color The color string (e.g., "rojo", "azul", "morado").
         */
        public DataItem(String data, String color) {
            this.data = data;
            this.color = color;
        }

        /**
         * Gets the data string of this item.
         * @return The data string.
         */
        public String getData() {
            return data;
        }

        /**
         * Gets the color string of this item.
         * @return The color string.
         */
        public String getColor() {
            return color;
        }
    }

    private static List<DataItem> dataItems = new ArrayList<>();

    /**
     * Main method to run the color counting application.
     * It prompts the user for data and color inputs, counts the occurrences
     * of each color, and displays the results.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputData;
        String inputColor;

        System.out.println("Ingrese los datos y sus colores. Escriba 'salir' en el dato para terminar.");

        while (true) {
            System.out.print("Ingrese el dato: ");
            inputData = scanner.nextLine();

            if (inputData.equalsIgnoreCase("salir")) {
                break;
            }

            while (true) {
                System.out.print("Seleccione un color (rojo, azul, morado): ");
                inputColor = scanner.nextLine().toLowerCase(Locale.ROOT);
                if (inputColor.equals("rojo") || inputColor.equals("azul") || inputColor.equals("morado")) {
                    break;
                } else {
                    System.out.println("Color inválido. Intente de nuevo.");
                }
            }
            
            dataItems.add(new DataItem(inputData, inputColor));
            System.out.println("Dato agregado.");
        }
        
        System.out.println("Entrada de datos finalizada.");

        int countRojo = 0;
        int countAzul = 0;
        int countMorado = 0;

        for (DataItem item : dataItems) {
            String color = item.getColor();
            if (color.equals("rojo")) {
                countRojo++;
            } else if (color.equals("azul")) {
                countAzul++;
            } else if (color.equals("morado")) {
                countMorado++;
            }
        }
        
        System.out.println("\n--- Resumen de Colores ---");
        System.out.println("Cantidad de Rojo: " + countRojo);
        System.out.println("Cantidad de Azul: " + countAzul);
        System.out.println("Cantidad de Morado: " + countMorado);

        scanner.close();
    }
}
