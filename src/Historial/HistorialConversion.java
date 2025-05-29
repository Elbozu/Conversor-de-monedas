package Historial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HistorialConversion {
    private static final String NOMBRE_ARCHIVO = "historial_conversiones.txt";

    public static void guardarConversion(double cantidad, String from, double resultado, String to) {
        try (FileWriter escritor = new FileWriter(NOMBRE_ARCHIVO, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String linea = String.format("[%s] %.2f %s --> %.2f %s%n", timestamp, cantidad, from, resultado, to);
            escritor.write(linea);
        } catch (IOException e) {
            System.out.println("Error al guardar en el historial: " + e.getMessage());
        }
    }

    public static void mostrarHistorial() {
        File archivo = new File(NOMBRE_ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("No hay historial disponible.");
            return;
        }

        System.out.println("\n=== HISTORIAL DE CONVERSIONES ===\n");
        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo de historial.");
        }
        System.out.println("\n*****************************\n");
    }
}
