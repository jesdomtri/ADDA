package pli.practica11.ejercicio4;

public class ReinasPLI {

	public static String getConstraints(int numeroDeReinas) {
		String r = "min: ;\n\n";

		// Filas
		for (int i = 0; i < numeroDeReinas; i++) {
			for (int j = 0; j < numeroDeReinas; j++) {
				r = r + "+x" + i + "_" + j;
			}
			r = r + "=1;\n";
		}
		r = r + "\n";

		// Columnas
		for (int i = 0; i < numeroDeReinas; i++) {
			for (int j = 0; j < numeroDeReinas; j++) {
				r = r + "+x" + j + "_" + i;
			}
			r = r + "=1;\n";
		}
		r = r + "\n";

		for (int d = -(numeroDeReinas - 1); d < numeroDeReinas - 1; d++) {
			for (int i = 0; i < numeroDeReinas; i++) {
				for (int j = 0; j < numeroDeReinas; j++) {
					if (d == j - i) {
						r = r + "+x" + i + "_" + j;
					}
				}
			}
			r = r + "<=1; //Diagonal " + d + "\n";
		}

		for (int d = -(numeroDeReinas - 1); d < numeroDeReinas - 1; d++) {
			for (int i = 0; i < numeroDeReinas; i++) {
				for (int j = 0; j < numeroDeReinas; j++) {
					if (d == j + i) {
						r = r + "+x" + i + "_" + j;
					}
				}
			}
			r = r + "<=1; //Diagonal " + d + "\n";
		}

		return r;
	}
}
