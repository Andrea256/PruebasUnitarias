/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.udec.mapas.Controlador;
import com.udec.mapas.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Consola;

/**
 *
 * @author AndreaOrjuela
 */
public class TestUnitario {
    
    private static HashMap<Integer, Persona> mapAbuelos;
    static Controlador cont;
    static Persona pers;
    static ArrayList <String> mapResp;
    static ArrayList <String> mapComp;
    
    public TestUnitario() {
        System.out.println("Prueba");
    }
    
    /*
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Antes de la clase");     
    }*/
    
    @BeforeClass
    public static void datos(){
        
        cont = new Controlador();
        mapAbuelos = new HashMap<>();
        mapComp = new ArrayList<String>();
        mapResp = new ArrayList<String>();
        
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
        
        //System.out.println("mapa " + mapAbuelos.get(listHijos));
    }
    
    /**
     * Se inicializan las variables.
     */
    
    @AfterClass
    public static void tearDownClass() {
        cont = null;
        pers = null;
        mapAbuelos = null;
        mapComp = null;
        mapResp = null;
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /**
     * Primera prueba unitaria.
     */ 
    
    @Test
    public void ImpPruebaAbuelo (){
        
        System.out.println("Prueba Abuelo");
        
        mapComp.add("Juan");
        mapComp.add("Andres");
        mapComp.add("Juana");        
        mapComp.add("Paola");
        mapComp.add("Maria");
        mapComp.add("Sofia");
        mapComp.add("Carlos");
        mapComp.add("Jaime");
        
        mapResp = cont.getTipoDescendencia(mapAbuelos, 1);
        
        assertEquals(mapResp, mapComp);
        
    }
    
    /**
     * Segunda prueba unitaria.
     */ 
    
    @Test
    public void ImpPruebaPapa (){
        
        System.out.println("Prueba Papa");
        
        mapComp.add("Jose");
        mapComp.add("Jimmy");
        mapComp.add("Viviana");        
        
        mapResp = cont.getTipoDescendencia(mapAbuelos, 7);
        
        assertEquals(mapResp, mapComp);
        
    }
    
    /**
     * Tercera prueba unitaria.
     */ 
    
    @Test
    public void ImpPruebaHijo (){
        
        System.out.println("Prueba Hijo");
        
        mapComp.add("Juan");
        mapComp.add("Maria");
        mapComp.add("Sofia");        
        
        mapResp = cont.getTipoDescendencia(mapAbuelos, 11);
        
        assertEquals(mapResp, mapComp);
        
    }
    
    /**
     * Cuarta prueba unitaria.
     */ 
    
    @Test
    public void pruebaNotNull(){
        
        System.out.println("Prueba No nula");
        
        assertNotNull(mapComp);
        System.out.println("    "+mapComp);
        
    }
    
    /**
     * Quinta prueba unitaria.
     */ 
    
    @Test
    public void pruebaNotEqual(){
        
        System.out.println("Prueba No igual");
        mapComp.add("Andrea");
        mapComp.add("Orjuela");
        
        mapResp = cont.getTipoDescendencia(mapAbuelos, 16);
        
        assertNotEquals(mapComp, mapResp);
        System.out.println("" + mapComp);
    }
    
}
