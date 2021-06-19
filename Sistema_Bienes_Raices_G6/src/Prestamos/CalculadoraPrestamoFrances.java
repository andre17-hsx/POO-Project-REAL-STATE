/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prestamos;

/**
 *
 * @author ALICE
 */

public class CalculadoraPrestamoFrances extends CalculadoraPrestamo{
    
    public CalculadoraPrestamoFrances(){}
    
    public double calculadoraPrestamoFrances(double costoPropiedad, double tasaInteres, int num_cuotas){
        CalculadoraPrestamoFrances c = new CalculadoraPrestamoFrances();
        return c.calculadorPrestamo(costoPropiedad, tasaInteres, num_cuotas, "frances");
        
    }
    
}
