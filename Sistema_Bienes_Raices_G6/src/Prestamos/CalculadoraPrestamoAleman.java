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
    
        public CalculadoraPrestamoAleman(){}
    
    public double calculadoraPrestamoFrances(double costoPropiedad, double tasaInteres, int num_cuotas){
        CalculadoraPrestamoAleman c = new CalculadoraPrestamoAleman();
        return c.calculadorPrestamo(costoPropiedad, tasaInteres, num_cuotas, "aleman");
    }       
}
