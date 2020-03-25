package pi2_problema2_2;

import java.util.List;

import com.google.common.collect.Lists;

public class ProblemaInversion {

	private Integer presupuesto;
	private List<Inversion> inversiones;

	public static ProblemaInversion create(Integer presupuesto, List<Inversion> inversiones) {
		return new ProblemaInversion(presupuesto, inversiones);
	}

	public ProblemaInversion(Integer presupuesto, List<Inversion> inversiones) {
		super();
		this.presupuesto = presupuesto;
		this.inversiones = inversiones;
	}

	public Integer getPresupuesto() {
		return presupuesto;
	}

	public List<Inversion> getInversiones() {
		return Lists.newArrayList(inversiones);
	}

	public void setPresupuesto(Integer presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setInversiones(List<Inversion> inversiones) {
		this.inversiones = inversiones;
	}

	public Inversion getInversion(Integer index) {
		return getInversiones().get(index);
	}

	public String toString() {
		return "ProblemaInversion [presupuesto=" + getPresupuesto() + ", inversiones=" + getInversiones() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inversiones == null) ? 0 : inversiones.hashCode());
		result = prime * result + ((presupuesto == null) ? 0 : presupuesto.hashCode());
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
		ProblemaInversion other = (ProblemaInversion) obj;
		if (inversiones == null) {
			if (other.inversiones != null)
				return false;
		} else if (!inversiones.equals(other.inversiones))
			return false;
		if (presupuesto == null) {
			if (other.presupuesto != null)
				return false;
		} else if (!presupuesto.equals(other.presupuesto))
			return false;
		return true;
	}

}
