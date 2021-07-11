/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Propiedades.*;
import java.text.SimpleDateFormat;
import sistema_bienes_raices_g6.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import sistema_bienes_raices_g6.UIUsuarios;
import sistema_bienes_raices_g6.Venta;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.mail.internet.ParseException;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;

/**
 *
 * @author andya
 */
public class Administrador extends Usuario {
    private ArrayList<Cliente> ListaClientes;
    private ArrayList<Agente_Venta> ListaAgentes;
    
    
    //Constructor#1
    public Administrador(String user, String password, String nombre, int cedula, String correo, ArrayList<Cliente> ListaClientes, ArrayList<Agente_Venta> ListaAgentes){
        super(user, password, nombre, cedula, correo/*, TipoUsuario.Administrador*/);
        this.ListaAgentes = ListaAgentes;
        this.ListaClientes = ListaClientes;
    }
    
    //Sobrecarga Constructor#1
    public Administrador(String user, String password, String nombre, int cedula, String correo){
        super(user,password,nombre,cedula,correo);
        ListaClientes=null;
        ListaAgentes= null;
    }
    
    //Metodo Mostrar MenuInicial
    public static void mostrarMenuAdministrador(){
        Scanner  sc = new Scanner(System.in);
        String opcion;
        do{
            System.out.println("\t\tBienvenido :)");
            System.out.println("\nOPCIONES DE ADMINISTRADOR\n");
            System.out.println("1. Registrar Propiedad");
            System.out.println("2. Registrar Agente");
            System.out.println("3. Reporte General");
            System.out.println("4. Cerrar sesion");
            System.out.print("Ingrese una opcion: ");
            
            while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.print("Ingreso datos incorrectos, Ingrese nuevamente opcion <SOLO NUMERO DE OPCION>:");
            }
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
    
    //MuestraOpcion#1
    public static void opcion1AD(){
        Scanner scanUbi = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner scanAgente = new Scanner(System.in);
        Scanner scanPrecio = new Scanner(System.in);
        System.out.println("Registro de nueva propiedad");
        System.out.print("Ingrese tipo de propiedad (Terreno o Casa):");
        String tipo = sc.nextLine();
        String nombreAgente;
        Agente_Venta agenteElejido = null;
        
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
                System.out.println("El valor ingresado es incorrecto <SOLO NUMEROS>");
                System.out.print("Ingrese el id de la propiedad:");
            }
        int id=sc.nextInt();
        
        while(validarIdPropiedad(id)){
            System.out.print("El ID ingresado ya existe, porfavor ingresa otro ID:");
            while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("El valor ingresao es incorrecto<SOLO NUMEROS>");
                System.out.print("Ingrese el id de la propiedad:");
            }
        id=sc.nextInt();
        }
        //Por ultimo se le muestra la lista de Agentes dispibles y seleccionamos uno
        System.out.println("\nAGENTES DISPONIBLES");

        mostrarAgentesDisponibles();
        
        System.out.print("\nIngrese el USUARIO del Agente a quien se le asignara esta propiedad:");
        nombreAgente = scanAgente.nextLine();
        
        while(importarAgente(nombreAgente)==null){
            System.out.print("El USUARIO ingresado es INVALIDO..!, ingrese uno de la Lista:\n\n");
            mostrarAgentesDisponibles();
            System.out.print("\nIngrese el USUARIO del Agente a quien se le asignara esta propiedad:");
            nombreAgente = scanAgente.nextLine();
            
        }
            agenteElejido = importarAgente(nombreAgente);
            agenteElejido.toString();
      
          
        if (tipo.toLowerCase().equals("terreno")){
            Propiedad terreno = new Terreno(tipoterreno, precio, ancho, profundidad,ubicacionPropiedad, false, false, agenteElejido, id);
            UIUsuarios.getListaPropiedades().add(terreno);
            System.out.println("\n**** La propiedad TERRENO se creo EXITOSAMENTE :) :) ***\n");
            
                //Si esta condicion se cumple quiere decir que el terreno que acabamos de crear
                //cumplio alguna preferencia de la lista
                if(enviarNotiTerreno(terreno)){
                    System.out.println("Se ha enviado una notificación...");
                }
            
        }
        
        else if(tipo.toLowerCase().equals("casa")){
            Casa casita = new Casa(numpisos, numhabitaciones, precio, ancho, profundidad, ubicacionPropiedad, false, false, agenteElejido, id);
            UIUsuarios.getListaPropiedades().add(casita);
            System.out.println("\n**** La Propiedad CASA se creo EXITOSAMENTE :) :) ***\n");
            
            
                    if(enviarNotiCasa(casita)){
                        System.out.println("Se ha enviado una notificación...");
                    }
            
        }
        
