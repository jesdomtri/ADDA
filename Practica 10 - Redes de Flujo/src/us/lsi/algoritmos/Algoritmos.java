package us.lsi.algoritmos;

import us.lsi.flowgraph.FlowAlgorithm;
import us.lsi.flowgraph.FlowEdge;
import us.lsi.flowgraph.FlowGraph;
import us.lsi.flowgraph.FlowVertex;
import us.lsi.graphs.GraphsReader;
import us.lsi.pl.AlgoritmoPL;
import us.lsi.pl.ProblemaPL;

public class Algoritmos {
		
	/**
	 * @param fichero Fichero que  describe la red de flujo
	 * @return Algoritmo de red de flujo que resuelve el problema especificado en el fichero
	 */
	public static FlowAlgorithm createFlow(String fichero) {
		FlowGraph f = FlowGraph.create(FlowEdge::createEdge);
		f = (FlowGraph) GraphsReader.newGraph(fichero,FlowVertex::create,FlowEdge::createEdge,f,null);
		return FlowAlgorithm.create(f);
	}

	/**
	 * Los tipos involucrados pueden encontrarse en el paquete <a href="https://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/optim/linear/package-summary.html" target="_blank">Apache</a>
	 * 
	 * @param p  Problema de Programaci�n Lineal
	 * @return Un algoritmo para resolver le conjunto de restricciones lineales con variables reales. 
	 * Ignora las declaraciones de varibles no reales y otros tipos de restrcciones distintas de  las lineales
	 */
	public static AlgoritmoPL createPL(ProblemaPL p) {
		return AlgoritmoPL.create(p);
	}
	
	/**
	 * Los tipos involucrados pueden encontrarse en el paquete <a href="https://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/optim/linear/package-summary.html" target="_blank">Apache</a>
	 * 
	 * @param p  Problema de Programaci�n Lineal
	 * @param fichero  Un fichero para guardar las restricciones del problema
	 * @return Un algoritmo para resolver le conjunto de restricciones lineales
	 * Ignora las declaraciones de varibles no reales y otros tipos de restrcciones distintas de  las lineales
	 */
	public static AlgoritmoPL createPL(ProblemaPL p, String fichero) {
		return AlgoritmoPL.create(p,fichero);
	}
	
}
