package practicas.practica12.tsp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.google.common.collect.Lists;

import practicas.practica12.tipos.Carretera;
import practicas.practica12.tipos.Ciudad;
import us.lsi.ag.IndexChromosome;
import us.lsi.ag.IndexProblemAG;
import us.lsi.graphs.GraphsReader;

public class ProblemaTspAG implements IndexProblemAG<List<Ciudad>> {

	public static Double SARISTAS = null;
	public static Graph<Ciudad, Carretera> g = null;
	public static List<Ciudad> ciudades = null;

	public static ProblemaTspAG create(String fichero) {
		return new ProblemaTspAG(fichero);
	}

	private ProblemaTspAG(String fichero) {
		ProblemaTspAG.g = new SimpleWeightedGraph<Ciudad, Carretera>(Carretera::create);
		ProblemaTspAG.g = GraphsReader.newGraph(fichero, Ciudad::create, Carretera::create, ProblemaTspAG.g,
				Carretera::getWeight);
		ProblemaTspAG.ciudades = Lists.newArrayList(g.vertexSet());
		ProblemaTspAG.SARISTAS = g.edgeSet().stream().mapToDouble(c -> c.getWeight()).sum();
	}

	@Override
	public List<Ciudad> getSolucion(IndexChromosome chromosome) {
		// TODO (ALUMNOS): EL METODO COMPLETO

		return getRecorrido(chromosome.decode());
	}

	public Double getPeso(List<Ciudad> lc) {
		boolean ok = IntStream.range(0, lc.size() - 1).allMatch(p -> g.containsEdge(lc.get(p), lc.get(p + 1)));
		if (!ok)
			return null;
		return IntStream.range(0, lc.size() - 1).boxed().map(p -> g.getEdge(lc.get(p), lc.get(p + 1)))
				.mapToDouble(p -> p.getWeight()).sum();
	}

	@Override
	public Double fitnessFunction(IndexChromosome ls) {

		List<Ciudad> lc = getRecorrido(ls.decode());
		// TODO (ALUMNOS): DESDE AQUI HASTA EL FINAL DEL METODO

		Double fitness = 0.;

		fitness = IntStream.range(0, lc.size() - 1).boxed().map(p -> g.getEdge(lc.get(p), lc.get(p + 1)))
				.mapToDouble(c -> c == null ? ProblemaTspAG.SARISTAS : c.getWeight()).sum();

		return -fitness;
	}

	public List<Ciudad> getRecorrido(List<Integer> ls) {
		List<Ciudad> la = ls.stream().map(p -> ciudades.get(p)).collect(Collectors.toList());
		la.add(la.get(0));
		return la;
	}

	@Override
	public Integer getObjectsNumber() {
		// TODO (ALUMNOS): EL METODO COMPLETO

		return ciudades.size();
	}

}
