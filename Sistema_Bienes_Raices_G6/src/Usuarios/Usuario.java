/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author andya
 */
public class Usuario {
    protected String user;
    protected String password;
    protected String nombre;
    protected int cedula;
    protected String correo;
    //protected TipoUsuario Tipo;
    private LocalDate FechaInicio;
    
    
    public Usuario(String user, String password, String nombre, int cedula, String correo/*, TipoUsuario Tipo*/){
        this.user= user;
        this.password=password;
        this.nombre=nombre;
        this.cedula=cedula;
        this.correo=correo;
        //this.Tipo= Tipo;
    }
    
    public Usuario(String user, String password){
        this.user = user;
        this.password = password;
    }
    
    public Usuario(String nombre, String correo, int cedula){
        this.nombre=nombre;
        this.correo=correo;
        this.cedula=cedula;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    public String getCorreo(){
        return correo;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /*public void setTipo(TipoUsuario Tipo) {
        //this.Tipo = Tipo;
    }*/
    
    public Usuario verificarUsuario(Usuario usuario, ArrayList<Usuario> usuarios) {
        if (!usuarios.isEmpty()){
            for (Usuario usu : usuarios){
                if (usu.equals(usuario)) {
                    return usu;
                }
            }
        }
        return null;
    }
    
    public String verificarNuevoUsuario(String usuario, ArrayList<Usuario> usuarios) {
        if (!usuarios.isEmpty()){
            for (Usuario usu : usuarios){
                if (usu.getUser().equals(usuario)) {
                    return usu.getUser();
                }
            }
        }
        return null;
    }
    public boolean verificarCorreo(String correo){
        Pattern pattern = Pattern.compile("^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@"
                        + "[a-z0-9-]+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$");
        Matcher match = pattern.matcher(correo);
        if(match.find()){
            boolean validar = correo.substring(correo.indexOf("@")).equals("@gmail.com") || correo.substring(correo.indexOf("@")).equals("@hotmail.com");
            return validar;
        }
        return false;
    }
   
    public boolean verificarNuevoCorreo(String correo, ArrayList<Usuario> usuarios){
        
        if(verificarCorreo(correo)==false){
            System.out.println("Correo invalido");
            return false;
        }else{
            return true;
        }
        
        /*if (!usuarios.isEmpty()){
            for (Usuario usu : usuarios){
                if (usu.getCorreo().equals(correo)) {
                    return true;
                }else{
                    System.out.println("Correo ya esta registrado");
                }
            }
        }*/
        
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj!=null){
            if (obj instanceof Usuario){
                Usuario u = (Usuario)obj;
                if (user.equals(u.getUser()) && password.equals(u.getPassword())){
                    System.out.println("Es un usuario..");
                    return true;
                }
            }
        }
        System.out.println("No lo es");
        return false;
    }

    //@Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + this.cedula;
        hash = 29 * hash + Objects.hashCode(this.correo);
        //hash = 29 * hash + Objects.hashCode(this.Tipo);
        hash = 29 * hash + Objects.hashCode(this.FechaInicio);
        return hash;
    }
    
    
}
