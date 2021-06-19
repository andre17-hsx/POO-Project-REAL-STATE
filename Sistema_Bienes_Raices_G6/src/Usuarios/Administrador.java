/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);}
        
     
     
     private static void opcion2AD(){
        Scanner sc = new Scanner(System.in);}
    
    
    private static void opcion3AD(){
        Scanner sc = new Scanner(System.in);}
    
    //public void RegistrarPropiedad(Propiedad){}
    
    //public void RegistrarAgente(Agente_Venta Agente, ArrayList<Propiedad> Propiedades){}
    
    //public void ReporteGeneral(Fehca_Inicio, Fecha_Fin){}
}
