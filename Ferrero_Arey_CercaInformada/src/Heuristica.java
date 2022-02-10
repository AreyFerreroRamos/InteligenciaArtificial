/**
 * La classe Heuristica serveix per calcular un valor heurístic a partir de la casella final i de la casella que s'està avaluant que determini la posició d'aquesta última a la llista de caselles pendents. 
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public abstract class Heuristica {
	/**
	 * Atributs.
	 */
	protected Casella casellaFinal;
	
	/**
	 * Aquest mètode serveix per calcular un valor heurístic que determini la posició de la casella que s'està avaluant a la llista de caselles pendents.
	 * @param casellaActual és la casella que s'està avaluant.
	 * @return el valor heuristic.
	 */
	public abstract double calcularValorHeuristic(Casella casellaActual);
}
