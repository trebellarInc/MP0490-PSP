package tarea_psp_01;

import java.util.ArrayList;
import java.util.Random;

/**
 * Segunda parte: implementa una aplicación, llamada 'aleatorios', que genere al
 * menos 40 números aleatorios (entre 0 y 100), y que los escriba en su salida
 * estándar.
 *
 * @author nacho limetre
 */
public class Aleatorios {

    public static void main(String[] args) {
        ArrayList<Integer> listaNumeros = new ArrayList<>();

        Random random = new Random();
        int nNumeros = 40;

        // Generar un número aleatorio entre 1 y 100
        for (int i = 1; i <= nNumeros; i++) {
            listaNumeros.add(random.nextInt(100) + 1);
            //System.out.println(i);
        }

        System.out.println("Números aleatorios:");
        for (int numero : listaNumeros) {
            System.out.println(numero);
        }

    }
}
