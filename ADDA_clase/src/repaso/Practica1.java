package repaso;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Practica1 {

	public static void main(String[] args) {

		List<Integer> l1 = new LinkedList<>();
		List<Integer> l2 = new LinkedList<>();
		Collections.addAll(l1, 1, 2, 3, 4, 5, 6);
		Collections.addAll(l2, 3, 4, 5, 6, 7, 8);

		System.out.println("Mismo incremento? " + ejercicio1(l1, l2));

		Integer n = 20;
		System.out.println("\nLista de numeros primos hasta " + n + ": " + ejercicio2(n));

		List<String> items = Arrays.asList("manzana", "manzana", "platano", "manzana", "naranja", "platano", "papaya");
		System.out.println(ejercicio3(items));

	}

	public static Boolean ejercicio1(List<Integer> l1, List<Integer> l2) {
		Boolean res = true;
		for (int i = 1; i < l1.size(); i++) {
			if ((l1.get(i) - l1.get(i - 1)) != (l2.get(i) - l2.get(i - 1))) {
				res = false;
				break;
			}
		}
		return res;
	}

	private static Boolean esPrimo2(Integer n) {
		Boolean res = true;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				res = false;
				break;
			}
		}
		return res;
	}

	public static List<Integer> ejercicio2(Integer n) {
		List<Integer> res = new LinkedList<>();
		for (int i = 3; i <= n; i++) {
			if (esPrimo2(i)) {
				res.add(i * i);
			}
		}
		return res;
	}

	public static Map<String, Integer> ejercicio3(List<String> ls) {
		Map<String, Integer> res = new LinkedHashMap<>();
		for (String s : ls) {
			if (!res.containsKey(s)) {
				res.put(s, 1);
			} else {
				res.put(s, res.get(s) + 1);
			}
		}
		return res;
	}

}
