/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prestamos;

/**
 *
 * @author Gene
 */
public class CalculadoraPrestamoAleman extends CalculadoraPrestamo{
    
    public CalculadoraPrestamoAleman(double tasaInteres, double costoPropiedad, int num_cuotas){
        this.tasaInteres= tasaInteres;
        this.costoPropiedad= costoPropiedad;
        this.num_cuotas=num_cuotas;
    }
 
    @Override
    public double calculadoraPrestamo() {
        double cuotaMensual = costoPropiedad*(tasaInteres/(1-Math.pow(1+tasaInteres, -num_cuotas)));
       
    return cuotaMensual;    
    }
 }       

