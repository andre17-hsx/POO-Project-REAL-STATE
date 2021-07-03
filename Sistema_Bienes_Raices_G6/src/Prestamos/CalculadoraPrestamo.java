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
public abstract class CalculadoraPrestamo{
    protected double tasaInteres;
    protected int num_cuotas;
    protected double costoPropiedad;
    
    
    public abstract double calculadoraPrestamo();
}
