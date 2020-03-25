package us.lsi.pl;

public interface SolutionPL {
	/**
	 * @return El coste total del objetivo
	 */
	public double getObjetivo();
	/**
	 * @return El punto solución
	 */
	public double[] getSolucion();	
}
