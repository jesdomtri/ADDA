package practicas.practica15;

import us.lsi.algoritmos.Algoritmos;
import us.lsi.graphs.GraphView;
import us.lsi.pd.AlgoritmoPD;

public class TestBicicletas {
	// El test se está ejecutando sin filtros, podemos quitar getObjetivo y
	// getObjetivoEstimado de la clase
	// Refrescar el proyecto para que salga el fichero "solucion.gv"

	/*
	 * Algoritmos de PD = Hay 2 tipos:
	 * 
	 * - ejecuta() - getSolucion() --> reconstruye la solucion
	 */
	public static void main(String[] args) {

		ProblemaBicicletas g = ProblemaBicicletas.create("ficheros/mapa.txt");
		System.out.println("Grafo inicial: " + g.getGrafo());

		GraphView<Estacion, Calle> gv = GraphView.create(g.getGrafo());
		int origen = gv.getIndex(new Estacion("Estacion0"));
		int destino = gv.getIndex(new Estacion("Estacion3"));

		ProblemaBicicletasPD<Estacion, Calle> p = ProblemaBicicletasPD.create(origen, destino, gv);
		AlgoritmoPD<String, ProblemaBicicletasPD.Alternativa> a = Algoritmos.createPD(p);
		a.ejecuta();

		System.out.println("Distancia: " + a.solucionesParciales.get(p).propiedad);
		System.out.println("Solucion: " + a.getSolucion(p));
		a.showAllGraph("ficheros/solucion.gv", "Solucion", p);

	}
}
