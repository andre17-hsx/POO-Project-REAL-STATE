/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prestamos;

import java.lang.Math;
/**
 *
 * @author ALICE
 */
public class CalculadoraPrestamo {
    private double costoPropiedad;
    private double tasaInteres;
    private int num_cuotas;
    private double cuotaMensual;
    
    public double calculadorPrestamo(double costoPropiedad, double tasaInteres, int num_cuotas, String tipo){
        if(tipo == "frances"){
            cuotaMensual = costoPropiedad*(tasaInteres/(1-Math.pow(1+tasaInteres, -num_cuotas)));
        }
        if(tipo == "aleman"){
            cuotaMensual = (costoPropiedad*tasaInteres)/(1-Math.pow(1+tasaInteres, num_cuotas));
        }
        return cuotaMensual;
    }
}
