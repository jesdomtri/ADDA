package practicas.practica17;

import static org.junit.Assert.assertTrue;

import org.jgrapht.GraphPath;
import org.junit.Before;
import org.junit.Test;

import us.lsi.algoritmos.Algoritmos;
import us.lsi.astar.AStarAlgorithm;
import us.lsi.astar.AStarGraph;
import us.lsi.graphs.SimpleEdge;

public class TestAStarPuzzleJUnit {

	AStarGraph<EstadoPuzzle, SimpleEdge<EstadoPuzzle>> graph;

	AStarAlgorithm<EstadoPuzzle, SimpleEdge<EstadoPuzzle>> d;
	GraphPath<EstadoPuzzle, SimpleEdge<EstadoPuzzle>> p;
	EstadoPuzzle pOrigen, pObjetivo1, pObjetivo2;

	@Before
	public void setUp() throws Exception {
		ProblemaPuzzle.numFilas = 3;
		pOrigen = EstadoPuzzle.create(0, 1, 2, 3, 4, 5, 6, 7, 8);
		pObjetivo1 = EstadoPuzzle.create(1, 2, 3, 4, 5, 6, 7, 8, 0);
		pObjetivo2 = EstadoPuzzle.create(1, 2, 3, 4, 5, 0, 6, 7, 8);

		graph = PuzzleGraph.create(pOrigen,pObjetivo1);

	}

	@Test
	public void testCosteCaminoAStart1() {
		d = Algoritmos.createAStar(graph, pOrigen, pObjetivo1);

		double weight = d.getPath().getLength();
		assertTrue("El coste del camino obtenido por el algoritmo A* debería ser 22 y sin embargo ha sido " + weight,
				weight == 22);
	}

	@Test
	public void testCosteCaminoAStart2() {
		d = Algoritmos.createAStar(graph, pOrigen, pObjetivo2);

		double weight2 = d.getPath().getLength();
		assertTrue("El coste del camino obtenido por el algoritmo A* debería ser 15 y sin embargo ha sido " + weight2,
				weight2 == 15);

	}

	@Test
	public void testCosteCaminoAStart3() {
		d = Algoritmos.createAStar(graph, pOrigen, pObjetivo2);

		double weight3 = d.getPath().getLength();
		assertTrue("El coste del camino obtenido por el algoritmo A* debería ser 15 y sin embargo ha sido " + weight3,
				weight3 == 15);
	}

	@Test
	public void testValorHeuristica1() {

		double distancia = graph.getWeightToEnd(pOrigen, pObjetivo1);
		assertTrue(
				"La distancia del hueco desde el puzzle origen al puzzle destino debería ser 8 y sin embargo ha sido "
						+ distancia,
				distancia == 8.0);
	}

	@Test
	public void testValorHeuristica2() {

		double distancia = graph.getWeightToEnd(pOrigen, pObjetivo2);
		assertTrue(
				"La distancia del hueco desde el puzzle origen al puzzle destino debería ser 5 y sin embargo ha sido "
						+ distancia,
				distancia == 5.0);
	}
}
