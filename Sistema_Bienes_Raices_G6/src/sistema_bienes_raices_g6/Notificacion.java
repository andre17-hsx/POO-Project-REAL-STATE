/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_bienes_raices_g6;

import java.util.ArrayList;
import Propiedades.*;


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
            mensaje.setText("Precio:"+propiedad.getPrecio()+", Tamanio[M2]:"+propiedad.getTamanio()+
                    ", Ubicacion: "+propiedad.getUbicacion()+", ID: "+propiedad.getId());
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com",remitente,clave);
            transport.sendMessage(mensaje,mensaje.getAllRecipients());
            transport.close();
            System.out.println("Correo Enviado");
        }catch(Exception e){
            e.printStackTrace(); 
        }
        
    }
    
    
    
}
