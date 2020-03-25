package practicas.practica12.tipos;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Carretera extends DefaultWeightedEdge{

	public static Carretera create(Ciudad c1, Ciudad c2) {
		return new Carretera(c1,c2);
	}

	public static Carretera create(Ciudad c1, Ciudad c2, String[] formato) {
		return new Carretera(c1,c2,formato);
	}

	public Carretera(Ciudad c1, Ciudad c2) {
		super();
		this.source = c1;
		this.target = c2;
		this.km = 0.;
		this.id = num;
		num++;
	}
	

	public Carretera (Ciudad c1, Ciudad c2, String [] formato) {
		this.source= c1;
		this.target= c2;
				
		if (formato!=null && formato.length>=3)
			this.km= new Double(formato[2]);
		else this.km= null;
		this.id= num;
		num++;
	}

	
	
	
    @Override  
    public String toString() {
    	Double peso= getWeight();
   	 	return "[" + getSource() + "," + getTarget() + (peso!=null?peso:"") + "]";
    }  	

	private static final long serialVersionUID = 1L;

	private static int num =0;
	private Ciudad source;
	private Ciudad target;
	private Double km;
	private int id;

	public Double getKm() {
		return km;
	}

	
	@Override
	public Ciudad getSource(){
		return source;
	}
	
	@Override
	public Ciudad getTarget(){
		return target;
	}

	@Override
	public double getWeight () {
		return km;
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
		if (!(obj instanceof Carretera))
			return false;
		Carretera other = (Carretera) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
