package practica9;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.interfaces.MinimumVertexCoverAlgorithm.VertexCover;
import org.jgrapht.alg.interfaces.MinimumWeightedVertexCoverAlgorithm;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm.SpanningTree;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm.Coloring;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.alg.tour.TwoApproxMetricTSP;
import org.jgrapht.alg.vertexcover.RecursiveExactVCImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class ClaseTeorica {

	public static void main(String[] args) {

		// CLASE TEORICA 20/12/2017
		Graph<String, DefaultEdge> g2 = new SimpleGraph<>(DefaultEdge.class);
		g2.addVertex("A");
		g2.addVertex("B");
		g2.addVertex("C");
		g2.addVertex("D");

		g2.addEdge("A", "C");
		g2.addEdge("C", "B");
		g2.addEdge("B", "D");
		g2.addEdge("C", "D");

		// Camino minimo (Dijkstra)
		DijkstraShortestPath<String, DefaultEdge> d = new DijkstraShortestPath<>(g2);

		// Camino minimo origen y destino

		GraphPath<String, DefaultEdge> path = d.getPath("A", "B");

		// Devuelve los vertices del camino minimo (path)

		List<String> pathVertices = path.getVertexList();
		System.out.println(pathVertices);

		// Devuelve el conjunto de aristas del camino minimo
		System.out.println(path.getEdgeList());

		// Devuelve todos los caminos minimos desde un vertice

		SingleSourcePaths<String, DefaultEdge> todosPath = d.getPaths("A");
		System.out.println(todosPath.getGraph());

		// Recorremos cada vertice del grafo para encontrar el camino minimo
		// desde el vertice indicado

		g2.vertexSet().stream().forEach(v -> System.out.println(todosPath.getPath(v)));

		// Peso del camino minimo de A y B
		System.out.println(d.getPathWeight("A", "B"));

		// Kruskal (arbol o bosque de recubrimiiento de aristas)

		SpanningTreeAlgorithm<DefaultEdge> k = new KruskalMinimumSpanningTree<>(g2);

		SpanningTree<DefaultEdge> spt = k.getSpanningTree();
		System.out.println(spt);

		spt.getEdges(); // Aristas del recubrimiento
		spt.getWeight(); // Peso del recubrimiento
		spt.forEach(e -> System.out.println(e));

		// Recubrimiento de vertices
		// Grafo no dirigido

		MinimumWeightedVertexCoverAlgorithm<String, DefaultEdge> vc = new RecursiveExactVCImpl<String, DefaultEdge>();

		VertexCover<String> vcv = vc.getVertexCover(g2);

		System.out.println(vcv);
		vcv.getVertices(); // Cjto de vertices
		vcv.getWeight(); // Peso del cjto de vertices

		// Ciclo hamiltoniano

		TwoApproxMetricTSP<String, DefaultEdge> tsp = new TwoApproxMetricTSP<>();

		GraphPath<String, DefaultEdge> ruta = tsp.getTour(g2);
		System.out.println(ruta);

		// Coloreado de grafos

		VertexColoringAlgorithm<String> coloreado = new GreedyColoring<>(g2);
		Coloring<String> colores = coloreado.getColoring();

		System.out.println(colores);
		colores.getNumberColors(); // Numero de colores
		colores.getColors(); // Mapa que relaciona los grupos de colores

		// Componentes conexas del grafo

		ConnectivityInspector<String, DefaultEdge> conexas = new ConnectivityInspector<>(g2);

		conexas.connectedSetOf("A");

		// Set con los vertices de la misma componente conexa del vertice

		List<Set<String>> componentes = conexas.connectedSets();

		componentes.size(); // Devuelve el numero de componentes conexas

		conexas.isGraphConnected(); // mirar si el grafo es conexo

	}

}
