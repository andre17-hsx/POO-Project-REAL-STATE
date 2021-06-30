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
enum TipoTerreno{
    COMERCIAL, VIVIENDA, EMPRESARIAL;
}


public class Terreno extends Propiedad {
    private TipoTerreno tipo;

    public Terreno(char t,double precio, double m2, double profundidad, String ubicacion, int id, boolean estadoVenta, boolean consultado) {
        super(precio, m2, profundidad, ubicacion, id, estadoVenta, consultado);
        
        if(t=='c'){ 
            this.tipo = tipo.COMERCIAL;
        }else if(t=='v'){
            this.tipo=tipo.VIVIENDA;
        }else if(t=='e'){ 
            this.tipo = tipo.EMPRESARIAL;
        }
        
    }

    public Terreno(char t,int precio, double m2, double profundidad, String ubicacion, int id) {
        super(precio, m2, profundidad, ubicacion, id);
        
        if(t=='c'){ 
            this.tipo = tipo.COMERCIAL;
        }else if(t=='v'){
            this.tipo=tipo.VIVIENDA;
        }else if(t=='e'){ 
            this.tipo = tipo.EMPRESARIAL;
        }
        
    }

    public TipoTerreno getTipo() {
        return tipo;
    }

    public void setTipo(TipoTerreno tipo) {
        this.tipo = tipo;
    }
        
    
    
}