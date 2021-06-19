/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_bienes_raices_g6.Usuarios;
import java.util.Objects;
import java.util.ArrayList;
import sistema_bienes_raices_g6.Usuarios.TipoUsuario;
/**
 *
 * @author andya
 */
public abstract class Usuario {
    protected String user;
    protected String password;
    protected String nombre;
    protected int cedula;
    protected String correo;
    protected TipoUsuario Tipo;
    
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
    
    
    
}
