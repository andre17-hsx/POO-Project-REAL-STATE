/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;
import Usuarios.*;
import java.util.Arrays;
import java.util.ArrayList;
/**
 *
 * @author jeras
 */
public class Propiedad {

private double precio;
private double ancho;
private double profundidad;
private String[] ubicacion; //Arreglo de 4 posiciones [provincia, ciudad, dir, sector]
private int id;
private boolean estadoVenta;
private boolean consultado;
private Agente_Venta agente;
    


    //Constructor#1 de la Clase Propiedad
    public Propiedad(double precio, double ancho, double profundidad, String[] ubicacion, boolean estadoVenta, boolean consultado,Agente_Venta agente) {
        this.precio = precio;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.ubicacion = ubicacion;
        this.estadoVenta = estadoVenta;
        this.consultado = consultado;
        this.agente = agente;
    }
    
    
    //@OverLoading de Constructor#1 Para instanciar una propiedad con los valores iniciales minimos
   //para crear, donde estadoVenta y consultado inician con FALSE.
    public Propiedad(double precio, double ancho, double profundidad, String[] ubicacion, Agente_Venta agente){
            this(precio, ancho, profundidad, ubicacion,false,false,agente);
    }
    

    /*//@OverLoading, creamos un constructor sin argumentos donde colocamos valores iniciales´por defecto  
    public Propiedad(){
        this.precio = 0.00;
        this.ancho = 1;
        this.profundidad = 1;
        this.ubicacion = new String[]{"GUAYAQUIL","GUAYAS","LA CHALA","SUR-OESTE"};
        this.estadoVenta = false;
        this.consultado = false;
    }
   */ 
 

    //@Getters
    
    public double getPrecio() {
        return precio;
    }

    public double getAncho() {
        return ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public String[] getUbicacion() {
        return ubicacion;
    }

    public int getId() {
        return id;
    }

    public boolean isEstadoVenta() {
        return estadoVenta;
    }

    public boolean isConsultado() {
        return consultado;
    }

    public Agente_Venta getAgente() {
        return agente;
    }

    
    //@Setters
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public void setUbicacion(String[] ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstadoVenta(boolean estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public void setConsultado(boolean consultado) {
        this.consultado = consultado;
    }
 
    
    //@Metodos de clase Propiedad
    
    public void mostrarInformacion(){

        System.out.print("\n====== DETALLES DE PROPIEDAD ======\n");
        System.out.println("- ID \t\t\t:"+id);
        System.out.println("- Metros 2 \t\t:"+ancho);
        System.out.println("- Profundidad \t\t:"+profundidad);
        System.out.println("- Ubicacion \t\t:"+ubicacion);
        System.out.println("- Precio $ \t\t:"+precio);
        System.out.println("-Agente asignado\t\t:"+agente.getUser());
        
        if(estadoVenta){ System.out.println("- Estado de Venta \t: SI");
        }else{ System.out.println("- Estado de Venta \t: NO");}
        
        if(estadoVenta){System.out.println("- Estado de Venta \t: SI");
        }else{System.out.println("- Estado de Venta \t: NO");}
        
    }
    
}