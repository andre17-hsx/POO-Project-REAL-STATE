/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ALICE
 */
public class Consulta {
    private LocalDate fechaconsulta;
    private int codigo;
    private String Agente;
    private boolean isRespondida;
    private String pregunta;
    private ArrayList<Conversacion> conversa;
    
    public Consulta(LocalDate fechaconsulta, int codigo, String Agente, String pregunta, boolean isRespondido) {
        this.pregunta=pregunta;
        this.fechaconsulta=fechaconsulta;
        this.Agente=Agente;
        this.isRespondida=isRespondida;
        this.codigo=codigo;
        ArrayList<Conversacion> conversa = new ArrayList<>();
//To change body of generated methods, choose Tools | Templates.
    }

    public LocalDate getFechaconsulta() {
        return fechaconsulta;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getAgente() {
        return Agente;
    }

    public ArrayList<Conversacion> getConversa() {
        return conversa;
    }

    public boolean isIsRespondida() {
        return isRespondida;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setFechaconsulta(LocalDate fechaconsulta) {
        this.fechaconsulta = fechaconsulta;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setAgente(String Agente) {
        this.Agente = Agente;
    }

    public void setIsRespondida(boolean isRespondida) {
        this.isRespondida = isRespondida;
    }
}