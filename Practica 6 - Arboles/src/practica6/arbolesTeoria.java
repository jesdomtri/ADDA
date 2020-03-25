package practica6;
import java.util.LinkedList;
import java.util.List;

public class arbolesTeoria {

	public static void main(String[] args) {
		// Tree<Integer> prueba = generaArbol(10);
		// System.out.println(TreeUtils.toPretty(prueba));
		// System.out.println(numEtiquetasPares(prueba));
		// List<Integer> ls = new LinkedList<Integer>();
		// Collections.addAll(ls, 1, 2, 3, 4, 5, 6, 7);
		// System.out.println(contieneEtiqueta(prueba, 8));
		// Tree<Integer> tr= Tree.create(1, Tree.create(2, Tree.create(3)),
		// Tree.create(4, Tree.create(5))
		// );
		// preorden(tr);
		Tree<String> tr = Tree.create("A", Tree.create("B", Tree.create("E"), Tree.create("F"), Tree.create("G")),
				Tree.create("C"), Tree.create("D", Tree.create("I"), Tree.create("J")));
		System.out.println(TreeUtils.toPretty(tr));
		// Tree<String> tr_ax = clonaArbol(tr);
		// System.out.println(TreeUtils.toPretty(tr_ax));
		// System.out.println("La altura es: " + alturaArbol(tr));
		// System.out.println(contieneEtiqueta(Tree.create(1,Tree.create(2)),
		// 2));
		System.out.println(TreeUtils.toPretty(cambiaEtiquetas(tr, "A", "Xuper")));
	}

	// Clonador de arbol.

	public static <T> Tree<T> clonaArbol(Tree<T> arbol) {
		Tree<T> aux = Tree.create();

		if (arbol.isEmpty()) {
			aux = Tree.create();
		} else {
			aux = Tree.create(arbol.getLabel());
			if (!arbol.isLeaf()) {
				for (Integer i = 0; i < arbol.getNumChildren(); i++) {
					aux.add(clonaArbol(arbol.getElement(i)));
				}
			}
		}
		return aux;
	}

	// Copiar un arbol cambiando las etiquetas con valor x por valor y

	public static <T> Tree<T> cambiaEtiquetas(Tree<T> arbol, T x, T y) {
		Tree<T> r = Tree.create();
		if (!arbol.isEmpty()) {

			T etiqueta = arbol.getLabel();
			if (arbol.getLabel().equals(x)) {
				etiqueta = y;
			}
			r = Tree.create(etiqueta);
			if (!arbol.isLeaf()) {
				for (Integer i = 0; i < arbol.getNumChildren(); i++) {
					r.add(cambiaEtiquetas(arbol.getElement(i), x, y));
				}
			}

		}

		return r;

	}

	// Altura de un arbol -> número de aristas que tiene el camino que va desde
	// la raíz hasta la hoja más profunda.

	public static <T> Integer alturaArbol(Tree<T> arbol) {
		Integer res = 0;
		if (arbol.isLeaf() || arbol.isEmpty()) {
			return res;
		} else {
			for (int i = 0; i < arbol.getNumChildren(); i++) {
				res = Math.max(res, alturaArbol(arbol.getElement(i)));
			}
			res = res + 1;
		}
		return res;
	}

	// Busca subarbol con etiqueta dada.

	// public static <T> Tree<T> subarbol(Tree<T> arbol, T label){
	//
	// if(arbol.isEmpty()){
	// return Tree.create();
	// }else if (!arbol.isEmpty() && arbol.getLabel().equals(label)){
	// return arbol;
	// }else{
	// Tree<T> aux = Tree.create();
	// for(int i=0; i<arbol.getNumChildren(); i++){
	// aux = subarbol(arbol.getElement(i), label);
	// if(!aux.isEmpty()){
	// return aux;
	//
	// }
	//
	// }
	//
	//
	// }
	//
	//
	//
	// }

	// Metodo para contar el numero de etiquetas.
	public static Tree<Integer> generaArbol(Integer MAX) {
		List<Tree<Integer>> elements = new LinkedList<Tree<Integer>>();
		int cont = 0;
		while (cont < MAX) {
			Tree<Integer> aux = Tree.create(cont);
			elements.add(aux);
			cont++;
		}
		return Tree.create(0, elements);

	}

	public static <E> Integer size(Tree<E> t) {
		Integer r = 0;
		if (!t.isEmpty()) {
			r = r + 1;
		}
		for (int i = 0; i < t.getNumChildren(); i++) {
			r = r + size(t.getElement(i));
		}
		return r;
	}

	// Metodo para contar el numero de etiquetas pares

	public static <E> Integer numEtiquetasPares(Tree<E> t) {
		Integer r = 0;
		if (!t.isEmpty() && (int) t.getLabel() % 2 == 0) {
			r = r + 1;
		}
		for (int i = 0; i < t.getNumChildren(); i++) {
			r = r + numEtiquetasPares(t.getElement(i));
		}
		return r;
	}

	public static <E> boolean contieneEtiqueta(Tree<E> t, E a) {
		boolean res = false;
		if (!t.isEmpty()) {
			if (t.getLabel().equals(a)) {
				res = true;
			} else {
				for (int i = 0; i < t.getNumChildren() && res != true; i++) {
					res = contieneEtiqueta(t.getElement(i), a);
				}
			}
		}
		return res;
	}

	public static <E> void preorden(Tree<E> t) {
		if (!t.isEmpty()) {
			System.out.println(t.getLabel());
		}
		if (t.getNumChildren() == 2) {
			preorden(t.getElement(0));
			preorden(t.getElement(1));
		}
	}
}
