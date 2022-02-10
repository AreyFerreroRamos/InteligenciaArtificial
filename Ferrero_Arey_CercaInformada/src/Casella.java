import java.util.*;

/**
 * La classe Casella serveix per emmagatzemar la posici� d'una casella del mapa geogr�fic (fila i columna) i el valor del contingut de la casella, que representa una al�ada. 
 * @author Arey Ferrero Ramos
 * @version 1.0
 */
public class Casella{
	/**
	 * Atributs.
	 */
	private int al�ada;
	private int fila;
	private int columna;
	private ArrayList<Casella> cami;
	private double costAcumulat;
	private double valorHeuristic;
	
	/**
	 * El constructor de la classe Casella inicialitza la posici� (fila i columna) i el contingut de la casella.
	 * @param al�ada �s el valor del contingut de la casella que representa una al�ada.
	 * @param fila �s la fila en la que es troba la casella.
	 * @param columna �s la columna en la que es troba la casella.
	 */
	public Casella(int al�ada, int fila, int columna) {
		this.al�ada = al�ada;
		this.fila = fila;
		this.columna = columna;
		cami = null;
		costAcumulat = 0;
		valorHeuristic = -1;
	}
	
	/**
	 * Aquest m�tode serveix per obtenir el valor de l'al�ada. 
	 * @return el valor d'al�ada.
	 */
	public int getAl�ada() {
		return al�ada;
	}
	
	/**
	 * Aquest m�tode serveix per obtenir la fila en la que es troba la casella.
	 * @return la fila en la que es troba la casella.
	 */
	public int getFila() {
		return fila;
	}
	
	/**
	 * Aquest m�tode serveix per obtenir la columna en la que es troba la casella.
	 * @return la columna en la que es troba la casella.
	 */
	public int getColumna() {
		return columna;
	}
	
	/**
	 * Aquest m�tode serveix per obtenir el cam� de caselles seguit per arribar fins a una casella concreta.
	 * @return el cami de caselles seguit per arribar fins a una casella concreta.
	 */
	public ArrayList<Casella> getCami() {
		return cami;
	}
	
	/**
	 * Aquest m�tode serveix per obtenir el cost temporal d'arribar a la casella actual pasant per totes les caselles del seu cam�.
	 * @return el cost acumulat d'arribar a la casella actual.
	 */
	public double getCostAcumulat() {
		return costAcumulat;
	}
	
	/**
	 * Aquest m�tode serveix per obtenir el valor calculat per la funci� heur�stica assignat a aquesta casella.
	 * @return el valor heur�stic de la casella.
	 */
	public double getValorHeuristic() {
		return valorHeuristic;
	}
	
	/**
	 * Aquest m�tode serveix per modificar el valor del cost acumulat. Aquest m�tode nom�s s'utilitzar� una vegada per afegir el valor del cost acumulat a la casella final una vegada s'ha arribat al final del mapa. 
	 * @param costAcumulat �s el nou valor del cost acumulat.
	 */
	public void setCostAcumulat(double costAcumulat) {
		this.costAcumulat = costAcumulat;
	}
	
	/**
	 * Aquest m�tode serveix per construir el cam� fins a la casella actual.
	 * @param cami es el cami per arribar a la casella anterior a la casella que s'est� tractant.
	 * @param casella es la casella anterior a la casella que s'est� tractant.  
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
	 * Aquest m�tode serveix per calcular el cost temporal d'arribar a la casella actual pasant per totes les caselles del seu cam�. 
	 * @param casellaAnterior �s la casella immediatament anterior a la casella que s'est� avaluant.
	 */
	public void calcularCostAcumulat(Casella casellaAnterior) {
		if (casellaAnterior.getAl�ada() <= this.al�ada) {
			costAcumulat = casellaAnterior.getCostAcumulat() + (this.getAl�ada() - casellaAnterior.getAl�ada()) + 1; 
		}
		else {
			costAcumulat = casellaAnterior.getCostAcumulat() + 0.5;
		}
	}
	
	/**
	 * Aquest m�tode serveix per calcular un valor heuristic a partir d'una funcio heur�stica.
	 * @param heuristica �s la classe que cont� la funci� heur�stica.
	 */
	public void calcularValorHeuristic(Heuristica heuristica) {
		valorHeuristic = heuristica.calcularValorHeuristic(this);
	}
	
	/**
	 * Aquest m�tode retorna els atributs de la classe Casella seguint un format espec�fic.
	 */
	public String toString() {
		return ("L'al�ada de la casella ("+fila+", "+columna+" �s: "+al�ada);
	}
	
	/**
	 * Aquest m�tode serveix per comprovar si la casella actual es igual o no a una casella que es passa per par�metre.
	 * @param casella �s la casella amb la qual es vol fer la comparaci�.
	 * @return si les dues caselles son iguals o no. 
	 */
	public boolean equals(Casella casella) {
		return ((this.fila == casella.fila) && (this.columna == casella.columna)); 
	}
}
