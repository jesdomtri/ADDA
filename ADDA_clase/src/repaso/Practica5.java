package repaso;

import java.util.HashMap;
import java.util.Map;

public class Practica5 {

	public static void main(String[] args) {
		Integer n = 4;
		System.out.println("------------------------- EJERCICIO 1 -------------------------");
		System.out.println(ej1SinMem(n));
		System.out.println(ej1ConMem(n));
		System.out.println(ej1Iter(n));
		System.out.println(ej1RF(n));
		System.out.println("\n------------------------- EJERCICIO 2 -------------------------");
		System.out.println(ej2RConMem(5, 3));
	}

	public static Integer ej1SinMem(Integer n) {
		Integer res = 0;
		if (n == 0) {
			res = 2;
		} else if (n == 1) {
			res = 1;
		} else if (n == 2) {
			res = 1;
		} else {
			res = 4 * ej1SinMem(n - 1) + ej1SinMem(n - 2) + ej1SinMem(n - 3);
		}
		return res;
	}

	public static Integer ej1ConMem(Integer n) {
		Map<Integer, Integer> m = new HashMap<>();
		Integer res = 0;
		if (m.containsKey(n)) {
			res = m.get(n);
		} else if (n == 0) {
			m.put(0, 2);
			res = 2;
		} else if (n == 1) {
			m.put(1, 1);
			res = 1;
		} else if (n == 2) {
			m.put(2, 1);
			res = 1;
		} else {
			res = 4 * ej1ConMem(n - 1) + ej1ConMem(n - 2) + ej1ConMem(n - 3);
			m.put(n, res);
		}
		return res;
	}

	public static Integer ej1Iter(Integer n) {
		Integer res = 0;
		Integer i = 3;
		if (n == 0) {
			res = 2;
		} else if (n == 1) {
			res = 1;
		} else if (n == 2) {
			res = 1;
		} else {
			Integer aux1 = 2;
			Integer aux2 = 1;
			Integer aux3 = 1;
			while (i <= n) {
				res = 4 * aux3 + aux2 + aux1;
				aux1 = aux2;
				aux2 = aux3;
				aux3 = res;
				i++;
			}
		}
		return res;
	}

	public static Integer ej1RF(Integer n) {
		return ej1RFG(n, 3, 1, 1, 2);
	}

	private static Integer ej1RFG(Integer n, Integer i, Integer a, Integer b, Integer c) {
		Integer res = 0;
		if (!(i <= n)) {
			res = a;
		} else {
			res = ej1RFG(n, i + 1, 4 * a + b + c, a, b);
		}
		return res;
	}
	
	
//	EJERCICIO 2
	
	public static Integer ej2RConMem(Integer n, Integer k) {
		Map<String, Integer> m = new HashMap<>();
		Integer res=0;
		if (k==0 || k==n) {
			res=1;
			m.put( k + " ," + n, res);
		}else if (k==1 || k==n-1) {
			res=n;
			m.put( k + " ," + n, res);
		}else {
			res = ej2RConMem(n-1, k-1) + ej2RConMem(n-1, k);
			m.put( k + " ," + n, res);
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
