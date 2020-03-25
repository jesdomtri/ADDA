package estudiante;

public class Estudiante {

	private String nombre, apellidos;

	private String nif;

	private Integer edad;

	enum genero {
		Femenino, Masculino
	}

	private genero sexo;

	public Estudiante(String nombre, String apellidos, String nif, Integer edad, genero sexo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.edad = edad;
		this.sexo = sexo;
	}

	public static Estudiante create(String nombre, String apellido, String nif, Integer edad, genero sexo) {
		return new Estudiante(nombre, apellido, nif, edad, sexo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public genero getSexo() {
		return sexo;
	}

	public void setSexo(genero sexo) {
		this.sexo = sexo;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", edad=" + edad
				+ ", sexo=" + sexo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
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
		Estudiante other = (Estudiante) obj;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	};

}