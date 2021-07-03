/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_bienes_raices_g6;

import Usuarios.Agente_Venta;
import Usuarios.Cliente;
import java.time.LocalDate;

/**
 *
 * @author andya
 */
public class Venta {
    private LocalDate fechaVenta;
    //private Agente_Venta Agente;
    //private int numVentas;
    private Cliente Comprador;
    
    public Venta(LocalDate fechaVenta, Cliente Comprador){
        this.fechaVenta = fechaVenta;
        this.Comprador= Comprador;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public Cliente getComprador() {
        return Comprador;
    }
    
    
}
