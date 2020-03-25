package febrero2017;

public class Moneda {

	private Double peso;
	private Double tamanyo;

	public Moneda(Double peso, Double tamanyo) {
		super();
		this.peso = peso;
		this.tamanyo = tamanyo;
	}

	public static Moneda create(Double peso, Double tamanyo) {
		return new Moneda(peso, tamanyo);
	}

	public Double getPeso() {
		return peso;
	}

	public Double getTamanyo() {
		return tamanyo;
	}

	public String toString() {
		return "" + getPeso();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moneda other = (Moneda) obj;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		return true;
	}

}
