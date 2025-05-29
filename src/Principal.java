import API.ConversorAPI;
import Historial.HistorialConversion;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("************************************************\n" +
                "|    Bienvenido a su conversor de monedas      |\n" +
                "************************************************");

        while (true) {
            mostrarMenu();

            System.out.print("Opción: ");
            int opcion = teclado.nextInt();

            if (opcion < 1 || opcion > 8) {
                System.out.println("Opción inválida. Cerrando el programa...");
                break;
            }

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor de monedas. ¡Hasta pronto!");
                break;
            }

            if (opcion == 8) {
                HistorialConversion.mostrarHistorial();
                continue;
            }

            String from = "";
            String to = "";

            switch (opcion) {
                case 1 -> { from = "USD"; to = "DOP"; }
                case 2 -> { from = "DOP"; to = "USD"; }
                case 3 -> { from = "USD"; to = "ARS"; }
                case 4 -> { from = "ARS"; to = "USD"; }
                case 5 -> { from = "USD"; to = "COP"; }
                case 6 -> { from = "COP"; to = "USD"; }
            }

            System.out.print("Ingresa la cantidad a convertir: ");
            double cantidad = teclado.nextDouble();

            try {
                double tasa = ConversorAPI.obtenerTasaCambio(from, to);
                double resultado = cantidad * tasa;
                System.out.printf(">>> %.2f %s equivalen a %.2f %s%n%n", cantidad, from, resultado, to);
                HistorialConversion.guardarConversion(cantidad, from, resultado, to);
            } catch (Exception e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }
        }

        teclado.close();
    }
      // el menu
    public static void mostrarMenu() {
        System.out.println("""
                Ingresa el número para elegir la conversión deseada:
                
                (1) [USD] Dólar --> [DOP] Peso Dominicano
                (2) [DOP] Peso Dominicano --> [USD] Dólar
                (3) [USD] Dólar --> [ARS] Peso Argentino
                (4) [ARS] Peso Argentino --> [USD] Dólar
                (5) [USD] Dólar --> [COP] Peso Colombiano
                (6) [COP] Peso Colombiano --> [USD] Dólar
                (7) Salir
                (8) Ver historial de conversiones
                """);
    }
}