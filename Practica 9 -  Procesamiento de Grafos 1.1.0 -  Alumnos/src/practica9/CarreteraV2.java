package practica9;

import org.jgrapht.graph.DefaultWeightedEdge;

public class CarreteraV2 extends DefaultWeightedEdge{

	
	private static final long serialVersionUID = 1L;
	private CiudadV2 source;
	private CiudadV2 target;
	private String nombre;
	private Double km;
	private int id;
	private static int num=0;
	
	public CarreteraV2(CiudadV2 source, CiudadV2 target, String nombre, Double km) {
		super();
		this.source = source;
		this.target = target;
		this.nombre = nombre;
		this.km = km;
		this.id = num;
		num = num + 1;
	}
	
	public static CarreteraV2 create(CiudadV2 source, CiudadV2 target){
		return new CarreteraV2(source, target, null, null);
	}
	
	public static CarreteraV2 create(CiudadV2 source, CiudadV2 target ,String[] formato){
		return new CarreteraV2(source, target, formato[2], new Double(formato[3]));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		CarreteraV2 other = (CarreteraV2) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ""+ km;
	}

	public CiudadV2 getSource() {
		return source;
	}

	public CiudadV2 getTarget() {
		return target;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getKm() {
		return km;
	}

	
	
	
	
	
	
}
