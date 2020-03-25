package practica10;

import us.lsi.flowgraph.FlowGraphSolution;
import us.lsi.flowgraph.SolveFlowGraphProblem;

//S,1,1.1.,0. --> nombre, tipo, min, max, coste
public class TestFlow {

	public static void main(String[] args) {

		System.out.println("ASIGNACION DE TAREAS:");
		System.out.println("=====================");
		FlowGraphSolution fs = SolveFlowGraphProblem.solve("./ficheros/asignacion.txt", "./ficheros/asignacion.fg",
				"./ficheros/asignacion.sol", "./ficheros/asignacion.const", true, true); // MINIMIZA COSTES
		System.out.println("TOTAL DE TAREAS ASIGNADAS: " + fs.getOptFlow());
		System.out.println("ASIGNACION REALIZADA: ");
		fs.getEdgeFlow().entrySet().stream().filter(x -> x.getValue() == 1.0)
				.forEach(x -> System.out.println("  (" + x.getKey().getFrom() + "," + x.getKey().getTo() + ")"));
		System.out.println();

		System.out.println("CAMINOS MINIMOS:");
		System.out.println("================");
		fs = SolveFlowGraphProblem.solve("./ficheros/caminoMinimo.txt", "./ficheros/caminoMinimo.fg",
				"./ficheros/caminoMinimo.sol", "./ficheros/caminoMinimo.const", true, true); // MINIMIZA EL NUMERO DE
																								// ARISTAS DE CAMINO
		System.out.println("NUMERO DE CAMINOS: " + fs.getOptFlow());
		System.out.println("PESO DEL CAMINO: " + fs.getGoal());
		System.out.println("CAMINO: " + fs.getWalks(false));
		System.out.println();

		System.out.println("CAMINOS DISJUNTOS EN ARISTAS:");
		System.out.println("=============================");
		fs = SolveFlowGraphProblem.solve("./ficheros/caminosDisjuntosAristas.txt",
				"./ficheros/caminosDisjuntosAristas.fg", "./ficheros/caminosDisjuntosAristas.sol",
				"./ficheros/caminosDisjuntosAristas.const", true, false); // MAXIMIZA EL NUMERO DE CAMINOS QUE LLEGAN AL
																			// VERTICES DESTINO
		System.out.println("NUMERO DE CAMINOS ENCONTRADOS: " + fs.getOptFlow());
		System.out.println("CAMINOS:" + fs.getWalks(true));
		System.out.println("CAMINOS:" + fs.getWalks(false));
		System.out.println("FLUJOS:" + fs.getEdgeFlow());
		System.out.println();

		System.out.println("CAMINOS DISJUNTOS EN VERTICES:");
		System.out.println("=============================");
		fs = SolveFlowGraphProblem.solve("./ficheros/caminosDisjuntosVertices.txt",
				"./ficheros/caminosDisjuntosVertices.fg", "./ficheros/caminosDisjuntosVertices.sol",
				"./ficheros/caminosDisjuntosVertices.const", true, false); // MAXIMIZA EL NUMERO DE CAMINOS QUE LLEGAN
																			// AL VERTICES DESTINO
		System.out.println(fs.getOptFlow());
		System.out.println("NUMERO DE CAMINOS ENCONTRADOS: " + fs.getOptFlow());
		System.out.println("CAMINOS:" + fs.getWalks(false));
		System.out.println();

		System.out.println("TRANSPORTE:");
		System.out.println("===========");
		fs = SolveFlowGraphProblem.solve("./ficheros/transporte.txt", "./ficheros/transporte.fg",
				"./ficheros/transporte.sol", "./ficheros/transporte.const", true, false); // MAXIMIZA EL BENEFICIO
		System.out.println("FLUJO MAXIMO: " + fs.getOptFlow());
		System.out.println("BENEFICIO: " + fs.getGoal());
		System.out.println("FLUJOS:" + fs.getEdgeFlow());
		System.out.println();

		System.out.println("FLUJO MAXIMO:");
		System.out.println("=============");
		fs = SolveFlowGraphProblem.solve("./ficheros/maxFlow.txt", "./ficheros/maxFlow.fg", "./ficheros/maxFlow.sol",
				"./ficheros/maxFlow.const", true, false); // MAXIMIZA EL FLUJO
		System.out.println("FLUJO MAXIMO: " + fs.getOptFlow());
		System.out.println("FLUJOS:" + fs.getEdgeFlow());

	}

}
