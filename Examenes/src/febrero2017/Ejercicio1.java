package febrero2017;

public class Ejercicio1 {

	public static void main(String[] args) {
		Integer n = 1024;
		System.out.println(sfactorialA(n));
		System.out.println(sfactorialC(n));
		System.out.println(sfactorialE(n));
	}

	public static Integer sfactorialA(Integer n) {
		if (n < 10) {
			return factorial(n);
		} else {
			return sfactorialA(n / 10) + factorial(n % 10);
		}
	}

	public static Integer sfactorialC(Integer n) {
		return sfactorialCG(n, 0);
	}

	private static Integer sfactorialCG(Integer n, Integer i) {
		if (n < 10) {
			return i + factorial(n);
		} else {
			return sfactorialCG(n / 10, i + factorial(n % 10));
		}
	}

	public static Integer sfactorialE(Integer n) {
		Integer i = 0;
		Integer res = 0;
		while (n > 0) {
			res = res + factorial(n % 10);
			n = n / 10;
			i++;
		}
		return res;
	}

	public static Integer factorial(Integer n) {
		if (n == 0) {
			return 1;
		} else {
			return factorial(n - 1) * n;
		}
	}
}
