/**
 * La classe PrimeraHeuristica implementa un m�tode per calcular el valor heur�stic d'una casella a partir de la posici� relativa d'aquesta casella respecte a la casella final.
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class PrimeraHeuristica extends Heuristica{

	/**
	 * El constructor de la classe PrimeraHeuristica inicialitza la casella final respecta a la qual es calcular� el valor heur�stic. 
	 * @param casellaFinal �s la casella final del mapa.
	 */
	public PrimeraHeuristica(Casella casellaFinal) {
		this.casellaFinal = casellaFinal;
	}
	
	/**
	 * Aquest m�tode serveix per calcular un valor heur�stic que determini l'ordre de les caselles en la llista de caselles pendents segons la posici� relativa de cada casella respecte a la casella final.
	 * @param casellaActual �s la casella que s'est� avaluant.
	 * @return el valor heuristic que s'obt� segons la posici� relativa de cada casella respecte a la casella final.
	 */
	@Override
	public double calcularValorHeuristic(Casella casellaActual) {
		return Math.abs((casellaFinal.getFila() - casellaActual.getFila()) + (casellaFinal.getColumna() - casellaActual.getColumna()));
	}
}
