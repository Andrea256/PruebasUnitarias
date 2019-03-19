
package com.udec.mapas;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author buscararchivo
 */
public class Persona 
{
    private int identificacion;
    
    private String nombre;
    
    private String apellido;
    
    private Map<Integer, Persona> descendientes;

    
    /**
     * Constructor de la clase Persona.
     * @param identificacion guarda la identificacion de la persona.
     * @param nombre guarda el nombre de la persona.
     * @param apellido  guarda el apellido de la persona.
     */
    
    public Persona(int identificacion, String nombre, String apellido) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descendientes = new HashMap<>();
    }
    
    /**
     * Constructor de la clase Persona con el mapa.
     * @param identificacion guarda la identificacion de la persona.
     * @param nombre guarda el nombre de la persona.
     * @param apellido guarda el apellido de la persona.
     * @param descendientes guarda la informacion en el mapa.
     */
    
    public Persona(int identificacion, String nombre, String apellido, Map<Integer, Persona> descendientes) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descendientes = descendientes;
    }

    /**
     * Getter y Setters 
     */
    
    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Map<Integer, Persona> getDescendientes() {
        return descendientes;
    }

    public void setDescendientes(Map<Integer, Persona> descendientes) {
        this.descendientes = descendientes;
    }
}
