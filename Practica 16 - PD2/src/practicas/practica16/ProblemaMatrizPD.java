package practicas.practica16;

import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

import us.lsi.common.Preconditions;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.ProblemaPD;

public class ProblemaMatrizPD implements ProblemaPD<SolucionMatriz, Integer> {

	private int i;
	private int j;
	private ProblemaMatriz problemaOriginal;

	public static ProblemaMatrizPD create(ProblemaMatriz problema) {
		return new ProblemaMatrizPD(0, problema.getMatrices().size(), problema);
	}

	public static ProblemaMatrizPD create(int i, int j, ProblemaMatriz problema) {
		return new ProblemaMatrizPD(i, j, problema);

	}

	private ProblemaMatrizPD(int i, int j, ProblemaMatriz problema) {
		this.i = i;
		this.j = j;
		this.problemaOriginal = problema;
	}

	public ProblemaPD.Tipo getTipo() {
		return ProblemaPD.Tipo.Min;

	}

	public boolean esCasoBase() {
		return j - i <= 2;
	}

	public Sp<Integer> getSolucionParcialCasoBase() {
		if (j - i == 1) {
			return Sp.create(null, 0.0);
		} else {
			return Sp.create(null, new Double(
					problemaOriginal.getFila(i) * problemaOriginal.getColumna(i) * problemaOriginal.getColumna(i + 1)));
		}
	}

	public List<Integer> getAlternativas() {
		List<Integer> res = Lists.newArrayList();
		for (int c = (this.i + 1); c < this.j; c++) {
			res.add(c);
		}
		return res;
	}

	public int getNumeroSubProblemas(Integer a) {
		return 2;
	}

	public ProblemaPD<SolucionMatriz, Integer> getSubProblema(Integer a, int np) {
		if (np == 0) {
			return ProblemaMatrizPD.create(i, a, problemaOriginal);
		} else {
			return ProblemaMatrizPD.create(a, j, problemaOriginal);
		}
	}

	public Sp<Integer> getSolucionParcial(List<Sp<Integer>> ls) {
		return ls.stream().min(Comparator.naturalOrder()).orElse(null);
	}

	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, List<Sp<Integer>> ls) {
		return Sp.create(a, ls.get(0).propiedad + ls.get(1).propiedad
				+ problemaOriginal.getFila(i) * problemaOriginal.getFila(a) * problemaOriginal.getColumna(j - 1));
	}

	public SolucionMatriz getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		Preconditions.checkState(esCasoBase());
		SolucionMatriz r;
		if (j - i == 1) // Una sola matriz.
			r = SolucionMatriz.create("(" + i + ")", sp.propiedad.intValue());
		else // Dos matrices.
			r = SolucionMatriz.create("(" + i + "*" + (j - 1) + ")", sp.propiedad.intValue());

		return r;
	}

	public SolucionMatriz getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<SolucionMatriz> ls) {
		SolucionMatriz r1 = ls.get(0);
		SolucionMatriz r2 = ls.get(1);
		String expresion = "(" + r1.getExpresionConParentesis() + "*" + r2.getExpresionConParentesis() + ")";
		return SolucionMatriz.create(expresion, sp.propiedad.intValue());
	}

	public Double getObjetivoEstimado(Integer a) {
		return Double.MIN_VALUE;
	}

	public Double getObjetivo() {
		return Double.MAX_VALUE;
	}

	public int size() {
		return j - i;

	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProblemaMatrizPD))
			return false;
		ProblemaMatrizPD other = (ProblemaMatrizPD) obj;
		if (problemaOriginal == null && other.problemaOriginal != null)
			return false;
		if (problemaOriginal != null && !problemaOriginal.equals(other.problemaOriginal))
			return false;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;

		return true;
	}

	public String toString() {
		return "(" + i + "," + j + ")";
	}

}
