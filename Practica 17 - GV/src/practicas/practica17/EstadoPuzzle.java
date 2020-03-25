package practicas.practica17;

import java.util.*;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import us.lsi.common.*;
import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.VirtualVertex;

public class EstadoPuzzle implements VirtualVertex<EstadoPuzzle, SimpleEdge<EstadoPuzzle>> {

	public static EstadoPuzzle create(ProblemaPuzzle problema) {
		return new EstadoPuzzle(problema);
	}

	public static EstadoPuzzle create(Integer... d) {
		return new EstadoPuzzle(ProblemaPuzzle.create(d));
	}

	public static EstadoPuzzle create(Integer[][] datos, int i0, int j0) {
		return new EstadoPuzzle(ProblemaPuzzle.create(datos, i0, j0));
	}

	private ProblemaPuzzle problema;

	private EstadoPuzzle(ProblemaPuzzle problema) {
		super();
		this.problema = problema;
	}

	public ProblemaPuzzle getProblema() {
		return problema;
	}

	public boolean isValid() {
		return problema.isValid();
	}

	public Set<EstadoPuzzle> getNeighborListOf() {
		List<PairInteger> ls = Lists.newArrayList(PairInteger.create(0, 1), PairInteger.create(0, -1),
				PairInteger.create(1, 0), PairInteger.create(-1, 0));
		return ls.stream()
				.filter(p -> 0 <= problema.getI0() + p.v1 && problema.getI0() + p.v1 < ProblemaPuzzle.numFilas)
				.filter(p -> 0 <= problema.getJ0() + p.v2 && problema.getJ0() + p.v2 < ProblemaPuzzle.numFilas)
				.map(p -> EstadoPuzzle.create(problema.getVecino(p.v1, p.v2))).collect(Collectors.toSet());
	}

	public Set<SimpleEdge<EstadoPuzzle>> edgesOf() {
		return getNeighborListOf().stream().map(v -> SimpleEdge.create(this, v)).collect(Collectors.toSet());
	}

	/**
	 * @param e
	 *            EstadoPuzzle con el que realizar la diferencia.
	 * @return El n�mero de casillas diferentes entre el puzzle del par�metro
	 *         <code> e </code> y el puzzle de <code>this</code>
	 */
	Integer getNumDiferentes(EstadoPuzzle e) {
		return problema.getNumDiferentes(e.problema);
	}

	public String toString() {
		return problema.toString();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((problema == null) ? 0 : problema.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EstadoPuzzle))
			return false;
		EstadoPuzzle other = (EstadoPuzzle) obj;
		if (problema == null) {
			if (other.problema != null)
				return false;
		} else if (!problema.equals(other.problema))
			return false;
		return true;
	}

}
