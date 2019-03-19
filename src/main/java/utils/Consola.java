
package utils;

import java.util.Scanner;

/**
 *
 * @author Holmes Yesid Ayala
 */
public class Consola {
    
    private Consola()
    {
        
    }
    
    public static void imprimirError(String error)
    {
        System.out.printf("\n%s\n", error);
    }
    
    public static void imprimirBloqueEspacios()
    {
        for(byte i = 0; i < 10; i++)
            System.out.println("");
    }
    
    public static void imprimirSeparador()
    {
        //System.out.println("\n=========================\n");
        System.out.printf("\n%s\n\n", "========================================");
    }
    
    public static void presionarParaContinuar()
    {
        System.out.println("\nPresione enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
    }
}
