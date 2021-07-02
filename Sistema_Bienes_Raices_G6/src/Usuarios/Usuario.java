/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ArrayList;

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
    protected TipoUsuario Tipo;
    private LocalDate FechaInicio;
    
    
    public Usuario(String user, String password, String nombre, int cedula, String correo, TipoUsuario Tipo){
        this.user= user;
        this.password=password;
        this.nombre=nombre;
        this.cedula=cedula;
        this.correo=correo;
        this.Tipo= Tipo;
    }
    
    public Usuario(String user, String password){
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
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

    public void setTipo(TipoUsuario Tipo) {
        this.Tipo = Tipo;
    }
    
    public Usuario verificarUsuario(Usuario usuario, ArrayList<Usuario> usuarios) {
        if (!usuarios.isEmpty()) {
            for (Usuario usu : usuarios) {
                if (usu.equals(usuario)) {
                    return usu;
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj!=null){
            if (obj instanceof Usuario){
                Usuario u = (Usuario)obj;
                if (user.equals(u.getUser()) && password.equals(u.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + this.cedula;
        hash = 29 * hash + Objects.hashCode(this.correo);
        hash = 29 * hash + Objects.hashCode(this.Tipo);
        hash = 29 * hash + Objects.hashCode(this.FechaInicio);
        return hash;
    }
    
    
}
