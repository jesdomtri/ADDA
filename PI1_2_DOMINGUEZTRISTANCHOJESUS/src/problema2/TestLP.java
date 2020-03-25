package problema2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import us.lsi.pl.AlgoritmoPLI;

public class TestLP {

	public static void main(String[] args) throws IOException {

		List<String> lines = Files.readAllLines(Paths.get("ficheros/bebe.txt"));
		Integer presupuesto = new Integer(lines.get(0));
		List<Cuidadora> cuidadoras = new ArrayList<>();
		for (int i = 1; i < lines.size(); i++) {
			cuidadoras.add(new Cuidadora(lines.get(i)));
		}

		String r = ProblemaLP.getConstraints(cuidadoras, presupuesto);
		System.out.println(r);

		AlgoritmoPLI a = AlgoritmoPLI.create();
		a.setConstraints(r);
		a.ejecuta();

		System.out.println("Solucion: \n");

		Integer numVariables = cuidadoras.size() * cuidadoras.get(0).getCompatibilidades().size();

		for (int i = 0; i < numVariables; i++) {
			double x = a.getSolucion(i);
			if (x == 1) {
				System.out.println(a.getName(i));
			}
		}

		System.out.println("\n------");
		System.out.println("Objetivo: " + a.getObjetivo());
		System.out.println("------");
	}
}
