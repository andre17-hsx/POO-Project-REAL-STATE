/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Prestamos.CalculadoraPrestamoAleman;
import Prestamos.CalculadoraPrestamoFrances;
import Propiedades.Casa;
import Propiedades.Propiedad;
import Propiedades.Terreno;
import Propiedades.TipoTerreno;
import static Usuarios.Administrador.esDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import sistema_bienes_raices_g6.*;
/**
 *
 * @author andya
 */
public class Cliente extends Usuario{
    private ArrayList<Consulta> ListaConsultas;

    public Cliente(String user, String password, String nombre, int cedula, String correo, ArrayList<Consulta> ListaConsultas){
    super(user, password, nombre, cedula, correo/*, TipoUsuario.Cliente*/);
    this.ListaConsultas = ListaConsultas;
    }
    
    public Cliente(String user, String password,String nombre, int cedula,String correo){
        super(user,password,nombre,cedula, correo);
    }
    
    //Bro este constructor tu lo usaste para crear 
    public Cliente(String nombre, String correo, int cedula){
        super(nombre, correo, cedula);
    }
    
    
    public static void MostrarMenuCliente(){
        Scanner  sc = new Scanner(System.in);
        String opcion;
        do{
            System.out.println("\t\tBienvenido :)");
            System.out.println("\nOPCIONES DE CLIENTE\n");
            System.out.println("1. Consultar Propiedad");
            System.out.println("2. Buzon de Consultas");
            System.out.println("3. Crear Alerta");
            System.out.println("4. Simular Prestamo");
            System.out.println("5. Cerrar sesion");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    opcion1C();
                    break;
                case "2":
                    opcion2C();
                    break;
                case "3":
                    opcion3C();
                    break;
                case "4":
                    opcion4C();
                    break;
                case "5":
                    System.out.println("Sesion cerrada");
                    break ; 
                 
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!opcion.equals("5"));
}
    
