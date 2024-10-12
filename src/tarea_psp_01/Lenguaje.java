package tarea_psp_01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Primera parte: implementa una aplicación que escriba en un fichero indicado
 * por el usuario conjuntos de letras generadas de forma aleatoria (sin sentido
 * real). Escribiendo cada conjunto de letras en una línea distinta. El número
 * de conjuntos de letras a generar por el proceso, también será dado por el
 * usuario en el momento de su ejecución. Esta aplicación se llamará "lenguaje"
 * y como ejemplo, podrá ser invocada así: java -jar lenguaje 40
 * miFicheroDeLenguaje.txt Indicando que se generarán 40 palabras del lenguaje y
 * serán guardadas en miFicheroDeLenguaje.txt
 *
 * @author nacho limetre
 */
public class Lenguaje {

    public static void main(String[] args) {

        int numPalabras = 10;
        int tamanoPalabrasMax = 5;
        String nombreFichero;

        if (args.length != 2) {
            System.out.println("java -jar lenguaje <número de palabras> <nombre del fichero>");
            return;
        } else {
            try {
                numPalabras = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("El parametro numero de palabras tiene que se un numero");
            }
        }

        nombreFichero = args[1];

        for (int i = 0; i < numPalabras; i++) {
            escribirArchivo(palabra(tamanoPalabrasMax), nombreFichero);
        }

    }

    private static String palabra(int tamanoMax) {
        Random aleatorio = new Random();
        String palabra = "";
        char letra;
        int tamano = aleatorio.nextInt(tamanoMax) + 1;

        for (int i = 0; i < tamano; i++) {

            if (aleatorio.nextInt(2) == 0) {
                letra = (char) (aleatorio.nextInt(26) + 'a');
            } else {
                letra = (char) (aleatorio.nextInt(26) + 'A');
            }
            palabra = palabra + letra;
        }
        //System.out.println(palabra);
        return palabra;
    }

    private static void escribirArchivo(String palabra, String archivo) {

        System.out.println("Escribiendo la palabra \"" + palabra + "\" en el archivo -> " + archivo);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));

            bw.write(palabra + "\n");
            bw.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
