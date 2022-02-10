/**
 * La classe PendentsAEstrella serveix desenvolupar una estructura de dades per emmagatzemar caselles pendents d'explorar seguints els criteris d'agafat i d'afegit de l'algorisme A*.
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class PendentsAEstrella extends Pendents{

	/**
	 * Aquest mètode es sobreescriu en l'implementació de l'algorisme A* per a poder afegir caselles repetides a la cua de pendents sense modificar l'estructura general de l'algorisme de cerca. 
	 * @param casella és la casella que s'està avaluant.
	 * @return sempre fals, ja que l'algorisme A* permet emmagatzemar caselles repetides.
	 */
	@Override
	public boolean casellaContinguda(Casella casella) {
		return false;
	}
	
	/**
	 * Aquest mètode serveix per obtenir una casella de la llista de caselles pendents.
	 * @param posicio és la posició de la casella que es vol obtenir.
	 * @return la casella que es vol obtenir.
	 */
	@Override
	public Casella agafarCasella() {
		return pendents.get(0);
	}

	/**
	 * Aquest mètode serveix per afegir una casella a la llista de caselles pendents.
	 * @param casella és la casella de que es vol afegir a la llista de caselles pendents.
	 * @param heuristica és l'heurística que s'utilitzarà per calcular un dels valors que s'utilitzaran com a criteri per a seleccionar la posició de la llista de pendents en la que s'afegirà la casella.
	 */
	@Override
	public void afegirCasella(Casella casellaActual) {
		int i = 0;
		boolean trobat = false;
		
		while ((!trobat) && (i < pendents.size())) {
			if (casellaActual.getValorHeuristic() + casellaActual.getCostAcumulat() < pendents.get(i).getValorHeuristic() + pendents.get(i).getCostAcumulat()) {
				trobat = true;
			}
			else {
				i++;
			}
		}
		pendents.add(i, casellaActual);
	}
}
