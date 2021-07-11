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
    

    public static Iterable<Agente_Venta> getAgentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
             
        //Registro de Agentes iniciales;
        Usuario ag1= new Agente_Venta("jose_17", "12345", "Jose Parrales", 0706404512, "josep@gmail.com", 1);
        Usuario ag2= new Agente_Venta("Pedrin_07", "xyz17000", "Pedro Santana", 0704541212, "pedri17@gmail.com", 2);
        Usuario ag3= new Agente_Venta("Alisson_L", "Hjk17000", "Alisson Herrera", 0703504512, "aliss@gmail.com", 3);
   
        //Registro Clinetes iniciales;
        Usuario C1 = new Cliente("maria20","m1234","Maria", 0706452102,"maria@gmail.com");
        
        //Registro de Administradores;
        Usuario admin1 = new Administrador("admin1","admin1","Andre",1102101478,"andre@gmail.com");
        Usuario admin2 = new Administrador("admi2","admin2","Jefferson",93024558,"jefferson@gmail.com");
   
        //Se registran todos los usuarios creados a la lista de Usuarios
        usuarios.add(ag1);
        usuarios.add(ag2);
        usuarios.add(ag3);
        usuarios.add(C1);
        usuarios.add(admin1);
        usuarios.add(admin2);
    
        //Registro Propiedades iniciales 2 Terreno, 2 Casas;
        String[] ubicacion1 = new String[]{"Guayas","Guayaquil","Calle A y la 7ma","SurOeste"};
        String[] ubicacion2 = new String[]{"Pichincha","Quito","Av.de los Shyris","Sur"};
        String[] ubicacion3 = new String[]{"Guayas","Guayaquil","7ma etapa","Alborada"};
        String[] ubicacion4 = new String[]{"Guayas","Guayaquil","5ta etapa","Alborada"};
        Propiedad terreno1 = new Terreno(TipoTerreno.VIVIENDA,5000.0,20.0,20.0,ubicacion1,(Agente_Venta)ag1,1);
        Propiedad terreno2 = new Terreno(TipoTerreno.COMERCIAL,50000,20,50,ubicacion2,(Agente_Venta)ag2,2);
        Propiedad casita1 = new Casa(2,4,10000,4.7,10.5,ubicacion3,(Agente_Venta)ag1,3);
        Propiedad casita2 = new Casa(3,10,20000,5.0,10.5,ubicacion4,(Agente_Venta)ag3,4);
    
        //Se resitran todas las propiedades creadas a la lista de Propiedades
        propiedades.add(terreno1);
        propiedades.add(terreno2);
        propiedades.add(casita1);
        propiedades.add(casita2);
 
    }
    
    //@Interfaz del Sistema con el Usuario
    public void iniciarSistema(){
        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        Scanner scanCorreo = new Scanner(System.in);
        Scanner scanLogging = new Scanner(System.in);
        Scanner scexit = new Scanner(System.in);
        int opSubmenu;
        //Usuario user, userSystem;
        int menu=0;
        
        
        //BUCLE DEL MENU PRINCIPAL
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
            
            //INICIO DEL SWITH DEL MENU PRINCIPAL
            switch (menu){
            
            //Usuario inicia el Logging, donde el Sistema valida que tipo de usuario es
            //y dependiendo de esto muestra los menus correspondientes
                case 1:
                    System.out.println("Ingrese sus Datos");
                    System.out.print("Usuario: ");
                    String usuario = scanLogging.nextLine();
                    System.out.print("Password: ");
                    String password = scanLogging.nextLine();
                    Usuario user = new Usuario(usuario,password);
                    Usuario userSystem = user.verificarUsuario(user,UIUsuarios.getListaUsuarios());
                    
                     while (userSystem == null) { //--> entra al bucle si el usuario no coincide con ninguno de la lista
                        System.out.println("\nEl usuario o constrasenia son invalidas...");
                        System.out.print("Usuario: ");
                        usuario = scanLogging.nextLine();
                        System.out.print("Contraseña: ");
                        password = scanLogging.nextLine();
                        user = new Usuario(usuario, password);
                        userSystem = user.verificarUsuario(user, UIUsuarios.getListaUsuarios());
                    }
                    
                    
                    if(userSystem instanceof Administrador){
                            System.out.println("Eres un Admin... ;p");
                            Administrador.mostrarMenuAdministrador();
                        
                    }else if(userSystem instanceof Cliente){
                            System.out.println("Eres un CLiente");
                            Cliente.MostrarMenuCliente();
                        
                    }else if(userSystem instanceof Agente_Venta){
                            System.out.println("Eres un Agente");
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
                                
            }//--->FIN DEL SWITCH DEL MENU PRINCIPAL
            
        }while(menu!=3);
        //FIN DEL BUCLE DEL MENU PRINCIPAL
       
        sc.close();
        scan.close();
        scanLogging.close();
        
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
