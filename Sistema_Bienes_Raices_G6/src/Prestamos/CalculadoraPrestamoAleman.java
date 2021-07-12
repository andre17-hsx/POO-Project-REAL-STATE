
package Prestamos;

/**
 *
 * @author Gene
 */

/*=================================================================================================|
SubCLASE CalculadoraPrestamoAleman                                                                 |
Calcula las cuotas mensuales del préstamo de tipo alemán.                                          |
====================================================================================================*/
public class CalculadoraPrestamoAleman extends CalculadoraPrestamo{
        private double tasaInteres;
        private double costoPropiedad;
        private int num_cuotas;
    
     /**Constructor con 3 parametros
     * @param tasaInteres
     * @param costoPropiedad
     * @param num_cuotas 
     */
    public CalculadoraPrestamoAleman(double tasaInteres, double costoPropiedad, int num_cuotas){
        //@param
        this.tasaInteres= tasaInteres;
        this.costoPropiedad= costoPropiedad;
        this.num_cuotas=num_cuotas;
    }
    
    //Metrodo Abstacto Sobrescrito
    /**
     *calculadoraPrestamo()
     * @return valorapgar de la simulacion
     */
    @Override
    
    public double calculadoraPrestamo() {
        //Datos a Utilizados para realizar calculos
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

