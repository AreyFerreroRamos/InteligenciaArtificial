
public abstract class Algorisme {
	protected int nivellMaxim;
	protected char colorOrdinador;
	protected char colorOponent;
	protected int direccioOrdinador;
	protected int direccioOponent;
	
	protected int nodeFinal(Node node) {
		int fila = 0, columna, contadorBlanques = 0, contadorNegres = 0;
		boolean fiOrdinador = true, fiOponent = true;
		
		while ((fiOrdinador == true && fiOponent == true) && (fila < node.getMaxFiles())) {
			columna = 0;
			while ((fiOrdinador == true && fiOponent == true) && (columna < node.getMaxColumnes())) {
				if (node.getTaulell()[fila][columna] == 'B') {
					if (fiOponent == false) {
						fiOrdinador = false;
					}
					else {
						if (((fila - 1 >= 0) && (((columna - 1 >= 0) && (node.getTaulell()[fila - 1][columna - 1] == '-')) || ((columna + 1 < node.getMaxColumnes()) && (node.getTaulell()[fila - 1][columna + 1] == '-')))) || ((fila - 2 >= 0) && (((columna - 2 >= 0) && (node.getTaulell()[fila - 2][columna - 2] == '-') && (node.getTaulell()[fila - 1][columna - 1] == 'B')) || ((columna + 2 < node.getMaxColumnes()) && (node.getTaulell()[fila - 2][columna + 2] == '-') && (node.getTaulell()[fila - 1][columna + 1] == 'B'))))) {
							fiOrdinador = false;
						}
					}
				}
				else {
					if (node.getTaulell()[fila][columna] == 'N') {
						if (fiOrdinador == false) {
							fiOponent = false;
						}
						else {
							if (((fila + 1 < node.getMaxFiles()) && (((columna - 1 >= 0) && (node.getTaulell()[fila + 1][columna - 1] == '-')) || ((columna + 1 < node.getMaxColumnes()) && (node.getTaulell()[fila + 1][columna + 1] == '-')))) || ((fila + 2 < node.getMaxFiles()) && (((columna - 2 >= 0) && (node.getTaulell()[fila + 2][columna - 2] == '-') && (node.getTaulell()[fila + 1][columna - 1] == 'N')) || ((columna + 2 < node.getMaxColumnes()) && (node.getTaulell()[fila + 2][columna + 2] == '-') && (node.getTaulell()[fila + 1][columna + 1] == 'N'))))) {
								fiOponent = false;
							}
						}
					}
				}
				columna++;
			}
			fila++;
		}
		if (fiOrdinador && fiOponent) {
			while ((contadorBlanques == contadorNegres) && (fila < node.getMaxFiles())) {
				for (columna = 0; columna < node.getMaxColumnes(); columna++) {
					if (node.getTaulell()[fila][columna] == 'B') {
						contadorBlanques++;
					}
					if (node.getTaulell()[node.getMaxFiles() - fila - 1][columna] == 'N')	{
						contadorNegres++;
					}
				}
				fila++;
			}
			if (contadorBlanques > contadorNegres) {
				if (colorOrdinador == 'B') {
					return 1;
				}
				else {
					return -1;
				}
			}
			else {
				if (contadorBlanques < contadorNegres) {
					if (colorOrdinador == 'N') {
						return 1;
					}
					else {
						return -1;
					}
				}
				else {
					return 2;
				}
			}
		}
		else {
			return 0;
		}
	}
	
	private boolean calcularLimitFila(Node node, int num) {
		if (node.getDireccio() == 1) {
			return (node.getPosFila() + num < node.getMaxFiles());
		}
		else {
			return (node.getPosFila() - num >= 0);
		}
	}
	
	protected boolean quedenNodesFills(Node node) {
		int numJugadaAnterior = node.getNumJugada();
		
		while ((numJugadaAnterior == node.getNumJugada()) && (node.getPosFila() < node.getMaxFiles())) {
			while ((numJugadaAnterior == node.getNumJugada()) && (node.getPosColumna() < node.getMaxColumnes())) {
				if (node.getTaulell()[node.getPosFila()][node.getPosColumna()] == node.getColorOrdinador()) {
						if (calcularLimitFila(node, 1)) {
							if ((node.getNumJugada() < 1) && (node.getPosColumna() - 1 >= 0) && (node.getTaulell()[node.getPosFila() + node.getDireccio()][node.getPosColumna() - 1] == '-')) {
								node.setNumJugada(1);
							}
							else {
								if ((node.getNumJugada() < 2) && (node.getPosColumna() + 1 < node.getMaxColumnes()) && (node.getTaulell()[node.getPosFila() + node.getDireccio()][node.getPosColumna() + 1] == '-')) {
									node.setNumJugada(2);
								}
								else {
									if (calcularLimitFila(node, 2)) {
										if ((node.getNumJugada() < 3) && (node.getPosColumna() - 2 >= 0) && (node.getTaulell()[node.getPosFila() + node.getDireccio() * 2][node.getPosColumna() - 2] == '-') && (node.getTaulell()[node.getPosFila() + node.getDireccio()][node.getPosColumna() - 1] == node.getColorOponent())) {
											node.setNumJugada(3);
										}
										else {
											if ((node.getPosColumna() + 2 < node.getMaxColumnes()) && (node.getTaulell()[node.getPosFila() + node.getDireccio() * 2][node.getPosColumna() + 2] == '-') && (node.getTaulell()[node.getPosFila() + node.getDireccio()][node.getPosColumna() + 1] == node.getColorOponent())) {
												node.setNumJugada(4);
											}
										}
									}
								}
							}
						}
				}
				if (numJugadaAnterior == node.getNumJugada()) {
					node.setPosColumna(node.getPosColumna() + 1);
					node.setNumJugada(0);
					numJugadaAnterior = node.getNumJugada();
				}
			}
			if (numJugadaAnterior == node.getNumJugada()) {
				node.setPosColumna(0);
				node.setPosFila(node.getPosFila() + 1);
			}
		}
		if (numJugadaAnterior == node.getNumJugada()) {
			node.setPosFila(0);
		}
		return (numJugadaAnterior != node.getNumJugada());
	}
	
	protected Node seguentNodeFill(Node node) {
		Node nodeFill = node.clone();
		
		switch (node.getNumJugada()) {
			case 1:
				nodeFill.setPosTaulell(node.getColorOrdinador(), node.getPosFila() + node.getDireccio(), node.getPosColumna() - 1);
				break;
			case 2:
				nodeFill.setPosTaulell(node.getColorOrdinador(), node.getPosFila() + node.getDireccio(), node.getPosColumna() + 1);
				break;
			case 3:
				nodeFill.setPosTaulell(node.getColorOrdinador(), node.getPosFila() + node.getDireccio() * 2, node.getPosColumna() - 2);
				nodeFill.setPosTaulell('-', node.getPosFila() + node.getDireccio(), node.getPosColumna() - 1);
				break;
			case 4:
				nodeFill.setPosTaulell(node.getColorOrdinador(), node.getPosFila() + node.getDireccio() * 2, node.getPosColumna() + 2);
				nodeFill.setPosTaulell('-', node.getPosFila() + node.getDireccio(), node.getPosColumna() + 1);
				break;
		}
		nodeFill.setPosTaulell('-', node.getPosFila(), node.getPosColumna());
		return nodeFill;
	}
	
	public abstract Node calcularMoviment(Node node, int nivell, Heuristica heuristica);
}
