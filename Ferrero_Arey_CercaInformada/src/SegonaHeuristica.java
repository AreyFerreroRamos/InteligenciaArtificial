/**
 * La classe SegonaHeuristica implementa un m�tode per calcular el valor heur�stic d'una casella a partir de l'al�ada relativa d'aquesta casella respecte a la casella final.
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class SegonaHeuristica extends Heuristica{

	/**
	 * El constructor de la classe SegonaHeuristica estableix quina ser� la casella final respecta a la qual es calcular� el valor heur�stic. 
	 * @param casellaFinal �s la casella final del mapa.
	 */
	public SegonaHeuristica(Casella casellaFinal) {
		this.casellaFinal = casellaFinal;
	}
	
	/**
	 * Aquest m�tode serveix per calcular un valor heur�stic que determini l'ordre de les caselles en la llista de caselles pendents segons la distancia euclidea entre cada casella i la casella final.
	 * @param casellaActual �s la casella que s'est� avaluant.
	 * @return el valor heuristic que s'obte segons la dist�ncia eucl�dea entre cada casella respecte a la casella final.
	 */
	@Override
	public double calcularValorHeuristic(Casella casellaActual) {
		return Math.sqrt(Math.pow(casellaFinal.getFila() - casellaActual.getFila(), 2) + Math.pow(casellaFinal.getColumna() - casellaActual.getColumna(), 2));
	}
}
