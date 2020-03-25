package practica6;

public class TreeUtils {

	// Devuelve un String con un formato para mostrar un Tree por consola.
	public static <E> String toPretty(Tree<E> e) {
		return toPretty(e, "") ;
	}

	private static <E> String toPretty(Tree<E> e, String tab) {
		String s = "";
		if (e.isLeaf()) {
			s = tab + "" ;
			s = s + "+";
			if (!e.isEmpty()) {
				s = s +  e.getLabel().toString() + ")\n";
			} else {
				s = s + "()\n";
			}
		} else  {
			if (e.isRoot()) {
				s = tab + "*" +e.getLabel().toString();
			} else {
				s = tab + "+" + e.getLabel().toString();	
			}
			s = s + "\n" ;
			for(int i=0;i<e.getNumChildren();i++) {
				s = s + toPretty(e.getElement(i),tab + "   ");
			}
		}
		return s;
	}

	
}
