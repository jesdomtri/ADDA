package febrero2017;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ejercicio3 {

	public static void main(String[] args) {
		Double tamanyo = 0.5;
		Double peso = 7.0;
		Moneda a = Moneda.create(5.0, tamanyo);
		Moneda b = Moneda.create(peso, tamanyo);
		Moneda c = Moneda.create(peso, tamanyo);
		Moneda d = Moneda.create(peso, tamanyo);
		Moneda e = Moneda.create(peso, tamanyo);
		Moneda f = Moneda.create(peso, tamanyo);

		List<Moneda> listaMonedas = new LinkedList<>();
		listaMonedas.add(b);
		listaMonedas.add(c);
		listaMonedas.add(d);
		listaMonedas.add(a);
		listaMonedas.add(e);
		listaMonedas.add(f);


		System.out.println(listaMonedas);

		System.out.println(problemaMonedas(listaMonedas));
	}

	public static int pesada(List<Moneda> listaMonedas, int i_izq, int j_izq, int i_der, int j_der) {
		List<Moneda> izq = new ArrayList<>(listaMonedas.subList(i_izq, j_izq));
		List<Moneda> der = new ArrayList<>(listaMonedas.subList(i_der, j_der));
		Double t1 = 0.0;
		Double t2 = 0.0;
		for (Moneda n : izq) {
			t1 = t1 + n.getPeso();
		}
		for (Moneda n : der) {
			t2 = t2 + n.getPeso();
		}
		return t1.compareTo(t2);
	}

	public static int problemaMonedas(List<Moneda> listaMonedas) {
		return problemaAux(listaMonedas, 0, listaMonedas.size());
	}

	public static int problemaAux(List<Moneda> listaMonedas, Integer i, Integer j) {
		Integer res;
		if (j - i == 1) {
			res = i;
		} else {
			Integer k = (i+j) / 2;
			Integer peso = pesada(listaMonedas, i, k, k + ((j - i) % 2), j);
			if (peso < 0) {
				res = problemaAux(listaMonedas, i, k);
			} else {
				if (peso > 0) {
					res = problemaAux(listaMonedas, k + ((j - i) % 2), j);
				} else {
					res = k;
				}
			}
		}
		return res;
	}

}
