package practica8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.generate.SimpleWeightedBipartiteGraphMatrixGenerator;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;

public class P8 {
	public static void main(String[] args) {

		// EJERCICIO 1.
		System.out.println("---------------------EJERCICIO 1------------------");

		Graph<String, DefaultEdge> grafoDir = new SimpleDirectedGraph<>(DefaultEdge.class);

		grafoDir.addVertex("A");
		grafoDir.addVertex("B");
		grafoDir.addVertex("C");
		DefaultEdge aristaAB = grafoDir.addEdge("A", "B");
		DefaultEdge aristaBC = grafoDir.addEdge("B", "C");

		// System.out.println(grafoDir);
		for (String v : grafoDir.vertexSet()) {
			System.out.println("Vertice " + v + " Grado: " + grafoDir.degreeOf(v) + " " + grafoDir.inDegreeOf(v));
		}
		for (DefaultEdge e : grafoDir.edgeSet()) {
			System.out.println("Arista " + e + " " + grafoDir.getEdgeSource(e) + " " + grafoDir.getEdgeTarget(e));
		}

		// EJERCICIO 2
		System.out.println("---------------------EJERCICIO 2------------------");

		Graph<String, DefaultWeightedEdge> grafoD = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		grafoD.addVertex("A");
		grafoD.addVertex("B");
		grafoD.addVertex("C");

		DefaultWeightedEdge arista_AB = grafoD.addEdge("A", "B");
		grafoD.setEdgeWeight(arista_AB, 3.0);

		DefaultWeightedEdge arista_BC = grafoD.addEdge("B", "C");
		grafoD.setEdgeWeight(arista_BC, 3.0);

		for (String v : grafoD.vertexSet()) {
			System.out.println("Vercie " + v + " Grafo: " + grafoD.degreeOf(v) + " " + grafoD.inDegreeOf(v));
		}

		for (DefaultWeightedEdge e : grafoD.edgeSet()) {
			System.out.println("Arista: " + e + " Peso: " + grafoD.getEdgeWeight(e));
		}

		// EJERCICIO 3
		System.out.println("---------------------EJERCICIO 3------------------");

		Graph<Integer, DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);
		int MAX_VERTICES = 10;

		/*
		 * IntStream.rangeClosed(1,100).forEach(i -> grafo.addVertex(i))
		 * 
		 * 
		 */
		// Se crean 100 vertices
		for (int i = 1; i <= MAX_VERTICES; i++) {
			grafo.addVertex(i);

		}
		

		// Recorremos cada vertice y lo conectamos con los demas.
		for (int i = 1; i <= MAX_VERTICES; i++) {

			for (int j = i + 1; j <= MAX_VERTICES; j++) {

				grafo.addEdge(i, j);

			}
		}

		System.out.println(grafo);

		// EJERCICIO 4
		System.out.println("---------------------EJERCICIO 4------------------");
		Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");

		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("C", "F");
		g.addEdge("F", "E");
		g.addEdge("E", "B");
		g.addEdge("D", "B");

		// PROFUNDIDAD

		ClosestFirstIterator<String, DefaultEdge> itProfundidad = new ClosestFirstIterator<>(g);
		List<String> listaProfundidad = new ArrayList<>();
		while (itProfundidad.hasNext()) {
			listaProfundidad.add(itProfundidad.next());
		}

		System.out.println(listaProfundidad);

		// ANCHURA

		BreadthFirstIterator<String, DefaultEdge> itAnchura = new BreadthFirstIterator<>(g);
		List<String> listaAnchura = new ArrayList<>();

		while (itAnchura.hasNext()) {
			listaAnchura.add(itAnchura.next());
		}

		System.out.println(listaAnchura);

		System.out.println("---------------------EJERCICIO ENTREGABLE------------------");
		// GRAFO DIRIGIDO de tipo Integer con pesos en las aristas. Impimir los pesos de
		// las aristas y sumar el peso de las aristas multiplicado por el valor de los
		// vertices.
		// 2 4
		// 1 --> 3 --> 5
		// En pantalla: 2 || 4 || 1*2*3 || 3*4*5

		Graph<Integer, DefaultWeightedEdge> grafoPesos = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

		// Vertices
		grafoPesos.addVertex(1);
		grafoPesos.addVertex(3);
		grafoPesos.addVertex(5);

		// Aristas
		DefaultWeightedEdge arista1 = grafoPesos.addEdge(1, 3);
		grafoPesos.setEdgeWeight(arista1, 2.0);

		DefaultWeightedEdge arista2 = grafoPesos.addEdge(3, 5);
		grafoPesos.setEdgeWeight(arista2, 4.0);

		for (DefaultWeightedEdge e : grafoPesos.edgeSet()) {
			Double peso = grafoPesos.getEdgeWeight(e);
			Double calculo = grafoPesos.getEdgeSource(e) * peso * grafoPesos.getEdgeTarget(e);
			System.out.println("Para la arista: " + e + " el peso es: " + peso
					+ " y el peso multiplicado por los vertices: " + calculo);

		}

	}

}
