/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcarretera;

import java.util.ArrayList;

/**
 *
 * @author JPMC
 */
public class Carretera {

    private Tramo tramoMasCorto;
    private Tramo tramoMasLargo;
    private double precioTotal;
    public int numTramoMasCorto;
    public int numTramoMasLargo;
    public double longitudTramoMasCorto;
    public double longitudTramoMasLargo;
    ArrayList <Tramo> coleccionDeTramos = new ArrayList<Tramo>();

    public Carretera() {
        
    }
    
    public void procesarTramo(Tramo tramo) {
       coleccionDeTramos.add(tramo);
    }
        
    public double calcularLongitudTotal() {
        double longitud = 0;
        for (Tramo tramo: coleccionDeTramos) {
            longitud += tramo.calcularLongitud();
        }
        return longitud;
    }
    
    public double calcularPrecioTotal() {
        for (Tramo tramo: coleccionDeTramos) {
            precioTotal += tramo.calcularPrecioDeTramo();
        }
        return precioTotal;
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
