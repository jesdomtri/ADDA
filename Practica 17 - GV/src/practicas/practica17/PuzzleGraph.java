package practicas.practica17;

import us.lsi.astar.AStarGraph;
import us.lsi.graphs.*;

public class PuzzleGraph extends SimpleVirtualGraph<EstadoPuzzle, SimpleEdge<EstadoPuzzle>>
		implements AStarGraph<EstadoPuzzle, SimpleEdge<EstadoPuzzle>> {

	public static PuzzleGraph create(EstadoPuzzle... v) {
		return new PuzzleGraph(v);
	}

	protected PuzzleGraph(EstadoPuzzle... v) {
		super(v);
	}

	// TODO incluir los m�todos necesarios para el algoritmo A*

	public double getWeightToEnd(EstadoPuzzle actual, EstadoPuzzle endVertex) {
		if (actual == null || endVertex == null) {
			throw new IllegalArgumentException();
		}
		return actual.getNumDiferentes(endVertex) - 1;
	}

}
