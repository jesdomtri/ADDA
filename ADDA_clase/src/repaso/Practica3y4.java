package repaso;

public class Practica3y4 {
	public static void main(String[] args) {
		System.out.println("Invertir numero en iterativo:" + e1Iter(1024));
		System.out.println("\nInvertir numero en recursivo final:" + e1RF(1024));
		System.out.println("\nFactorial: " + factorial(4));
		System.out.println("\nSuma de los digitos de un factorial en modulo: " + e2RF(1024, 10));

	}

	public static Integer e1Iter(Integer n) {
		Integer res = 0;
		Integer num;
		while (n > 0) {
			num = n % 10;
			res = res * 10 + num;
			n = n / 10;
		}
		return res;
	}

	public static Integer e1RF(Integer n) {
		if (n < 10) {
			return n;
		} else {
			Integer num = n % 10;
			Integer cifras = (int) Math.log10(n);
			return (num * (int) Math.pow(10, cifras) + e1RF(n / 10));
		}
	}
	
	public static Integer factorial(Integer n) {
		if (n==0) {
			return 1;
		} else {
			return factorial(n-1)*n;
		}
	}
	
	public static Integer e2Iter(Integer numero, Integer base) {
		Integer res = 0;
		Integer numero_conv = 0;
		while (numero >= 1) {
			numero_conv = numero % base;
			numero = numero / base;
			res = res + factorial(numero_conv);
		}
		return res;
	}
	
	public static Integer e2RF(Integer n, Integer mod) {
		if (n==0) {
			return 0;
		} else {
			return e2RF(n/mod, mod) + factorial(n%mod);
		}
	}

}
