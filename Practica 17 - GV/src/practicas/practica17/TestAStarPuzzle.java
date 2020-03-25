package practicas.practica17;

import java.util.Set;

import org.jgrapht.Graphs;

import us.lsi.algoritmos.Algoritmos;
import us.lsi.astar.AStarAlgorithm;
import us.lsi.astar.AStarGraph;
import us.lsi.graphs.SimpleEdge;

public class TestAStarPuzzle {

	
	public static void main(String[] args) {
		
		ProblemaPuzzle.numFilas = 3;
		EstadoPuzzle pInicial = EstadoPuzzle.create(0,1,2,3,4,5,6,7,8);
		EstadoPuzzle pObjetivo = EstadoPuzzle.create(1,2,3,4,0,5,6,7,8);
		System.out.println("Puzzle objetivo");
		System.out.println(pInicial);
	
		AStarGraph<EstadoPuzzle,SimpleEdge<EstadoPuzzle>> graph = PuzzleGraph.create(pInicial,pObjetivo);
		AStarAlgorithm<EstadoPuzzle,SimpleEdge<EstadoPuzzle>> d = Algoritmos.createAStar(graph, pInicial, pObjetivo);
		
		System.out.println("Vertices del camino mínimo obtenido");
		System.out.println(d.getPathVertexList());
		
		System.out.println("Numero de movimientos");
		System.out.println(d.getPath().getLength());
		
		System.out.println("Vertices vecinos de pInicial");
		Set<SimpleEdge<EstadoPuzzle>> ss = graph.edgesOf(pInicial);
		System.out.println("pInicial = \n"+pInicial);
		for (SimpleEdge<EstadoPuzzle> e: ss){
			System.out.println(Graphs.getOppositeVertex(graph,e, pInicial));
		}
		
}

}
