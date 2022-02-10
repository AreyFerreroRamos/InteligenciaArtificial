import java.util.*;

/**
 * La classe Pendents és una classe abstracta que, una vegada implemntada, serveix per construir una estructura de dades (llista ordenada) per emmagatzemar totes les caselles que estiguin pendents d'explorar. 
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public abstract class Pendents{
	/**
	 * Atributs.
	 */
	protected ArrayList<Casella> pendents;
	
	/**
	 * El constructor de la classe pendents crea una llista instanciant la classe ArrayList, que és una classe pròpia de Java.
	 */
	public Pendents() {
		pendents = new ArrayList<Casella>();
	}
	
	/**
	 * Aquest mètode permet saber si hi ha caselles a la llista de caselles pendents.
	 * @return si hi ha caselles o no a la llista de caselles pendents.
	 */
	public boolean hiHaCaselles() {
		return !pendents.isEmpty();
	}
	
	/**
	 * Aquest mètode permet esborrar una casella de la llista de caselles pendents.
	 * @param casella és la casella que es vol esborrar.
	 */
	public void esborrarCasella(Casella casella) {
		pendents.remove(casella);
	}
	
	/**
	 * Aquest mètode permet saber si una casella es troba a la llista de caselles pendents.
	 * @param casella és la casella que es vol saber si es troba a la llista de caselles pendents.
	 * @return si la casella es troba a la llista de caselles pendents o no.
	 */
	public abstract boolean casellaContinguda(Casella casella);
	
	/**
	 * Aquest mètode és un mètode abstracte que, una vegada implementat, permetrà obtenir una casella de la llista de caselles pendents.
	 * @param posicio és la posició en la que es troba la casella que es vol obtenir.
	 * @return una casella de la llista de caselles pendents.
	 */
	public abstract Casella agafarCasella();
	
	/**
	 * Aquest mètode és un mètodes abstracte que, una vegada implementat, permetrà afegir una casella a la llista de caselles pendents.
	 * @param casella és la casella que es vol afegir.
	 * @param heuristica és l'heurística que s'utilitzarà.
	 */
	public abstract void afegirCasella(Casella casellaActual);
}
