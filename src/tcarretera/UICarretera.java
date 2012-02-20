
package tcarretera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author Jose P. Medrano
 */
public class UICarretera {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Carretera carretera = new Carretera();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws java.io.IOException, InterruptedException {
        int opc;
        boolean noSalir = true;
	do{
            mostrarMenu();
            opc = leerOpcion();
            noSalir = ejecutarAccion(opc);
        }while (noSalir);
    }   

    private static void mostrarMenu() {
                out.println();
                out.println("Menu Carretera");
		out.println();
		out.println("1. Agregar tramo.");
                out.println("2. Mostrar informacion de tramo.");
		out.println("3. Mostrar longitud total de carretera.");
		out.println("4. Mostrar precio total de carretera.");	
		out.println("5. Mostrar numero y longitud del tramo mas largo.");
		out.println("6. Mostrar numero y longitud del tramo mas corto.");
                out.println("7. Salir.");
		out.println();
    }

    private static int leerOpcion() throws IOException {
        int opcion;

		out.print("Seleccione su opcion: ");
		opcion = Integer.parseInt(in.readLine());
		out.println();

		return opcion;
    }

    private static boolean ejecutarAccion(int popcion) throws IOException, InterruptedException {
        boolean noSalir = true;
        
		switch(popcion){
			
			case 1: //Agregar tramo
                                if (carretera.coleccionDeTramos.size() < 1) {
                                    out.println("COORDENADAS");
                                    out.println("Indique x1: ");
                                    double x1 = Double.parseDouble(in.readLine());
                                    out.println("Indique x2: ");
                                    double x2 = Double.parseDouble(in.readLine());
                                    out.println("Indique y1: ");
                                    double y1 = Double.parseDouble(in.readLine());
                                    out.println("Indique y2: ");
                                    double y2 = Double.parseDouble(in.readLine());
                                    out.println("ANCHO DEL TRAMO");
                                    out.println("Indique ancho del tramo: ");
                                    double anchoDelTramo = Double.parseDouble(in.readLine());
                                    out.println("DIFERENCIA DE NIVEL");
                                    out.println("Indique la diferencia de nivel: ");
                                    double difNivel = Double.parseDouble(in.readLine());
                                    out.println("TIPO DE MATERIAL");
                                    out.println("Indique el tipo de material: ");
                                    String tipoMaterial = (in.readLine());
                                    Tramo nuevoTramo = new Tramo(x1, y1, x2, y2, anchoDelTramo, difNivel, tipoMaterial);
                                    boolean tramoProcesado = carretera.tramoProcesado(nuevoTramo);
                                    
                                    if(tramoProcesado == true) {
                                        out.println(nuevoTramo.toString());
                                        out.println("Tramo procesado satisfactoriamente.");
                                    } else {
                                        out.println("Valores invalidos. Tramo no pudo ser procesado.");
                                    }

                                } else {
                                    out.println("COORDENADAS");
                                    double x1 = carretera.getUltimoTramoRegistrado().getX2();
                                    double y1 = carretera.getUltimoTramoRegistrado().getY2();
                                    out.println("Indique x2: ");
                                    double x2 = Double.parseDouble(in.readLine());                                   
                                    out.println("Indique y2: ");
                                    double y2 = Double.parseDouble(in.readLine());
                                    out.println("ANCHO DEL TRAMO");
                                    out.println("Indique ancho del tramo: ");
                                    double anchoDelTramo = Double.parseDouble(in.readLine());
                                    out.println("DIFERENCIA DE NIVEL");
                                    out.println("Indique la diferencia de nivel: ");
                                    double difNivel = Double.parseDouble(in.readLine());
                                    out.println("TIPO DE MATERIAL");
                                    out.println("Indique el tipo de material: ");
                                    String tipoMaterial = (in.readLine());
                                    Tramo nuevoTramo = new Tramo(x1, y1, x2, y2, anchoDelTramo, difNivel, tipoMaterial);
                                    boolean tramoProcesado = carretera.tramoProcesado(nuevoTramo);
                                    
                                    if(tramoProcesado == true) {
                                        out.println(nuevoTramo.toString());
                                        out.println("Tramo procesado satisfactoriamente.");
                                    } else {
                                        out.println("Valores invalidos. Tramo no pudo ser procesado.");
                                    }
                                }
				break;

			case 2: //Mostrar informacion de tramo.
                                out.println("INDIQUE NUMERO DE TRAMO QUE DESEA CONSULTAR");
                                int numTramo = Integer.parseInt(in.readLine());
                                numTramo--; 
                                out.println(carretera.coleccionDeTramos.get(numTramo).toString());
                                break;

			case 3: //Mostrar longitud total de carretera
                                out.println("LONGITUD TOTAL DE CARRETERA");
                                out.println(carretera.calcularLongitudTotal() + "m");
				break;
                            
                        case 4: //Mostrar precio total de carretera.
                                out.println("PRECIO TOTAL DE CARRETERA");
                                out.println(carretera.calcularPrecioTotal() + " colones");
				break;
                            
                        case 5: //Mostrar numero y longitud del tramo mas largo.
                                out.println("TRAMO MAS LARGO");
                                out.println("Numero: " + carretera.getNumTramoMasLargo());
                                out.println("Distancia: " + carretera.getLongitudTramoMasLargo());
				break;
                        case 6: //Mostrar numero y longitud del tramo mas corto
                                out.println("TRAMO MAS CORTO");
                                out.println("Numero: " + carretera.getNumTramoMasCorto());
                                out.println("Distancia: " + carretera.getLongitudTramoMasCorto());
                                break;
                            
                        case 7: //Detener                     
                                noSalir = false;
				break;

			default: //Cualquier otro valor dado por el usuario se considera inv·lido

				out.println("Opcion invalida");
				out.println();
				break;
		}
		return noSalir;
    }
        

}

