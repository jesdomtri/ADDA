package repaso;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Practica2 {

	public static void main(String[] args) {
		List<Integer> l1 = new LinkedList<>();
		List<Integer> l2 = new LinkedList<>();
		Collections.addAll(l1, 1, 2, 3, 4, 5, 6);
		Collections.addAll(l2, 3, 4, 5, 6, 7, 8);

		System.out.println("Mismo incremento? " + ejercicio1(l1, l2));

		Integer n = 20;
		System.out.println("\nLista de numeros primos hasta " + n + ": " + ejercicio2(n));
	}

	private static Boolean ejercicio1(List<Integer> l1, List<Integer> l2) {
		return null;
	}

//	private static Boolean esPrimo2(Integer n) {
//		Boolean res = true;
//		for (int i = 2; i <= Math.sqrt(n); i++) {
//			if (n % i == 0) {
//				res = false;
//				break;
//			}
//		}
//		return res;
//	}

	private static List<Integer> ejercicio2(Integer n) {
		return null;
	}

}
