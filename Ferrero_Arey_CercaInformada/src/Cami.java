import java.util.*;

/**
 * La classe Cami serveix per construir una estructura de dades (llista) per emmagatzemar totes les caselles que formen el camí des del node inicial fins al node final.
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class Cami {
	/**
	 * Atributs.
	 */
	ArrayList<Casella> cami;
	
	/**
	 * El constructor de la classe camí direcciona un apuntador cap a una llista de caselles que conté el camí que s'ha trobat per arribar fins a la casella final del mapa.
	 * @param cami és la llista de caselles que conté totes les caselles el camí que s'ha trobat per arribar fins a la casella final del mapa.
	 */
	public Cami(ArrayList<Casella> cami) {
		this.cami = cami;
	}
	
	/**
	 * Aquest mètode serveix per obtenir la dimensió del camí.
	 * @return la dimensió del camí.
	 */
	public int dimensio() {
		return cami.size();
	}
	
	/**
	 * Aquest mètode serveix per afegir una casella al camí fins a la casella final. Aquest mètode només s'utilitzarà per afegir la casella final al camí fins aquesta.
	 * @param casella és la casella que es vol afegir al camí.
	 */
	public void afegirCasella(Casella casella) {
		cami.add(casella);
	}
	
	/**
	 * Aquest mètode permet saber si una casella forma part del camí fins a la casella final del mapa.
	 * @param casella és la casella que es vol saber si forma part del camí fins a la casella final.
	 * @return si la casella forma part del camí fins a la casella final.
	 */
	public boolean casellaContinguda(Casella casella) {
		int i = 0;
		boolean trobat = false;
		
		while ((!trobat) && (i < cami.size())) {
			if (cami.get(i).equals(casella)) {
				trobat = true;
			}
			else {
				i++;
			}
		}
		return trobat;
	}
	
	
}
