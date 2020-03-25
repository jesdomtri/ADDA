package clase;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Clase {

	public static void main(String[] args) {
	
		System.out.println("Fib raro: " + fibRaroI(4));
	}

	private static Double sumaCuadrado(List<Double> lista) {

		return lista.stream().mapToDouble(x -> x * x).sum();

	}

	private static Double sumaCuadrado2(List<Double> lista) {
		Double res = 0.0;
		for (Double x : lista) {
			res = res + x * x;
		}
		return res;
	}

	private static Double sumaCuadrado3(List<Double> lista) {

		Integer contador = 0;
		Double res = 0.0;

		while (contador != lista.size()) {
			res = res + lista.get(contador) * lista.get(contador);
			contador++;
		}
		return res;

	}

	// Dada una lista de enteros, buscar el primer elemento que sea mayor que el
	// umbral

	private static Integer buscarMayorUmbral(List<Integer> lista, Integer umbral) {

		return lista.stream().filter(x -> x > umbral).findFirst().orElse(null);
	}

	private static Integer buscarMayorUmbra2l(List<Integer> lista, Integer umbral) {
		Integer r = 0;
		for (Integer num : lista) {
			if (num > umbral) {
				r = num;
				break;
			}
		}
		return r;

	}

	private static Integer buscarMayorUmbral3(List<Integer> lista, Integer umbral) {
		Integer r = lista.get(0);
		Integer cont = 0;
		while (cont < lista.size() && r <= umbral) {
			r = lista.get(cont);
			cont++;
		}
		return r;
	}

	private static Boolean esPrimo(int inicio, Integer n) {

		int end = (int) Math.sqrt(n);

		boolean aux = IntStream.rangeClosed(inicio, end).anyMatch(x -> n % x == 0);

		return !aux;
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

	// Dada una lista de enteros comprobar si existe alguno que sea primo e
	// impar.

	private static Boolean esPrimoImpar(List<Integer> enteros) {
		return enteros.stream().anyMatch(x -> esPrimo(3, x));
	}

	// Dado un entero buscar el siguiente numero primo

	private static Integer siguientePrimo(Integer n) {
		Integer inicio = (n % 2 == 0 ? n + 1 : n + 2);
		return Stream.iterate(inicio, e -> e + 2).filter(e -> esPrimo(3, e)).findFirst().orElse(0);
	}

	// NO FINAL
	private static Integer calculaFactorial(Integer fact) {
		if (fact.equals(0)) {
			return 1;
		} else {
			return fact * calculaFactorial(fact - 1);
		}

	}

	// FINAL
	private static Integer calculaFactorial2(Integer n) {
		Integer r = 0;
		Integer a = 1;
		r = ffinalg(n, a);

		return r;

	}

	private static Integer ffinalg(Integer n, Integer a) {
		if (n.equals(0)) {
			return a;
		} else {
			return ffinalg(n - 1, a * n);
		}

	}

	private static Integer calculaFactorialIterativo(Integer n) {
		Integer i = 0;
		Integer a = 1;

		while (i < n) {
			i = i + 1;
			a = a * i;
		}
		return a;

	}

	public static int binarySearch(List<Integer> ls, Integer p, Comparator<Integer> c) {
		Integer r = -1;
		Integer i = 0;
		Integer j = ls.size();

		while (j - i > 1) {
			Integer k = (i + j) / 2;
			Integer centro = ls.get(k);

			if (c.compare(p, centro) == 0) {
				r = k;
				break;
			} else if (c.compare(p, centro) < 0) {
				j = k;
			} else {
				i = k;
			}

		}
		return r;

	}
	
	
	
	//Método de ordenación.
	private static int[] dutchNationalFlag(List<Integer> ls, Integer p) {
		Integer n = ls.size();
		Integer a = 0;
		Integer b = 0;
		Integer c = n;

		while (c - b > 0) {
			if (ls.get(b).compareTo(p) < 0) {
				intercambia(ls, b, a);
				a++;
				b++;
			} else if (ls.get(b).compareTo(p) == 0) {
				b++;
			} else {
				// ls.get(b) es mayor que el pivote
				intercambia(ls, b, c - 1);
				c--;
			}

		}
		int[] res = { a, b };
		return res;
	}

	public static void intercambia(List<Integer> ls, Integer q, Integer r) {
		Integer aux = ls.get(q);
		ls.add(q, ls.get(r));
		ls.remove(q + 1);

		ls.add(r, aux);
		ls.remove(r + 1);
	}

	// Dada una lista de enteros sumar los valores de aquellos que sean pares.

	public static Long sumaCuadradosPares(List<Integer> ls) {

		return ls.stream().filter(x -> x % 2 == 0).mapToLong(x -> x * x).sum();

	}

	public static Long sumaCuadradosPares2(List<Integer> ls) {

		Integer cont = 0; 
		Long suma = 0L; 
		while (cont < ls.size()) {

			if (ls.get(cont) % 2 == 0) {
				suma = suma + (ls.get(cont) * ls.get(cont));
			}
			cont = cont + 1;
		}
		return suma;

	}

	public static Integer sumaElementosRecursivo2(List<Integer> ls) {
		Integer indice = 0;
		Integer suma = 0;
		suma = sumag(ls, indice, suma);
		return suma;
	}

	public static Integer sumag(List<Integer> lista, Integer indice, Integer suma) {
		if (indice.equals(lista.size())) {
			return suma + 0;
		} else {
			return sumag(lista, indice + 1, suma + lista.get(indice));
		}
	}

	public static Integer sumaElementosListaRecursivo(List<Integer> ls, Integer pos) {

		if (pos.equals(ls.size())) {
			return 0;
		} else {
			return ls.get(pos) + sumaElementosListaRecursivo(ls, pos + 1);
		}

	}

	// FINAL - cuando llegamos a la ultima recursion tenemos el mcd
	public static Integer mcdRecursivo(int a, int b) {
		if (a % b != 0) {
			return mcdRecursivo(b, a % b);
		} else {
			return b;
		}

	}

	public static Integer mcdIterativo(int a, int b) {
		int aux, aux2 = 0;
		while (a % b != 0) {
			aux = a;
			aux2 = b;
			a = b;
			b = aux % aux2;
		}
		return b;
	}

	// RECURSIVIDAD MULTIPLE - FIBONACCI
	public static Integer fib(Integer n){
		Map<Integer, Integer> mem = new HashMap<Integer, Integer>();
		Integer res = fibg(mem,n);
		return res;
	}
	public static Integer fibg(Map<Integer, Integer> mem,Integer n) {
		
		if(mem.containsKey(n)){
		
			return mem.get(n);
		}else if (n <= 1) {
		
			mem.put(1, 1);
			return 1;
		} else {
			//Hay dos llamadas al metodo recursivo
		
			Integer y1 = fibg(mem, n - 1);
			Integer y2 = fibg(mem, n - 2);
			Integer r = y1+y2;
			mem.put(n, r);
			return (r);
		}

	}
	
	//Recursivo final
	public static Integer fibRecursivoF(Integer n){
		Integer i = 0;
		Integer a = 1;
		Integer b = 0;
		return fibRecursivog(i,a,b, n);
	}
	public static Integer fibRecursivog(Integer i, Integer a, Integer b, Integer n){
		Integer aux = a;
		if(i<n){
			return fibRecursivog(i+1,a+b, aux, n);
		}else{
			return b;
		}
	}
	
	
	public static Integer fibIterativo(Integer n){
		//Empezar desde el caso baso hacia arriba
		//Casos base: 0, 1 = 1
		Integer i = 0;
		Integer a = 1;
		Integer b = 0;
		
		while(i<n){
			i=i+1;
			int aux = a;
			a = a+b;
			b = aux;
		}
		return b;
	}
	
	public static Integer fibRaroI(Integer n){
		Integer i = 0;
		Integer a = 4; //a = fib(i+3)
		Integer b = 0; // b = fin(i+2)
		Integer c = 3; //c = fib(i+1)
		Integer d = 1; //d = fib(i)
		
		while(i<n){
		i = i+1;
		Integer aux = 2*(a) + (c)/3 -(d);
		Integer aux_b = b;
		Integer aux_c = c;
		Integer aux_a = a;
		a = aux;
		b = aux_a;
		c = aux_b;
		d= aux_c;
			
			
			
		}
		return d;
		
		
	}

}
