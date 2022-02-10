import java.util.*;

/**
 * La classe Cami serveix per construir una estructura de dades (llista) per emmagatzemar totes les caselles que formen el cam� des del node inicial fins al node final.
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class Cami {
	/**
	 * Atributs.
	 */
	ArrayList<Casella> cami;
	
	/**
	 * El constructor de la classe cam� direcciona un apuntador cap a una llista de caselles que cont� el cam� que s'ha trobat per arribar fins a la casella final del mapa.
	 * @param cami �s la llista de caselles que cont� totes les caselles el cam� que s'ha trobat per arribar fins a la casella final del mapa.
	 */
	public Cami(ArrayList<Casella> cami) {
		this.cami = cami;
	}
	
	/**
	 * Aquest m�tode serveix per obtenir la dimensi� del cam�.
	 * @return la dimensi� del cam�.
	 */
	public int dimensio() {
		return cami.size();
	}
	
	/**
	 * Aquest m�tode serveix per afegir una casella al cam� fins a la casella final. Aquest m�tode nom�s s'utilitzar� per afegir la casella final al cam� fins aquesta.
	 * @param casella �s la casella que es vol afegir al cam�.
	 */
	public void afegirCasella(Casella casella) {
		cami.add(casella);
	}
	
	/**
	 * Aquest m�tode permet saber si una casella forma part del cam� fins a la casella final del mapa.
	 * @param casella �s la casella que es vol saber si forma part del cam� fins a la casella final.
	 * @return si la casella forma part del cam� fins a la casella final.
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
