

//@see
package Usuarios;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ArrayList;

/**
 *
 * @author andya
 */
/*=======================================================================================================|
CLASE PADRE Usuario                                                                                      |
Clase del cual heredan sus hijas, Administrador,AgenteVenta,Cliente, contiene atributos comunes en todos |
los usuarios, consta con un equals donde valida mediante usuario y contrsenia                            |
========================================================================================================*/
public class Usuario {

    private String user;
    private String password;
    private String nombre;
    private int cedula;
    private String correo;
    private LocalDate FechaInicio;
    
    //@Constructor
    /**
     * Constructor con 6 parametros
     * @param user username del usuario
     * @param password password del usuario
     * @param nombre nombre del usuario
     * @param cedula cedula del usuario
     * @param correo correo del usuario
     * @param fechaInicio Fecha de incio de creacion
     */
    public Usuario(String user, String password, String nombre, int cedula, String correo/*, TipoUsuario Tipo*/){
        this.user= user;
        this.password=password;
        this.nombre=nombre;
        this.cedula=cedula;
        this.correo=correo;
        //this.Tipo= Tipo;
    }
    
    /**Constructor de 2 parametros (Sobrecargado)
     * @param user
     * @param password 
     */
    public Usuario(String user, String password){
        this.user = user;
        this.password = password;
    }
    
    /**Constructor de 3 parametros (Sobrecargado)
     * @param nombre
     * @param correo
     * @param cedula 
     */
    public Usuario(String nombre, String correo, int cedula){
        this.nombre=nombre;
        this.correo=correo;
        this.cedula=cedula;
    }
    
    /**
     * getUser()
     * @return username del usuario
     */
    public String getUser() {
        return user;
    }
    
    /**
     * getNombre()
     * @return nombre del usuario
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * getPassword()
     * @return la contrasenia del usuario
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * getCedula()
     * @return cedula del usuario
     */
    public int getCedula(){
        return cedula;
    }
    
    /**
     * getCorreo()
     * @return correo del usuario
     */
    public String getCorreo(){
        return correo;
    }
    
    
    /**
     * setUser(String user)
     * @param user setea el username del usuario
     */
    public void setUser(String user) {
        this.user = user;
    }
    
    /**
     * setPassword(String password)
     * @param password setea la contrasenia del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * setNombre(String nombre)
     * @param nombre setea el nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * setCedula(int cedula)
     * @param cedula setea la cedula del usuario
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    /**
     * setCorreo(String correo)
     * @param correo setea el correo del usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //Metodo que verifica si un usuario se encuentra en la Lista de Usuarios.
    //@methods
    /**
     * verificarusuario(Usuario usuario, ArrayList<usuario> usuarios)
     * @param usuario
     * @param usuarios
     * @return el usuario que coincidio en la busqueda, o null si no coincidio
     */
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
    
    @Override
    //Metodo que me dice que un usuario es igual a otro cuando coincide su user y contrasenia
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
