package practicas.practica14.caballo;

import us.lsi.algoritmos.Algoritmos;
import us.lsi.bt.AlgoritmoBT;

public class TestCaballoBT {

	public static void main(String[] args) {
	
		//TODO ALUMNOS: variar el n�mero de soluciones.
		AlgoritmoBT.numeroDeSoluciones = 2;

		//TODO ALUMNOS: probar qu� ocurre al establecer isRandomize a true.
		//AlgoritmoBT.isRandomize = true;
		
		
		ProblemaCaballo.setLadoTablero(6);
		ProblemaCaballo.setCasillaInicialX(1);
		ProblemaCaballo.setCasillaInicialY(1);
		
		//TODO ALUMNOS: creaci�n del estado inicial y del AlgoritmoBT.
		EstadoCaballoBT p = EstadoCaballoBT.create();
		AlgoritmoBT<SolucionCaballoBT,Integer> a = Algoritmos.createBT(p);
		
		a.ejecuta();

		if (a.getSoluciones().isEmpty()) 
			System.out.println("No se encuentra ninguna soluci�n.");
		else 
			for(SolucionCaballoBT s: a.getSoluciones())
				System.out.println(s);
	}
}
