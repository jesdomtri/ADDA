package pi2_problema2_2;

public class Inversion {

	private Integer id;
	private String nombre;
	private Double beneficio;
	private Double coste;
	private Double riesgo;
	private CategoriaTecnologica catTec;
	private GradoInnovacion gradoInn;

	public Inversion(Integer id, String nombre, Double beneficio, Double coste, Double riesgo,
			CategoriaTecnologica catTec, GradoInnovacion gradoInn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.beneficio = beneficio;
		this.coste = coste;
		this.riesgo = riesgo;
		this.catTec = catTec;
		this.gradoInn = gradoInn;
	}

	public Inversion(String s) {
		String[] inv = s.split("#");
		this.id = new Integer(inv[0].trim());
		this.nombre = inv[1].trim();
		this.beneficio = new Double(inv[2].trim());
		this.coste = new Double(inv[3].trim());
		this.riesgo = new Double(inv[4].trim());
		this.catTec = CategoriaTecnologica.valueOf(inv[5].trim());
		this.gradoInn = GradoInnovacion.valueOf(inv[6].trim());
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getBeneficio() {
		return beneficio;
	}

	public Double getCoste() {
		return coste;
	}

	public Double getRiesgo() {
		return riesgo;
	}

	public CategoriaTecnologica getCatTec() {
		return catTec;
	}

	public GradoInnovacion getGradoInn() {
		return gradoInn;
	}

	public Double getValor() {
		return new Double(getBeneficio() / (getCoste() + getRiesgo()));
	}

	public String toString() {
		return getNombre() + " (" + getId() + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beneficio == null) ? 0 : beneficio.hashCode());
		result = prime * result + ((catTec == null) ? 0 : catTec.hashCode());
		result = prime * result + ((coste == null) ? 0 : coste.hashCode());
		result = prime * result + ((gradoInn == null) ? 0 : gradoInn.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((riesgo == null) ? 0 : riesgo.hashCode());
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
		Inversion other = (Inversion) obj;
		if (beneficio == null) {
			if (other.beneficio != null)
				return false;
		} else if (!beneficio.equals(other.beneficio))
			return false;
		if (catTec != other.catTec)
			return false;
		if (coste == null) {
			if (other.coste != null)
				return false;
		} else if (!coste.equals(other.coste))
			return false;
		if (gradoInn != other.gradoInn)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (riesgo == null) {
			if (other.riesgo != null)
				return false;
		} else if (!riesgo.equals(other.riesgo))
			return false;
		return true;
	}

}
