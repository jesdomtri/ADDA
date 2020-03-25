package problema2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cuidadora {

	public Integer codigo;
	public Integer sueldo;
	public List<Integer> compatibilidades;

	public Cuidadora(Integer codigo, Integer sueldo, List<Integer> compatibilidades) {
		super();
		this.codigo = codigo;
		this.sueldo = sueldo;
		this.compatibilidades = compatibilidades;
	}

	public Cuidadora(String s) {
		String[] r = s.split("@");
		this.codigo = new Integer(r[0].trim());
		this.sueldo = new Integer(r[1].trim());
		List<Integer> comp = new ArrayList<>();
		for (int i = 2; i < r.length; i++) {
			Integer h = new Integer(r[i].trim());
			comp.add(h);
		}
		this.compatibilidades = comp;
	}

	public Cuidadora(String[] formato) {
		this.codigo = new Integer(formato[0].trim());
		this.sueldo = new Integer(formato[1].trim());
		List<Integer> lb = Arrays.asList();
		for (int i = 2; i < formato.length; i++) {
			lb.add(new Integer(formato[i].trim()));
		}
		this.compatibilidades = lb;
	}

	public static Cuidadora create(Integer codigo, Integer sueldo, List<Integer> compatibilidades) {
		return new Cuidadora(codigo, sueldo, compatibilidades);
	}

	public static Cuidadora create(String s) {
		return new Cuidadora(s);
	}

	public static Cuidadora create(String[] formato) {
		return new Cuidadora(formato);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public List<Integer> getCompatibilidades() {
		return compatibilidades;
	}

	public String toString() {
		return "Cuidadora [codigo=" + codigo + ", sueldo=" + sueldo + ", compatibilidades=" + compatibilidades + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((compatibilidades == null) ? 0 : compatibilidades.hashCode());
		result = prime * result + ((sueldo == null) ? 0 : sueldo.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuidadora other = (Cuidadora) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (compatibilidades == null) {
			if (other.compatibilidades != null)
				return false;
		} else if (!compatibilidades.equals(other.compatibilidades))
			return false;
		if (sueldo == null) {
			if (other.sueldo != null)
				return false;
		} else if (!sueldo.equals(other.sueldo))
			return false;
		return true;
	}

}
