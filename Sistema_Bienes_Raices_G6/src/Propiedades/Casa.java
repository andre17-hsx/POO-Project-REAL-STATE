
package Propiedades;

//@see
import Usuarios.*;

/**
 *
 * @author jeras
 */

/*===========================================================================================|
SubCLASE Casa                                                                                |
Contiene las variables, constructores, getters y setters, que permiten crear las propiedades | 
que definen a una casa como son los Pisos y Habitaciones                                     |
=============================================================================================*/
public class Casa extends Propiedad {
    /**
     * @param numPisos contiene el numero de pisos de la casa
     * @param habitaciones contiene el numero de habitaciones de la casa
     */
    private int numPisos;
    private int habitaciones;

    
    public Casa(int numPisos, int habitaciones, double precio, double ancho, double profundidad, String[] ubicacion, boolean estadoVenta, boolean consultado,Agente_Venta agente, int id) {
        super(precio,ancho,profundidad,ubicacion,estadoVenta,consultado,agente, id); //--> Llama al constructor de la Superclase
        this.numPisos = numPisos;
        this.habitaciones = habitaciones;
    }
    
    //@OverLoading de Constructor
   public Casa(int numPisos,int habitaciones, double precio, double ancho, double profundidad, String[] ubicacion,Agente_Venta agente, int id) {
        super(precio,ancho, profundidad, ubicacion,agente, id); //--> Se llama al constructor de la Superclase que solo recibe 5 parametros
        this.numPisos = numPisos;
        this.habitaciones = habitaciones;
    }
    
    //@OverLoading de Constructor
    public Casa(int numPisos, int habitaciones, double precio, double ancho, double profundidad, String[] ubicacion){
        super(precio,ancho, profundidad, ubicacion); //---> Llama al constructor de la SuperClase que solo recibe 5 argumentos
        this.numPisos = numPisos;
        this.habitaciones = habitaciones;
    }

    
    
    /**
     * getNumPisos()
     * @return numeroPisos
     */
    public int getNumPisos() {
        return numPisos;
    }
    
    /**
     * getHabitaciones()
     * @return numero de habitaciones
     */
    public int getHabitaciones() {
        return habitaciones;
    }
    
    /**
     * setNumPisos(int numPisos)
     * @param numPisos setea el atributo numPisos
     */
    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }
    
    /**
     * setHabitaciones(int numPisos)
     * @param habitaciones sete el numero de habitaciones
     */
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
    
    
    /**Metodo EQUALS de Clase CASA, devuelve verdadero cuando TODOS sus parametros son iguales.
     * @param obj
     * @return 
     */
    @Override
    
    public boolean equals(Object obj){
            if(obj!=null){
                if(obj instanceof Casa){
                    Casa otro = (Casa)obj;
                    if((super.getPrecio()==otro.getPrecio())&&(super.getTamanio()==otro.getTamanio())&&
                        (numPisos==otro.getNumPisos())&&(habitaciones==otro.getHabitaciones())&&super.validarUbicacion(otro)){
                        System.out.println("CUMPLIO CON TODO");
                    return true;
                }
            }
        }
            System.out.println("AL MENOS ALGO NO CUMPLIO");
            return false;
    }
    

}
