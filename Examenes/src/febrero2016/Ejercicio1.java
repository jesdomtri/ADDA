package febrero2016;

public class Ejercicio1 {

	public static void main(String[] args) {

	}

	private static Integer min(Integer integer, Integer integer2) {
		return 0;
	}

	public static Integer smingNF(Integer a, Integer b, Integer[] v) {
		Integer res;
		if (a < b) {
			res = smingNF(a + 1, b - 2, v) + min(v[a], v[b - 1]);
		} else {
			res = 0;
		}
		return res;
	}

	public static Integer smingF(Integer a, Integer b, Integer[] v) {
		return smingFG(a, b, v, 0);
	}

	private static Integer smingFG(Integer a, Integer b, Integer[] v, Integer i) {
		if (a < b) {
			i = smingFG(a + 1, b - 2, v, i + min(v[a], v[b - 1]));
		}
		return i;
	}

	public static Integer smingIter(Integer a, Integer b, Integer[] v) {
		Integer res = 0;
		while (a < b) {
			res = res + min(v[a], v[b - 1]);
			a = a + 1;
			b = b - 2;
		}
		return res;
	}

}
