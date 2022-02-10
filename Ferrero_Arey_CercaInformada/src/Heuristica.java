/**
 * La classe Heuristica serveix per calcular un valor heur�stic a partir de la casella final i de la casella que s'est� avaluant que determini la posici� d'aquesta �ltima a la llista de caselles pendents. 
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public abstract class Heuristica {
	/**
	 * Atributs.
	 */
	protected Casella casellaFinal;
	
	/**
	 * Aquest m�tode serveix per calcular un valor heur�stic que determini la posici� de la casella que s'est� avaluant a la llista de caselles pendents.
	 * @param casellaActual �s la casella que s'est� avaluant.
	 * @return el valor heuristic.
	 */
	public abstract double calcularValorHeuristic(Casella casellaActual);
}
