/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcarretera;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author JPMC
 */
public class Carretera {
    
    private double precioTotalCarretera;
    private double longitudTotalCarretera;
    private double numTramoMasLargo;
    private double longitudTramoMasLargo;
    private double numTramoMasCorto;
    private double longitudTramoMasCorto;
    ArrayList coleccionDeTramos = new ArrayList();

    public Carretera(Tramo[] tramos) {
        for (Tramo tramo: tramos) {
        }
    }
        
    public double getLongitudTotalCarretera() {
        return longitudTotalCarretera;
    }

    public void setLongitudTotalCarretera(double longitudTotalCarretera) {
        this.longitudTotalCarretera = longitudTotalCarretera;
    }

    public double getLongitudTramoMasCorto() {
        return longitudTramoMasCorto;
    }

    public void setLongitudTramoMasCorto(double longitudTramoMasCorto) {
        this.longitudTramoMasCorto = longitudTramoMasCorto;
    }

    public double getLongitudTramoMasLargo() {
        return longitudTramoMasLargo;
    }

    public void setLongitudTramoMasLargo(double longitudTramoMasLargo) {
        this.longitudTramoMasLargo = longitudTramoMasLargo;
    }

    public double getNumTramoMasCorto() {
        return numTramoMasCorto;
    }

    public void setNumTramoMasCorto(double numTramoMasCorto) {
        this.numTramoMasCorto = numTramoMasCorto;
    }

    public double getNumTramoMasLargo() {
        return numTramoMasLargo;
    }

    public void setNumTramoMasLargo(double numTramoMasLargo) {
        this.numTramoMasLargo = numTramoMasLargo;
    }

    public double getPrecioTotalCarretera() {
        return precioTotalCarretera;
    }

    public void setPrecioTotalCarretera(double precioTotalCarretera) {
        this.precioTotalCarretera = precioTotalCarretera;
    }

    
    
    
    
    
    
}
