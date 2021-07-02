/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Propiedades.Terreno;
import Propiedades.Casa;
import Propiedades.TipoTerreno;
import java.util.ArrayList;
import java.util.Scanner;
import sistema_bienes_raices_g6.UIUsuarios;

/**
 *
 * @author andya
 */
public class Administrador extends Usuario {
    private ArrayList<Cliente> ListaClientes;
    private ArrayList<Agente_Venta> ListaAgentes;
    
    public Administrador(String user, String password, String nombre, int cedula, String correo, ArrayList<Cliente> ListaClientes, ArrayList<Agente_Venta> ListaAgentes){
        super(user, password, nombre, cedula, correo, TipoUsuario.Administrador);
        this.ListaAgentes = ListaAgentes;
        this.ListaClientes = ListaClientes;
        
    }
    
    public static void mostrarMenuAdministrador(){
        Scanner  sc = new Scanner(System.in);
        String opcion;
        System.out.println("Bienvenido :)");
        do{
            System.out.println("1. Registrar Propiedad");
            System.out.println("2. Registrar Agente");
            System.out.println("3. Reporte General");
            System.out.println("4. Cerrar sesion");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    opcion1AD();
                    break;
                case "2":
                    opcion2AD();
                    break;
                case "3":
                    opcion3AD();
                    break;
                case "4":
                    System.out.println("Sesion cerrada");
                    break;  
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!opcion.equals("4"));
}
    
    
     private static void opcion1AD(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Registro de nueva propiedad");
        System.out.println("Ingrese tipo de propiedad (Terreno o Casa):");
        String tipo = sc.nextLine();
        while(!("casa".equals(tipo.toLowerCase())||"terreno".equals(tipo.toLowerCase()))){
            System.out.println("Tipo no válido");
            System.out.println("Ingrese el tipo del propiedad (Terreno o Casa)");
            tipo = sc.nextLine();
            
        }
        
        TipoTerreno tipoterreno = null;
        
        if (tipo.toLowerCase().equals("terreno")){
            System.out.println("Ingrese el tipo de terreno (Comercial, Vivienda o Empresarial)");
            String tip=sc.nextLine();
            switch(tip.toLowerCase()){
                case "comercial":
                    tipoterreno=TipoTerreno.COMERCIAL;
                    break;
                case "vivienda":
                    tipoterreno=TipoTerreno.VIVIENDA;
                    break;
                case "empresarial":
                    tipoterreno=TipoTerreno.EMPRESARIAL;
                    break;
                default:
                    System.out.println("Ingrese el tipo de terreno (Comercial, Vivienda o Empresarial)");
            }
          
        }
        
        int numpisos = 0;
        int numhabitaciones = 0;
        if (tipo.toLowerCase().equals("casa")){
            System.out.println("Ingrese el numero de pisos");
            while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Cantidad de pisos incorrectos");
                System.out.println("Ingrese el numero de pisos de la propiedad");
            }
            numpisos = sc.nextInt();
        
            System.out.println("Ingrese el numero de habitaciones de la propiedad");
            while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Numero de habitaciones incorrecto");
                System.out.println("Ingrese el numero de habitaciones de la propiedad");
            }
            numhabitaciones = sc.nextInt();
        }
        
        System.out.println("Ingrese el precio de la propiedad");
        while(!(sc.hasNextDouble()||sc.hasNextInt())){
                sc.nextLine();
                System.out.println("Precio incorrecto");
                System.out.println("Ingrese el precio de la propiedad");
            }
        double precio = sc.nextDouble();
        
        System.out.println("Ingrese el ancho de la propiedad");
        while(!(sc.hasNextDouble()||sc.hasNextInt())){
                sc.nextLine();
                System.out.println("Ancho incorrecto");
                System.out.println("Ingrese el ancho de la propiedad");
            }
        double ancho = sc.nextDouble();
        
        System.out.println("Ingrese la profundidad de la propiedad");
        while(!(sc.hasNextDouble()||sc.hasNextInt())){
                sc.nextLine();
                System.out.println("Profundidad incorrecto");
                System.out.println("Ingrese la profundidad de la propiedad");
            }
        double profundidad = sc.nextDouble();
        
        System.out.println("Ingrese la ubicacion de la propiedad");
        System.out.print("Ingrese Provincia:"); String provincia = sc.nextLine();
        System.out.print("Ingrese Ciudad:"); String ciudad = sc.nextLine();
        System.out.print("Ingrese Direccion:"); String direccion = sc.nextLine();
        System.out.println("Ingrese Sector:"); String sector = sc.nextLine();
        String[] ubicacionPropiedad = new String[]{provincia,ciudad,direccion,sector};
        
        System.out.println("Ingrese el id de la propiedad");
        while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Id incorrecto");
                System.out.println("Ingrese el id de la propiedad");
            }
        int id=sc.nextInt();
        
        System.out.println("Ingrese el numero del Agente al que se le asiganara la propiedad");
        int i=0;
        for(Usuario aventa: UIUsuarios.getListaUsuarios()){
                i+=1;
                if(aventa!=null){
                    if(aventa instanceof Agente_Venta){
                        Agente_Venta agent = (Agente_Venta)aventa;
                        System.out.print(i+") "+agent.getUser()+"\n");
                    }
                }
        }
        
        int numAgente = sc.nextInt();
        do{
            System.out.println("Ingrese numero Correcto");
        }while(!UIUsuarios.verificarSiesAgente(numAgente-1));
        
        
        Agente_Venta agenteElejido = (Agente_Venta)UIUsuarios.getListaUsuarios().get(numAgente-1);
        
        
        
        
        String Agente = sc.nextLine();
        
        if (tipo.toLowerCase().equals("terreno")){
            Terreno terreno = new Terreno(tipoterreno, precio, ancho, profundidad,ubicacionPropiedad,agenteElejido);
            //UIUsuarios.getAnimales().add(perro);
        }
        
        else if(tipo.toLowerCase().equals("casa")){
            Casa casita = new Casa(numpisos, numhabitaciones, precio, ancho, profundidad, ubicacionPropiedad, agenteElejido);
        }
     }
     private static void opcion2AD(){
         
        Scanner sc = new Scanner(System.in);
           
        System.out.println("Opcion Registrar Agente");
        
        System.out.println("Ingrese el usuario del Agente:");
        String usuario = sc.nextLine();
        
        System.out.println("Ingrese la contraseña del Agente:");
        String contraseña = sc.nextLine();
        
        System.out.println("Ingrese el nombre del Agente:");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese su identificacion:");
        int identificacion=sc.nextInt();
        
        System.out.println("Ingrese el correo del Agente:");
        String correo = sc.nextLine();
        
        Agente_Venta Agente = new Agente_Venta(usuario, contraseña, nombre, identificacion, correo);
        
     }
    
     
    
    private static void opcion3AD(){
        Scanner sc = new Scanner(System.in);}
    
        
    }
    //public void RegistrarAgente(Agente_Venta Agente, ArrayList<Propiedad> Propiedades){}
    
    //public void ReporteGeneral(Fehca_Inicio, Fecha_Fin){}

