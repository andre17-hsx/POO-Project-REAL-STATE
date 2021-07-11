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
    public Casa(int numPisos, int habitaciones, double precio, double ancho, double profundidad, String[] ubicacion, boolean estadoVenta, boolean consultado,Agente_Venta agente, int id) {
        super(precio,ancho,profundidad,ubicacion,estadoVenta,consultado,agente, id); //--> Llama al constructor de la Superclase
        this.numPisos = numPisos;
        this.habitaciones = habitaciones;
    }
    
   public Casa(int numPisos,int habitaciones, double precio, double ancho, double profundidad, String[] ubicacion,Agente_Venta agente, int id) {
        super(precio,ancho, profundidad, ubicacion,agente, id); //--> Se llama al constructor de la Superclase que solo recibe 5 parametros
        this.numPisos = numPisos;
        this.habitaciones = habitaciones;
    }
    
    //@OverLoading del Constructor#1 de Casa
    public Casa(int numPisos, int habitaciones, double precio, double ancho, double profundidad, String[] ubicacion){
        super(precio,ancho, profundidad, ubicacion); //---> Llama al constructor de la SuperClase que solo recibe 5 argumentos
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.numPisos;
        hash = 41 * hash + this.habitaciones;
        return hash;
    }
    
    
public boolean equals(Object obj){
        if(obj!=null){
            if(obj instanceof Casa){
                Casa otro = (Casa)obj;
                if((super.getPrecio()==otro.getPrecio()) && (super.getAncho()==otro.getAncho())&&(super.getProfundidad()==otro.getProfundidad())&&
                        super.validarUbicacion(otro)&&(numPisos== otro.getNumPisos())&&(habitaciones==otro.getHabitaciones())){
                    System.out.println("CUMPLIO CON TODO");
                    return true;
                }
            }
        }
        System.out.println("AL MENOS ALGO NO CUMPLIO");
        return false;
    }
    

}
