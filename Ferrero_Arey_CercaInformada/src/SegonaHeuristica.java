/**
 * La classe SegonaHeuristica implementa un mètode per calcular el valor heurístic d'una casella a partir de l'alçada relativa d'aquesta casella respecte a la casella final.
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class SegonaHeuristica extends Heuristica{

	/**
	 * El constructor de la classe SegonaHeuristica estableix quina serà la casella final respecta a la qual es calcularà el valor heurístic. 
	 * @param casellaFinal és la casella final del mapa.
	 */
	public SegonaHeuristica(Casella casellaFinal) {
		this.casellaFinal = casellaFinal;
	}
	
	/**
	 * Aquest mètode serveix per calcular un valor heurístic que determini l'ordre de les caselles en la llista de caselles pendents segons la distancia euclidea entre cada casella i la casella final.
	 * @param casellaActual és la casella que s'està avaluant.
	 * @return el valor heuristic que s'obte segons la distància euclídea entre cada casella respecte a la casella final.
	 */
	@Override
	public double calcularValorHeuristic(Casella casellaActual) {
		return Math.sqrt(Math.pow(casellaFinal.getFila() - casellaActual.getFila(), 2) + Math.pow(casellaFinal.getColumna() - casellaActual.getColumna(), 2));
	}
}
