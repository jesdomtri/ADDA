package pi2_problema2_2;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import us.lsi.bt.EstadoBT;

public class EstBT implements EstadoBT<SolInv, Alternativa> {

	private int index;
	private Double costeTotal;
	private Double valorTotal;
	private List<Inversion> invSel;
	private ProblemaInversion prob;

	public EstBT(ProblemaInversion prob) {
		this.index = 0;
		this.costeTotal = 0.;
		this.valorTotal = 0.;
		this.invSel = Lists.newArrayList();
		this.prob = prob;
	}

	public static EstBT create(ProblemaInversion prob) {
		return new EstBT(prob);
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

	public EstadoBT<SolInv, Alternativa> getEstadoInicial() {
		return create(prob);
	}

	public EstadoBT<SolInv, Alternativa> avanza(Alternativa a) {
		if (a.equals(Alternativa.YES)) {
			costeTotal += prob.getInversion(index).getCoste();
			valorTotal += prob.getInversion(index).getValor();
			invSel.add(prob.getInversion(index));
		}
		index++;
		return this;
	}

	public EstadoBT<SolInv, Alternativa> retrocede(Alternativa a) {
		index--;
		if (a.equals(Alternativa.YES)) {
			costeTotal -= prob.getInversion(index).getCoste();
			valorTotal -= prob.getInversion(index).getValor();
			invSel.remove(prob.getInversion(index));
		}
		return this;
	}

	public int size() {
		return prob.getInversiones().size() - index;
	}

	public boolean esCasoBase() {
		return index == prob.getInversiones().size();
	}

	public List<Alternativa> getAlternativas() {
		List<Alternativa> ls = Lists.newArrayList();
		Collections.addAll(ls, Alternativa.YES, Alternativa.NO);
		return ls;
	}

	public SolInv getSolucion() {
		if (mitadWeb(invSel) && costeTotal <= prob.getPresupuesto()) {
			return SolInv.create(valorTotal, invSel);
		} else {
			return null;
		}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costeTotal == null) ? 0 : costeTotal.hashCode());
		result = prime * result + index;
		result = prime * result + ((invSel == null) ? 0 : invSel.hashCode());
		result = prime * result + ((prob == null) ? 0 : prob.hashCode());
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
		EstBT other = (EstBT) obj;
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
		if (prob == null) {
			if (other.prob != null)
				return false;
		} else if (!prob.equals(other.prob))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

}
