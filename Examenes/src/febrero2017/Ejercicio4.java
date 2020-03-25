package febrero2017;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.alg.interfaces.MinimumWeightedVertexCoverAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.alg.vertexcover.GreedyVCImpl;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Ejercicio4 {

	public static void main(String[] args) {
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		System.out.println(graph);
	}

	public static Set<String> getMonitorizaciónMenor(Graph<String, DefaultWeightedEdge> red) {
		MinimumWeightedVertexCoverAlgorithm<String, DefaultWeightedEdge> vc = new GreedyVCImpl<String, DefaultWeightedEdge>();
		return vc.getVertexCover(red).getVertices();
	}

	public static List<String> getRutaMenorLatencia(Graph<String, DefaultWeightedEdge> red, String d1, String d2) {
		DijkstraShortestPath<String, DefaultWeightedEdge> dj = new DijkstraShortestPath<>(red);
		return dj.getPath(d1, d2).getVertexList();
	}

	public static int getGruposAislados(Graph<String, DefaultWeightedEdge> red) {
		ConnectivityInspector<String, DefaultWeightedEdge> ci = new ConnectivityInspector<>(red);
		return ci.connectedSets().size();
	}

	public static Set<String> getAccesibles(Graph<String, DefaultWeightedEdge> red) {
		return new ConnectivityInspector(red).connectedSetOf(new String("A"));
	}

	public static Set<DefaultWeightedEdge> getInterconexionesInnecesarias(Graph<String, DefaultWeightedEdge> red) {
		KruskalMinimumSpanningTree<String, DefaultWeightedEdge> kr = new KruskalMinimumSpanningTree<>(red);
		Set<DefaultWeightedEdge> pene = new HashSet<>(red.edgeSet());
		pene.removeAll(kr.getSpanningTree().getEdges());
		return pene;
	}

}
