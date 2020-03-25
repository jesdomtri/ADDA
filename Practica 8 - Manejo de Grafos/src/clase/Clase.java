package clase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.interfaces.MinimumVertexCoverAlgorithm.VertexCover;
import org.jgrapht.alg.interfaces.MinimumWeightedVertexCoverAlgorithm;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm.SpanningTree;
import org.jgrapht.alg.interfaces.TSPAlgorithm;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.alg.tour.TwoApproxMetricTSP;
import org.jgrapht.alg.vertexcover.RecursiveExactVCImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;

public class Clase {

	public static void main(String[] args) {
		
		/*
		 
		--> Graph<V, E>  V es el tipo del vertice y E el tipo de la arista
		--> Las aritas tienen una implementación por defecto en esta librería. Los vertices se implementan mediante las clases:
			DefaultEdge o DefaultWeightedEdge
		 
		--> Todo constructor de grafos recibe un parámetro, que es la forma de crear las aristas del grafo.(el constructor de las aristas)
		  
		 */
		
		//Creación de un grafo simple.
		
		Graph<String,DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
		
		//El método addVertex añade un vertice al grafo.Devuelve un boolean, true si lo añade, false si no lo añade.
		
		boolean res = g.addVertex("A");
		
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addEdge("B", "C");
		g.addEdge("C", "D");
		g.addEdge("A", "D");
		
		//Añade una arista entre los parametros dados devolviendo la arista.
		DefaultEdge arista = g.addEdge("A", "B");
		
		//Puedo saber el origen de una arista (source) o el destino (target): Aunque no es dirigido, al insertarlo respeta ese orden y lo muestra así.
		
		System.out.println(g.getEdgeSource(arista));
		System.out.println(g.getEdgeTarget(arista));
		
		
		//Para saber el peso de una arista (por defecto es 1.0 )
		System.out.println(g.getEdgeWeight(arista));
		
		
		//otra forma de crearlo. Se crea y lo añade devolviendo un boolean si lo añade o no.
	//	DefaultEdge arista2 = new DefaultEdge();
		//boolean res2 = g.addEdge("A", "B", arista2);
		
		
		//Devuleve el conjunto de vertices del grafo.
		Set<String> vertices = g.vertexSet();
		//System.out.println(vertices);
		
		
		//Devuelve el conjunto de aristas del grafo
		Set<DefaultEdge> aristas = g.edgeSet();
		//System.out.println(aristas);
		
		
		
		//Devuleve el numero de aristas conectas con el parametro
		Integer n = g.degreeOf("A");
		//System.out.println(n);
		
		//Devulev el conjunto de aristas conectadas cone l paramentro
		Set<DefaultEdge> a = g.edgesOf("A");
		
		
		
		//Creando un grafo simple ponderado.
		System.out.println("-----------------GRAFO PONDERADO-----------------");
		
		Graph<String, DefaultWeightedEdge> gpon = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		gpon.addVertex("A");
		gpon.addVertex("B");
		gpon.addVertex("C");
		DefaultWeightedEdge aristap = gpon.addEdge("A", "B");
		gpon.addEdge("B", "C");
		DefaultWeightedEdge aristapon = gpon.addEdge("A", "C");
		gpon.setEdgeWeight(aristapon, 2.0);
		System.out.println(gpon.edgeSet());
		System.out.println(gpon.getEdgeWeight( aristap));
		System.out.println(gpon.getEdgeWeight(aristapon));
		
		
		//Creando un grafo simple dirigido.
		System.out.println("-----------------GRAFO DIRIGIDO-----------------");
		Graph<String, DefaultEdge> gdir = new SimpleDirectedGraph<>(DefaultEdge.class);
		String v1 = "A";
		String v2 = "B";
		gdir.addVertex(v1);
		gdir.addVertex(v2);
		gdir.addEdge(v1, v2);
		gdir.addEdge(v2, v1);
		
		//Calculo de aristas salientes y entrantes
		gdir.inDegreeOf(v1); //Devuelve el numero de aristas entrantes a v1;
		Set<DefaultEdge> aristas_v1 = gdir.incomingEdgesOf(v1); //Devuelve el conjunto de aristas entrates a v1
		gdir.outDegreeOf(v1); //Numero de aristas salientes a v1;
		Set<DefaultEdge> aristas_sal_v1 = gdir.outgoingEdgesOf(v1); //Conjunto de aristas salientes a v1
		
		
		System.out.println("-----------------RECORRIENDO GRAFOS----------------");
		BreadthFirstIterator<String, DefaultEdge> itAnchura = new BreadthFirstIterator<>(g); //se le puede pasar un vertice como 
		//parametro para empezar por ese.Si no empieza por uno arbitrario.
		
		
		//Sin guava
		List<String> listaAnchura = new ArrayList<>();
		while(itAnchura.hasNext()){
			listaAnchura.add(itAnchura.next());
		}
		
		//Con guava
		//List<String> listaAchuraGuava = Lists.newArrayList(itAnchura);
		
		//Profundidad
		DepthFirstIterator<String, DefaultEdge> itProfundidad = new DepthFirstIterator<>(g);
		
		// El primero mas cercano
		ClosestFirstIterator<String, DefaultEdge> itClose = new ClosestFirstIterator<>(g);
		
		System.out.println("-----------------DIJKSTRA ALGORITMO----------------");
		
		Graph<String, DefaultWeightedEdge> grafoDij = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		grafoDij.addVertex("A");
		grafoDij.addVertex("B");
		grafoDij.addVertex("C");
		grafoDij.addVertex("D");
	//	grafoDij.addVertex("F");
		
		
		DefaultWeightedEdge arista1 = grafoDij.addEdge("A", "B");
		DefaultWeightedEdge arista2 = grafoDij.addEdge("B", "D");
		
		DefaultWeightedEdge arista4 = grafoDij.addEdge("D", "C");
		DefaultWeightedEdge arista3 = grafoDij.addEdge("C", "A");
		DefaultWeightedEdge arista5 = grafoDij.addEdge("A", "D");
		DefaultWeightedEdge arista6 = grafoDij.addEdge("B", "C");
		//DefaultWeightedEdge arista7 = grafoDij.addEdge("F", "B");
		//DefaultWeightedEdge arista8 = grafoDij.addEdge("F", "D");
		
		DijkstraShortestPath<String, DefaultWeightedEdge> d = new DijkstraShortestPath<>(grafoDij);
		
		//Camino entre origen y destino
		
		GraphPath<String, DefaultWeightedEdge> camino1 = d.getPath("A", "B");
		
		//Lista de los vertices del camino minimo
		List<String> pathVertices = camino1.getVertexList();
		System.out.println(pathVertices);
		
		//Devuleve el conkunto de aristas del camino minimo
		List<DefaultWeightedEdge> pathAristas = camino1.getEdgeList();
		System.out.println(pathAristas);
		
		//Devuelve todos los camnios desde A hasta el resto de vertices
		
		SingleSourcePaths<String, DefaultWeightedEdge> caminos = d.getPaths("A");
		System.out.println(caminos.getGraph());
		
		
		//DEVUELVE los pesos del camino
		System.out.println(d.getPath("A", "B").getWeight());
	
		
		
		
		System.out.println("-----------------KRUSKAL SPANNING TREE (ARBOL DE RECUBRIMIENTO) ALGORITMO----------------");
		
		KruskalMinimumSpanningTree<String, DefaultWeightedEdge> k = new KruskalMinimumSpanningTree<>(grafoDij);
	
		SpanningTree<DefaultWeightedEdge> spt = k.getSpanningTree();
	
		System.out.println(spt.getEdges()); //Obtenemos las aristas
		System.out.println(spt.getWeight()); //Obtenemo el peso del arbol (del recorrido)
		
		
		
		
		
		System.out.println("-----------------VERTEX COVER  ALGORITMO----------------"); //Recubrimiento de vertices
		
		MinimumWeightedVertexCoverAlgorithm<String, DefaultWeightedEdge> recVC = new RecursiveExactVCImpl<>();
		VertexCover<String> cover =  recVC.getVertexCover(grafoDij);
		System.out.println(cover);
		System.out.println(cover.getWeight());
		
		
		System.out.println("-----------------CICLO HAMILTONIANO----------------");
		
		TSPAlgorithm<String, DefaultWeightedEdge> hamil = new TwoApproxMetricTSP<>();
		GraphPath<String, DefaultWeightedEdge> tourne = hamil.getTour(grafoDij);
		System.out.println(tourne);
		
		
		System.out.println("-----------------CICLO HAMILTONIANO----------------");
		VertexColoringAlgorithm<String> colores = new GreedyColoring<String, DefaultWeightedEdge>(grafoDij);
		colores.getColoring().getColors();
		
		
		
		//Componentes conexas
		ConnectivityInspector<String, DefaultWeightedEdge> con = new ConnectivityInspector<>(grafoDij);
		List<Set<String>> componentes = con.connectedSets(); //Set con los vértices de la mimsa componente conexa del vértice.
		con.isGraphConnected(); //Devuelve si el grafo es conexo o no.
		componentes.size(); //Número de componentes conexas.
	}
	

}
