package practica9;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.interfaces.MinimumVertexCoverAlgorithm;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.alg.tour.TwoApproxMetricTSP;
import org.jgrapht.alg.vertexcover.GreedyVCImpl;
import org.jgrapht.graph.SimpleWeightedGraph;

import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class RepasoP9 {

	public static void main(String[] args) {

		Graph<CiudadV2, CarreteraV2> graph = new SimpleWeightedGraph<CiudadV2, CarreteraV2>(CarreteraV2::create);
		graph = GraphsReader.newGraph("./ficheros/andalucia.w.txt", CiudadV2::create, CarreteraV2::create, graph,
				CarreteraV2::getKm);
		Graph<CiudadV2, CarreteraV2> graphCompleto = Graphs2.completeGraph(graph, 1000.0);

		System.out.println("----------------------- EJERCICIO 1 -----------------------");
		DijkstraShortestPath<CiudadV2, CarreteraV2> g1 = new DijkstraShortestPath<>(graph);
		GraphPath<CiudadV2, CarreteraV2> d = g1.getPath(CiudadV2.create("Huelva"), CiudadV2.create("Almeria"));
		System.out.println(d.getVertexList());

		System.out.println("\n----------------------- EJERCICIO 2 -----------------------");
		KruskalMinimumSpanningTree<CiudadV2, CarreteraV2> g2 = new KruskalMinimumSpanningTree<>(graph);
		System.out.println(g2.getSpanningTree());

		System.out.println("\n----------------------- EJERCICIO 3 -----------------------");
		// [92.85, 159.947, 51.523, 201.029] [Huelva, Sevilla, Antequera, Malaga,
		// Almeria]
		TwoApproxMetricTSP<CiudadV2, CarreteraV2> g3 = new TwoApproxMetricTSP<CiudadV2, CarreteraV2>();
		System.out.println(g3.getTour(graphCompleto));

		System.out.println("\n----------------------- EJERCICIO 4 -----------------------");
		VertexColoringAlgorithm<CiudadV2> g4 = new GreedyColoring<>(graph);
		System.out.println(g4.getColoring());

		System.out.println("\n----------------------- EJERCICIO 5 -----------------------");
		MinimumVertexCoverAlgorithm<CiudadV2, CarreteraV2> g5 = new GreedyVCImpl<>();
		System.out.println(g5.getVertexCover(graph));

	}

}
