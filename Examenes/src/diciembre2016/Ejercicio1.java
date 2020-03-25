package diciembre2016;

public class Ejercicio1 {

	public static void main(String[] args) {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("\nRecursivo no final: " + suma2NF(a));
		System.out.println("\nRecursivo final: " + suma2F(a));
		System.out.println("\nIterativo: " + suma2Iter(a));
	}

	public static Integer suma2NF(Integer[] a) {
		return suma2NFG(a, 0, a.length * 2 - 1);
	}

	private static Integer suma2NFG(Integer[] a, Integer i, Integer j) {
		if (j - i != 1) {
			Integer m = (i + j) / 2;
			return suma2NFG(a, i, m) + a[m];
		} else {
			return a[i];
		}
	}

	public static Integer suma2F(Integer[] a) {
		return suma2FG(a, 0, a.length * 2 - 1, 0);
	}

	private static Integer suma2FG(Integer[] a, Integer i, Integer j, Integer acum) {
		if (j - i != 1) {
			Integer m = (i + j) / 2;
			return suma2FG(a, i, m, acum + a[m]);
		} else {
			return acum + a[i];
		}
	}

	public static Integer suma2Iter(Integer[] a) {
		Integer i = 0;
		Integer j = a.length * 2 - 1;
		Integer res = 0;
		while (j - i != 1) {
			Integer m = (i + j) / 2;
			res = res + a[m];
			j = m;
		}
		return res + a[i];
	}

}
