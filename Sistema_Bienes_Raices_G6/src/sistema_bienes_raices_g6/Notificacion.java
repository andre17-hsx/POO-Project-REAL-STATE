/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_bienes_raices_g6;

import java.util.ArrayList;
import Propiedades.*;

/**
 *
 * @author jeras
 */
public class Notificacion {
    private String email;
    private Propiedad propiedadPreferencia;
    
    
     public Notificacion(String email,Propiedad propiedadPreferencia){
        this.email = email;
        this.propiedadPreferencia = propiedadPreferencia;
     }
     
    public boolean registrarNotificacion(Notificacion noti) {
        for (Notificacion i : UIUsuarios.getListaNotificaciones()) {
            if (!i.equals(noti)) {
                UIUsuarios.getListaNotificaciones().add(noti);
                return true;
            }
        }
        return false;
    }
    
    public String getEmail(){
        return email;
    }
    
    public Propiedad getPropiedadPreferencia(){
        return propiedadPreferencia;
    }
    
}
