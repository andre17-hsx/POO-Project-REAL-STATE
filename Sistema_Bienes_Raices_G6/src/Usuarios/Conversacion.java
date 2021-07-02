/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.time.LocalDate;

/**
 *
 * @author andya
 */
public class Conversacion {
    private LocalDate fechaMss;
    private String mss;
    
    public Conversacion (LocalDate fechaMss, String mss){
        this.fechaMss=fechaMss;
        this.mss=mss;
    }
    
    @Override
    public String toString(){
     return fechaMss + ":" + mss ;   
    }
}
