/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_bienes_raices_g6.Usuarios;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author andya
 */
public class Agente_Venta extends Usuario {
    private ArrayList<Propiedad> ListaPropiedades;
    private ArrayList<Venta> ListaVentas;
    private ArrayList<Consulta> ListaConsultas;

    public Agente_Venta(String user, String password, String nombre, int cedula, String correo, ArrayList<Propiedad> ListaPropiedades, ArrayList<Venta> ListaVentas, ArrayList<Consulta> ListaConsultas){
    super(user, password, nombre, cedula, correo, TipoUsuario.Agente_Venta);
    this.ListaPropiedades = ListaPropiedades;
    this.ListaVentas= ListaVentas;
    this.ListaConsultas= ListaConsultas;
    }
    
    public static void MostrarMenuAdministrador(){
        Scanner  sc = new Scanner(System.in);
        String opcion;
        System.out.println("Bienvenido :)");
        do{
            System.out.println("1. Revisar Buzon");
            System.out.println("2. Responder Consultas");
            System.out.println("3. Registrar Venta");
            System.out.println("4. Cerrar sesion");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    opcion1AV();
                    break;
                case "2":
                    opcion2AV();
                    break;
                case "3":
                    opcion3AV();
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
    
    private static void opcion1AV(){
        Scanner sc = new Scanner(System.in);
    }
    
    
    private static void opcion2AV(){
        Scanner sc = new Scanner(System.in);
    }
    
    
    private static void opcion3AV(){
        Scanner sc = new Scanner(System.in);
    }
    
    
    public static void RevisarBuzon(){}
    
    
    public void ResponderConsulta(){}
    
    //public void RegistrarVenta(Venta){}
    
}
