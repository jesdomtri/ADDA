package practica9;

public class CiudadV2 {
	private String nombre;
	private Double poblacion;

	public CiudadV2(String nombre, Double poblacion) {
		super();
		this.nombre = nombre;
		this.poblacion = poblacion;
	}

	public CiudadV2(String nombre) {
		super();
		this.nombre = nombre;
	}

	public static CiudadV2 create(String nombre) {
		return new CiudadV2(nombre);
	}

	public static CiudadV2 create(String nombre, Double poblacion) {
		return new CiudadV2(nombre, poblacion);
	}

	public static CiudadV2 create(String[] formato) {
		return new CiudadV2(formato[0], new Double(formato[1]));
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CiudadV2 other = (CiudadV2) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public String toString() {
		return nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPoblacion() {
		return poblacion;
	}

}
