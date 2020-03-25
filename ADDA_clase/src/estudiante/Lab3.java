package estudiante;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import estudiante.Estudiante.genero;

public class Lab3 {
	static Integer contSin = 0;
	static Integer contCon = 0;

	public static void main(String[] args) {

		/*
		 * Estudiante e1 = new Estudiante("Pedro", "Martinez", "12345T", 19,
		 * genero.Masculino); Estudiante e2 = new Estudiante("Laura", "Martinez",
		 * "54321G", 31, genero.Femenino); Estudiante e3 = new Estudiante("Maria",
		 * "Martinez", "76421R", 31, genero.Femenino); Estudiante e4 = new
		 * Estudiante("Dolores", "Martinez", "89352P", 29, genero.Femenino); Estudiante
		 * e5 = new Estudiante("Gilberto", "Martinez", "95312O", 25, genero.Masculino);
		 * Estudiante e6 = new Estudiante("Carmen", "Martinez", "67296R", 25,
		 * genero.Femenino); Estudiante e7 = new Estudiante("Pepa", "Martinez",
		 * "12638I", 53, genero.Femenino); List<Estudiante> estudiantes = new
		 * LinkedList<Estudiante>(); Collections.addAll(estudiantes, e1, e2, e3, e4, e5,
		 * e6, e7);
		 * 
		 * System.out.println("Iterativo: " + estudiantesEdadPrimoF7(estudiantes));
		 * System.out.println("Recursivo: " + estudianteEdadPrimoR(estudiantes));
		 */
		System.out.println(funcionRecursivoNF(15));
		System.out.println(contSin);
		System.out.println(funcionRecursivoNFMem(15));
		System.out.println(contCon);
		System.out.println(funcionIterativo(15));
		// System.out.println(numeroCombinatorioRMem(40, 3));
		System.out.println(P(15));
		System.out.println(PIt(15));
	}

	public static Boolean todosIncrementosIguales(List<Integer> l1, List<Integer> l2) {
		return IntStream.range(1, l1.size()).allMatch(

				x -> ((l1.get(x) - l1.get(x - 1) == 0) && ((l2.get(x) - l2.get(x - 1)) == 0) ||

						((l1.get(x) - l1.get(x - 1)) * (l2.get(x) - l2.get(x - 1)) > 0)));
	}

	// Generar la lista de los cuadrados de los números primos hata un número n
	// dado.

	public static List<Integer> cudradosPrimos(Integer n) {
		return IntStream.rangeClosed(2, n).filter(x -> esPrimo(x)).mapToObj(x -> new Integer(x * x))
				.collect(Collectors.toList());

	}

	public static Boolean esPrimo(Integer x) {

		return IntStream.rangeClosed(2, (int) Math.sqrt(x)).allMatch(n -> x % n != 0);
	}

	public static Integer invierteNumero(Integer num) {

		Integer solucion = 0;
		Integer resto = 0;
		while (num > 0) {
			resto = num % 10;
			solucion = solucion * 10 + resto;
			num = num / 10;
		}
		return solucion;

	}

	public static Integer invierteNumeroRNF(Integer num) {
		if (num < 10) {
			return num;
		} else {
			Integer resto = num % 10;
			Integer cifras = (int) Math.log10(num);
			return (resto * (int) Math.pow(10, cifras) + invierteNumeroRNF(num / 10));
		}
	}

	public static Integer invierteNumeroR(Integer num) {
		Integer solucion = 0;
		return invierteNumeroRG(num, solucion);

	}

	private static Integer invierteNumeroRG(Integer num, Integer solucion) {

		if (!(num > 0)) {
			return solucion;
		} else {

			return invierteNumeroRG(num / 10, solucion * 10 + num % 10);
		}

	}

	public static Integer factorialDigitosBaseR(Integer num, Integer base) {

		return factorialDigitosBaseRG(num, base, 0, 0);

	}

	private static Integer factorialDigitosBaseRG(Integer num, Integer base, Integer res, Integer numero_conv) {

		if (!(num >= 1)) {
			return res;
		} else {
			numero_conv = num % base;
			return factorialDigitosBaseRG(num / base, base, res + calculaFact(numero_conv), num % base);
		}

	}

	public static Integer factorialDigitosBase(Integer numero, Integer base) {
		Integer res = 0;
		Integer numero_conv = 0;
		while (numero >= 1) {
			numero_conv = numero % base;
			numero = numero / base;
			res = res + calculaFact(numero_conv);
		}
		return res;
	}

	private static Integer calculaFact(Integer numero) {
		if (numero == 1 || numero == 0) {
			return 1;
		} else {
			return numero * calculaFact(numero - 1);
		}

	}

