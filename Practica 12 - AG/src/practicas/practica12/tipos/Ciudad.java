package practicas.practica12.tipos;

public class Ciudad {
	
	public static Ciudad create (String [] formato) {
		return new Ciudad(formato);
	}
	
	private String nombre;
	
	private Ciudad (String [] formato) {
		nombre= formato[0];
	}
	
	public String getNombre () {
		return nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

}
