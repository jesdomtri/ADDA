package practicas.practica12.acolorea;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import practicas.practica12.tipos.Carretera;
import practicas.practica12.tipos.Ciudad;
import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.graphs.GraphsReader;

public class ProblemaColoreaAG implements ValuesInRangeProblemAG<Integer, Map<Ciudad, Integer>> {

	private static Graph<Ciudad, Carretera> g = null;
	private static List<Ciudad> ciudades = null;
	// private static List<Carretera> carreteras = null;

	public ProblemaColoreaAG(String fichero) {
		ProblemaColoreaAG.g = new SimpleGraph<Ciudad, Carretera>(Carretera::create);
		ProblemaColoreaAG.g = GraphsReader.newGraph(fichero, Ciudad::create, Carretera::create, ProblemaColoreaAG.g,
				null);

		ciudades = Lists.newArrayList(g.vertexSet()); // num vertices

		// carreteras = Lists.newArrayList(g.edgeSet());

	}

	@Override
	public Map<Ciudad, Integer> getSolucion(ValuesInRangeChromosome<Integer> chromosome) {
		// TODO (ALUMNOS): EL METODO COMPLETO

		List<Integer> ls = chromosome.decode();

		Map<Ciudad, Integer> ms = Maps.newHashMap();

		IntStream.range(0, ls.size()).boxed().forEach(i -> ms.put(ProblemaColoreaAG.ciudades.get(i), ls.get(i) + 1));

		return ms;
	}

	@Override
	public Integer getVariableNumber() {
		// TODO (ALUMNOS): EL METODO COMPLETO

		return ProblemaColoreaAG.ciudades.size();
	}

	@Override
	public Integer getMax(Integer index) {
		// TODO (ALUMNOS): EL METODO COMPLETO

		return ProblemaColoreaAG.ciudades.size() - 1;
	}

	@Override
	public Integer getMin(Integer index) {
		// TODO (ALUMNOS): EL METODO COMPLETO

		return 0;
	}

	@Override
	public Double fitnessFunction(ValuesInRangeChromosome<Integer> ls) {
		Map<Ciudad, Integer> m = getSolucion(ls);

		// TODO (ALUMNOS): DESDE AQUI HASTA EL FINAL DEL METODO

		// calculo si tngo q penalizar o no
		long rko = g.edgeSet().stream().filter(c -> m.get(c.getSource()) == m.get(c.getTarget())).count();

		int N = ProblemaColoreaAG.ciudades.size();

		int CU = m.values().stream().collect(Collectors.toSet()).size();

		double fitness = -((rko * N * N) + CU);

		return fitness;
	}

	public Set<Set<Ciudad>> getComponentes(ValuesInRangeChromosome<Integer> chromosome) {
		Map<Ciudad, Integer> m = getSolucion(chromosome);

		return m.entrySet().stream()
				.collect(Collectors.groupingBy(e -> e.getValue(),
						Collectors.mapping(e -> e.getKey(), Collectors.toSet())))
				.values().stream().collect(Collectors.toSet());
	}

}
