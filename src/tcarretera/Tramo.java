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
    
    private static int cantTramos = 0;
    private int numTramo;
    private static double x1;
    private static double y1;
    private static double x2;
    private static double y2;
    private double anchoTramo;
    private double difNivel;
    private int tipoMaterial;

    
    public Tramo(double px1, double py1, double px2, double py2, double panchoTramo, double pdifNivel, int ptipoMaterial) {
        cantTramos++;
        setNumTramo(cantTramos);
        if(cantTramos < 2) {
            setX1(px1);
            setY1(py1);
        }
        setX2(px2);
        setY2(py2);
        setAnchoTramo(panchoTramo);
        setDifNivel(pdifNivel);
        setTipoMaterial(ptipoMaterial);
    }

    public Tramo(double px2, double py2, double anchoTramo, double difNivel, int ptipoMaterial) {
        setX1(getX2());
        setY1(getY2());
        setX2(px2);
        setY2(py2);
        setAnchoTramo(anchoTramo);
        setDifNivel(difNivel);
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

    public int getTipoMaterial() {
        return tipoMaterial;
    }

    private void setTipoMaterial(int tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public double getX1() {
        return x1;
    }

    private void setX1(double x1) {
        Tramo.x1 = x1;
    }

    private double getX2() {
        return x2;
    }

    private void setX2(double x2) {
        Tramo.x2 = x2;
    }

    public double getY1() {
        return y1;
    }

    private void setY1(double y1) {
        Tramo.y1 = y1;
    }

    private double getY2() {
        return y2;
    }

    private void setY2(double y2) {
        Tramo.y2 = y2;
    }
        
    private double calcularPrecioDelMaterial() {
        double precioDelTramo;
        switch(getTipoMaterial()) {
            case 1: //caso adoquin
                precioDelTramo = 6000;
                break;
            case 2: //caso asfalto
                precioDelTramo = 17000;
                break;
            case 3: //caso material selecto
                precioDelTramo = 4000;
                break;
            default:
                precioDelTramo = 0;
                break;
        }
        return precioDelTramo;
    }
    
    private double calcularLongitud () {
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
        double areaTramo = 1000 * getAnchoTramo() * calcularLongitud();
        return areaTramo;
    }
    
    public double calcularPrecioDeTramo() {
        double precioTramo = calcularAreaDeTramo() * calcularPrecioDelMaterial();
        return precioTramo;
    }
    
    
    
    
    
    
        
    
}
