/**
 * La classe TerceraHeuristica implementa un mètode per calcular el valor heurístic d'una casella a partir de la posició relativa i de l'alçada relativa d'aquesta casella respecte a la casella final.
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class TerceraHeuristica extends Heuristica{

	/**
	 * El constructor de la classe TerceraHeuristica estableix quina serà la casella final respecta a la qual es calcularà el valor heurístic. 
	 * @param casellaFinal és la casella final del mapa.
	 */
	public TerceraHeuristica(Casella casellaFinal) {
		this.casellaFinal = casellaFinal;
	}
	
	/**
	 * Aquest mètode serveix per calcular un valor heurístic que determini l'ordre de les caselles en la llista de caselles pendents segons el valor relatiu d'alçada de cada casella respecte a la casella final.
	 * @param casellaActual és la casella que s'està avaluant.
	 * @return el valor heuristic que s'obte segons l'alçada relativa de cada casella respecte a la casella final.
	 */
	@Override
	public double calcularValorHeuristic(Casella casellaActual) {
		if (casellaActual.getAlçada() <= casellaFinal.getAlçada()) {
			return (casellaFinal.getAlçada() - casellaActual.getAlçada() + 1);
		}
		else {
			return 0.5;
		}	
	}
}
