
package sistema_bienes_raices_g6;


//@see
import java.util.ArrayList;
import Propiedades.*;
import java.util.Objects;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;

/**
 *
 * @author jeras
 */
/*==================================================================================================|
CLASE Notificacion                                                                                  |
Clase que se encarga de guardar la informacion para crear una alerta deacuerdo a la preferencia del |
Cliente, consta de atributo email y de la Propiedad que esta interesado                             |
=====================================================================================================*/
public class Notificacion {
    /**
     * @param email contiene el correo del cliente
     * @param propiedadPreferencia contiene la propiedad con las caracteristicas de su preferencia
     */
    private String email;
    private Propiedad propiedadPreferencia;
    
    //Contructor#1 para instanciar una Notificacion, solo recibe un correo
    //y una Propiedad con las preferencias que ingreso en tiempo de compilacion
    public Notificacion(String email,Propiedad propiedadPreferencia){
        this.email = email;
        this.propiedadPreferencia = propiedadPreferencia;
    }
    
    
    //GETTERS
    public String getEmail(){
        return email;
    }
    
    public Propiedad getPropiedadPreferencia(){
        return propiedadPreferencia;
    }
    
    
    //Metodo que envía correo mediante STMP de gmail
    public static void enviarCorreo(String correo, Propiedad propiedad) {
        
        //Inicializamos nuestras credenciales de remitente
        String remitente = "sistemabienesraicesg6@gmail.com";
        String clave = "sbr12345";
        String destino = correo; //A quien le quieres escribir.
        String asunto = "Alerta de Propiedades - Sistema Bienes Raicez";
        //String cuerpo = "Esta es una prueba de correo...";
        
        //Configuramos las credenciales, host, puerto para enviar correo, usando smtp de Gmail
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);

        
        Session session = Session.getDefaultInstance(props);
        MimeMessage mensaje = new MimeMessage(session); //mensaje basado con la configuracion inicial que creamos

        //Controlamos el envio smtp con un try-catch
        try{
            mensaje.addRecipient(Message.RecipientType.TO,new InternetAddress(destino));
            mensaje.setSubject(asunto);
            if(propiedad instanceof Terreno){ //--> Si la Propiedad es un Terreno envia mensaje con info de terreno
            Terreno terrCorreo = (Terreno)propiedad;
            mensaje.setText("Precio:"+terrCorreo.getPrecio()+", Tipo: "+terrCorreo.getTipo()+"Tamanio[M2]:"+terrCorreo.getTamanio()+
                    ", Ubicacion: "+terrCorreo.getProvincia()+"-"+terrCorreo.getCiudad()+"-"+terrCorreo.getSector()+ ", ID: "+terrCorreo.getId());
            }else if(propiedad instanceof Casa){ //--> Si la propiedad es una CASA, envia mensaje con info de casa
             Casa casaCorreo=(Casa)propiedad;
             mensaje.setText("Precio:"+casaCorreo.getPrecio()+", Pisos: "+casaCorreo.getNumPisos()+", Habitaciones: "+casaCorreo.getHabitaciones()+"Tamanio[M2]:"+casaCorreo.getTamanio()+
                    ", Ubicacion: "+casaCorreo.getProvincia()+"-"+casaCorreo.getCiudad()+"-"+casaCorreo.getSector()+ ", ID: "+casaCorreo.getId());
        
            }
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com",remitente,clave);
            transport.sendMessage(mensaje,mensaje.getAllRecipients());
            transport.close();
            System.out.println("\n*** Correo Enviado ****");
        }catch(Exception e){
            e.printStackTrace(); 
        }
        
    }
    
    
    
}
