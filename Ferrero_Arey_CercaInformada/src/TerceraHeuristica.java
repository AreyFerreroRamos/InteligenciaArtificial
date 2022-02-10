/**
 * La classe TerceraHeuristica implementa un m�tode per calcular el valor heur�stic d'una casella a partir de la posici� relativa i de l'al�ada relativa d'aquesta casella respecte a la casella final.
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class TerceraHeuristica extends Heuristica{

	/**
	 * El constructor de la classe TerceraHeuristica estableix quina ser� la casella final respecta a la qual es calcular� el valor heur�stic. 
	 * @param casellaFinal �s la casella final del mapa.
	 */
	public TerceraHeuristica(Casella casellaFinal) {
		this.casellaFinal = casellaFinal;
	}
	
	/**
	 * Aquest m�tode serveix per calcular un valor heur�stic que determini l'ordre de les caselles en la llista de caselles pendents segons el valor relatiu d'al�ada de cada casella respecte a la casella final.
	 * @param casellaActual �s la casella que s'est� avaluant.
	 * @return el valor heuristic que s'obte segons l'al�ada relativa de cada casella respecte a la casella final.
	 */
	@Override
	public double calcularValorHeuristic(Casella casellaActual) {
		if (casellaActual.getAl�ada() <= casellaFinal.getAl�ada()) {
			return (casellaFinal.getAl�ada() - casellaActual.getAl�ada() + 1);
		}
		else {
			return 0.5;
		}	
	}
}