	public static Boolean esPrimo7(Integer n) {

		Integer i = 2;
		Boolean res = true;
		while (i <= ((int) Math.sqrt(n))) {
			if (n % i == 0) {
				res = false;
				break;
			}
			i = i + 1;
		}

		return res;
	}

	public static List<Integer> calculaDivisoresRF(Integer numero) {

		return calculaDivisoresRFG(numero, 1, new LinkedList<Integer>());

	}

	private static List<Integer> calculaDivisoresRFG(Integer numero, Integer i, List<Integer> divisores) {

		if (numero % i == 0 && i <= (numero / 2)) {
			divisores.add(i);
			return calculaDivisoresRFG(numero, i + 1, divisores);
		} else if (i > (numero / 2)) {
			return divisores;
		} else {
			return calculaDivisoresRFG(numero, i + 1, divisores);
		}

	}

	public static List<Integer> calculaDivisoresR(Integer numero) {
		return getDivisoresRG(numero, 1);
	}

	private static List<Integer> getDivisoresRG(Integer n, Integer i) {
		List<Integer> r;
		if (i > n / 2) {
			return new LinkedList<Integer>();
		} else {
			// Devuelve la lsita de divisores de n en el intervalo [i+1, n)
			r = getDivisoresRG(n, i + 1);
			if (n % i == 0) {
				r.add(0, i);
			}
		}
		return r;
	}

	// Dada una lista de objetos de tipo Estudiante, devolver una lista que
	// guarde los estudiantes cuya edad es un número primo y son de
	// género femenino

	/*
	 * public static List<Estudiante> estudiantesEdadPrimoF(List<Estudiante>
	 * estudiantes){
	 * 
	 * return estudiantes.stream(). filter(es -> esPrimo(es.getEdad()) &&
	 * es.getSexo().equals(Estudiante.genero.Femenino))
	 * .collect(Collectors.toList()); }
	 * 
	 * public static Map<String, Long> contarFruta(List<String> frutas){ return
	 * frutas.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));
	 * }
	 */

	public static List<Integer> estudiantesEdadPrimoF7(List<Estudiante> ls) {
		List<Integer> res = new LinkedList<Integer>();
		Integer i = 0;
		while (i < ls.size()) {
			if (esPrimo7(ls.get(i).getEdad()) && ls.get(i).getSexo().equals(genero.Femenino)) {
				res.add(ls.get(i).getEdad());
			}
			i = i + 1;
		}
		return res;
	}

	public static List<Integer> estudianteEdadPrimoR(List<Estudiante> ls) {
		List<Integer> res = new LinkedList<Integer>();
		return estudiantesEdadPrimoRG(ls, 0, res);

	}

	private static List<Integer> estudiantesEdadPrimoRG(List<Estudiante> ls, Integer i, List<Integer> res) {

		if (!(i < ls.size())) {
			return res;
		} else if (esPrimo7(ls.get(i).getEdad()) && ls.get(i).getSexo().equals(genero.Femenino)) {
			res.add(ls.get(i).getEdad());
			return estudiantesEdadPrimoRG(ls, i + 1, res);

		} else {
			return estudiantesEdadPrimoRG(ls, i + 1, res);
		}
	}

	// Calcular el producto de los digitos impares de un numero entero con un
	// programa rec. no final y transformar el anterior a final.

	public static Integer productoCifras(Integer n) {

		if (n < 10 && n % 2 == 1) {
			return n;
		} else {
			Integer resto = n % 10;
			Integer cociente = n / 10;
			if (resto % 2 == 1) {
				return resto * productoCifras(cociente);
			} else {
				return productoCifras(cociente);
			}

		}
	}

	public static Integer productoCifrasRF(Integer n) {
		Integer r = productoCifrasRFG(n, 1);
		return r;

	}

	public static Integer productoCifrasRFG(Integer n, Integer a) {
		Integer r;
		if (n < 10) {
			if (n % 2 == 1) {
				r = a * n;
			} else {
				r = a;
			}
		} else {
			Integer resto = n % 10;
			Integer cociente = n / 10;
			if (resto % 2 == 1) {

				r = productoCifrasRFG(cociente, a * resto);
			} else {
				r = productoCifrasRFG(cociente, a);
			}
		}
		return r;
	}

