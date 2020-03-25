package septiembre207;

public class Ejercicio1 {

	public static void main(String[] args) {
		int m = 6;
		int n = 5;
		System.out.println("\nEl primer apartado sale: " + func(m, n));
		System.out.println("\nEl segundo apartado sale: " + funcF(m, n));
		System.out.println("\nEl tercer apartado sale: " + funcIter(m, n));
	}

	public static int func(int m, int n) {
		int[] aux = { n, 1, 2, 3, 4, 5, m, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int res = 0;
		if (m == 0) {
			res = aux[m];
		} else {
			if (m > 0 && n == 0) {
				res = func(m - 1, aux[m]);
			} else {
				res = func(m - 1, aux[m]) + aux[m];
			}
		}
		return res;
	}

	public static int funcF(int m, int n) {
		return funcFG(m, n, 0);
	}

	private static int funcFG(int m, int n, int acum) {
		int[] aux = { n, 1, 2, 3, 4, 5, m, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int res = 0;
		if (m == 0) {
			res = acum + aux[m];
		} else {
			if (m > 0 && n == 0) {
				res = funcFG(m - 1, aux[m], acum);
			} else {
				res = funcFG(m - 1, aux[m], acum + aux[m]);
			}
		}
		return res;
	}

	public static int funcIter(int m, int n) {
		int[] aux = { n, 1, 2, 3, 4, 5, m, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int res = 0;
		while (m > 0) {
			if (n > 0) {
				res = res + aux[m];
			}
			n = aux[m];
			m = m - 1;
		}
		return res + aux[m];
	}

}
