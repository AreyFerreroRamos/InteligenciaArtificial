
public class TerceraHeuristica extends Heuristica{

	public TerceraHeuristica(char colorOrdinador, char colorOponent) {
		this.colorOrdinador = colorOrdinador;
		this.colorOponent = colorOponent;
	}
	
	private int valorPecesDefensa(Node node, int fila, char color) {
		int contDefensa = 0;
		
		if (node.getTaulell()[fila][1] == color) {
			if (node.getTaulell()[fila][3] == color) {
				if (node.getTaulell()[fila][5] == color) {
					if (node.getTaulell()[fila][7] == color) {
						contDefensa = 13;
					}
					else {
						contDefensa = 12;
					}
				}
				else {
					if (node.getTaulell()[fila][7] == color) {
						contDefensa = 10;
					}
					else {
						contDefensa = 7;
					}
				}
				contDefensa = 7;
			}
			else {
				if (node.getTaulell()[fila][5] == color) {
					if (node.getTaulell()[fila][7] == color) {
						contDefensa = 11;
					}
					else {
						contDefensa = 9;
					}
				}
				else {
					if (node.getTaulell()[fila][7] == color) {
						contDefensa = 5;
					}
					else {
						contDefensa = 2;
					}
				}
			}
		}
		else {
			if (node.getTaulell()[fila][3] == color) {
				if (node.getTaulell()[fila][5] == color) {
					if (node.getTaulell()[fila][7] == color) {
						contDefensa = 9;
					}
					else {
						contDefensa = 8;
					}
				}
				else {
					if (node.getTaulell()[fila][7] == color) {
						contDefensa = 7;
					}
					else {
						contDefensa = 4;
					}
				}
			}
			else {
				if (node.getTaulell()[fila][5] == color) {
					if (node.getTaulell()[fila][7] == color) {
						contDefensa = 6;
					}
					else {
						contDefensa = 3;
					}
				}
				else {
					if (node.getTaulell()[fila][7] == color) {
						contDefensa = 1;
					}
				}
			}
		}
		return contDefensa;
	}
	
	@Override
	public int calcularValorHeuristic(Node node) {
		int fila, columna, contPecesOrdinador = 0, contPecesOponent = 0;
		
		contPecesOrdinador = valorPecesDefensa(node, 0, colorOrdinador);
		contPecesOponent = valorPecesDefensa(node, node.getMaxFiles() - 1, colorOponent);
		for (fila = 0; fila < node.getMaxFiles(); fila++) {
			for (columna = 0; columna < node.getMaxColumnes(); columna++) {
				if (node.getTaulell()[fila][columna] == colorOrdinador) {
					contPecesOrdinador += 2;
				}
				else {
					if (node.getTaulell()[fila][columna] == colorOponent) {
						contPecesOponent += 2;
					}
				}
			}
		}
		return (contPecesOrdinador - contPecesOponent);
	}

}
