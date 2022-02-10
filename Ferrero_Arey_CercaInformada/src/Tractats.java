import java.util.*;

/**
 * La classe tractats serveix per construir una estructura de dades (taula de Hash) per emmagatzemar totes les caselles que ja hagin estat tractades.
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class Tractats {
	/**
	 * Atributs.
	 */
	private HashSet<Casella> tractats;
	
	/**
	 * El constructor de la classe Tractats crea una taula de hash instanciant la classe HashSet, que �s una classe pr�pia de Java.
	 */
	public Tractats() {
		tractats = new HashSet<Casella>();
	}
	
	/**
	 * Aquest m�tode permet saber si una casella es troba a l'estructura de caselles tractades.
	 * @param casella �s la casella que es vol saber si es troba a l'estructura de caselles tractades.
	 * @return si la casella es troba a l'estructura de caselles tractades o no
	 */
	public boolean casellaContinguda(Casella casella) {
		Iterator<Casella> caselles = tractats.iterator();
		boolean trobat = false;
		
		while ((!trobat) && (caselles.hasNext())) {
			if (caselles.next().equals(casella)) {
				trobat = true;
			}
		}
		return trobat;
	}
	
	/**
	 * Aquest m�tode permet afegir una casella a l'estructura de caselles tractades.
	 * @param casella �s la casella que es vol afegir a l'estructura de caselles tractades.
	 */
	public void afegirCasella(Casella casella) {
		tractats.add(casella);
	}
}
