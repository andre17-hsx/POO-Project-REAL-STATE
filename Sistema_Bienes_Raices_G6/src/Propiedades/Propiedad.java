
//@see
package Propiedades;
import Usuarios.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Objects;
/**
 
 * @author jeras
 */

/*=================================================================================================|
CLASE Padre Propiedad                                                                              |
Incluye las particularidades base de toda propiedad, el estado de venta y consulta de la propiedad,|
y muestra los detalles de esta.                                                                    |
===================================================================================================*/
public class Propiedad {
//@param
private double precio;
private double ancho;
private double profundidad;
private String[] ubicacion; //Arreglo de 4 posiciones [provincia, ciudad, dir, sector]
private int id;
private boolean estadoVenta;
private boolean consultado;
private Agente_Venta agente;
    


    //Constructor
    /**
     * Constructor con 8 parametros
     * @param precio precio de la propiedad
     * @param ancho ancho de la propiedad
     * @param profundidad profundidad de la propiedad
     * @param ubicacion ubicacion de la propiedad
     * @param id id de la propiedad
     * @param estadoVenta estado de venta de la propiedad
     * @param consultado si esta consultado true, false si no
     * @param agente agente a quien fue signado
     */
    public Propiedad(double precio, double ancho, double profundidad, String[] ubicacion, boolean estadoVenta, boolean consultado,Agente_Venta agente, int id) {
        this.precio = precio;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.ubicacion = ubicacion;
        this.estadoVenta = estadoVenta;
        this.consultado = consultado;
        this.agente = agente;
        this.id = id;
    }
    
    
    //@OverLoading
    /**Constructor de 6 parametros
     * @param precio
     * @param ancho
     * @param profundidad
     * @param ubicacion
     * @param agente
     * @param id 
     */
    public Propiedad(double precio, double ancho, double profundidad, String[] ubicacion, Agente_Venta agente, int id){
            this(precio, ancho, profundidad, ubicacion,false,false,agente, id);
    }
    
    /**Constructor de 4 parametros
     * @param precio
     * @param ancho
     * @param profundidad
     * @param ubicacion 
     */
    public Propiedad(double precio, double ancho, double profundidad, String[] ubicacion){
        this.precio = precio;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.ubicacion = ubicacion;
    }

     /**getPrecio()
      * @return precio de la propiedad
      */
    public double getPrecio() {
        return precio;
    }
    
    /**getAncho()
     * @return ancho de la propiedad
     */
    public double getAncho() {
        return ancho;
    }

    /**getProfundidad()
     * @return profundidad de la propiedad
     */
    public double getProfundidad() {
        return profundidad;
    }
    
    
    /**getTamanio()
     * @return retorna los metros cuadrados de la propiedad
     */
    public double getTamanio(){
        return ancho*profundidad;
    }
    
    /**getUbicacion()
     * @return retorna la direccion de memoria de ubicacion
     */
    public String[] getUbicacion() {
        return ubicacion;
    }
    
    /**getId()
     * @return retorna la Id de la propiedad 
     */
    public int getId() {
        return id;
    }
    
    /**isEstadoVenta()
     * @return retorna el estado de venta de la propiedad
     */
    public boolean isEstadoVenta() {
        return estadoVenta;
    }
    
    /**isConsultado
     * @return retorna si ya fue consultado o no
     */
    public boolean isConsultado() {
        return consultado;
    }
    
    /**getAgente()
     * @return retona al agente que fue asignado
     */
    public Agente_Venta getAgente() {
        return agente;
    }

    
    /**setPrecio(double precio)
     * @param precio setea el precio de la propiedad
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**setAncho(double ancho)
     * @param ancho setea el ancho de la propiedad
     */
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    
    /**setProfundidad(double profundidad)
     * @param profundidad sete la profundidad de la propiedad
     */
    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }
    
    /**setUbicacion(String[] ubicacion)
     * @param ubicacion setea la direccion de memoria de ubicacion
     */
    public void setUbicacion(String[] ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    /**setId(Int id)
     * @param id setea la id de la propiedad
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**setEstadoVenta
     * @param estadoVenta setea el estado de venta de la Propiedad 
     */
    public void setEstadoVenta(boolean estadoVenta) {
        this.estadoVenta = estadoVenta;
    }
    
    /**setConsultado(boolean consultado)
     * @param consultado setea el valor de consultado de la propiedad
     */
    public void setConsultado(boolean consultado) {
        this.consultado = consultado;
    }
 

    //Este metodo muestra la informacion detallada de la Propiedad
    public void mostrarInformacion(){

        System.out.print("\n====== DETALLES DE PROPIEDAD ======\n");
        System.out.println("- ID \t\t\t:"+id);
        System.out.println("- Metros 2 \t\t:"+ancho);
        System.out.println("- Profundidad \t\t:"+profundidad);
        System.out.println("- Ubicacion \t\t:"+ubicacion[0]+"-"+ubicacion[1]+"-"+ubicacion[2]+"-"+ubicacion[3]);
        System.out.println("- Precio $ \t\t:"+precio);
        System.out.println("-Agente asignado\t:"+agente.getUser());
        
        if(estadoVenta){ System.out.println("- Estado de Venta \t: SI");
        }else{ System.out.println("- Estado de Venta \t: NO");}
        
        if(estadoVenta){System.out.println("- Estado de Venta \t: SI");
        }else{System.out.println("- Estado de Venta \t: NO");}
        
    }
    
    
    /**Este metodo valida SOLAMENTE la ubicacion de la propiedad(PROVINCIA,CIUDAD,SECTOR)
     * validarUbicacion(Object obj)
     * @param obj
     * @return verdadero o falso segun las treas condiciones de Provincia,Ciudad,Sector sean verdaderas
     */
    public boolean validarUbicacion(Object obj){
        if(obj!=null){
            if(obj instanceof Propiedad){
                Propiedad otro=(Propiedad)obj;
                 if((ubicacion[0].toString().toLowerCase().equals(otro.getProvincia().toLowerCase()))&&
                         (ubicacion[1].toString().toLowerCase().equals(otro.getCiudad().toLowerCase()))&&
                         (ubicacion[3].toString().toLowerCase().equals(otro.getSector().toLowerCase()))){
                    
                    System.out.println("CUMPLIO CON TODOS LOS LUGARES");
                    return true;
                }
            }
        }
        System.out.println("NO CUMPLIO CON ALGUN O NINGUN LUGAR");
        return false;
    }
    
    
    
    /**getProvincia()
     * @return la provincia de la Ubicacion
     */
    public String getProvincia(){
        return ubicacion[0];
    }
    
    /**getCiudad()
     * @return la ciudad de la Ubicacion
     */
    public String getCiudad(){
        return ubicacion[1];
    }
    
    /**getSector()
     * @return el sector de la Ubicacion
     */
    public String getSector(){
        return ubicacion[3];
    }
   
}