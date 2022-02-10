/**
 * La classe PrimeraHeuristica implementa un mètode per calcular el valor heurístic d'una casella a partir de la posició relativa d'aquesta casella respecte a la casella final.
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class PrimeraHeuristica extends Heuristica{

	/**
	 * El constructor de la classe PrimeraHeuristica inicialitza la casella final respecta a la qual es calcularà el valor heurístic. 
	 * @param casellaFinal és la casella final del mapa.
	 */
	public PrimeraHeuristica(Casella casellaFinal) {
		this.casellaFinal = casellaFinal;
	}
	
	/**
	 * Aquest mètode serveix per calcular un valor heurístic que determini l'ordre de les caselles en la llista de caselles pendents segons la posició relativa de cada casella respecte a la casella final.
	 * @param casellaActual és la casella que s'està avaluant.
	 * @return el valor heuristic que s'obté segons la posició relativa de cada casella respecte a la casella final.
	 */
	@Override
	public double calcularValorHeuristic(Casella casellaActual) {
		return Math.abs((casellaFinal.getFila() - casellaActual.getFila()) + (casellaFinal.getColumna() - casellaActual.getColumna()));
	}
}