        /*scanUbi.close();
        sc.close();*/
     
}
     
    //MuestraOpcion#2
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
        
         while(validarIdAgente(id)){
            System.out.print("El ID ingresado ya existe, porfavor ingresa otro ID:");
            while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("El valor ingresado es incorrecto<SOLO NUMEROS>");
                System.out.print("Ingrese id del Agente:");
            }
            
            id=sc.nextInt();
        } 
        
        Usuario Agente = new Agente_Venta(usuario, contraseña, nombre, identificacion, correo, id);
        UIUsuarios.getListaUsuarios().add(Agente);
         System.out.println("\n**** El Agente se creo EXITOSAMENTE :) :) ***\n");
        
}
    
    //MuestraOpcion#3
    private static void opcion3AD(){
        ArrayList<Venta> listaVentas; 
        Scanner sc = new Scanner(System.in);
        int numVentas=0;
        int numConsultas=0;
        System.out.println("Reporte contactos y ventas");
        System.out.print("Ingrese la fecha inicial :" + "(aaaa-mm-dd):");
        String Fechin = sc.nextLine();
        
        while(!validarFecha(Fechin)){
            System.out.println("Fecha ingresada no es correcta...!");
            System.out.print("Ingrese la fecha inicial: (aaaa-mm-dd)");
            Fechin = sc.nextLine();
        }
        LocalDate fechain = LocalDate.parse(Fechin);
        
        System.out.print("Ingrese la fecha final :" + "(aa-mm-dd):");
        String Fechfin = sc.nextLine();
        
        while(!validarFecha(Fechfin)){
            System.out.println("Fecha ingresada no es correcta...!");
            System.out.print("Ingrese la fecha final: (aaaa-mm-dd)");
            Fechfin = sc.nextLine();
        }
        
        LocalDate fechafin = LocalDate.parse(Fechfin);
        System.out.println("AGENTE\tNUMERO DE VENTAS\tNUMERO RESPUESTAS\n\n");
        
        for (Usuario ag: UIUsuarios.getListaUsuarios()){  
            if(ag!=null &&(ag instanceof Agente_Venta)){
                Agente_Venta otroAge=(Agente_Venta)ag;
                numConsultas = calcularNumeroConsultas(fechain,fechafin,otroAge);
                numVentas = calcularNumeroVentas(fechain,fechafin,otroAge);
                System.out.println(otroAge.getId()+"\t\t"+numVentas+"\t\t"+numConsultas);
            }//--INGRESA AL IF SI NO ESTA VACIA LA LISTA y Es un Agente de Venta
    
        }//--FINAL DEL FOR
        
        
            System.out.print("Ingrese el id del agente del que quiere ver mas detalles: ");
            int busquedaAgente = sc.nextInt();
            for ( Usuario u: UIUsuarios.getListaUsuarios()){
                if(u!=null & (u instanceof Agente_Venta)){
                    Agente_Venta ageMostrar = (Agente_Venta)u;
                    if(ageMostrar.getId()==busquedaAgente){
                        ageMostrar.mostrarInformacion();
                    }
                }
            }

}   

        
    public static boolean enIntervalo(LocalDate inicio, LocalDate fin, LocalDate buscar){
        return buscar.isAfter(inicio)&& buscar.isBefore(fin);
    }
    
    //Metodo para validar entrada de valores con decimales
    public static boolean esDecimal(String cad){
            try{
                Double.parseDouble(cad);
                return true;
            }catch(NumberFormatException nfe){
                return false;
            }
    }
     
    //Metodo que devuelve un Agente_Venta en caso de coincidir el usuario ingresado como parametro
    public static Agente_Venta importarAgente(String userAgente){
        for(Usuario u: UIUsuarios.getListaUsuarios()){
            if(u!=null){
                if(u instanceof Agente_Venta){
                    Agente_Venta agente = (Agente_Venta)u;
                    System.out.println(u.getUser());
                    if(u.getUser().equals(userAgente)){
                        System.out.println("SI COINCIDE CON NOMBRE DE AGENTE");
                        return agente;
                    }
                }
            }
        }
        System.out.println("NO SE ENCONTRO");
        return null;    
    }
    
    
    //Metodo que envia correo cuando se crea una Propiedad tipo TERRENO
    public static boolean enviarNotiTerreno(Propiedad propiedad){
        for(Notificacion n: UIUsuarios.getListaNotificaciones()){
            if(n!=null){
                if(n instanceof Notificacion){
                Propiedad terre = n.getPropiedadPreferencia();
                    if(terre!=null){
                        if(terre instanceof Terreno){
                        Terreno propi = (Terreno)propiedad;
                            if(terre.equals(propi)){
                                System.out.println("CUMPLIO");
                                Notificacion.enviarCorreo(n.getEmail(),n.getPropiedadPreferencia());
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    
    //Metodo que envía correo cuando se crea una Propiedad tipo CASA
    public static boolean enviarNotiCasa(Propiedad propiedad){
        for(Notificacion n: UIUsuarios.getListaNotificaciones()){
            if(n!=null){
                if(n instanceof Notificacion){
                Propiedad casa = n.getPropiedadPreferencia();
                    if(casa!=null){
                        if(casa instanceof Casa){
                        Casa propi = (Casa)propiedad;
                            if(casa.equals(propi)){
                                System.out.println("CUMPLIO");
                                Notificacion.enviarCorreo(n.getEmail(),n.getPropiedadPreferencia());
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    //Metodo que muestra los agentesDisponibles para asignacion de Propiedad
    public static void mostrarAgentesDisponibles(){
        int i=0;
        for(Usuario aventa: UIUsuarios.getListaUsuarios()){
                i+=1;
                if(aventa!=null){
                    if(aventa instanceof Agente_Venta){
                        Agente_Venta agent = (Agente_Venta)aventa;
                        System.out.print(i+") USUARIO: "+agent.getUser()+"\tNOMBRE: "+agent.getNombre()+"\n");
                    }
                }
        }
    }
    
    //Metodo que valida la ID de una propiedad, devuelve TRUE cuando la ID está
    //disponible, FALSE cuando ya existe la ID que se paso por argumento
    public static boolean validarIdPropiedad(int id){
        for(Propiedad p: UIUsuarios.getListaPropiedades()){
                if(p!=null){
                    if(p.getId()==id){
                        System.out.println("YA ExISTE ID PROPIEDAD");
                        return true;
                    }
                }
        }
        System.out.println("NO ExISTE ID PROPIEDAD");
        return false;
    }
    
    //Metodo que valida la ID de un Agente_Ventas, devuelve TRUE cuando la ID está
    //disponible, FALSE cuando ya existe la ID que se paso por argumento
    public static boolean validarIdAgente(int id){
        for(Usuario u: UIUsuarios.getListaUsuarios()){
            if(u!=null){
                if(u instanceof Agente_Venta){
                    Agente_Venta av = (Agente_Venta)u;
                    if(av.getId()==id){
                        System.out.println("YA ExISTE EL USUARIO");
                        return true;
                        
                    }
                }
            }
        }
        System.out.println("El ID esta disponible");
        return false;
    
    }
    
    public static boolean validarFecha(String cadena){
             try{
                LocalDate.parse(cadena);
                return true;
            }catch(DateTimeParseException n){
                return false;
            }
    }
    
    //Metodo calcula el numero de consulta que ha realizado un agente dentro de un filtro de Fecha
    public static int calcularNumeroConsultas(LocalDate inicio,LocalDate fin,Agente_Venta agente){
        int numConsul=0;
        for(Consulta c: UIUsuarios.getListaConsultas()){
            if(c!=null && (c instanceof Consulta)){
                Consulta otraConsul = (Consulta)c;
                Agente_Venta ageConsul = otraConsul.getAgente();
                if(ageConsul.equals(agente)){
                    LocalDate buscar=otraConsul.getFechaconsulta();
                    if(buscar.isAfter(inicio)&& buscar.isBefore(fin)){
                        numConsul+=1;
                    }
                        
                }
            }
        
        }
        return numConsul;
    }
    
    public static int calcularNumeroVentas(LocalDate inicio,LocalDate fin,Agente_Venta agente){
        int numVentas=0;
        for(Usuario u: UIUsuarios.getListaUsuarios()){
            if(u!=null &&(u instanceof Agente_Venta)){
                Agente_Venta otroAgen = (Agente_Venta)u;
                if(otroAgen.equals(agente)){
                    for(Venta v: otroAgen.getVentasRealizadas()){
                        LocalDate buscar = v.getFechaVenta();
                        if(buscar.isAfter(inicio)&&buscar.isBefore(fin)){
                            numVentas+=1;
                        }
                    }
                }
            }
        }
        return numVentas;
    }
    
    
   
    
}
    

