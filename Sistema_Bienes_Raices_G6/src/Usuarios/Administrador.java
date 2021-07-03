/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Propiedades.*;
import sistema_bienes_raices_g6.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import sistema_bienes_raices_g6.UIUsuarios;
import sistema_bienes_raices_g6.Venta;

/**
 *
 * @author andya
 */
public class Administrador extends Usuario {
    private ArrayList<Cliente> ListaClientes;
    private ArrayList<Agente_Venta> ListaAgentes;
    
    public Administrador(String user, String password, String nombre, int cedula, String correo, ArrayList<Cliente> ListaClientes, ArrayList<Agente_Venta> ListaAgentes){
        super(user, password, nombre, cedula, correo/*, TipoUsuario.Administrador*/);
        this.ListaAgentes = ListaAgentes;
        this.ListaClientes = ListaClientes;
    }

    public Administrador(String user, String password, String nombre, int cedula, String correo){
        super(user,password,nombre,cedula,correo);
        ListaClientes=null;
        ListaAgentes= null;
    }
    
    public static void mostrarMenuAdministrador(){
        Scanner  sc = new Scanner(System.in);
        String opcion;
        System.out.println("\t\tBienvenido :)");
        System.out.println("\nOPCIONES DE ADMINISTRADOR\n");
        do{
            System.out.println("1. Registrar Propiedad");
            System.out.println("2. Registrar Agente");
            System.out.println("3. Reporte General");
            System.out.println("4. Cerrar sesion");
            System.out.print("Ingrese una opcion: ");
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
        sc.close();
}
    
    
     private static void opcion1AD(){
        Scanner scanUbi = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner scanPrecio = new Scanner(System.in);
        System.out.println("Registro de nueva propiedad");
        System.out.print("Ingrese tipo de propiedad (Terreno o Casa):");
        String tipo = sc.nextLine();
        while(!("casa".equals(tipo.toLowerCase())||"terreno".equals(tipo.toLowerCase()))){
            System.out.println("Tipo no válido");
            System.out.print("Ingrese el tipo del propiedad (Terreno o Casa)");
            tipo = sc.nextLine();
            
        }
        
        TipoTerreno tipoterreno = null;
        
        if (tipo.toLowerCase().equals("terreno")){
            System.out.print("Ingrese el tipo de terreno (Comercial, Vivienda o Empresarial):");
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
                    System.out.print("Ingrese el tipo de terreno (Comercial, Vivienda o Empresarial):");
            }
          
        }
        
        int numpisos = 0;
        int numhabitaciones = 0;
        if (tipo.toLowerCase().equals("casa")){
            System.out.print("Ingrese el numero de pisos:");
            while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Cantidad de pisos incorrectos:");
                System.out.print("Ingrese el numero de pisos de la propiedad:");
            }
            numpisos = sc.nextInt();
        
            System.out.print("Ingrese el numero de habitaciones de la propiedad:");
            while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Numero de habitaciones incorrecto:");
                System.out.print("Ingrese el numero de habitaciones de la propiedad:");
            }
            numhabitaciones = sc.nextInt();
        }
        
        System.out.print("Ingrese el precio de la propiedad:");
        String valor = sc.nextLine();
        esDecimal(valor);
        
        //esta validacion reemplaza a la que esta con comentarios ya que esta
        //considera tanto si ingresa un entero como double y no deja un string
        //en cambio con el !hashNextDouble() entraba en bucle y no leia el dato ingresado.
        while(!esDecimal(valor)){
                System.out.println("Precio incorrecto:");
                System.out.print("Ingrese el precio correctamente:");
                valor = sc.nextLine();
            }
        Double precio = Double.parseDouble(valor);
        
        System.out.print("Ingrese el ancho de la propiedad:");
        valor = sc.nextLine();
        while(!esDecimal(valor)){
                System.out.println("Ancho incorrecto:");
                System.out.print("Ingrese el ancho correctamente:");
                valor = sc.nextLine();
            }
        Double ancho = Double.parseDouble(valor);

        
        System.out.print("Ingrese la profundidad de la propiedad:");
        valor = sc.nextLine();
        while(!esDecimal(valor)){
                System.out.println("Profundidad incorrecta");
                System.out.print("Ingrese la profundidad correctamente:");
                valor = sc.nextLine();
            }

        Double profundidad = Double.parseDouble(valor);
        
        System.out.println("\nIngrese la ubicacion de la propiedad");
        System.out.print("Ingrese Provincia:"); String provincia = scanUbi.nextLine();
        System.out.print("Ingrese Ciudad:"); String ciudad = scanUbi.nextLine();
        System.out.print("Ingrese Direccion:"); String direccion = scanUbi.nextLine();
        System.out.print("Ingrese Sector:"); String sector = scanUbi.nextLine();
        String[] ubicacionPropiedad = new String[]{provincia,ciudad,direccion,sector};
        
        System.out.print("Ingrese el id de la propiedad:");
        
        //aqui si vale dejarlo porque es un numero entero... no tiene decimales 
        while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Id incorrecto");
                System.out.print("Ingrese el id de la propiedad:");
            }
        int id=sc.nextInt();
        
        /// En esta parte falta la validacion del ID
        ///donde tendra que llamar al arreglo y verificar si no sigue pidiendo
        
        //Por ultimo se le muestra la lista de Agentes dispibles y seleccionamos uno
        System.out.println("\nAGENTES DISPONIBLES");

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
        
        System.out.print("\nIngrese el nombre del Agente al que se asiganara la propiedad:");
        String nombreAgente = sc.nextLine();
        
        Agente_Venta agenteElejido = importarAgente(nombreAgente); 
      
          
        if (tipo.toLowerCase().equals("terreno")){
            Terreno terreno = new Terreno(tipoterreno, precio, ancho, profundidad,ubicacionPropiedad, false, false, agenteElejido, id);
            UIUsuarios.getListaPropiedades().add(terreno);
            
            for(Notificacion n: UIUsuarios.getListaNotificaciones()){
                    if(enviarNotiTerreno(terreno)){
                        Notificacion.enviarCorreo(n.getEmail(),n.getPropiedadPreferencia());
                    }
            }
            
        }
        
        else if(tipo.toLowerCase().equals("casa")){
            Casa casita = new Casa(numpisos, numhabitaciones, precio, ancho, profundidad, ubicacionPropiedad, false, false, agenteElejido, id);
            UIUsuarios.getListaPropiedades().add(casita);
            
            for(Notificacion n: UIUsuarios.getListaNotificaciones()){
                    if(enviarNotiCasa(casita)){
                        Notificacion.enviarCorreo(n.getEmail(),n.getPropiedadPreferencia());
                    }
            }
            
        }
        
    // scanUbi.close();
     //sc.close();
     
     }
     
     
     private static void opcion2AD(){
         
        Scanner sc = new Scanner(System.in);
        Scanner scanCorreo = new Scanner(System.in);
           
        System.out.println("Opcion Registrar Agente");
        
        System.out.print("Ingrese el usuario del Agente:");
        String usuario = sc.nextLine();
        
        System.out.print("Ingrese la contraseña del Agente:");
        String contraseña = sc.nextLine();
        
        System.out.print("Ingrese el nombre del Agente:");
        String nombre = sc.nextLine();
        
        System.out.print("Ingrese su identificacion:");
         while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Identificacion incorrecta");
                System.out.print("Ingrese su identificacion correctamente:");
            }
         
        int identificacion=sc.nextInt();
        
        System.out.print("Ingrese el correo del Agente:");
        String correo = scanCorreo.nextLine();
        
        System.out.print("Ingrese el id del Agente:");
         while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("El id es Incorrecto, solo numeros:");
                System.out.print("Ingrese el id Correctamente:");
            }
        int id = sc.nextInt();
        
        Agente_Venta Agente = new Agente_Venta(usuario, contraseña, nombre, identificacion, correo, id);
        
     }
    
     
 public static boolean enIntervalo(LocalDate inicio, 
            LocalDate fin, LocalDate buscar){
        return buscar.isAfter(inicio) && buscar.isBefore(fin);
    }
 
    private static void opcion3AD(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Reporte contactos y ventas");
        System.out.print("Ingrese la fecha inicial :" + "(aa-mm-dd");
        String Fechin = sc.nextLine();
        LocalDate fechain = LocalDate.parse(Fechin);
        
        System.out.print("Ingrese la fecha final :" + "(aa-mm-dd");
        String Fechfin = sc.nextLine();
        LocalDate fechafin = LocalDate.parse(Fechfin);
        
        for (Agente_Venta Ag: UIUsuarios.getAgentes()){
            for (Venta v : Ag.getVentasRealizadas()){
                LocalDate fechabuscar = v.getFechaVenta();
                if(enIntervalo(fechain, fechafin, fechabuscar)){
                    System.out.println("Agente  Numero_Ventas  Num_Respuestas" + "\n" + Ag.getId() + Ag.getVentasRealizadas().size() + Ag.getContador());
                }
            }
        }
        
        System.out.print("Ingrese el id del agente del que quiere ver mas detalles");
        int busquedaAgente = sc.nextInt();
        for (Agente_Venta a: UIUsuarios.getAgentes()){
            if (a.getId()== busquedaAgente){
                a.mostrarInformacion();
            }
        }
    }   


     public static boolean esDecimal(String cad){
            try{
                Double.parseDouble(cad);
                return true;
            }catch(NumberFormatException nfe){
                return false;
            }
    }
     
    public static Agente_Venta importarAgente(String nombreAgente){
        for(Usuario u: UIUsuarios.getListaUsuarios()){
            if(u!=null){
                if(u instanceof Agente_Venta){
                    Agente_Venta agente = (Agente_Venta)u;
                    if(agente.getNombre()==nombreAgente){
                        return agente;
                    }
                }
            }
        }
        return null;    
    }
    
    public static boolean enviarNotiTerreno(Terreno terreno){
        return false;
    }
    
    public static boolean enviarNotiCasa(Casa casa){
        return false;
    }
    
}