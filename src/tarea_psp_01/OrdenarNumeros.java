package tarea_psp_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Primera parte: implementa una aplicación que ordena un conjunto indeterminado
 * de números que recibe a través de su entrada estándar; y muestra el resultado
 * de la ordenación en su salida estándar. La aplicación se llamará
 * 'ordenarNumeros'.
 *
 * @author nacho limetre
 */
public class OrdenarNumeros {

    public static void main(String[] args) {
        // Creamos un escáner para leer la entrada desde el teclado
        Scanner teclado = new Scanner(System.in);

        // Creamos una lista para almacenar los números
        ArrayList<Integer> listaNumeros = new ArrayList<>();

        System.out.println("Introduce un numero a ordenar\n('salir' para terminar):");

        // Ciclo para capturar los números de la entrada estándar
        while (teclado.hasNext()) {
            String entrada = teclado.next();

            if (entrada.equalsIgnoreCase("salir")) {
                break; // Si el usuario ingresa "fin", terminamos el ciclo
            }

            try {
                // Intentamos convertir el input a un número
                int numero = Integer.parseInt(entrada);
                listaNumeros.add(numero);
            } catch (NumberFormatException e) {
                System.out.println("Entrada = "+ entrada);
                System.out.println("Introduce un número válido\n('salir' para terminar):");
            }
        }

        // Ordenamos la lista de números
        Collections.sort(listaNumeros);

        // Envia a la salida los la lista ordenada
        System.out.println("Números ordenados:");
        for (int numero : listaNumeros) {
            System.out.println(numero);
        }
        System.out.println("Fin");
    }

}
