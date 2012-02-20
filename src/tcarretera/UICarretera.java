/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcarretera;

/**
 *
 * @author Jose P. Medrano
 * @author  Daniela Brizuela
 */
public class UICarretera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                Carretera carretera = new Carretera();
        
        Tramo tramo1 = new Tramo(7, 5, 4, 1, 2, 4, "asfalto");
        System.out.println(tramo1.toString());
        carretera.procesarTramo(tramo1);
        System.out.println(carretera.toString());
        Tramo tramo2 = new Tramo(-3, -9, 5, 1, "asfalto");
        System.out.println(tramo2.toString());
        carretera.procesarTramo(tramo2);
        System.out.println(carretera.toString());
        

    }
}