    private static void opcion1C(){
        Scanner sc = new Scanner(System.in);
        int encontrado =0;
        System.out.println("Opcion Consular Propiedades");
        System.out.print("Ingrese Tipo de propiedad <Casa> o <Terreno> :");
        String tipo = sc.nextLine();
        while(!("casa".equals(tipo.toLowerCase())||"terreno".equals(tipo.toLowerCase()))){
            System.out.println("Tipo no válido");
            System.out.println("Ingrese Tipo de propiedad: (Casa o Terreno)");
            tipo = sc.nextLine();
            tipo.toLowerCase();
        }
        
        TipoTerreno tipoterreno = null;
        
        if (tipo.toLowerCase().equals("terreno")){
            
            //Bro aqui la miss solo dice que lo filtre por tipo, osea terreno o casa, nada mas.
            /*System.out.println("Ingrese el tipo de terreno (Comercial, Vivienda o Empresarial)");
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
            }*/
          
        }
        
        int numpisos = 0;
        int numhabitaciones = 0;
        if (tipo.toLowerCase().equals("casa")){
            /*
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
            numhabitaciones = sc.nextInt();*/
        }
    
        System.out.print("Ingrese el precio minimo de la propiedad: ");
        String valor = sc.nextLine();
        while(!esDecimal(valor)){
                System.out.println("Precio minimo incorrecto");
                System.out.print("Ingrese precio correctamente:");
                valor = sc.nextLine();
            }

        Double preciomin = Double.parseDouble(valor);
       
        
        System.out.print("Ingrese el precio maximo de la propiedad: ");
        valor = sc.nextLine();
        while(!esDecimal(valor)){
                System.out.println("Precio maximo incorrecto");
                System.out.print("Ingrese precio correctamente: ");
                valor = sc.nextLine();
            }
        Double preciomax = Double.parseDouble(valor);
        

        System.out.println("Ingrese la ubicacion de la propiedad");
        System.out.print("Ingrese la Provincia:");
        String provincia = sc.nextLine();
        System.out.print("Ingrese la Ciudad:");
        String ciudad = sc.nextLine();
        System.out.print("Ingrese el sector: ");
        String sector=sc.nextLine();
        String ubicacion = sc.nextLine();
        
        System.out.println("Tipo: " + tipo + "\nRango Precio:" + preciomin +"-" + preciomax + "\nProvincia:"+provincia+"\nCiudad: " + ciudad+"\nSector: "+sector);
        boolean estadoVenta = false;
        
        for (Propiedad p: UIUsuarios.getListaPropiedades()){
            if(p!=null && tipo.toLowerCase().equals("casa")){
                if(p instanceof Casa){
                   Casa c = (Casa)p;
                   if (preciomin<=(p.getPrecio()) && preciomax>=(p.getPrecio()) && (p.getProvincia().toLowerCase().equals(provincia) && p.getCiudad().toLowerCase().equals(ciudad) && p.getSector().toLowerCase().equals(sector)) && !p.isEstadoVenta()){
                        System.out.println("\nCodigo\t\tPrecio\t\tTamaño[M2]\tPisos\tHabitaciones\tUbicacion\t\t\tConsultada" + "\n" +c.getId() + "\t\t" + 
                                c.getPrecio() + "\t\t" + (c.getAncho()*c.getProfundidad()) + "\t\t" + c.getNumPisos() + " \t" + c.getHabitaciones() + "\t\t" + c.getProvincia()+"-"+c.getCiudad()+"-"+c.getSector() + "\t" + c.isConsultado());
                   encontrado =1;
                   }
                }
            }else if(p!=null && tipo.toLowerCase().equals("terreno")){
                if(p instanceof Terreno){
                    Terreno t = (Terreno)p;
                    if(preciomin<=(p.getPrecio()) && preciomax>=(p.getPrecio()) && (p.getProvincia().toLowerCase().equals(provincia) && p.getCiudad().toLowerCase().equals(ciudad) && p.getSector().toLowerCase().equals(sector)) && !p.isEstadoVenta()){
                        System.out.println("\nCodigo\tTipo\t\tPrecio\t\tTamaño[M2]\tUbicacion\t\t\tConsultada" + "\n" +t.getId() + "\t" + 
                                t.getTipo() + "\t" + t.getPrecio() + "\t\t" + (t.getAncho()*t.getProfundidad()) + "\t\t"+ t.getProvincia()+"-"+t.getCiudad()+"-"+t.getSector() + "\t\t" + t.isConsultado());
                    encontrado=1;
                    }
                }
            
            }else if(p==null){System.out.println("La lista de Propiedades esta vacia...");}
        }
        if(encontrado!=1){System.out.println("\nNO se encontro la propiedad con los parámetros indicados...!");}
        
        System.out.print("\nIngrese el codigo de la propiedad que desea ver mas detalles o vacio para regresar: ");
        String propiedadId = sc.nextLine();
        
        //VaLIDACION EN CASO DE QUE NO INGRESE NINGUNA OPCION
        if (!propiedadId.isBlank()){
            int Id= Integer.parseInt(propiedadId);
            for (Propiedad p: UIUsuarios.getListaPropiedades()){
                
                if(p!=null){
                    if(Id==p.getId()){
                        if (p instanceof Casa){
                            Casa c = (Casa)p;
                            c.mostrarInformacion();
                            //System.out.println("Codigo  Precio  Tamaño[M2]  Pisos  Habitaciones  Ubicacion  Consultada" + "\n" +c.getId() + "  " + c.getPrecio() + "  " + (c.getAncho()*c.getProfundidad()) + "  " + c.getNumPisos() + "  " + c.getHabitaciones() + "  " + c.getUbicacion() + "  " + c.isConsultado());
                        }else if(p instanceof Terreno ){
                            Terreno t = (Terreno)p;
                            t.mostrarInformacion();
                            //System.out.println("Codigo  Tipo  Precio  Tamaño[M2]  Ubicacion Consultada" + "\n" +t.getId() + "  " + t.getTipo() + "  " + t.getPrecio() + "  " + (t.getAncho()*t.getProfundidad()) + "  " + t.getUbicacion() + "  " + t.isConsultado());
                        }
                        System.out.println("Desea realizar una consulta (si/no)");
                        String consultar = sc.nextLine();
                        if (consultar.toLowerCase().equals("si")){
                        //ArrayList<Consulta> ListaConsultas = new ArrayList<>();
                        System.out.println("Ingrese la consulta : ");
                        String consulta = sc.nextLine();
                        LocalDate fecha = LocalDate.now();
                        p.setConsultado(true);
                        Consulta c = new Consulta(fecha, p.getId(), p.getAgente(), consulta, false);
                        UIUsuarios.getListaConsultas().add(c);
                        }
                    }
                }//--INGRESA AL IF SIEMPRE Y CUANDO ESTE VACIO

            }//-->FIN DEL FOR DE RECORRIDO DE listaPropiedades
            
        }//--> FIN DEL IF DE VALIDACION
        
    }
       
