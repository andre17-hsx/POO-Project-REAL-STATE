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
public class Propiedad {
    
private double precio;
private double m2;
private double profundidad;
private String ubicacion; //[provincia, ciudad, dir, sector]
private int id;
private boolean estadoVenta;
private boolean consultado;
private String Agente;

    public Propiedad(double precio, double m2, double profundidad, String ubicacion, int id, boolean estadoVenta, boolean consultado, String Agente) {
        this.precio = precio;
        this.m2 = m2;
        this.profundidad = profundidad;
        this.ubicacion = ubicacion;
        this.id = id;
        this.estadoVenta = estadoVenta;
        this.consultado = consultado;
        this.Agente = Agente;
    }
    
    /*@overwrite -> Se estable un constructor donde recibe parametros minimos necesarios
    para inicialiar una propiedad, los cuales serian todos excepto los estados
    de estadoVenta y consultado que por defalut serian falsos.
    */ 
   public Propiedad(double precio, double m2, double profundidad, String ubicacion, int id, String Agente){
            this(precio, m2, profundidad, ubicacion, id,false,false, Agente);
   }
    
    public Propiedad(double precio, double m2, double profundidad, String ubicacion){
            this.precio=precio;
            this.m2=m2;
            this.profundidad=profundidad;
            this.ubicacion=ubicacion;
   } 
    
    /*@overwrite -> Se estable un constructor pque no recibe parámetros
    el cual inicializa a todos los atributos con valores por defecto.
    */    
    public Propiedad(){
        this.precio = 0.00;
        this.m2 = 0.00;
        this.profundidad = 0.00;
        this.ubicacion = "Guayaquil, Norte";
        this.id = 0;
        this.estadoVenta = false;
        this.consultado = false;
    }
    


    //@Getters
    
    public double getPrecio() {
        return precio;
    }

    public double getM2() {
        return m2;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public String getUbicacion() {
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

    public String getAgente() {
        return Agente;
    }

    
    //@Setters
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public void setUbicacion(String ubicacion) {
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
 
    
    //Cuando se agregue el paquete Propiedad junto con las otras clases
    //descomentar el método de abajo
    
    
    //@Metodos de clase Propiedad
    
    public void mostrarInformacion(){

        System.out.print("\n====== DETALLES DE PROPIEDAD ======\n");
        System.out.println("- ID \t\t\t:"+id);
        System.out.println("- Metros 2 \t\t:"+m2);
        System.out.println("- Profundidad \t\t:"+profundidad);
        System.out.println("- Ubicacion \t\t:"+ubicacion);
        System.out.println("- Precio $ \t\t:"+precio);
        
        if(estadoVenta){ System.out.println("- Estado de Venta \t: SI");
        }else{ System.out.println("- Estado de Venta \t: NO");}
        
        if(estadoVenta){System.out.println("- Estado de Venta \t: SI");
        }else{System.out.println("- Estado de Venta \t: NO");
        }
        
    }
    
}