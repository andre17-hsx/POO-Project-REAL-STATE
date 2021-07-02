/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;
/**
 *
 * @author jeras
 */
public class Terreno extends Propiedad {
    private TipoTerreno tipo;

    public Terreno(TipoTerreno tipo,double precio, double m2, double profundidad, String ubicacion, int id, boolean estadoVenta, boolean consultado, String Agente) {
        super(precio, m2, profundidad, ubicacion, id, estadoVenta, consultado, Agente);
        this.tipo = tipo;
    }

    public Terreno(TipoTerreno tipo, double precio, double m2, double profundidad, String ubicacion, int id, String Agente) {
        super(precio, m2, profundidad, ubicacion, id, Agente);
        this.tipo = tipo;
    }

    public Terreno(TipoTerreno tipo, double precio, double m2, double profundidad, String ubicacion) {
            super(precio, m2, profundidad, ubicacion);
            this.tipo=tipo;
    }
    
    public TipoTerreno getTipo() {
        return tipo;
    }

    public void setTipo(TipoTerreno tipo) {
        this.tipo = tipo;
    }
        
    
    
}