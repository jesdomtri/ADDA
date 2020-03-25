package pi2_problema2_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.common.collect.Lists;

public class LeeFichero {

	public static void main(String[] args) throws IOException {
		List<String> ls = leeFicheros();

		System.out.println(getPresupuesto(ls));
		for (Inversion inv : getInversiones(ls)) {
			System.out.println(inv);
		}
	}

	public static List<String> leeFicheros() throws IOException {
		return Files.readAllLines(Paths.get("ficheros/inversiones.txt"));
	}

	public static Integer getPresupuesto(List<String> ls) {
		return new Integer(ls.get(0));
	}

	public static List<Inversion> getInversiones(List<String> ls) {
		List<Inversion> inversiones = Lists.newArrayList();
		for (int i = 1; i < ls.size(); i++) {
			inversiones.add(new Inversion(ls.get(i)));
		}
		return inversiones;
	}
}
