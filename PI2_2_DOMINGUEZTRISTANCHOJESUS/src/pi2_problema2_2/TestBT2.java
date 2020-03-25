package pi2_problema2_2;

import java.io.IOException;
import java.util.List;

import us.lsi.algoritmos.AbstractAlgoritmo;
import us.lsi.algoritmos.Algoritmos;
import us.lsi.bt.AlgoritmoBT;

public class TestBT2 {

	public static void main(String[] args) throws IOException {

		AbstractAlgoritmo.calculaMetricas();
		AlgoritmoBT.conFiltro = true;

		AlgoritmoBT.numeroDeSoluciones = 1;
		List<String> ls = LeeFichero.leeFicheros();

		ProblemaInversion prob = ProblemaInversion.create(LeeFichero.getPresupuesto(ls), LeeFichero.getInversiones(ls));

		EstBT p = EstBT.create(prob);
		AlgoritmoBT<SolInv, Alternativa> a = Algoritmos.createBT(p);
		a.ejecuta();
		for (SolInv sol : a.getMejoresSoluciones()) {
			System.out.println(sol);
		}
	}
}
