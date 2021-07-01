/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;
import Usuarios.*;

/**
 *
 * @author jeras
 */
public class Casa extends Propiedad {
    private int numPisos;
    private int habitaciones;

    /* Herencia --> Para construir una Casa se aplica a herencia y hereda el constructor de la SuperClase Propiedad y
    aniade los atributos propios de casa
    */
    public Casa(int numPisos, int habitaciones, double precio, double m2, double profundidad, String ubicacion, int id, boolean estadoVenta, boolean consultado, String Agente) {
        super(precio, m2, profundidad, ubicacion, id, estadoVenta, consultado, Agente);
        this.numPisos = numPisos;
        this.habitaciones = habitaciones;
    }
    
    /*Herencia y OverWrite = llama al constructor de la SuperClase que solo recibe 5 parámetros
    y aplica sobre-escritura al constructor Casa donde solo añade el numPisos y Habitaciones
    */
    public Casa(int numPisos, int habitaciones, double precio, double m2, double profundidad, String ubicacion, int id, String Agente){
        super(precio, m2, profundidad, ubicacion, id, Agente);
        this.numPisos = numPisos;
        this.habitaciones = habitaciones;
    }

    public Casa(int numPisos, int numhabitaciones, double precio, double m2, double profundidad, String ubicacion) {
        super(precio, m2, profundidad, ubicacion);
        this.numPisos=numPisos;
        this.habitaciones=habitaciones;
    }
    
    
    
    //@Getters
    
    public int getNumPisos() {
        return numPisos;
    }

    public int getHabitaciones() {
        return habitaciones;
    }
    
    
    
    //@Setters

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }
    
    
    
    

}
