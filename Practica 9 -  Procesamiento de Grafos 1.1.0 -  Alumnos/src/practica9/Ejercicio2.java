package practica9;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.interfaces.MinimumVertexCoverAlgorithm.VertexCover;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm.SpanningTree;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm.Coloring;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.alg.tour.TwoApproxMetricTSP;
import org.jgrapht.alg.vertexcover.GreedyVCImpl;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;

import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsFileExporter;
import us.lsi.graphs.GraphsReader;

public class Ejercicio2 {
	public static void main(String[] args) {

		Graph<CiudadV2, CarreteraV2> graph = new SimpleWeightedGraph<CiudadV2, CarreteraV2>(CarreteraV2::create);

		graph = GraphsReader.newGraph("./ficheros/andalucia.w.txt", CiudadV2::create, CarreteraV2::create, graph,
				CarreteraV2::getKm);

		// System.out.println(graph);
		GraphsFileExporter.saveFile(graph, "./ficheros/salida.w.gv");

		// Mostrar el peso de la arista que va de Sevilla a Antequera.
		String[] a = { "Sevilla", "0" };
		String[] b = { "Antequera", "0" };
		CiudadV2 sev = CiudadV2.create(a);
		CiudadV2 ant = CiudadV2.create(b);
		System.out.println(graph.getEdgeWeight(graph.getEdge(sev, ant)));

		// EJ2: Recubrimiento (2ndo)
		KruskalMinimumSpanningTree<CiudadV2, CarreteraV2> k = new KruskalMinimumSpanningTree<>(graph);
		SpanningTree<CarreteraV2> spt = k.getSpanningTree();
		System.out.println(spt);

		// EJ4: Coloreado (4to)
		VertexColoringAlgorithm<CiudadV2> colores = new GreedyColoring<CiudadV2, CarreteraV2>(graph);
		Coloring<CiudadV2> coloreado = colores.getColoring();

		System.out.println("\nNumero cromatico: " + coloreado.getNumberColors());
		System.out.println("Asignacion de colores " + coloreado.getColors());
		System.out.println("Clases de colores: " + coloreado.getColorClasses());

		// Grafo completo
		Graph<CiudadV2, CarreteraV2> graphCompleto = Graphs2.completeGraph(graph, 1000.0);

		// EJ1: Dijkstra
		ShortestPathAlgorithm<CiudadV2, CarreteraV2> d = new DijkstraShortestPath<CiudadV2, CarreteraV2>(graph);

		String[] a2 = { "Huelva", "0" };
		String[] b2 = { "Almeria", "0" };
		CiudadV2 huelva = CiudadV2.create(a2);
		CiudadV2 almeria = CiudadV2.create(b2);
		GraphPath<CiudadV2, CarreteraV2> n1 = d.getPath(huelva, almeria);

		System.out.println("\nEl camino mas corto entre Huelva y Almeria es: " + n1 + " " + n1.getVertexList());

		// EJ3: Algoritmo del viajante 3,3
		// Para utilizar esto, el grafo debe ser completo
		TwoApproxMetricTSP<CiudadV2, CarreteraV2> ch = new TwoApproxMetricTSP<CiudadV2, CarreteraV2>();
		GraphPath<CiudadV2, CarreteraV2> n2 = ch.getTour(graphCompleto);
		System.out.println("\nCiclo hamiltoniano: " + n2);

		// EJ5: Vertex Cover
		GreedyVCImpl<CiudadV2, CarreteraV2> gvc = new GreedyVCImpl<CiudadV2, CarreteraV2>();
		VertexCover<CiudadV2> n3 = gvc.getVertexCover(graph);
		System.out.println("\nVertex Cover: " + n3);

		// Recorrido en BFS
		BreadthFirstIterator<CiudadV2, CarreteraV2> n4 = new BreadthFirstIterator<>(graph, sev);
		System.out.println("\nBFS del grafo empezando por Sevilla");
		while (n4.hasNext()) {
			System.out.println(n4.next());
		}

		// Recorrido en DFS
		ClosestFirstIterator<CiudadV2, CarreteraV2> n5 = new ClosestFirstIterator<>(graph, sev);
		System.out.println("\nDFS del grafo empezando por Sevilla");
		while (n5.hasNext()) {
			System.out.println(n5.next());
		}

	}
}