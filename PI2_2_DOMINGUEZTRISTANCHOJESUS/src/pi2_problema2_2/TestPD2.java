package pi2_problema2_2;

import java.io.IOException;
import java.util.List;

import us.lsi.algoritmos.AbstractAlgoritmo;
import us.lsi.algoritmos.Algoritmos;
import us.lsi.pd.AlgoritmoPD;
import us.lsi.pd.ProblemaPD;

public class TestPD2 {

	public static void main(String[] args) throws IOException {

		List<String> ls = LeeFichero.leeFicheros();

		AbstractAlgoritmo.calculaMetricas();
		AlgoritmoPD.conFiltro = true;

		ProblemaInversion prob = ProblemaInversion.create(LeeFichero.getPresupuesto(ls), LeeFichero.getInversiones(ls));

		ProblemaPD<SolInv, Alternativa> pd = ProbPD.create(prob);

		AlgoritmoPD<SolInv, Alternativa> a = Algoritmos.createPD(pd);
		a.ejecuta();
		System.out.println(a.getSolucion(pd) + "\n");
		AbstractAlgoritmo.raiz = "";
		a.showAllGraph("ficheros/inversiones.gv", "Inversion", pd);
	}

}
