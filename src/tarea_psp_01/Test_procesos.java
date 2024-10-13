package tarea_psp_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author nacho
 */
public class Test_procesos {

    public static void main(String[] args) {
        int numPalabras = 10;
        int numInstancias = 10;
        // Usamos ProcessBuilder para lanzar el comando "ping"
        ProcessBuilder builder = new ProcessBuilder();
        //builder.command("java", "/Users/nacho/Documents/DAM-Chan-24-25/MP0490-Programacion_servizos_procesos/TareaPSP01/src/tarea_psp_01/Lenguaje.java", String.valueOf(numPalabras), "text.txt");

        try {
            for (int i = 0; i < numInstancias; i++) {
                System.out.println("Instancia -> " + (i + 1));
                //builder.command("java","/Users/nacho/Documents/DAM-Chan-24-25/PSP/git/MP0490-PSP/src/tarea_psp_01/Lenguaje.java", String.valueOf(numPalabras) ,"text.txt"); 
                builder.command("java", "/Users/nacho/Documents/DAM-Chan-24-25/MP0490-Programacion_servizos_procesos/TareaPSP01/src/tarea_psp_01/Lenguaje.java", String.valueOf(numPalabras), "text.txt");
                // Lanzar el proceso
                Process proceso = builder.start();
                // Leer la salida estándar del proceso
                BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);  // Imprimir cada línea de la salida
                }

                // Esperar a que el proceso termine y obtener su código de salida
                int exitCode = proceso.waitFor();
                System.out.println("\nProceso finalizado con código: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
