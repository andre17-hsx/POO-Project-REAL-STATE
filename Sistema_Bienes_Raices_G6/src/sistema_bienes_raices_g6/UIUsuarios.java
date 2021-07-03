/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_bienes_raices_g6;

import Propiedades.*;
import Usuarios.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author andya
 */
public class UIUsuarios {
    public static Scanner sc;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Propiedad> propiedades;
    private static ArrayList<Consulta> consultas;
    private static ArrayList<Notificacion> notificaciones;
    private static ArrayList<Agente_Venta> Agentes;


    public static Iterable<Agente_Venta> getAgentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    //Registro de Agentes;
    Agente_Venta Ag1= new Agente_Venta("Jose_17", "Abc17000", "Jose Parrales", 0706404512, "josep@gmail.com", 1);
    Agente_Venta Ag2= new Agente_Venta("Pedrin_07", "Xyz17000", "Pedro Santana", 0704541212, "pedri17@gmail.com", 2);
    Agente_Venta Ag3= new Agente_Venta("Alisson_L", "Hjk17000", "Alisson Herrera", 0703504512, "aliss@gmail.com", 3);
    
    
    //Registro clinete;
    Cliente C1 = new Cliente("Maria", "mari@gmail.com", 0706452102);
    
    //Registro propiedades;   (((aqui no se porque me da error, mira si a ti tambien)))
    
    String[] u = new String[4];
    u[0] = "Guayas"; u[1] = "Guayaquil"; u[2] = "Alborada" ; u[3] = "7ma etapa";
    
    Propiedad C1= new Casa(2, 4, 50000, 12.5, 10, u, Ag1, 1);
    
    
    
    
    public static Iterable<Usuario> getUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Iterable<Propiedad> getpropiedades() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static Iterable<Consulta> getConsultas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Iterable<Consulta> getConversacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public UIUsuarios(){ 
        usuarios = new ArrayList<Usuario>();
        propiedades = new ArrayList<Propiedad>();
        consultas = new ArrayList<Consulta>();
        notificaciones = new ArrayList<Notificacion>();
       
    }
    
    //@Interfaz del Sistema con el Usuario
    public void iniciarSistema(){
        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        Scanner scanCorreo = new Scanner(System.in);
        Usuario user, userSystem;
        int menu=0;
        
        do{
            System.out.println("\tBIENVENIDOS AL SISTEMA DE BIENES RAICES\n");
            System.out.print("MENU INICIAL\n1)Iniciar Sesión\n2)Registrarse\n3)SALIR\n\nIngrese opcion:");  
        
            //Validacion de Ingreso al Menu Principal, no deja ingresar Cualquir string, solo tipo numerico
            //y solamente las opciones validas, caso contario entrara en bucle hasta que ingrese correctamente.
            do{
                while(!sc.hasNextInt() ){
                System.out.print("\nIngreso incorrecto... solo ingresar numero de opcion..!\nIngrese opcion:");
                sc.nextLine();}
                menu = sc.nextInt();
            }while(!validarIngresoMenu(menu));
        
            switch (menu){
            
            //Usuario inicia el Logging, donde el Sistema valida que tipo de usuario es
            //y dependiendo de esto muestra los menus correspondientes
                case 1:
                    System.out.println("Ingrese sus Datos");
                    System.out.println("Usuario: ");
                    String usuario = sc.nextLine();
                    System.out.println("Password: ");
                    String password = sc.nextLine();
                    user = new Usuario(usuario,password);
                    userSystem = user.verificarUsuario(user, usuarios);
                
                    if(userSystem instanceof Administrador){
                        Administrador.mostrarMenuAdministrador();
                    }else if(userSystem instanceof Cliente){
                        Cliente.MostrarMenuCliente();
                    }else if(userSystem instanceof Agente_Venta){
                        Agente_Venta.MostrarMenuAgente();
                    }
                    
                break;
                
                case 2:
                    System.out.print("Igrese su edad:");
                        while(!sc.hasNextInt() ){
                            System.out.print("\nIngreso incorrecto... solo cantidad numerica:");
                            sc.nextLine();
                        }
                        int edad = sc.nextInt();
                        
                        if(edad<18){
                            System.out.println("\n\nEres menor de edad :'( no puedes registrarte AUN...!\n\n");
                        }else{
                            System.out.print("Ingrese su Nombre:");
                            String nombreCliente = scan.nextLine();
                            System.out.print("Ingrese el Usuario:");String userCliente=scan.nextLine();
                            System.out.print("Ingrese su Password"); String passwordCliente = scan.nextLine();
                            System.out.print("Ingrese su cedula:");
                                while(!scan.hasNextInt() ){
                                    System.out.print("\nIngreso incorrecto... solo cantidad numerica:");
                                }
                             int cedulaCliente=scan.nextInt();
                            System.out.print("Ingrese correo electronico:"); 
                            String correoCliente = scanCorreo.nextLine();
                            Cliente nuevoCLiente = new Cliente(userCliente,passwordCliente,nombreCliente,cedulaCliente,correoCliente,null);
                            System.out.println("\n\nSe Creo correctamente el CLiente...!\n\n\n");
                        }
                        
               break;
               
                case 3 :
                    System.out.println("ADIOS...:D!");
                    break;
                                
            }  
        }while(menu!=3);
       
        sc.close();
        scan.close();
        
        
    }
    
    
    
    
    public static boolean validarIngresoMenu(int menu){
            if (menu==1 || menu==2 || menu ==3){
                return true;
            }else{System.out.print("\nIngreso una opcion INCORRECTA, ingrese nuevamente opcion: ");return false;}
    }
    
    public static ArrayList<Usuario> getListaUsuarios(){
        return usuarios;
    }
    
    public static ArrayList<Propiedad> getListaPropiedades(){
        return propiedades;
    }
    
    public static ArrayList<Consulta> getListaConsultas(){
        return consultas;
    }
    
    public static ArrayList<Notificacion> getListaNotificaciones(){
        return notificaciones;
    }
    
    public static boolean verificarSiesAgente(int indice){
        Usuario userPrueba = usuarios.get(indice);
        if(userPrueba instanceof Agente_Venta){
           return true;
         }
        return false;
    }
    
    public void filtrarPropiedades(String filtro){
        
    }
    
}
