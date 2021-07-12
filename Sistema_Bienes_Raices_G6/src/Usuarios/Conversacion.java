
package Usuarios;

//@see
import java.time.LocalDate;

/**
 *
 * @author andya
 */

/*======================================================================================|
CLASE Conversacion                                                                      |
Clase que contiene las variables para mostrar la conversación en el buzón de consulta.  |
========================================================================================*/

public class Conversacion {
    /**
     * @param fechaMss contiene la fecha del mensaje
     * @param mss contiene el mensaj
     */
    private LocalDate fechaMss;
    private String mss;
    
    //@Constructor
    public Conversacion (LocalDate fechaMss, String mss){
        this.fechaMss=fechaMss;
        this.mss=mss;
    }
    
    @Override
    public String toString(){
     return fechaMss + ":" + mss ;   
    }
}
