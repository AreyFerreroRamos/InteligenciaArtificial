
public class PrimeraHeuristica extends Heuristica{
	
	public PrimeraHeuristica(char colorOrdinador, char colorOponent) {
		this.colorOrdinador = colorOrdinador;
		this.colorOponent = colorOponent;
	}
	
	@Override
	public int calcularValorHeuristic(Node node) {
		int fila, columna, contPecesOrdinador = 0, contPecesOponent = 0;
		
		for (fila = 0; fila < node.getMaxFiles(); fila++) {
			for (columna = 0; columna < node.getMaxColumnes(); columna++) {
				if (node.getTaulell()[fila][columna] == colorOrdinador) {
					contPecesOrdinador++;
				}
				else {
					if (node.getTaulell()[fila][columna] == colorOponent) {
						contPecesOponent++;
					}
				}
			}
		}
		return (contPecesOrdinador - contPecesOponent);
	}
}
