
package Usuarios;

//@see java.util y java.util
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ALICE
 */
/*==========================================================================================|
Clase Consulta                                                                              |
Incluye las variables y métodos necesarios para iniciar y responder la consulta del cliente |
============================================================================================*/
public class Consulta {
    /**
     * @param fechaConsulta contiene la fecha que se creo la consulta
     * @param codigo contiene el id de la consulta
     * @param agente contiene el nombre del agente que se encarga de responder
     * @param isRespondida contiene true si ya fue respondida o false si no
     * @param pregunta contiene el mensaje que contiene la consulta
     * @param conversaciones contiene todas los mensajes que se han realizado
     */
    private LocalDate fechaconsulta;
    private int codigo;
    private Agente_Venta agente;
    private boolean isRespondida;
    private String pregunta;
    private ArrayList<Conversacion> conversaciones;
    
    //@CONSTRUCTOR
    public Consulta(LocalDate fechaconsulta, int codigo,Agente_Venta agente, String pregunta, boolean isRespondido) {
        this.pregunta=pregunta;
        this.fechaconsulta=fechaconsulta;
        this.agente=agente;
        this.isRespondida=isRespondida;
        this.codigo=codigo;
        ArrayList<Conversacion> conversa = new ArrayList<>();
    
    }
    
    //@GETTERS
    public LocalDate getFechaconsulta() {
        return fechaconsulta;
    }

    public int getCodigo() {
        return codigo;
    }

    public Agente_Venta getAgente() {
        return agente;
    }

    public ArrayList<Conversacion> getConversaciones() {
        return conversaciones;
    }

    public boolean isIsRespondida() {
        return isRespondida;
    }

    public String getPregunta() {
        return pregunta;
    }
    
    
    //@SETTERS
    public void setFechaconsulta(LocalDate fechaconsulta) {
        this.fechaconsulta = fechaconsulta;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setAgente(Agente_Venta agente) {
        this.agente = agente;
    }

    public void setIsRespondida(boolean isRespondida) {
        this.isRespondida = isRespondida;
    }
}