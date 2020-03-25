package pi2_problema2_2;

import java.util.List;

import com.google.common.collect.Lists;

import us.lsi.bt.SolucionBT;
import us.lsi.pd.AlgoritmoPD;

public class SolInv implements SolucionBT {

	private Double resValor;
	private List<Inversion> resInvers;

	public SolInv(Double resValor, List<Inversion> resInvers) {
		super();
		this.resValor = resValor;
		this.resInvers = Lists.newArrayList(resInvers);
	}

	public static SolInv create(Double resValor, List<Inversion> resInvers) {
		return new SolInv(resValor, resInvers);
	}

	public Double getResValor() {
		return resValor;
	}

	public List<Inversion> getResInvers() {
		return resInvers;
	}

	public Double getObjetivo() {
		return this.resValor;
	}

	

	public String toString() {
		String res = "LISTA DE INVERSIONES SELECCIONADAS:\n";
		for (Inversion inversion : getResInvers()) {
			res = res + inversion + "\n";
		}
		res = res + "VALOR: " + getResValor();
		return res;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resInvers == null) ? 0 : resInvers.hashCode());
		result = prime * result + ((resValor == null) ? 0 : resValor.hashCode());
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
		SolInv other = (SolInv) obj;
		if (resInvers == null) {
			if (other.resInvers != null)
				return false;
		} else if (!resInvers.equals(other.resInvers))
			return false;
		if (resValor == null) {
			if (other.resValor != null)
				return false;
		} else if (!resValor.equals(other.resValor))
			return false;
		return true;
	}

}
