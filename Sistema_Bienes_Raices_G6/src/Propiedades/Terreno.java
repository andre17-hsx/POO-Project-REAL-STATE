//@see
package Propiedades;
import Usuarios.*;
import java.util.Objects;
/**
 *
 * @author jeras
 */

/*=================================================================================================|
SubCLASE Terreno                                                                                   |
Hereda de Propiedad, y solo tiene como atributo diferente el tipo, adicional contiene getter,setter|
asi como sobrescritura del Metodo EQUALS definido para un Terreno                                  |
====================================================================================================*/
public class Terreno extends Propiedad {
     /**
     * @param tipo me indica que tipo de terreno es --> TipoTerreno
     */
    private TipoTerreno tipo;

    
    //CONSTRUCTOR
    public Terreno(TipoTerreno tipo,double precio, double ancho, double profundidad, String[] ubicacion, boolean estadoVenta, boolean consultado,Agente_Venta agente, int id) {
        super(precio,ancho,profundidad,ubicacion, estadoVenta, consultado,agente, id); //--> Se llama al constructor de la SuperClase
        this.tipo = tipo;
    }

    //@OverLoading del Constructor
    public Terreno(TipoTerreno tipo, double precio, double ancho, double profundidad, String[] ubicacion,Agente_Venta agente, int id) {
        super(precio,ancho, profundidad, ubicacion,agente, id); //--> Se llama al constructor de la Superclase que solo recibe 5 parametros
        this.tipo = tipo;
    }
    
    //@OverLoading del Constructor
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    //Metodo Sobrescrito EQUALS que retorna verdadero si coincide con TODOS sus parametros.
    public boolean equals(Object obj){
        if(obj!=null){
            if(obj instanceof Terreno){
                Terreno otro = (Terreno)obj;
                if((super.getPrecio()==otro.getPrecio())&&(super.getTamanio()==otro.getTamanio())&&
                        (getTipo().equals(otro.getTipo())) && super.validarUbicacion(otro)){
                    System.out.println("CUMPLIO CON TODO");
                    return true;
                }
            }
        }
        return false;
    }
    
   
}