package practicas.practica15;

import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

import us.lsi.graphs.GraphView;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.ProblemaPD;

public class ProblemaBicicletasPD<V, E> implements ProblemaPD<String, ProblemaBicicletasPD.Alternativa> {
	/** (i,j) = El camino minimo de ir de la estacion i a la estacion j */
	/**
	 * (i,j,k) = El camino minimo de ir de la estacion i a la estacion j
	 * considerando las estaciones alternativas de K a n-1 w(i, k, k+1) + w(k, j,
	 * k+1)
	 */
	// k = n --> ya no queda ninguna estacion alternativa

	/*
	 * -> i = k ---> (No, 0) CASOS BASE (i, j, k) -> k = n y (i, j) existe en el
	 * grafo ---> (No, w(i, j)) = SOLUCION PARCIAL (alternativa, propiedad
	 * optimizar) -> k = n y (i, j) no existe en el grafo ---> vacio
	 * 
	 */
	public enum Alternativa {
		Yes, No
	};

	private int i;
	private int j;
	private int k;
	private GraphView<V, E> grafo;

	private ProblemaBicicletasPD(int i, int j, int k, GraphView<V, E> grafo) {
		super();
		this.i = i;
		this.j = j;
		this.k = k;
		this.grafo = grafo;
	}

	public static <V, E> ProblemaBicicletasPD<V, E> create(int i, int j, GraphView<V, E> grafo) {
		return new ProblemaBicicletasPD<V, E>(i, j, 0, grafo);
	}

	public static <V, E> ProblemaBicicletasPD<V, E> create(int i, int j, int k, GraphView<V, E> grafo) {
		return new ProblemaBicicletasPD<V, E>(i, j, k, grafo);
	}

	public ProblemaPD.Tipo getTipo() {
		return Tipo.Min;
	}

	public boolean esCasoBase() {
		return (i == j) || (k == grafo.getNumVertices());
	}

	public Sp<Alternativa> getSolucionParcialCasoBase() {
		// Creamos una tupla:
		if (i == j) {
			return Sp.create(Alternativa.No, 0.);
		} else if (grafo.isEdge(i, j)) {
			return Sp.create(Alternativa.No, grafo.getWeight(i, j));
		} else {
			return null; // No hay solucion
		}
	}

	public List<Alternativa> getAlternativas() {
		List<Alternativa> ls = Lists.newArrayList();
		ls.add(Alternativa.No);
		ls.add(Alternativa.Yes);
		return ls;
	}

	public int getNumeroSubProblemas(Alternativa a) {
		if (a.equals(Alternativa.No)) {
			return 1;
		} else {
			return 2;
		}
	}

	public ProblemaPD<String, Alternativa> getSubProblema(Alternativa a, int np) {
		if (a.equals(Alternativa.No)) {
			return ProblemaBicicletasPD.create(i, j, k + 1, grafo);
		} else if (np == 0) {
			return ProblemaBicicletasPD.create(i, k, k + 1, grafo);
		} else {
			return ProblemaBicicletasPD.create(k, j, k + 1, grafo);
		}
	}

	public Sp<Alternativa> getSolucionParcialPorAlternativa(Alternativa a, List<Sp<Alternativa>> ls) {
		if (Alternativa.No.equals(a)) {
			return Sp.create(Alternativa.No, ls.get(0).propiedad); // Propiedad devuelve el peso
		} else {
			return Sp.create(Alternativa.Yes, ls.get(0).propiedad + ls.get(1).propiedad);
		}
	}

	public Sp<Alternativa> getSolucionParcial(List<Sp<Alternativa>> ls) {
		return ls.stream().min(Comparator.naturalOrder()).orElse(null);
	}

	public String getSolucionReconstruidaCasoBase(Sp<Alternativa> sp) {
		return grafo.getVertice(i) + "<" + sp.propiedad + ">" + grafo.getVertice(j);
	}

	public String getSolucionReconstruidaCasoRecursivo(Sp<Alternativa> sp, List<String> ls) {
		String r = null;
		switch (sp.alternativa) {
		case No:
			r = ls.get(0);
			break;
		case Yes:
			r = ls.get(0) + ", " + ls.get(1);
			break;
		}
		return r;
	}

	public Double getObjetivoEstimado(Alternativa a) {
		return Double.MIN_VALUE;
	}

	public Double getObjetivo() {
		return Double.MAX_VALUE;
	}

	public int size() {
		return grafo.getNumVertices() - k;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		result = prime * result + k;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProblemaBicicletasPD))
			return false;
		ProblemaBicicletasPD<?, ?> other = (ProblemaBicicletasPD<?, ?>) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		if (k != other.k)
			return false;
		return true;
	}

	public String toString() {
		return "(" + i + "," + j + "," + k + ")";
	}
}
