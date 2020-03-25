package practica6;

public class Repaso {

	public static void main(String[] args) {
		Tree<String> arbol = Tree.create("A",
				(Tree.create("B", (Tree.create("E")), (Tree.create("F")), (Tree.create("G")))), (Tree.create("C")),
				(Tree.create("D", (Tree.create("I")), (Tree.create("J")))));

		Tree<String> arbol2 = Tree.create("A",
				(Tree.create("B", (Tree.create("E")), (Tree.create("F")), (Tree.create("G")))), (Tree.create("C")),
				(Tree.create("D", (Tree.create("I")), (Tree.create("J", (Tree.create("Z",
						(Tree.create("W", (Tree.create("Q", (Tree.create("R", (Tree.create("T")))))))))))))));

		System.out.println("\nEjercicio 1: \n" + TreeUtils.toPretty(arbol));
		System.out.println("\nSegundo arbol para probar cosas: \n" + TreeUtils.toPretty(arbol2));
		System.out.println("\nEjercicio 2: " + numEtiquetas(arbol));
		System.out.println(
				"\nEjercicio 3: \n" + TreeUtils.toPretty(clonar(arbol)) + "\n" + TreeUtils.toPretty(clonar(arbol2)));
		System.out.println("\nEjercicio 4: Primer arbol: " + altura(arbol) + " Segundo arbol: " + altura(arbol2));
		System.out.println("\nEjercicio5: \n" + TreeUtils.toPretty(subarbol(arbol, "A")));

	}

	public static <E> Integer numEtiquetas(Tree<E> arbol) {
		Integer res;
		if (arbol == null || arbol.isEmpty()) {
			res = 0;
		} else if (arbol.getNumChildren() == 0) {
			res = 1;
		} else {
			res = 1;
			for (int i = 0; i < arbol.getNumChildren(); i++) {
				res = res + numEtiquetas(arbol.getElement(i));
			}
		}

		return res;
	}

	public static <E> Tree<E> clonar(Tree<E> arbol) {
		Tree<E> res = null;
		if (arbol == null || arbol.isEmpty()) {
			res = Tree.create();
		} else if (arbol.isLeaf()) {
			res = Tree.create(arbol.getLabel());
		} else {
			res = Tree.create(arbol.getLabel());
			for (int i = 0; i < arbol.getNumChildren(); i++) {
				res.add(arbol.getElement(i));
			}
		}
		return res;
	}

	public static <E> Integer altura(Tree<E> arbol) {
		Integer res = 0;
		if (arbol == null || arbol.isEmpty()) {
			res = 0;
		} else if (arbol.isLeaf()) {
			res = 1;
		} else {
			res = 1;
			for (int i = 0; i < arbol.getNumChildren(); i++) {
				res = res + arbol.getElement(i).getHeight();
			}
		}
		return res;
	}

	public static <E> Tree<E> subarbol(Tree<E> arbol, E etiqueta) {
		Tree<E> res = null;
		if (arbol == null || arbol.isEmpty()) {
			res = Tree.create();
		} else if (arbol.isLeaf()) {
			res = Tree.create(arbol.getLabel());
		} else {
			for (int i = 0; i < arbol.getNumChildren(); i++) {
				if (arbol.getElement(i).getLabel().equals(etiqueta)) {
					res = Tree.create(arbol.getElement(i));
					for (int j = 0; j < arbol.getElement(i).getNumChildren(); j++) {
						if (!arbol.getElement(i).elements.contains(arbol.getElement(i).getElement(j))) {
							res.add(arbol.getElement(i).getElement(j));
						}
					}
				}
			}
		}
		return res;
	}

}
