package pi2_problema2_2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.ProblemaPD;

public class ProbPD implements ProblemaPD<SolInv, Alternativa> {

	private int index;
	private Double costeTotal;
	private Double valorTotal;
	private List<Inversion> invSel;
	private ProblemaInversion prob;

	public ProbPD(int index, Double costeTotal, Double valorTotal, List<Inversion> invSel, ProblemaInversion prob) {
		super();
		this.index = index;
		this.costeTotal = costeTotal;
		this.valorTotal = valorTotal;
		this.invSel = invSel;
		this.prob = prob;
	}

	public ProbPD(ProblemaInversion prob) {
		super();
		this.index = 0;
		this.costeTotal = 0.;
		this.valorTotal = 0.;
		this.invSel = Lists.newArrayList();
		this.prob = prob;
	}

	public static ProbPD create(int index, Double costeTotal, Double valorTotal, List<Inversion> invSel,
			ProblemaInversion prob) {
		return new ProbPD(index, costeTotal, valorTotal, invSel, prob);
	}

	public static ProbPD create(ProblemaInversion prob) {
		return new ProbPD(prob);
	}

	public Boolean mitadWeb(List<Inversion> inv) {
		Integer cont = 0;
		for (Inversion inversion : inv) {
			if (inversion.getCatTec().equals(CategoriaTecnologica.WEB)) {
				cont++;
			}
		}
		if (cont >= (inv.size() / 2.)) {
			return true;
		} else {
			return false;
		}
	}

	public Tipo getTipo() {
		return Tipo.Max;
	}

	public int size() {
		return prob.getInversiones().size() - index;
	}

	public boolean esCasoBase() {
		return index == prob.getInversiones().size();
	}

	public Sp<Alternativa> getSolucionParcialCasoBase() {
		if (mitadWeb(invSel) && costeTotal <= prob.getPresupuesto()) {
			return Sp.create(null, valorTotal);
		} else {
			return null;
		}
	}

	public Sp<Alternativa> getSolucionParcial(List<Sp<Alternativa>> ls) {
		return ls.stream().max(Comparator.naturalOrder()).orElse(null);
	}

	public ProblemaPD<SolInv, Alternativa> getSubProblema(Alternativa a, int np) {
		List<Inversion> li = Lists.newArrayList(invSel);
		if (a.equals(Alternativa.NO)) {
			return create(index + 1, costeTotal, valorTotal, li, prob);
		} else {
			Inversion e = prob.getInversiones().get(index);
			li.add(e);
			return create(index + 1, costeTotal + e.getCoste(), valorTotal + e.getValor(), li, prob);
		}
	}

	public Sp<Alternativa> getSolucionParcialPorAlternativa(Alternativa a, List<Sp<Alternativa>> ls) {
		return Sp.create(a, ls.get(0).propiedad);
	}

	public List<Alternativa> getAlternativas() {
		List<Alternativa> ls = Lists.newArrayList();
		Collections.addAll(ls, Alternativa.YES, Alternativa.NO);
		return ls;
	}

	public int getNumeroSubProblemas(Alternativa a) {
		return 1;
	}

	public SolInv getSolucionReconstruidaCasoBase(Sp<Alternativa> sp) {
		return SolInv.create(valorTotal, invSel);
	}

	public SolInv getSolucionReconstruidaCasoRecursivo(Sp<Alternativa> sp, List<SolInv> ls) {
		return ls.get(0);
	}

	public Double getObjetivoEstimado(Alternativa a) {
		Integer alt = 0;
		if (a.equals(Alternativa.YES)) {
			alt = 1;
		}
		Double cont = 0.;
//		for (Inversion inv : prob.getInversiones()) {
//			cont += inv.getValor();
//		}
		for (int i = index+1; i < prob.getInversiones().size(); i++) {
			cont += prob.getInversion(i).getValor();
		}
		return valorTotal + alt * prob.getInversion(index).getValor() + cont;
	}

	public String toString() {
		return this.invSel + " " + this.valorTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costeTotal == null) ? 0 : costeTotal.hashCode());
		result = prime * result + index;
		result = prime * result + ((invSel == null) ? 0 : invSel.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProbPD other = (ProbPD) obj;
		if (costeTotal == null) {
			if (other.costeTotal != null)
				return false;
		} else if (!costeTotal.equals(other.costeTotal))
			return false;
		if (index != other.index)
			return false;
		if (invSel == null) {
			if (other.invSel != null)
				return false;
		} else if (!invSel.equals(other.invSel))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

}
