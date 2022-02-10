
public class SegonaHeuristica extends Heuristica{

	public SegonaHeuristica(char colorOrdinador, char colorOponent) {
		this.colorOrdinador = colorOrdinador;
		this.colorOponent = colorOponent;
	}
	
	@Override
	public int calcularValorHeuristic(Node node) {
		int fila, columna, contPecesVoraOrdinador = 0, contPecesVoraOponent = 0, contDamesOrdinador = 0, contDamesOponent = 0;
		
		for (columna = 0; columna < node.getMaxColumnes(); columna++) {
			if (node.getTaulell()[0][columna] == colorOponent) {
				contDamesOponent += 2;
			}
		}
		for (fila = 1; fila < node.getMaxFiles() - 1; fila++) {
			if (node.getTaulell()[fila][0] == colorOrdinador) {
				contPecesVoraOrdinador++;
			}
			else {
				if (node.getTaulell()[fila][0] == colorOponent) {
					contPecesVoraOrdinador++;
				}
			}
			if (node.getTaulell()[fila][node.getMaxColumnes() - 1] == colorOrdinador) {
				contPecesVoraOrdinador++;
			}
			else {
				if (node.getTaulell()[fila][node.getMaxColumnes() - 1] == colorOponent) {
					contPecesVoraOrdinador++;
				}
			}
		}
		for (columna = 0; columna < node.getMaxColumnes(); columna++) {
			if (node.getTaulell()[0][columna] == colorOrdinador) {
				contDamesOrdinador += 2;
			}
		}
		return ((contPecesVoraOrdinador + contDamesOrdinador) - (contPecesVoraOponent + contDamesOponent));
	}

}
