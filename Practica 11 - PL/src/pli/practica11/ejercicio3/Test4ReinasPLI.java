package pli.practica11.ejercicio3;
import us.lsi.algoritmos.Algoritmos;
import us.lsi.pl.*;

public class Test4ReinasPLI {

	public static void main(String[] args) {
		AlgoritmoPLI a = Algoritmos.createPLI("ficheros/ejercicio3.txt");
		a.ejecuta();
		int nReinas = 4;
		for (int i = 0; i < nReinas; i++){
			for (int j = 0; j < nReinas; j++){
				double x = a.getSolucion()[i*nReinas + j];
				System.out.print(Math.round(x) + " ");
			}
			System.out.println();
		}
	}
}

