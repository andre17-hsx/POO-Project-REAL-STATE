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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import sistema_bienes_raices_g6.*;
/**
 *
 * @author andya
 */
public class Cliente extends Usuario{
    private ArrayList<Consulta> ListaConsultas;

    public Cliente(String user, String password, String nombre, int cedula, String correo, ArrayList<Consulta> ListaConsultas){
    super(user, password, nombre, cedula, correo, TipoUsuario.Cliente);
    this.ListaConsultas = ListaConsultas;
    }
    
    public Cliente(String nombre, String correo, int cedula){
        super(nombre, correo, cedula);
    }
    
    
    public static void MostrarMenuCliente(){
        Scanner  sc = new Scanner(System.in);
        String opcion;
        System.out.println("Bienvenido :)");
        do{
            System.out.println("1. Consultar Propiedad");
            System.out.println("2. Buzon de Consultas");
            System.out.println("3. Crear Alerta");
            System.out.println("4. Simular Prestamo");
            System.out.println("5. Cerrar sesion");
            System.out.println("Ingrese una opcion: ");
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
        System.out.println("Opcion Consular Propiedades");
        System.out.println("Ingrese Tipo de propiedad: (Casa o Terreno)");
        String tipo = sc.nextLine();
        while(!("casa".equals(tipo.toLowerCase())||"terreno".equals(tipo.toLowerCase()))){
            System.out.println("Tipo no válido");
            System.out.println("Ingrese Tipo de propiedad: (Casa o Terreno)");
            tipo = sc.nextLine();
            tipo.toLowerCase();
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
    
        System.out.println("Ingrese el precio minimo de la propiedad");
        while(!(sc.hasNextDouble()||sc.hasNextInt())){
                sc.nextLine();
                System.out.println("Precio incorrecto");
                System.out.println("Ingrese el precio de la propiedad");
            }
        double preciomin = sc.nextDouble();
        
        System.out.println("Ingrese el precio maximo de la propiedad");
        while(!(sc.hasNextDouble()||sc.hasNextInt())){
                sc.nextLine();
                System.out.println("Precio incorrecto");
                System.out.println("Ingrese el precio de la propiedad");
            }
        double preciomax = sc.nextDouble();
        
        System.out.println("Ingrese la ubicacion de la propiedad");
        String ubicacion = sc.nextLine();
        
        System.out.println("Tipo: " + tipo + "\n" + "Rango Precio:" + preciomin +"-" + preciomax + "\n" + "Ciudad" + ubicacion);
        boolean estadoVenta = false;
        for (Propiedad p: UIUsuarios.getpropiedades()){
                if (tipo.toLowerCase().equals("casa") && p instanceof Casa && preciomin>=(p.getPrecio()) && preciomax<=(p.getPrecio()) && ubicacion.toLowerCase().equals(p.getUbicacion()) && estadoVenta==p.isEstadoVenta()){
                Casa c = (Casa)p;
                System.out.println("Codigo  Precio  Tamaño[M2]  Pisos  Habitaciones  Ubicacion  Consultada" + "\n" +c.getId() + "  " + c.getPrecio() + "  " + (c.getAncho()*c.getProfundidad()) + "  " + c.getNumPisos() + "  " + c.getHabitaciones() + "  " + c.getUbicacion() + "  " + c.isConsultado());
                }
                else if(tipo.toLowerCase().equals("terreno") && p instanceof Terreno && preciomin>=(p.getPrecio()) && preciomax<=(p.getPrecio()) && ubicacion.toLowerCase().equals(p.getUbicacion()) && estadoVenta==p.isEstadoVenta()){
                Terreno t = (Terreno)p;
                System.out.println("Codigo  Tipo  Precio  Tamaño[M2]  Ubicacion Consultada" + "\n" +t.getId() + "  " + t.getTipo() + "  " + t.getPrecio() + "  " + (t.getAncho()*t.getProfundidad()) + "  " + t.getUbicacion() + "  " + t.isConsultado());
                }
            
        }
        System.out.println("Ingrese el codigo de la propiedad que desea ver mas detalles o vacio para regresar");
        String propiedadId = sc.nextLine();
        if (!propiedadId.isBlank()){
            int Id= Integer.parseInt(propiedadId);
            for (Propiedad p: UIUsuarios.getpropiedades()){
                if(Id==p.getId()){
                  if (p instanceof Casa){
                    Casa c = (Casa)p;
                    System.out.println("Codigo  Precio  Tamaño[M2]  Pisos  Habitaciones  Ubicacion  Consultada" + "\n" +c.getId() + "  " + c.getPrecio() + "  " + (c.getAncho()*c.getProfundidad()) + "  " + c.getNumPisos() + "  " + c.getHabitaciones() + "  " + c.getUbicacion() + "  " + c.isConsultado());
                    }
                    else if(p instanceof Terreno ){
                    Terreno t = (Terreno)p;
                    System.out.println("Codigo  Tipo  Precio  Tamaño[M2]  Ubicacion Consultada" + "\n" +t.getId() + "  " + t.getTipo() + "  " + t.getPrecio() + "  " + (t.getAncho()*t.getProfundidad()) + "  " + t.getUbicacion() + "  " + t.isConsultado());
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
            
            }
            
            
        }
    sc.close(); 
    }
   
    
    private static void opcion2C(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Opcion Buzon de Consultas");
        for (Consulta c: UIUsuarios.getConsultas()){
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
        for (Consulta c: UIUsuarios.getConsultas()){
            if(c.getCodigo()== codigo){
                for(Conversacion con:c.getConversa()){
                    System.out.println(con);
                }
                System.out.println("Desea agregar una pregunta o regresar (si/no)");
                String respuesta = sc.nextLine();
                if(respuesta.toLowerCase().equals("si")){
                    System.out.println("Ingrese la pregunta: ");
                    String pregunta = sc.nextLine();
                    LocalDate fechapreg = LocalDate.now();
                    Conversacion nuevo_mss  = new Conversacion(fechapreg, pregunta);
                    c.getConversa().add(nuevo_mss);
                }
            }
        }
    sc.close();
    }
    private static void opcion3C(){
        Notificacion alerta;
        String mail;
        Scanner sc = new Scanner(System.in);
        System.out.println("Opcion crear Alerta");
        System.out.println("Ingrese sus filtros de Alerta");
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
                
        System.out.println("Ingrese la ubicacion de la propiedad");
        System.out.print("Ingrese Provincia:"); String provincia = sc.nextLine();
        System.out.print("Ingrese Ciudad:"); String ciudad = sc.nextLine();
        System.out.print("Ingrese Direccion:"); String direccion = sc.nextLine();
        System.out.println("Ingrese Sector:"); String sector = sc.nextLine();
        String[] ubicacion = new String[]{provincia,ciudad,direccion,sector};  
        
        if (tipo.toLowerCase().equals("terreno")){
            Terreno terreno = new Terreno(tipoterreno, precio, ancho, profundidad, ubicacion);
            System.out.println("Ingrese correo electronico"); 
            mail = sc.nextLine();
            alerta = new Notificacion(mail,terreno);
            alerta.registrarNotificacion(alerta);
            
        /*for (Propiedad p: UIUsuarios.getListaPropiedades()){ //--> Aqui te puse getListaPropiedades porque salia error!!
            if (p instanceof Terreno && !p.isEstadoVenta()){
                Terreno t = (Terreno) p;
                if (t.equals(terreno)){
                    //envio correo de alerta
                    System.out.println("Alerta creada exitosamente");
                    }
                }   
           // }
        }*/
        
        }else if(tipo.toLowerCase().equals("casa")){
            Casa casita = new Casa(numpisos, numhabitaciones, precio, ancho, profundidad, ubicacion);
            System.out.println("Ingrese correo electronico"); 
            mail = sc.nextLine();
            alerta = new Notificacion(mail,casita);
            alerta.registrarNotificacion(alerta);
            
           /* for (Propiedad p: UIUsuarios.getpropiedades()){
            if (p instanceof Casa && !p.isEstadoVenta()){
                Casa c = (Casa) p;
                if (c.equals(casita)){
                    //envio correo de alerta
                    System.out.println("Alerta creada exitosamente");
                    }
                }   
            }*/         
        }
        //System.out.println("No hay propiedades con estas caracterizticas");
        

    }   
        
    private static void opcion4C(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Opcion Simular Prestamo");
         
         
         
         System.out.println("Ingrese el costo de la propiedad:");
         double costo = sc.nextInt();
         
         System.out.println("Ingrese su tasa de interes");
         double interes = sc.nextDouble();
         sc.nextLine();
                 
         System.out.println("Ingrese el numero cuotas");
         int cuotas = sc.nextInt();
         sc.nextLine();
         
         System.out.println("Ingrese el sistema de amortizacion");
         String sistema = sc.nextLine();
         
         double prestamo = 0;
         if (sistema.toLowerCase().equals("frances")){
             CalculadoraPrestamoFrances p1 = new CalculadoraPrestamoFrances(interes, costo, cuotas);
             prestamo = p1.calculadoraPrestamo();
             System.out.println("Su prestamo tendria un valor de :" + prestamo);

         }
         else if (sistema.toLowerCase().equals("aleman")){
             CalculadoraPrestamoAleman p1 = new CalculadoraPrestamoAleman(interes, costo, cuotas);
             prestamo = p1.calculadoraPrestamo();
             System.out.println("Su prestamo tendria un valor de :" + prestamo);
         }
   }
    private static void opcion5C(){
        Scanner sc = new Scanner(System.in);}


    
    
}