	public static Integer funcionIterativo(Integer n) {
		// INV(i,a,b,c) -> a == f(i) && b == f(i+1) && c = f(i+2)
		Integer i = 3;
		Integer A = 2; // a == f(i) siendo i = 0, entonces a == f(0) = 2
		Integer B = 1; // b == f(i+1) siendo i = 0, entonces b == f(1) = 1
		Integer C = 1; // c == f(i+2) siendo i = 0, entonces c == f(2) = 1
		Integer A_aux;
		Integer B_aux;
		Integer C_aux;
		while (i <= n) {
			C_aux = 4 * C + B + A;
			B_aux = C;
			A_aux = B;

			A = A_aux;
			B = B_aux;
			C = C_aux;
			i = i + 1;
		}
		return C;
	}

	public static Integer funcionRecursivoF(Integer n) {
		return funcionRecursivoFG(n, 3, 2, 1, 1);
	}

	public static Integer funcionRecursivoFG(Integer n, Integer i, Integer A, Integer B, Integer C) {

		Integer A_aux;
		Integer B_aux;
		Integer C_aux;

		if (!(i <= n)) {
			// Si es caso base, devuelvo la solución.
			return C;
		} else {
			// Si no es caso base, llamo otra vez a la función.
			// La solución parcial
			C_aux = 4 * C + B + A;
			B_aux = C;
			A_aux = B;
			A = A_aux;
			B = B_aux;
			C = C_aux;
			return funcionRecursivoFG(n, i + 1, A, B, C);

		}
	}

	public static Integer PIt(Integer n) {
		Integer i = 0;
		Integer a = 2; // a = p(i) i = 0 -> a == p(0) = 2;
		Integer b = 2; // b = p(i+1) i = 0 -> b == p(1) = 2;
		Integer c = 1; // c = P(i+2) i = 0 -> c == p(2) = 1;
		Integer d = 1; // d = P(i+3) i = 0 -> d == p(3) = 1;
		Integer a_aux;
		Integer b_aux;
		Integer c_aux;
		Integer d_aux;
		while (i < n) {
			// P(n) = 3*P(n-2) -P(n-3) + 2*P(n-4)

			d_aux = d;
			c_aux = c;
			b_aux = b;
			a_aux = a;

			a = b_aux;
			b = c_aux;
			c = d_aux;
			d = 3 * c_aux - b_aux + 2 * a_aux;

			i = i + 1;
		}
		return a;

	}

	public static Integer P(Integer n) {
		Integer r;
		if (n == 0 || n == 1) {
			r = 2;
		} else if (n == 2 || n == 3) {
			r = 1;
		} else {
			r = 3 * P(n - 2) - P(n - 3) + 2 * P(n - 4);
		}
		return r;
	}

	public static Integer funcionRecursivoNF(Integer n) {
		contSin++;
		if (n == 0) {
			return 2;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 1;
		} else {
			return 4 * funcionRecursivoNF(n - 1) + funcionRecursivoNF(n - 2) + funcionRecursivoNF(n - 3);
		}
	}

	public static Integer funcionRecursivoNFMem(Integer n) {
		Map<Integer, Integer> memoria = new HashMap<Integer, Integer>();
		return funcionRecursivoNFMemG(n, memoria);
	}

	private static Integer funcionRecursivoNFMemG(Integer n, Map<Integer, Integer> memoria) {
		contCon++;
		if (memoria.containsKey(n)) {
			return memoria.get(n);
		} else if (n == 0) {
			memoria.put(0, 2);
			return 2;
		} else if (n == 1) {
			memoria.put(1, 1);
			return 1;
		} else if (n == 2) {
			memoria.put(2, 1);
			return 1;
		} else {
			Integer calculo = 4 * funcionRecursivoNFMemG(n - 1, memoria) + funcionRecursivoNFMemG(n - 2, memoria)
					+ funcionRecursivoNFMemG(n - 3, memoria);
			memoria.put(n, calculo);
			return calculo;
		}
	}

	public static Integer numeroCombinatorioRMem(Integer n, Integer k) {
		Map<String, Integer> memoria = new HashMap<String, Integer>();
		Integer sol = numeroCombinatorioRMemG(n, k, memoria);
		System.out.println(memoria);
		return sol;
	}

	private static Integer numeroCombinatorioRMemG(Integer n, Integer k, Map<String, Integer> memoria) {
		String num = "" + n + "//" + k;
		if (memoria.containsKey(num)) {
			return memoria.get(num);
		}
		if (k == 0 || k == n) {
			memoria.put(num, 1);
			return 1;
		} else if (k == 1 || k == n - 1) {
			memoria.put(num, n);
			return n;
		} else {
			Integer calculo = numeroCombinatorioRMemG(n - 1, k - 1, memoria)
					+ numeroCombinatorioRMemG(n - 1, k, memoria);
			memoria.put(num, calculo);
			return calculo;
		}
	}

}
