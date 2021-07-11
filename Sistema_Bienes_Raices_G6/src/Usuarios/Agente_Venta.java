/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import sistema_bienes_raices_g6.UIUsuarios;
import sistema_bienes_raices_g6.Venta;

/**
 *
 * @author andya
 */
public class Agente_Venta extends Usuario {
    //private ArrayList<Propiedad> ListaPropiedades;
    private static ArrayList<Venta> VentasRealizadas;
    //private ArrayList<Consultas> ListaConsultas;
    private static int contador;
    private int id;
    
     public Agente_Venta(String user, String password, String nombre, int cedula, String correo, int id) {
        super(user, password, nombre, cedula, correo/*, TipoUsuario.Agente_Venta*/);
        VentasRealizadas = new ArrayList<Venta>();
        contador= 0;
        this.id = id;
    }
    
    
    public static void MostrarMenuAgente(){
        Scanner  sc = new Scanner(System.in);
        String opcion;
        do{
            System.out.println("\t\tBienvenido :)");
            System.out.println("\nOPCIONES DE AGENTE DE VENTAS\n");
            System.out.println("1. Revisar Buzon");
            System.out.println("2. Registrar Venta");
            System.out.println("3. Cerrar sesion");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    opcion1AV();
                    break;
                case "2":
                    opcion2AV();
                    break;
                case "3":
                    System.out.println("Sesion cerrada");
                    break;  
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!opcion.equals("3"));
        }
    
    private static void opcion1AV(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Opcion Buzon de Consultas");
        //Muestro por pantalla todas las consultas
        for (Consulta c: UIUsuarios.getListaConsultas()){
            System.out.println("Fecha_Inicio  Codigo_Propiedad  Nombre_Agente  Pregunta  Estado" + "\n" +
                                c.getFechaconsulta() + "  " + c.getCodigo()+ "  " + c.getAgente() + "  " + c.getPregunta()+ "  " + c.isIsRespondida());
        }
        
        System.out.println("Ingrese el id de la propiedad para responder la consulta");
        while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Id incorrecta");
                System.out.println("Ingrese el id de la propiedad para seguir la consulta");
            }
        
        //Le pregunto al agente si quiere responder alguna consulta
        int codigo = sc.nextInt();
        for (Consulta c: UIUsuarios.getListaConsultas()){
            if(c.getCodigo()== codigo){
                for(Conversacion con:c.getConversaciones()){
                    System.out.println(con);
                }
                System.out.println("Desea agregar una respuesta o regresar (si/no)");
                String respuesta = sc.nextLine();
                if(respuesta.toLowerCase().equals("si")){
                    System.out.println("Ingrese la respuesta: ");
                    String pregunta = sc.nextLine();
                    LocalDate fechapreg = LocalDate.now();
                    Conversacion nuevo_mss  = new Conversacion(fechapreg, pregunta);
                    c.getConversaciones().add(nuevo_mss);
                    contador+=1;
                }
            }
        }
    }
    
    
    private static void opcion2AV(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Opcion Resgistrar Venta");
        System.out.println("Ingrese los datos del cliente al que se realizo la venta");
        System.out.print("Ingrese el nombre del cliente:");
        String nombrec = sc.nextLine();
        System.out.print("Ingrese el correo del cliente");
        String correoc= sc.nextLine();
        System.out.print("Ingrese los datos la cedula del cliente: ");
        while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Cedula Identidad Incorrecta");
                System.out.print("Ingrese su identificacion correctamente:");
            }

        int cedulac= sc.nextInt();
        sc.nextLine();
        
        //Pido los datos de la venta que realizo, creo una venta con esos datos y lo añado a la lista de ventas realizadas
        Cliente cv = new Cliente(nombrec, correoc, cedulac);
        LocalDate fechav = LocalDate.now();
        Venta v = new Venta(fechav, cv);
   
        VentasRealizadas.add(v);
        
    
    }

    public int getId() {
        return id;
    }

    public static void setVentasRealizadas(ArrayList<Venta> VentasRealizadas) {
        Agente_Venta.VentasRealizadas = VentasRealizadas;
    }

    public ArrayList<Venta> getVentasRealizadas() {
        return VentasRealizadas;
    }
    
    public int getContador(){
        return contador;
    }
    
    public void mostrarInformacion(){
        System.out.print("\nVentas:"+ VentasRealizadas.size()+"\nConsultas:"+calcularNumeroConsultas()+
                "\nNombre: "+super.getNombre()+"\nUsuario: "+super.getUser());
    }
    
    public int calcularNumeroConsultas(){
       
        for(Consulta c: UIUsuarios.getListaConsultas()){
            if(c!=null){
                if(c.getAgente().getId()==id){
                contador +=1;
                return contador;
                }
            }
        }
        return contador;
    }
    
    
    public int calcularVentasRealizadas(){
        return VentasRealizadas.size();
    }
}

