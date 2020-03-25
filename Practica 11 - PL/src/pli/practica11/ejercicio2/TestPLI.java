package pli.practica11.ejercicio2;
import us.lsi.algoritmos.Algoritmos;
import us.lsi.pl.*;

public class TestPLI {

	public static void main(String[] args) {
		
		AlgoritmoPLI a = Algoritmos.createPLI("ficheros/Ejercicio2.txt");
		
		a.ejecuta();
		
		int nV = a.getNumVar();
		
		for (int pos = 0; pos < nV; pos++){
			double x = a.getSolucion()[pos];
			System.out.println(a.getName(pos) + " = " + x + " ");
		}
		
		System.out.println("------");
		System.out.println("Objetivo: " + a.getObjetivo());
		System.out.println("------");
	}
}

