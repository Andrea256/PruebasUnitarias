
package com.udec.mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import utils.Consola;

/**
 *
 * @author buscararchivo
 * @author AndreaOrjuela
 */

public class Controlador 
{
    
    private Scanner scanner;
    
    private HashMap<Integer, Persona> mapAbuelos;
    
    ArrayList<String> ppp = new ArrayList<String>();
    
    public Controlador() 
    {
        scanner = new Scanner(System.in);
        inicialializarDatos();
        
    }
    
    /**
     * Metodo donde se queman los datos.
     */
    
    public void inicialializarDatos()
    {
      
        List<Persona> listHijos = new ArrayList<>();
        
        listHijos.add(new Persona(9, "Juana", "x"));
        listHijos.add(new Persona(10, "Paola", "x"));
        listHijos.add(new Persona(11, "Sofia", "x"));
        listHijos.add(new Persona(12, "Jaime", "x"));
        listHijos.add(new Persona(13, "Tatiana", "x"));
        listHijos.add(new Persona(14, "Fernanda", "x"));
        listHijos.add(new Persona(15, "Viviana", "x"));
        listHijos.add(new Persona(16, "Diana", "x"));
        
        
        Persona andres = new Persona(3, "Andres", "x");
        andres.getDescendientes().put(listHijos.get(0).getIdentificacion(), listHijos.get(0));
        andres.getDescendientes().put(listHijos.get(1).getIdentificacion(), listHijos.get(1));
        
        Persona maria = new Persona(4, "Maria", "x");
        maria.getDescendientes().put(listHijos.get(2).getIdentificacion(), listHijos.get(2));
        
        Persona carlos = new Persona(5, "Carlos", "x");
        carlos.getDescendientes().put(listHijos.get(3).getIdentificacion(), listHijos.get(3));
        
        
        Persona alberto = new Persona(6, "Alberto", "x");
        alberto.getDescendientes().put(listHijos.get(4).getIdentificacion(), listHijos.get(4));
        alberto.getDescendientes().put(listHijos.get(5).getIdentificacion(), listHijos.get(5));
        
        Persona jimmy = new Persona(7, "Jimmy", "x");
        jimmy.getDescendientes().put(listHijos.get(6).getIdentificacion(), listHijos.get(6));
        
        Persona jhon = new Persona(8, "Jhon", "x");
        jhon.getDescendientes().put(listHijos.get(7).getIdentificacion(), listHijos.get(7));
        
        
        Persona juan = new Persona(1, "Juan", "x");
        juan.getDescendientes().put(andres.getIdentificacion(), andres);
        juan.getDescendientes().put(maria.getIdentificacion(), maria);
        juan.getDescendientes().put(carlos.getIdentificacion(), carlos);
        
        Persona jose = new Persona(2, "Jose", "x");
        jose.getDescendientes().put(alberto.getIdentificacion(), alberto);
        jose.getDescendientes().put(jimmy.getIdentificacion(), jimmy);
        jose.getDescendientes().put(jhon.getIdentificacion(), jhon);
        
        mapAbuelos = new HashMap<>();
        
        mapAbuelos.put(juan.getIdentificacion(), juan);
        mapAbuelos.put(jose.getIdentificacion(), jose);
    }
    
    public void start()
    {
        viewMenu();
    }
    
    /**
     * Metodo del menu. 
     */
    
    public void viewMenu()
    {
        while (true)
        {
            Consola.imprimirBloqueEspacios();
            
            Consola.imprimirSeparador();
            System.out.println("Menu de consultas");
            Consola.imprimirSeparador();

            System.out.println("1) Ingresar cedula");
            System.out.println("2) Salir");
            
            System.out.println();
            System.out.print("Seleccion: ");

            String seleccion = scanner.nextLine().trim();

            switch(seleccion)
            {
                case "1":
                    solicitarIdentificacion();
                    break;
                case "2":
                    return;
                default:
                    Consola.imprimirError("Opcion no valida!");
                    Consola.presionarParaContinuar();
            }
        }
    }
    
    /**
     * Metodo para solicitar el id a buscar. 
     */
    
    public void solicitarIdentificacion()
    {
        Consola.imprimirBloqueEspacios();

        Consola.imprimirSeparador();
        System.out.println("Ingreso de identificacion");
        Consola.imprimirSeparador();
        
        System.out.println();
        System.out.print("Identificacion: ");
        
        String identificacion = scanner.nextLine().trim();
        
        getTipoDescendencia(mapAbuelos, Integer.parseInt(identificacion));
        
        //System.out.println(tipo);
    }
    
    /**
     * 
     * @param mapAbuelos Trae el mapa de los abuelos para recorrerlo.
     * @param identificacion Parametro que se digito para buscar.
     * @return Un array para poder hacer las pruebas.
     */
    
    public ArrayList <String> getTipoDescendencia(HashMap<Integer, Persona> mapAbuelos ,int identificacion)
    {
        boolean antecesorAbuelo = false;
        boolean antecesorPapa = false;
        boolean encontrado = false;
        
        for(Integer idAbuelo : mapAbuelos.keySet())
        {
            Persona abuelo = mapAbuelos.get(idAbuelo);
            
            if(abuelo.getIdentificacion() == identificacion)
            {
                printPersona(abuelo, "");
                ppp.add(abuelo.getNombre());
                
                antecesorAbuelo = true;
                encontrado = true;
            }
            
            for(Integer idPapa : abuelo.getDescendientes().keySet())
            {
                Persona papa = abuelo.getDescendientes().get(idPapa);
                
                if(antecesorAbuelo)
                {
                    printPersona(papa, "    ");
                    ppp.add(papa.getNombre());
                }
                else if(papa.getIdentificacion() == identificacion)
                {
                    printPersona(abuelo, "");
                    ppp.add(abuelo.getNombre());
                    printPersona(papa, "    ");
                    ppp.add(papa.getNombre());
                    antecesorPapa = true;
                    encontrado = true;
                }
                
                for(Integer idHijo : papa.getDescendientes().keySet())
                {
                    Persona hijo = papa.getDescendientes().get(idHijo);
                    
                    if(antecesorAbuelo || antecesorPapa)
                    {
                        printPersona(hijo, "        ");
                        ppp.add(hijo.getNombre());
                    }
                    else if(hijo.getIdentificacion() == identificacion)
                    {
                        printPersona(abuelo, "");
                        ppp.add(abuelo.getNombre());
                        printPersona(papa, "  ");
                        ppp.add(papa.getNombre());
                        printPersona(hijo, "    ");
                        ppp.add(hijo.getNombre());
                        encontrado = true;
                    }
                }
                
                if(antecesorPapa) antecesorPapa = false;
            }
            
            if(antecesorAbuelo) antecesorAbuelo = false;
        }
        
        if(!encontrado)
            Consola.imprimirError("Persona no exite");
        
        //Consola.presionarParaContinuar();
        
        return ppp;
    }
    
    /**
     * 
     * @param p atributo de la clase Persona.
     * @param identacion Atributo de identificacion.
     */
    
    public void printPersona(Persona p, String identacion)
    {
        System.out.printf("%s id: %-10d Nombre: %-10s Apellido: %-10s \n",
                identacion,
                p.getIdentificacion(),
                p.getNombre(),
                p.getApellido());
    }
}
