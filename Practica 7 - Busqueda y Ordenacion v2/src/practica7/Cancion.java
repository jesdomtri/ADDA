package practica7;

public class Cancion {

	private Integer duracion;
	private Integer popularidad;
	private String nombre;
	
	static public Cancion create(Integer duracion, Integer popularidad, String nombre) {
		return new Cancion(duracion, popularidad, nombre);
	}
	private Cancion(Integer duracion, Integer popularidad, String nombre) {
		super();
		this.duracion = duracion;
		this.popularidad = popularidad;
		this.nombre = nombre;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public Integer getPopularidad() {
		return popularidad;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Cancion other = (Cancion) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cancion [duracion=" + duracion + ", popularidad=" + popularidad
				+ ", nombre=" + nombre + "]";
	};
	
	
	
	
}
