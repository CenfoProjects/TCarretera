
package tcarretera;

import java.util.ArrayList;

/**
 *
 * @author Jose P. Medrano
 */
public class Carretera {

    private Tramo tramoMasCorto;
    private Tramo tramoMasLargo;
    private Tramo ultimoTramoRegistrado;
    public int numTramoMasCorto;
    public int numTramoMasLargo;
    public double longitudTramoMasCorto;
    public double longitudTramoMasLargo;
    ArrayList <Tramo> coleccionDeTramos = new ArrayList<Tramo>();

    public Carretera() {
        
    }
    
    public boolean tramoProcesado(Tramo tramo) {
       if (tramo.calcularRelacInclin() > 0 && tramo.calcularRelacInclin() <= 30 && tramo.calcularLongitud() <= 1000) {
        coleccionDeTramos.add(tramo);
        setUltimoTramoRegistrado(tramo);
        return true;
       } else {
           return false;
       }
    }
        
    public double calcularLongitudTotal() {
        double longitudTotal = 0;
        for (Tramo tramo: coleccionDeTramos) {
            longitudTotal += tramo.calcularLongitud();
        }
        return longitudTotal;
    }
    
    public double calcularPrecioTotal() {
        double precioTotalCarretera = 0;
        for (Tramo tramo: coleccionDeTramos) {
            precioTotalCarretera += tramo.calcularPrecioDeTramo();
        }
        return precioTotalCarretera;
    }
    
    public Tramo buscarTramoMasCorto() {
        if (coleccionDeTramos.size() > 1) {
            for (Tramo tramo: coleccionDeTramos) {
                if (tramo.calcularLongitud() <= tramoMasCorto.calcularLongitud()) {
                    tramoMasCorto = tramo;
                }
            }
        } else {
            tramoMasCorto = coleccionDeTramos.get(0);
        }
        return tramoMasCorto;
    }

    public Tramo buscarTramoMasLargo() {
        if (coleccionDeTramos.size() > 1) {
            for (Tramo tramo: coleccionDeTramos) {
                if (tramo.calcularLongitud() >= tramoMasLargo.calcularLongitud()) {
                    tramoMasLargo = tramo;
                }
            }
        } else {
            tramoMasLargo = coleccionDeTramos.get(0);
        }
        return tramoMasLargo;
    }

 
    
    public double getLongitudTramoMasLargo() {
        return buscarTramoMasLargo().calcularLongitud();
    }
    
    public double getLongitudTramoMasCorto() {
        return buscarTramoMasCorto().calcularLongitud();
    }
          
    public int getNumTramoMasCorto() {
        return buscarTramoMasCorto().getNumTramo();
    }

    public int getNumTramoMasLargo() {
        return buscarTramoMasLargo().getNumTramo();
    }

    public Tramo getUltimoTramoRegistrado() {
        return ultimoTramoRegistrado;
    }

    public void setUltimoTramoRegistrado(Tramo ultimoTramoRegistrado) {
        this.ultimoTramoRegistrado = ultimoTramoRegistrado;
    }
    
    

    
    @Override
    public String toString() {
        
        String estado = "Longitud total de carretera: " + calcularLongitudTotal() +  "\n";
        estado += "Precio total de carretera: " + calcularPrecioTotal() + "\n";
        estado += "Numero del tramo mas largo: " + getNumTramoMasLargo() + "\n";
        estado += "Longitud del tramo mas largo: " + getLongitudTramoMasLargo() + "\n";
        estado += "Numero del tramo mas corto: " + getNumTramoMasCorto() + "\n";
        estado += "Longitud del tramo mas corto: " + getLongitudTramoMasCorto() + "\n";
        return estado;  
    }

    


    
    
    
    
    
    
}
