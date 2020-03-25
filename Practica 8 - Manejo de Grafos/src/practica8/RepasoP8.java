package practica8;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;

public class RepasoP8 {

	public static void main(String[] args) {

		System.out.println("----------------------- EJERCICIO 1 -----------------------");
		SimpleDirectedGraph<String, DefaultEdge> g1 = new SimpleDirectedGraph<>(DefaultEdge.class);
		g1.addVertex("A");
		g1.addVertex("B");
		g1.addVertex("C");
		g1.addEdge("A", "B");
		g1.addEdge("B", "C");
		System.out.println("El primer grafo es: " + g1);

		System.out.println("\n----------------------- EJERCICIO 2 -----------------------");

		DefaultDirectedWeightedGraph<String, DefaultWeightedEdge> g2 = new DefaultDirectedWeightedGraph<>(
				DefaultWeightedEdge.class);
		g2.addVertex("A");
		g2.addVertex("B");
		g2.addVertex("C");
		g2.addEdge("A", "B");
		g2.addEdge("B", "C");
		g2.setEdgeWeight(g2.getEdge("A", "B"), 3);
		g2.setEdgeWeight(g2.getEdge("B", "C"), 3);
		System.out.println("El segundo grafo es: " + g2 + " y sus pesos son: " + g2.getEdgeWeight(g2.getEdge("A", "B"))
				+ " y " + g2.getEdgeWeight(g2.getEdge("B", "C")));

		System.out.println("\n----------------------- EJERCICIO 3 -----------------------");

		SimpleGraph<Integer, DefaultEdge> g3 = new SimpleGraph<>(DefaultEdge.class);
		for (int i = 0; i < 100; i++) {
			g3.addVertex(i);
		}
		for (Integer v : g3.vertexSet()) {
			for (int i = v + 1; i < 100; i++) {
				g3.addEdge(v, i);
			}
		}
		System.out.println("El tercer grafo es: " + g3);

		System.out.println("\n----------------------- EJERCICIO 4 -----------------------");

		SimpleGraph<String, DefaultEdge> g4 = new SimpleGraph<>(DefaultEdge.class);
		g4.addVertex("A");
		g4.addVertex("B");
		g4.addVertex("C");
		g4.addVertex("D");
		g4.addVertex("E");
		g4.addVertex("F");
		g4.addEdge("A", "B");
		g4.addEdge("B", "C");
		g4.addEdge("C", "F");
		g4.addEdge("B", "E");
		g4.addEdge("B", "D");

		System.out.println("El cuarto grafo es: " + g4);

		// BFS

		BreadthFirstIterator<String, DefaultEdge> bfs = new BreadthFirstIterator<>(g4);
		System.out.println("\nBFS del grafo g4: ");
		while (bfs.hasNext()) {
			System.out.println(bfs.next());
		}

		// DFS

		ClosestFirstIterator<String, DefaultEdge> dfs = new ClosestFirstIterator<>(g4);
		System.out.println("\nDFS del grafo g4: ");
		while (dfs.hasNext()) {
			System.out.println(dfs.next());
		}

		System.out.println("\n---------------------EJERCICIO ENTREGABLE------------------");
		// GRAFO DIRIGIDO de tipo Integer con pesos en las aristas. Impimir los pesos de
		// las aristas y sumar el peso de las aristas multiplicado por el valor de los
		// vertices.
		// 2 4
		// 1 --> 3 --> 5
		// En pantalla: 2 || 4 || 1*2*3 || 3*4*5

		DefaultDirectedWeightedGraph<Integer, DefaultWeightedEdge> g5 = new DefaultDirectedWeightedGraph<>(
				DefaultWeightedEdge.class);
		for (int i = 0; i < 4; i++) {
			g5.addVertex(i);
		}
		for (Integer v : g5.vertexSet()) {
			for (int i = v + 1; i < 4; i++) {
				g5.addEdge(v, i);
			}
		}

		for (DefaultWeightedEdge a : g5.edgeSet()) {
			g5.setEdgeWeight(a, 2);
		}

		for (DefaultWeightedEdge e : g5.edgeSet()) {
			Double peso = g5.getEdgeWeight(e);
			Double calculo = g5.getEdgeSource(e) * peso * g5.getEdgeTarget(e);
			System.out.println("Para la arista: " + e + " el peso es: " + peso
					+ " y el peso multiplicado por los vertices: " + calculo);
		}
	}
}
