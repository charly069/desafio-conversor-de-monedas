import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        HistorialConversiones historial = new HistorialConversiones();

        while (true) {
            // Solicitar moneda base al usuario
            System.out.println("**********************************************");
            System.out.println("Ingrese la moneda base (por ejemplo, USD): ");
            String monedaBase = scanner.nextLine().toUpperCase(); // Convertir a mayúsculas para estandarizar
            consulta.setMonedaBase(monedaBase);

            // Solicitar moneda objetivo al usuario
            System.out.println("Ingrese la moneda objetivo (por ejemplo, COP): ");
            String monedaObjetivo = scanner.nextLine().toUpperCase(); // Convertir a mayúsculas para estandarizar
            consulta.setMonedaObjetivo(monedaObjetivo);

            // Solicitar el valor de la conversión al usuario (decimal)
            while (true) {
                System.out.println("Ingrese el valor a convertir (número decimal con punto, 'salir' para terminar o 'cambiar' para volver a escoger divisas): ");
                String input = scanner.nextLine();

                // Verificar si el usuario desea salir
                if (input.equalsIgnoreCase("salir")) {
                    System.out.println("Saliendo del programa...");
                    System.out.println("**********************************************");
                    System.out.println("**********************************************");
                    historial.mostrarHistorial();
                    scanner.close();
                    return;
                }
                if (input.equalsIgnoreCase("cambiar")) {
                    System.out.println("Regresando para seleccionar nuevas divisas...");
                    break; // Salir del bucle interno para permitir al usuario seleccionar nuevas divisas
                }

                try {
                    // Intentar convertir el valor ingresado a un número decimal
                    double valorDeLaConversion = Double.parseDouble(input);
                    consulta.setValorDeLaConversion(valorDeLaConversion);

                    // Realizar la consulta
                    Moneda resultado = consulta.buscaMoneda();
                    System.out.println("**********************************************");
                    System.out.println("El resultado de la conversion de moneda es : " + resultado);
                    System.out.println("**********************************************");

                    historial.agregarConversion(resultado);
                } catch (NumberFormatException e) {
                    // Manejo de errores para entradas no válidas
                    System.out.println("Entrada inválida. Por favor, ingrese un número decimal o 'salir'.");
                } catch (RuntimeException e) {
                    // Manejo de errores para problemas con la API
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}