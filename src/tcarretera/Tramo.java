/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcarretera;

/**
 *
 * @author Jose P. Medrano
 * @author Daniela Brizuela
 */
public class Tramo {
    
    private static int cantTramos;
    private int numTramo;
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double anchoTramo;
    private double difNivel;
    private String tipoMaterial;

    
    public Tramo(double px1, double py1, double px2, double py2, double panchoTramo, double pdifNivel, String ptipoMaterial) {
        cantTramos++;
        setNumTramo(cantTramos);
        setX1(px1);
        setY1(py1);
        setX2(px2);
        setY2(py2);
        setAnchoTramo(panchoTramo);
        setDifNivel(pdifNivel);
        setTipoMaterial(ptipoMaterial);
    }

    public int getNumTramo() {
        return numTramo;
    }

    private void setNumTramo(int numTramo) {
        this.numTramo = numTramo;
    }

    private double getAnchoTramo() {
        return anchoTramo;
    }

    private void setAnchoTramo(double anchoTramo) {
        this.anchoTramo = anchoTramo;
    }

    public double getDifNivel() {
        return difNivel;
    }

    private void setDifNivel(double difNivel) {
        this.difNivel = difNivel;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    private void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public double getX1() {
        return x1;
    }

    private void setX1(double x1) {
        this.x1 = x1;
    }

    private double getX2() {
        return x2;
    }

    private void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY1() {
        return y1;
    }

    private void setY1(double y1) {
        this.y1 = y1;
    }

    private double getY2() {
        return y2;
    }

    private void setY2(double y2) {
        this.y2 = y2;
    }
        
    private double calcularPrecioDelMaterial() {
        double precioDelMaterial;
        if ("adoquin".equals(getTipoMaterial())) {
            precioDelMaterial = 6000;
        } else if ("asfalto".equals(getTipoMaterial())) {
            precioDelMaterial = 17000;
        } else if ("material selecto".equals(getTipoMaterial())){
            precioDelMaterial = 4000;
        } else {
            precioDelMaterial = 0;
        }
        return precioDelMaterial;
    }
    
    public double calcularLongitud () {
        double longitud = Math.sqrt((Math.pow(getX2() - getX1(), 2)) + Math.pow(getY2() - getY1(), 2));
        return longitud;
    }

    public double calcularRelacInclin() {
        double relacIncl = getDifNivel()/calcularLongitud();
        return relacIncl;
    }
    
    public String clasificarTramo() {
        String clasificacionTramo;
        if (calcularRelacInclin() <= 5) {
            clasificacionTramo = "Suave";
        } else if (calcularRelacInclin() <= 20) {
            clasificacionTramo = "Moderada";
        } else if (calcularRelacInclin() <= 30) {
            clasificacionTramo = "Levemente fuerte";
        } else {
            clasificacionTramo = "Relacion de inclinacion excedida.";
        }
        return clasificacionTramo;
    }
    
    public double calcularAreaDeTramo(){
        double areaTramo =  getAnchoTramo() * calcularLongitud() * 1000;
        return areaTramo;
    }
    
    public double calcularPrecioDeTramo() {
        double precioTramo = calcularAreaDeTramo() * calcularPrecioDelMaterial();
        return precioTramo;
    }

    @Override
    public String toString() {
        String estado = "Tramo: " + getNumTramo() +  "\n";
        estado += "Coordenadas: " + "x1: " + getX1() + ", y1: " + getY1() + ", x2:" + getX2() + ", y2:" + getY2() + "\n";
        estado += "Longitud: " + calcularLongitud() + "\n";
        estado += "Precio: " + calcularPrecioDeTramo() + "\n";
        estado += "Clasificacion: " + clasificarTramo() + "\n";
        estado += "Area: " + calcularAreaDeTramo() + "\n";
        estado += "Relacion de inclinacion: " + calcularRelacInclin() + "\n";
        estado += "Diferencia de nivel: " + getDifNivel() + "\n";
        estado += "Ancho: " + getAnchoTramo() + "\n";
        estado += "Tipo material: " + getTipoMaterial() + "\n";
        
        return estado;  
    }
    
    
}
