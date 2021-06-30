/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Propiedades.Propiedad;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Objects;
/**
 *
 * @author andya
 */
public class Cliente extends Usuario{
    private ArrayList<Consultas> ListaConsultas;

    public Cliente(String user, String password, String nombre, int cedula, String correo, ArrayList<Consultas> ListaConsultas){
    super(user, password, nombre, cedula, correo, TipoUsuario.Cliente);
    this.ListaConsultas = ListaConsultas;
    }
    
    public static void MostrarMenuCliente(){
        Scanner  sc = new Scanner(System.in);
        String opcion;
        System.out.println("Bienvenido :)");
        do{
            System.out.println("1. Consultar Propiedad");
            System.out.println("2. Simular Prestamo");
            System.out.println("3. Realizar Consulta a un Agente");
            System.out.println("4. Autoregistrarse");
            System.out.println("5. Crear Alerta" );
            System.out.println("6. Cerrar sesion");
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
                    opcion5C();
                    break;  
                case "6":
                    System.out.println("Sesion cerrada");
                    break;  
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!opcion.equals("6"));
        }
    
    private static void opcion1C(){
        Scanner sc = new Scanner(System.in);}
    private static void opcion2C(){
        Scanner sc = new Scanner(System.in);}
    private static void opcion3C(){
        Scanner sc = new Scanner(System.in);}
    private static void opcion4C(){
         Scanner sc = new Scanner(System.in);}
    private static void opcion5C(){
        Scanner sc = new Scanner(System.in);}
    
    
    public void ConsultarPropiedad(ArrayList<Propiedad> ListaP, int precio){}
    public void ConsultarPropiedad(ArrayList<Propiedad> ListaP, String Tipo){}
    //public void ConsultarPropiedad(ArrayList<Propiedad> ListaP, String Ciudad){}
    //public void ConsultarPropiedad(ArrayList<Propiedad> ListaP, String Sector){}
}
