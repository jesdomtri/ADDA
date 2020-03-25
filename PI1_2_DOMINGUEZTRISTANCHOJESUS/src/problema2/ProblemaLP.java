package problema2;

import java.util.List;

public class ProblemaLP {

	public static String getConstraints(List<Cuidadora> cuidadoras, Integer pres) {

		String r = "max: ";

		// funcion objetiva
		for (int i = 0; i < cuidadoras.size(); i++) {
			for (int j = 0; j < cuidadoras.get(i).getCompatibilidades().size(); j++) {
				if (i == (cuidadoras.size() - 1) && j == (cuidadoras.get(i).getCompatibilidades().size() - 1)) {
					r = r + cuidadoras.get(i).getCompatibilidades().get(j) + "x" + i + "_" + j;
				} else {
					r = r + cuidadoras.get(i).getCompatibilidades().get(j) + "x" + i + "_" + j + " + ";
				}
			}
		}
		r = r + "; \n\n";

		// 4 cuidadoras
		for (int i = 0; i < cuidadoras.size(); i++) {
			for (int j = 0; j < cuidadoras.get(i).getCompatibilidades().size(); j++) {
				if (i == (cuidadoras.size() - 1) && j == (cuidadoras.get(i).getCompatibilidades().size() - 1)) {
					r = r + "x" + i + "_" + j;
				} else {
					r = r + "x" + i + "_" + j + " + ";
				}
			}
		}
		r = r + " = " + cuidadoras.get(0).getCompatibilidades().size() + ";\n\n";

		// una cuidadora no puede cuidar mas de un bebe
		for (int i = 0; i < cuidadoras.size(); i++) {
			for (int j = 0; j < cuidadoras.get(i).getCompatibilidades().size(); j++) {
				if (j == (cuidadoras.get(i).getCompatibilidades().size() - 1)) {
					r = r + "x" + i + "_" + j;
				} else {
					r = r + "x" + i + "_" + j + " + ";
				}
			}
			r = r + " <= 1; \n";
		}
		r = r + "\n\n";

		// un bebe no puede tener mas de una cuidadora
		for (int i = 0; i < cuidadoras.get(i).getCompatibilidades().size(); i++) {
			for (int j = 0; j < cuidadoras.size(); j++) {
				if (j == (cuidadoras.size() - 1)) {
					r = r + "x" + j + "_" + i;
				} else {
					r = r + "x" + j + "_" + i + " + ";
				}
			}
			r = r + " = 1; \n";
		}
		r = r + "\n\n";

		// no se puede superar el presupuesto
		for (int i = 0; i < cuidadoras.size(); i++) {
			for (int j = 0; j < cuidadoras.get(i).getCompatibilidades().size(); j++) {
				if (i == (cuidadoras.size() - 1) && j == (cuidadoras.get(i).getCompatibilidades().size() - 1)) {
					r = r + cuidadoras.get(i).getSueldo() + "x" + i + "_" + j;
				} else {
					r = r + cuidadoras.get(i).getSueldo() + "x" + i + "_" + j + " + ";
				}
			}
		}
		r = r + " <= " + pres + ";\n\n";

		// Los elementos son binarios
		r = r + "bin ";

		for (int i = 0; i < cuidadoras.size(); i++) {
			for (int j = 0; j < cuidadoras.get(i).getCompatibilidades().size(); j++) {
				if (i == (cuidadoras.size() - 1) && j == (cuidadoras.get(i).getCompatibilidades().size() - 1)) {
					r = r + "x" + i + "_" + j;
				} else {
					r = r + "x" + i + "_" + j + ", ";
				}
			}
		}

		r = r + "; \n\n";

		return r;
	}

}