    private static void opcion2C(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Opcion Buzon de Consultas");
        for (Consulta c: UIUsuarios.getListaConsultas()){
            System.out.println("Fecha_Inicio  Codigo_Propiedad  Nombre_Agente  Pregunta  Estado" + "\n" +
                                c.getFechaconsulta() + "  " + c.getCodigo()+ "  " + c.getAgente() + "  " + c.getPregunta()+ "  " + c.isIsRespondida());
        }
        
        System.out.println("Ingrese el id de la propiedad para seguir la consulta");
        while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Id incorrecta");
                System.out.println("Ingrese el id de la propiedad para seguir la consulta");
            }
        int codigo = sc.nextInt();
        for (Consulta c: UIUsuarios.getListaConsultas()){
            if(c.getCodigo()== codigo){
                for(Conversacion con:c.getConversaciones()){
                    System.out.println(con);
                }
                System.out.println("Desea agregar una pregunta o regresar (si/no)");
                String respuesta = sc.nextLine();
                if(respuesta.toLowerCase().equals("si")){
                    System.out.println("Ingrese la pregunta: ");
                    String pregunta = sc.nextLine();
                    LocalDate fechapreg = LocalDate.now();
                    Conversacion nuevo_mss  = new Conversacion(fechapreg, pregunta);
                    c.getConversaciones().add(nuevo_mss);
                }
            }
        }
    }
    
    private static void opcion3C(){
        Notificacion alerta;
        String mail;
        Scanner sc = new Scanner(System.in);
        Scanner scPrecio = new Scanner(System.in);
        Scanner scAncho = new Scanner(System.in);
        Scanner scProf = new Scanner(System.in);
        System.out.println("Opcion crear Alerta");
        System.out.print("Ingrese sus filtros de Alerta <casa> o <terreno>:");
        String tipo = sc.nextLine();
        while(!("casa".equals(tipo.toLowerCase())||"terreno".equals(tipo.toLowerCase()))){
            System.out.println("Tipo no válido");
            System.out.print("Ingrese el tipo del propiedad <terreno> o <casa>):");
            tipo = sc.nextLine();
            
        }
        
        TipoTerreno tipoterreno = null;
        
        if (tipo.toLowerCase().equals("terreno")){
            System.out.print("Ingrese el tipo de terreno <Comercial>,<Vivienda> o <Empresarial>: ");
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
                    System.out.print("Ingrese el tipo de terreno <Comercial>, <Vivienda> o <Empresarial>: )");
            }
          
        }
        
        int numpisos = 0;
        int numhabitaciones = 0;
        if (tipo.toLowerCase().equals("casa")){
            System.out.print("Ingrese el numero de pisos:");
            while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.print("Cantidad de pisos incorrectos:");
                System.out.print("Ingrese el numero de pisos de la propiedad:");
            }
            numpisos = sc.nextInt();
        
            System.out.print("Ingrese el numero de habitaciones de la propiedad: ");
            while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Numero de habitaciones incorrecto");
                System.out.print("Ingrese el numero de habitaciones de la propiedad: ");
            }
            numhabitaciones = sc.nextInt();
        }
        
        System.out.print("Ingrese el precio de la propiedad: ");
        String valor = sc.nextLine();
        while(!esDecimal(valor)){
                sc.reset();
                System.out.println("Precio incorrecto");
                System.out.print("Ingrese precio correctamente:");
                valor = sc.nextLine();
            }

        Double precio = Double.parseDouble(valor);
        
        System.out.print("Ingrese el ancho de la propiedad: ");
        valor = scAncho.nextLine();
        while(!esDecimal(valor)){
                sc.reset();
                System.out.println("Ancho incorrecto");
                System.out.print("Ingrese ancho correctamente:");
                valor = sc.nextLine();
            }

        Double ancho = Double.parseDouble(valor);

        
        System.out.print("Ingrese la profundidad de la propiedad: ");
        valor = sc.nextLine();
        while(!esDecimal(valor)){
                sc.reset();
                System.out.println("Profundidad incorrecto");
                System.out.print("Ingrese profundidad correctamente:");
                valor = sc.nextLine();
            }

        Double profundidad = Double.parseDouble(valor);

        
        System.out.println("Ingrese la ubicacion de la propiedad ");
        System.out.print("Ingrese Provincia:"); String provincia = sc.nextLine();
        System.out.print("Ingrese Ciudad:"); String ciudad = sc.nextLine();
        System.out.print("Ingrese Direccion:"); String direccion = sc.nextLine();
        System.out.print("Ingrese Sector:"); String sector = sc.nextLine();
        String[] ubicacion = new String[]{provincia,ciudad,direccion,sector};  
        
        if (tipo.toLowerCase().equals("terreno")){
            Propiedad terreno = new Terreno(tipoterreno, precio, ancho, profundidad, ubicacion);
            System.out.print("Ingrese correo electronico: "); 
            mail = sc.nextLine();
            alerta = new Notificacion(mail,terreno);
            
            if(UIUsuarios.getListaNotificaciones().contains(alerta)){
                System.out.println("YA EXISTE UNA ALERTA IGUAL");
            }
                UIUsuarios.getListaNotificaciones().add(alerta);
                Notificacion.enviarCorreo(mail, terreno);
                System.out.println("La alerta se creo Exitosamente...se envio un correo a:"+mail);
            
            //en el metodo registrarNotificacionn ya se considera que la notificacion no se repita
            //t.equals(terreno), si ya existe un correo con la misma preferencia no lo agrega
        /*for (Propiedad p: UIUsuarios.getListaPropiedades()){ //--> Aqui te puse getListaPropiedades porque salia error!!
            if (p instanceof Terreno){
                Terreno t = (Terreno) p;
                if (t.equals(terreno)){
                    System.out.println("La notificacion fue creada exitosamente");
                    }
                }   
           // }
        }*/
        
        }else if(tipo.toLowerCase().equals("casa")){
            Propiedad casita = new Casa(numpisos, numhabitaciones, precio, ancho, profundidad, ubicacion);
            System.out.print("Ingrese correo electronico: "); 
            mail = sc.nextLine();
            alerta = new Notificacion(mail,casita);
            
            if(UIUsuarios.getListaNotificaciones().contains(alerta)){
                System.out.println("YA EXISTE UNA ALERTA IGUAL");
            }
            UIUsuarios.getListaNotificaciones().add(alerta);
            Notificacion.enviarCorreo(mail,casita);
            System.out.println("\nLa alerta se creo Exitosamente...se envio un correo a:"+mail);

            
            /*for (Propiedad p: UIUsuarios.getListaPropiedades()){
            if (p instanceof Casa){
                Casa c = (Casa) p;
                if (c.equals(casita)){
                    System.out.println("Alerta creada exitosamente");
                    }
                }   
            }       
        }
        //System.out.println("No hay propiedades con estas caracterizticas");
        */
        }
    }   
        
    private static void opcion4C(){
         Scanner sc = new Scanner(System.in);
         Scanner scAmorti = new Scanner(System.in);
         String valor;
         System.out.println("Opcion Simular Prestamo");
         
         
         
         System.out.print("Ingrese el costo de la propiedad:");
         valor = sc.nextLine();
            while(!esDecimal(valor)){
                sc.reset();
                System.out.println("Precio incorrecto");
                System.out.print("Ingrese costo correctamente:");
                valor = sc.nextLine();
            }

        Double costo = Double.parseDouble(valor);
         
        System.out.print("Ingrese su tasa de interes: ");
        valor = sc.nextLine();
        while(!esDecimal(valor)){
                sc.reset();
                System.out.println("Tasa incorrecto");
                System.out.print("Ingrese tasa correctamente:");
                valor = sc.nextLine();
        }

        Double interes = Double.parseDouble(valor);

                 
         System.out.print("Ingrese el numero cuotas: ");
         while(!sc.hasNextInt()){
             sc.nextLine();
             System.out.println("Dato invalido...Ingrese solo numeros enteros...");
             System.out.print("Ingrese numero de cuotas: ");
         }
         
         int cuotas = sc.nextInt();
         
         
         System.out.print("Ingrese el sistema de amortizacion <frances> o <aleman> : ");
         String sistema = scAmorti.nextLine();
         
         double prestamo = 0;
         if (sistema.toLowerCase().equals("frances")){
             CalculadoraPrestamoFrances p1 = new CalculadoraPrestamoFrances(interes, costo, cuotas);
             System.out.println(p1.getCosto());
             System.out.println(p1.getCuotas());
             System.out.println(p1.getTasa());
             prestamo = p1.calculadoraPrestamo();
             System.out.println("Su prestamo tendria un valor de :" + prestamo);

         }
         else if (sistema.toLowerCase().equals("aleman")){
             CalculadoraPrestamoAleman p1 = new CalculadoraPrestamoAleman(interes, costo, cuotas);
             prestamo = p1.calculadoraPrestamo();
             System.out.println("Su prestamo tendria un valor de :" + prestamo);
         }
         
         System.out.println("\n****   FIN DE SIMULACION    *****\n\n");
   }
    private static void opcion5C(){
        Scanner sc = new Scanner(System.in);
    }
    
    //Metodo que muestra los detalles completos de una propiedad
    private static void mostrarListaPropiedades(){
        for(Propiedad p:UIUsuarios.getListaPropiedades()){
            if(p!=null){
                p.mostrarInformacion();
            }   
        }
    }
    
   //Metodo que registra una preferencia, siempre y cuando no este repetida
    public static boolean registrarNotificacion(Notificacion noti) {
        for (Notificacion i : UIUsuarios.getListaNotificaciones()) {
            if(i!=null){
                if (!i.equals(noti)) {
                    System.out.println("se creo la alerta con exito");
                    UIUsuarios.getListaNotificaciones().add(noti);
                    return true;
                }
            }
            
        }
        System.out.println("Ya existe una notificacion, no se creo la alerta");
        return false;
    }
    
    
}
