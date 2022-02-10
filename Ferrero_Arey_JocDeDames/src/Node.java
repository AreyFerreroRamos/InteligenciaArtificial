
public class Node {
	private final int MAX_FILES = 8;
	private final int MAX_COLUMNES = 8;
	
	private char[][] taulell;
	private int posFila;
	private int posColumna;
	private int numJugada;
	private int valorHeuristic;
	private char colorOrdinador;
	private char colorOponent;
	private int direccio;
	
	public Node() {
		taulell = new char[MAX_FILES][MAX_COLUMNES];
		posFila = 0;
		posColumna = 0;
		numJugada = 0;
	}
	
	public int getMaxFiles() {
		return MAX_FILES;
	}
	
	public int getMaxColumnes() {
		return MAX_COLUMNES;
	}
	
	public char[][] getTaulell() {
		return taulell;
	}
	
	public int getValorHeuristic() {
		return valorHeuristic;
	}
	
	public int getPosFila() {
		return posFila;
	}
	
	public int getPosColumna() {
		return posColumna;
	}
	
	public int getNumJugada() {
		return numJugada;
	}
	
	public char getColorOrdinador() {
		return colorOrdinador;
	}
	
	public char getColorOponent() {
		return colorOponent;
	}
	
	public int getDireccio() {
		return direccio;
	}
	
	public void setTaulell(char[][] taulell) {
		int fila, columna;
		
		for (fila = 0; fila < MAX_FILES; fila++) {
			for (columna = 0; columna < MAX_COLUMNES; columna++) {
				this.taulell[fila][columna] = taulell[fila][columna];
			}
		}
	}
	
	public void setPosTaulell(char caracter, int fila, int columna) {
		taulell[fila][columna] = caracter;
	}
	
	public void setValorHeuristic(int valorHeuristic) {
		this.valorHeuristic = valorHeuristic;
	}
	
	public void setPosFila(int posFila) {
		this.posFila = posFila;
	}
	
	public void setPosColumna(int posColumna) {
		this.posColumna = posColumna;
	}
	
	public void setNumJugada(int numJugada) {
		this.numJugada = numJugada;
	}
	
	public void setColorOrdinador(char colorOrdinador) {
		this.colorOrdinador = colorOrdinador;
	}
	
	public void setColorOponent(char colorOponent) {
		this.colorOponent = colorOponent;
	}
	
	public void setDireccio(int direccio) {
		this.direccio = direccio;
	}
	
	public Node clone() {
		Node node = new Node();
		node.setTaulell(this.taulell);
		return (node);
	}
}
