package practicas.practica12.tsp;

import java.util.List;
import org.apache.commons.math3.genetics.Chromosome;

import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory;
import us.lsi.ag.IndexChromosome;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;
import us.lsi.algoritmos.Algoritmos;

import practicas.practica12.tipos.Carretera;
import practicas.practica12.tipos.Ciudad;


public class TestTspAG {

	public static void main(String[] args){

		AlgoritmoAG.ELITISM_RATE  = 0.3;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.8;
		AlgoritmoAG.POPULATION_SIZE = 300;
		
		StoppingConditionFactory.NUM_GENERATIONS = 1500;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 3;
		StoppingConditionFactory.FITNESS_MIN = 0.;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.SolutionsNumber;		
		
		ProblemaTspAG p = ProblemaTspAG.create("ficheros\\tsp.txt");
		//TODO (ALUMNOS): CREACION DEL OBJETO AlgoritmoAG ap
		AlgoritmoAG ap = Algoritmos.createAG(ChromosomeType.IndexPermutation, p);
		ap.ejecuta();
		System.out.println("================================");
		/*
		for (Chromosome c: AlgoritmoAG.bestChromosomes) {
			List<Ciudad> lc = p.getSolucion((IndexChromosome) c);
			System.out.println(lc + " -> " + p.getPeso(lc));
		}
		*/
		IndexChromosome cr = ChromosomeFactory.asIndex(ap.getBestFinal());
		System.out.println("Solución del mejor cromosoma: "+ p.getSolucion(cr));
		System.out.println("Fitness del mejor cromosoma:  "+ p.fitnessFunction(cr));
		System.out.println("SARISTAS: "+ProblemaTspAG.SARISTAS);
		System.out.println("================================");
		System.out.println("Número final de cromosomas en la lista bestChromosomes: "
                + AlgoritmoAG.bestChromosomes.size());

	}	

}

