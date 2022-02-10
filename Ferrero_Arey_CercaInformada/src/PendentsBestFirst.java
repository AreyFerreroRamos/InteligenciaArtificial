/**
 * La classe PendentsBestFirst serveix desenvolupar una estructura de dades per emmagatzemar caselles pendents d'explorar seguints els criteris d'agafat i d'afegit de l'algorisme Best First. 
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class PendentsBestFirst extends Pendents{
	
	/**
	 * Aquest m�tode permet saber si una casella es troba a la llista de caselles pendents.
	 * @param casella �s la casella que es vol saber si es troba a la llista de caselles pendents.
	 * @return si la casella es troba a la llista de caselles pendents o no.
	 */
	@Override
	public boolean casellaContinguda(Casella casella) {
		int i = 0;
		boolean trobat = false;
		
		while ((!trobat) && (i < pendents.size())) {
			if (pendents.get(i).equals(casella)) {
				trobat = true;
			}
			else {
				i++;
			}
		}
		return trobat;
	}
	
	/**
	 * Aquest m�tode serveix per obtenir una casella de la llista de caselles pendents.
	 * @param posicio �s la posici� de la casella que es vol obtenir.
	 * @return la casella que es vol obtenir.
	 */
	@Override
	public Casella agafarCasella() {
		return pendents.get(0);
	}

	/**
	 * Aquest m�tode serveix per afegir una casella a la llista de caselles pendents.
	 * @param casella �s la casella de que es vol afegir a la llista de caselles pendents.
	 * @param heuristica �s l'heur�stica que s'utilitzar� per calcular el valor que s'utilitzar� com a criteri per a seleccionar la posici� de la llista de pendents en la que s'afegir� la casella.
	 */
	@Override
	public void afegirCasella(Casella casellaActual) {
		int i = 0;
		boolean trobat = false;
		
		while ((!trobat) && (i < pendents.size())) {
			if (casellaActual.getValorHeuristic() <= pendents.get(i).getValorHeuristic()) {
				trobat = true;
			}
			else {
				i++;
			}
		}
		pendents.add(i, casellaActual);	
	}
}
