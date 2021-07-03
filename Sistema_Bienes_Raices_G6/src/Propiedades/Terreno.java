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
public class Terreno extends Propiedad {
    private TipoTerreno tipo;

    
    //CONSTRUCTOR#1 DE LA CLASE TERRENO
    public Terreno(TipoTerreno tipo,double precio, double ancho, double profundidad, String[] ubicacion, boolean estadoVenta, boolean consultado,Agente_Venta agente, int id) {
        super(precio,ancho,profundidad,ubicacion, estadoVenta, consultado,agente, id); //--> Se llama al constructor de la SuperClase
        this.tipo = tipo;
    }

    //@OverLoading del Constructor#1
    public Terreno(TipoTerreno tipo, double precio, double ancho, double profundidad, String[] ubicacion,Agente_Venta agente, int id) {
        super(precio,ancho, profundidad, ubicacion,agente, id); //--> Se llama al constructor de la Superclase que solo recibe 5 parametros
        this.tipo = tipo;
    }
    
    public Terreno(TipoTerreno tipo, double precio, double ancho, double profundidad, String[] ubicacion){
        super(precio,ancho, profundidad, ubicacion); //---> Llama al constructor de la SuperClase que solo recibe 5 argumentos
        this.tipo= tipo;
    }
    

    //@Getters
    public TipoTerreno getTipo() {
        return tipo;
    }

    //@Setters
    public void setTipo(TipoTerreno tipo) {
        this.tipo = tipo;
    }
    
       
    
    
}