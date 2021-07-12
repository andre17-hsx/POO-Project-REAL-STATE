
package sistema_bienes_raices_g6;

//@see
import Usuarios.Agente_Venta;
import Usuarios.Cliente;
import java.time.LocalDate;

/**
 * 
 * @author andya
 */

/*========================================================|
CLASE Venta                                               |
Contiene la fecha de venta y datos del comprador.         |                                                                        |
==========================================================*/
public class Venta {
    /**
     * @param fechaVenta contiene la fecha en la que se realizo la venta
     * @param comprador contiene el nombre de su cliente
     */
    private LocalDate fechaVenta;
    private Cliente Comprador;
    
    //@Constructor
    public Venta(LocalDate fechaVenta, Cliente Comprador){
        this.fechaVenta = fechaVenta;
        this.Comprador= Comprador;
    }
    
    //@Getters
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public Cliente getComprador() {
        return Comprador;
    }
    
    
}
