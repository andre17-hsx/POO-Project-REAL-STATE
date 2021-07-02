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

    
    //@Constructor#1 de la Clase Casa
    public Casa(int numPisos, int habitaciones, double precio, double ancho, double profundidad, String[] ubicacion, boolean estadoVenta, boolean consultado,Agente_Venta agente) {
        super(precio,ancho,profundidad,ubicacion,estadoVenta,consultado,agente); //--> Llama al constructor de la Superclase
        this.numPisos = numPisos;
        this.habitaciones = habitaciones;
    }

    //@OverLoading del Constructor#1 de Casa
    public Casa(int numPisos, int habitaciones, double precio, double ancho, double profundidad, String[] ubicacion,Agente_Venta agente){
        super(precio,ancho, profundidad, ubicacion,agente); //---> Llama al constructor de la SuperClase que solo recibe 5 argumentos
        this.numPisos = numPisos;
        this.habitaciones = habitaciones;
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
