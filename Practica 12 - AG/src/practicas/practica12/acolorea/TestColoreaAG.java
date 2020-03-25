package practicas.practica12.acolorea;

import java.util.stream.Collectors;

import us.lsi.ag.ValuesInRangeChromosome;

import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;

import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;

import us.lsi.algoritmos.Algoritmos;

public class TestColoreaAG {


	public static void main(String[] args){

		AlgoritmoAG.ELITISM_RATE  = 0.3;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 100;
		
		StoppingConditionFactory.NUM_GENERATIONS = 10000;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 1;
		StoppingConditionFactory.FITNESS_MIN = 623.;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.SolutionsNumber;
		
		
		ProblemaColoreaAG p = new ProblemaColoreaAG("ficheros\\andalucia.txt");
		//TODO (ALUMNOS): CREACION DE AlgoritmoAG ap
		AlgoritmoAG ap = Algoritmos.createAG(ChromosomeType.Range, p);
		ap.ejecuta();
		
		System.out.println("================================");
		ValuesInRangeChromosome<Integer> cr = ChromosomeFactory.asValuesInRange(ap.getBestFinal());
		System.out.println("Solución del mejor cromosoma:     "+ p.getSolucion(cr));
		System.out.println("Fitness del mejor cromosoma:      "+ p.fitnessFunction(cr));
		System.out.println("Ciudades con el mismo color (según mejor cromosoma): "+ p.getComponentes(cr));
		int cu= cr.decode()
				.stream()
				.collect(Collectors.toSet())
			    .size();
		System.out.println("Colores usados: " +cu);
		System.out.println("================================");
		System.out.println("Número final de cromosomas en la lista bestChromosomes: "
		                   + AlgoritmoAG.bestChromosomes.size());
		
	}	

}
