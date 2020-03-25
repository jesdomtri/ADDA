package problema2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.Maps;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;

public class ProblemaAG implements ValuesInRangeProblemAG<Integer, Map<Cuidadora, Integer>> {

	// private static Map<Cuidadora, Integer> mc = null;
	private static List<Cuidadora> lc = new ArrayList<>();
	private static Integer numBebes = null;
	private static Integer p = null;

	public ProblemaAG(String fichero) throws IOException {
		List<String> l = Files.readAllLines(Paths.get(fichero));
		ProblemaAG.p = new Integer(l.get(0).trim());
		for (int i = 1; i < l.size(); i++) {
			ProblemaAG.lc.add(Cuidadora.create(l.get(i)));
		}
		ProblemaAG.numBebes = lc.get(0).getCompatibilidades().size();
	}

	public Integer getVariableNumber() {
		return ProblemaAG.lc.size();
	}

	public Integer getMax(Integer i) {
		return ProblemaAG.lc.get(i).getCompatibilidades().size();
	}

	public Integer getMin(Integer i) {
		return ProblemaAG.lc.get(i).getCompatibilidades().size();
	}

	public Map<Cuidadora, Integer> getSolucion(ValuesInRangeChromosome<Integer> cr) {
		List<Integer> d = cr.decode();
		Map<Cuidadora, Integer> res = Maps.newHashMap();
		IntStream.range(0, d.size()).boxed().forEach(i -> res.put(ProblemaAG.lc.get(i), d.get(i) + 1));
		return res;
	}

	public Double fitnessFunction(ValuesInRangeChromosome<Integer> cr) {
		Map<Cuidadora, Integer> m = getSolucion(cr);

		long rko = ProblemaAG.lc.stream().filter(c -> lc.get(c.getCodigo()) == lc.get(c.getCodigo())).count();

		int N = ProblemaAG.lc.size();

		int CU = m.values().stream().collect(Collectors.toSet()).size();

		double fitness = (rko * N * N) + CU;

		return fitness;
	}
}
