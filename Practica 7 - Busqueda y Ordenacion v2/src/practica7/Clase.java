package practica7;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import us.lsi.common.Tuple2;
import us.lsi.dyv.problemasdelistas.ProblemasDeListas;

public class Clase {
	public static void main(String[] args) {

		List<Integer> ls = new LinkedList<Integer>();
		Collections.addAll(ls, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);

		System.out.println(ls);
		Comparator<Integer> cmp = Comparator.naturalOrder();

		System.out.println(getListaEdades(ls, 8, 10));

		// System.out.println(busquedaDesordenada(ls, 2));
		// ProblemasDeListas.sort(ls, cmp);
		// System.out.println(ls);
		// System.out.println(busquedaOrdenada(ls, 7, cmp));
		// System.out.println(buscaMaxMin(ls, cmp));

		/*
		 * List<Cancion> canciones = new LinkedList<Cancion>(); Cancion c1 =
		 * Cancion.create(4, 5, "Penesito"); Cancion c2 = Cancion.create(2, 7,
		 * "Penesito Remiz Samerh"); Cancion c3 = Cancion.create(4, 8,
		 * "Pensito Remix Guinter ft. DJ jEsUsiitOh_12HD"); Cancion c4 =
		 * Cancion.create(5, 8, "Penesito Remix Master 3000pls ft. DJ aMar$it0");
		 * Cancion c5 = Cancion.create(1, 5, "Paquito"); Cancion c6 = Cancion.create(1,
		 * 5, "El RAp de Maincra"); Cancion c7 = Cancion.create(2, 1, "Mierdi cancion");
		 * Collections.addAll(canciones, c1, c2, c3, c4, c5, c6, c7);
		 * 
		 * System.out.println(posicionPorDuracion(canciones, 1));
		 */

	}

	public static <E> Integer busquedaDesordenada(List<E> ls, E elemento) {
		return busquedaDesordenadaG(ls, elemento, 0);
	}

	public static <E> Integer busquedaDesordenadaG(List<E> ls, E elemento, Integer i) {
		Integer r;
		if (i == ls.size()) {
			r = -1;
		} else if (ls.get(i).equals(elemento)) {
			r = i;
		} else {
			r = busquedaDesordenadaG(ls, elemento, i + 1);
		}
		return r;
	}

	public static <E> Integer busquedaOrdenada(List<E> ls, E elemento, Comparator<E> cmp) {
		return busquedaOrdenadaG(ls, elemento, cmp, 0, ls.size());
	}

	private static <E> Integer busquedaOrdenadaG(List<E> ls, E elemento, Comparator<E> cmp, Integer i, Integer j) {
		Integer r;
		if (j - i > 1) {
			Integer k = (i + j) / 2;
			E centro = ls.get(k);
			if (cmp.compare(centro, elemento) > 0) {
				r = busquedaOrdenadaG(ls, elemento, cmp, i, k);
			} else if (cmp.compare(centro, elemento) < 0) {
				r = busquedaOrdenadaG(ls, elemento, cmp, k, j);
			} else {
				r = k;
			}
		} else {
			r = -1;
		}
		return r;
	}

	public static List<Cancion> posicionPorDuracion(List<Cancion> ls, Integer k) {
		System.out.println(ls);
		List<Cancion> canciones = new LinkedList<Cancion>();
		Comparator<Cancion> cmp = Comparator.comparing(Cancion::getDuracion).thenComparing(Cancion::getNombre);
		ProblemasDeListas.sort(ls, cmp);
		System.out.println(ls);
		Cancion c = ProblemasDeListas.getKesimo(ls, k, cmp);
		System.out.println(ls);
		for (int i = ls.indexOf(c); i < ls.size(); i++) {
			System.out.println(i);
			if (ls.get(i).getDuracion().equals(c.getDuracion())) {
				System.out.println("He entrado");
				canciones.add(ls.get(i));
			} else {
				break;
			}
		}
		return canciones;
	}

	public static Integer getKEsimaCancionXDuracion(int k, List<Integer> ls) {
		return ProblemasDeListas.getKesimo(ls, k);
	}

	public static <E> Tuple2<E, E> buscaMaxMin(List<E> ls, Comparator<E> cmp) {
		return buscaMaxMinG(ls, 0, ls.size() - 1, cmp);
	}

	private static <E> Tuple2<E, E> buscaMaxMinG(List<E> ls, int i, int j, Comparator<E> cmp) {
		E max;
		E min;
		Tuple2<E, E> res;
		if (j - i == 1) {
			max = ls.get(i);
			min = ls.get(i);
			res = Tuple2.create(max, min);
		} else if (j - i == 2) {
			if (cmp.compare(ls.get(j), ls.get(i)) > 0) {
				max = ls.get(j);
				min = ls.get(i);
				res = Tuple2.create(max, min);
			} else {
				min = ls.get(j);
				max = ls.get(i);
				res = Tuple2.create(max, min);
			}
		} else {
			int s = (i + j) / 2;
			if (cmp.compare(buscaMaxMinG(ls, i, s, cmp).v1, buscaMaxMinG(ls, s, j, cmp).v1) > 0) {
				max = buscaMaxMinG(ls, i, s, cmp).v1;
			} else {
				max = buscaMaxMinG(ls, s, j, cmp).v1;
			}
			if (cmp.compare(buscaMaxMinG(ls, i, s, cmp).v2, buscaMaxMinG(ls, s, j, cmp).v2) > 0) {
				min = buscaMaxMinG(ls, s, j, cmp).v2;
			} else {
				min = buscaMaxMinG(ls, i, s, cmp).v2;
			}
			res = Tuple2.create(max, min);
		}
		return res;
	}

	// Para entregar: Dada una lista de edades de estudiantes sin ordenar, devolver
	// las edades que se encuentra en el intervalo [a,b).
	// Las edades devuletas no tienen pq estar ordenadas. la lista de estudiantes no
	// se puede ordenar.
	// Aplicar dos veces la bandera holandesa, una para cada extremo.

	public static List<Integer> getListaEdades(List<Integer> edades, Integer a, Integer b) {
		Comparator<Integer> cmp = Comparator.naturalOrder();
		Tuple2<Integer, Integer> t = ProblemasDeListas.reordenaMedianteBanderaHolandesa(edades, a, 0, edades.size(),
				cmp);
		Tuple2<Integer, Integer> s = ProblemasDeListas.reordenaMedianteBanderaHolandesa(edades, b, t.v1, edades.size(),
				cmp);
		return new LinkedList<Integer>(edades.subList(t.v1, s.v1));
	}

	private static <E> int[] banderaHolandesa(List<E> ls, E p, Comparator<E> cmp, int aux, int cux) {
		int a = aux;
		int b = a;
		int c = cux;
		while (c - b > 0) {
			if (cmp.compare(p, ls.get(b)) > 0) {
				// El numero en B es más pequeño que el pivote.
				intercambia(ls, b, a);
				a++;
				b++;
			} else if (cmp.compare(p, ls.get(b)) < 0) {
				// El numero en B es más grande que el pivote.
				intercambia(ls, b, c - 1);
				c--;
			} else {
				// El número en B es igual al pivote.
				b++;
			}
		}
		int[] res = { a, b };
		return res;
	}

	private static <E> void intercambia(List<E> ls, Integer p, Integer q) {
		E aux = ls.get(q);
		ls.add(q, ls.get(p));
		ls.remove(q + 1);
		ls.add(p, aux);
		ls.remove(p + 1);

	}

}
