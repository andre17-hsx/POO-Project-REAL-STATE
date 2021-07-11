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
        private double tasaInteres;
        private double costoPropiedad;
        private int num_cuotas;
    
    public CalculadoraPrestamoAleman(double tasaInteres, double costoPropiedad, int num_cuotas){
        this.tasaInteres= tasaInteres;
        this.costoPropiedad= costoPropiedad;
        this.num_cuotas=num_cuotas;
    }
 
    @Override
    public double calculadoraPrestamo() {
        double tasaParcial = (1-tasaInteres/100);
        double interesAnio = costoPropiedad*(tasaInteres/100);
        double anulidad;
        double amortizacion;  //interesAnio(IK);
        double capitalVivo = costoPropiedad;
        
        
        double capitalAmortizado = costoPropiedad;
        double capitalPendiente = costoPropiedad;//(Mk)

        System.out.println("\nCuota\tANULIDAD\tAMORTIZACION\tInteres          CapitalAMORTIZADO\tCapitalPendiente");
  
        for(int i=1;i<=num_cuotas;i++){
            tasaInteres =Math.pow(tasaParcial,i) ;
            anulidad =(costoPropiedad*(tasaInteres/100))/(1-tasaInteres);
            double rndAnulidad = Math.round(anulidad*100.0)/100.0;
            amortizacion = anulidad-interesAnio;
            double rndAmort = Math.round(amortizacion*100.0)/100.0;
            capitalPendiente -=amortizacion; //(Mk)
            double rndCapPend = Math.round(capitalPendiente*100.0)/100.0;
            capitalAmortizado +=amortizacion;//(CK)
            double rndCapAmort=Math.round(capitalAmortizado*100.0)/100.0;
            capitalAmortizado += amortizacion;
            double rndCapital = Math.round(capitalAmortizado*100.0)/100.0;
            capitalVivo=capitalVivo-(capitalAmortizado)-amortizacion;
            double rndCapVivo = Math.round(capitalVivo*100.0)/100.0;
            double rndIntAnio = Math.round(interesAnio*100.0)/100.0;
            
           System.out.println(i+"\t"+rndAnulidad+"\t\t"+rndAmort+"               "+rndIntAnio+"           "+rndCapAmort+"\t\t"+rndCapPend);
           interesAnio=capitalAmortizado*(tasaInteres/100);
        }
       
    return capitalPendiente;    
    }
 }       

