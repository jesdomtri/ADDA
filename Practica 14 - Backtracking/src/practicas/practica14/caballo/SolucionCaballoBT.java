package practicas.practica14.caballo;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import us.lsi.bt.SolucionBT;

//TODO ALUMNOS: OTRAS IMPORTACIONES.

public class SolucionCaballoBT implements SolucionBT {

	/** ATRIBUTOS DE LA CLASE. **/
	private Table<Integer, Integer, Integer> tablero = null;

	public Double getObjetivo() {
		return 0.;
	}

	// -----------------------------------------
	private SolucionCaballoBT() {
		tablero = HashBasedTable.create();
	}

	// TODO ALUMNOS: OTROS CONSTRUCTORES.

	public static SolucionCaballoBT create(Table<Integer, Integer, Integer> tablero) {
		return new SolucionCaballoBT(tablero);
	}
	// -----------------------------------------> No tienen mucha utilidad

	/** Creamos una COPIA del tablero **/
	private SolucionCaballoBT(Table<Integer, Integer, Integer> tablero) {
		this.tablero = HashBasedTable.create(tablero);
	}

	public String toString() {
		String s = "";
		int tam = ProblemaCaballo.getLadoTablero();
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				if (j > 0) {
					s = s + " ";
				}
				Integer v = tablero.get(i, j);
				if (v != null) {
					if (v < 10) {
						s = s + " " + v;
					} else {
						s = s + v;
					}
				} else {
					s = s + " X";
				}
			}
			s = s + "\n";
		}
		return s;
	}

	// public String toString() {
	// String s = "";
	// int tam = ProblemaCaballo.getLadoTablero();
	// for (int i = 0; i < tam; i++) { // Recorreremos todas las celdas
	// for (int j = 0; j < tam; j++) {
	// if (j > 0)
	// s = s + " "; // Separamos cada celda con un espacio en blanco
	// Integer v = tablero.get(i, j);
	// if (v != null) {
	// if (v < 10) {
	// s = s + " " + v;
	// } else {
	// s = s + v;
	// }
	// } else {
	// s = s + "X"; // la celda es X si es null
	// }
	// }
	// s = s + "\n";
	// }
	// return s;
	// }

}
