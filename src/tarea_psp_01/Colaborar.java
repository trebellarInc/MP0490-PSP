package tarea_psp_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Segunda parte: implementa una aplicación, llamada 'colaborar', que lance al
 * menos 10 instancias de la aplicación "lenguaje". Haciendo que todas ellas,
 * colaboren en generar un gran fichero de palabras.\ Cada instancia generará un
 * número creciente de palabras de 10, 20, 30, … Por supuesto, cada proceso
 * seguirá escribiendo su palabra en una línea independiente de las otras. Es
 * decir, si lanzamos 10 instancias de "lenguaje", al final, debemos tener en el
 * fichero 10 + 20 + 30 + … + 100 = 550 líneas.
 *
 * @author nacho limetre
 */
public class Colaborar {

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
                //builder.command("java", "/Users/nacho/Documents/DAM-Chan-24-25/MP0490-Programacion_servizos_procesos/TareaPSP01/src/tarea_psp_01/Lenguaje.java", String.valueOf(numPalabras), "text.txt");
                builder.command("java", "-jar", "lenguaje.jar", String.valueOf(numPalabras), "palabras.txt");
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
                numPalabras = numPalabras+10;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
