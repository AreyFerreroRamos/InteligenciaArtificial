import java.util.*;

/**
 * La classe Casella serveix per emmagatzemar la posició d'una casella del mapa geogràfic (fila i columna) i el valor del contingut de la casella, que representa una alçada. 
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class Casella{
	/**
	 * Atributs.
	 */
	private int alçada;
	private int fila;
	private int columna;
	private ArrayList<Casella> cami;
	private double costAcumulat;
	private double valorHeuristic;
	
	/**
	 * El constructor de la classe Casella inicialitza la posició (fila i columna) i el contingut de la casella.
	 * @param alçada és el valor del contingut de la casella que representa una alçada.
	 * @param fila és la fila en la que es troba la casella.
	 * @param columna és la columna en la que es troba la casella.
	 */
	public Casella(int alçada, int fila, int columna) {
		this.alçada = alçada;
		this.fila = fila;
		this.columna = columna;
		cami = null;
		costAcumulat = 0;
		valorHeuristic = -1;
	}
	
	/**
	 * Aquest mètode serveix per obtenir el valor de l'alçada. 
	 * @return el valor d'alçada.
	 */
	public int getAlçada() {
		return alçada;
	}
	
	/**
	 * Aquest mètode serveix per obtenir la fila en la que es troba la casella.
	 * @return la fila en la que es troba la casella.
	 */
	public int getFila() {
		return fila;
	}
	
	/**
	 * Aquest mètode serveix per obtenir la columna en la que es troba la casella.
	 * @return la columna en la que es troba la casella.
	 */
	public int getColumna() {
		return columna;
	}
	
	/**
	 * Aquest mètode serveix per obtenir el camí de caselles seguit per arribar fins a una casella concreta.
	 * @return el cami de caselles seguit per arribar fins a una casella concreta.
	 */
	public ArrayList<Casella> getCami() {
		return cami;
	}
	
	/**
	 * Aquest mètode serveix per obtenir el cost temporal d'arribar a la casella actual pasant per totes les caselles del seu camí.
	 * @return el cost acumulat d'arribar a la casella actual.
	 */
	public double getCostAcumulat() {
		return costAcumulat;
	}
	
	/**
	 * Aquest mètode serveix per obtenir el valor calculat per la funció heurística assignat a aquesta casella.
	 * @return el valor heurístic de la casella.
	 */
	public double getValorHeuristic() {
		return valorHeuristic;
	}
	
	/**
	 * Aquest mètode serveix per modificar el valor del cost acumulat. Aquest mètode només s'utilitzarà una vegada per afegir el valor del cost acumulat a la casella final una vegada s'ha arribat al final del mapa. 
	 * @param costAcumulat és el nou valor del cost acumulat.
	 */
	public void setCostAcumulat(double costAcumulat) {
		this.costAcumulat = costAcumulat;
	}
	
	/**
	 * Aquest mètode serveix per construir el camí fins a la casella actual.
	 * @param cami es el cami per arribar a la casella anterior a la casella que s'està tractant.
	 * @param casella es la casella anterior a la casella que s'està tractant.  
	 */
	public void calcularCami(ArrayList<Casella> cami, Casella casella) {
		if (cami == null) {
			this.cami = new ArrayList<Casella>();
		}
		else {
			this.cami = new ArrayList<Casella>(cami);
		}
		this.cami.add(casella);
	}
	
	/**
	 * Aquest mètode serveix per calcular el cost temporal d'arribar a la casella actual pasant per totes les caselles del seu camí. 
	 * @param casellaAnterior és la casella immediatament anterior a la casella que s'està avaluant.
	 */
	public void calcularCostAcumulat(Casella casellaAnterior) {
		if (casellaAnterior.getAlçada() <= this.alçada) {
			costAcumulat = casellaAnterior.getCostAcumulat() + (this.getAlçada() - casellaAnterior.getAlçada()) + 1; 
		}
		else {
			costAcumulat = casellaAnterior.getCostAcumulat() + 0.5;
		}
	}
	
	/**
	 * Aquest mètode serveix per calcular un valor heuristic a partir d'una funcio heurística.
	 * @param heuristica és la classe que conté la funció heurística.
	 */
	public void calcularValorHeuristic(Heuristica heuristica) {
		valorHeuristic = heuristica.calcularValorHeuristic(this);
	}
	
	/**
	 * Aquest mètode retorna els atributs de la classe Casella seguint un format específic.
	 */
	public String toString() {
		return ("L'alçada de la casella ("+fila+", "+columna+" és: "+alçada);
	}
	
	/**
	 * Aquest mètode serveix per comprovar si la casella actual es igual o no a una casella que es passa per paràmetre.
	 * @param casella és la casella amb la qual es vol fer la comparació.
	 * @return si les dues caselles son iguals o no. 
	 */
	public boolean equals(Casella casella) {
		return ((this.fila == casella.fila) && (this.columna == casella.columna)); 
	}
}
