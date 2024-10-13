package tarea_psp_01;

/**
 * Segunda parte: implementa una aplicación, llamada 'colaborar', 
 * que lance al menos 10 instancias de la aplicación "lenguaje". 
 * Haciendo que todas ellas, colaboren en generar un gran fichero de palabras.\
 * Cada instancia generará un número creciente de palabras de 10, 20, 30, … 
 * Por supuesto, cada proceso seguirá escribiendo su palabra en una línea 
 * independiente de las otras. 
 * Es decir, si lanzamos 10 instancias de "lenguaje", al final,
 * debemos tener en el fichero 10 + 20 + 30 + … + 100 = 550 líneas.
 * 
 * @author nacho limetre
 */
public class Colaborar {
    public static void main(String[] args) {
          Process nuevoProceso; //Definimos una variable de tipo Process
        try{
           
            
            
                nuevoProceso = Runtime.getRuntime().exec("java "+
                   "/Users/nacho/Documents/DAM-Chan_Monte-2425/PSP/git/MP0490-PSP/MP0490-PSP/src/tarea_psp_01/Lenguaje.java" + " 40 texto.txt");
            
            System.out.println("Fin.");
        }catch (SecurityException ex){
            System.out.println("Ha ocurrido un error de Seguridad."+
                    "No se ha podido crear el proceso por falta de permisos.");
        }catch (Exception ex){
            System.out.println("Ha ocurrido un error, descripción: "+
                    ex.toString());
        }
    }
}
