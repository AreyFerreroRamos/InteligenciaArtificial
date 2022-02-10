
public class Minimax extends Algorisme{

	public Minimax(int nivellMaxim, char colorOrdinador, char colorOponent, int direccioOrdinador, int direccioOponent) {
		this.nivellMaxim = nivellMaxim;
		this.colorOrdinador = colorOrdinador;
		this.colorOponent = colorOponent;
		this.direccioOrdinador = direccioOrdinador;
		this.direccioOponent = direccioOponent;
	}
	
	public Node minimax(Node node, int nivell, Heuristica heuristica) {
		Node nodeARetornar, nodeFill, nodeNou;
		int fi;
		
		fi = nodeFinal(node);
		if (fi != 0) {
			if (fi == 1) {
				nodeARetornar = node.clone();
				nodeARetornar.setValorHeuristic(20);
			}
			else {
				if (fi == -1) {
					nodeARetornar = node.clone();
					nodeARetornar.setValorHeuristic(-20);
				}
				else {
					nodeARetornar = node.clone();
					nodeARetornar.setValorHeuristic(-15);
				}
			}
		}
		else {
			if (nivell == nivellMaxim) {
				nodeARetornar = node.clone();
				nodeARetornar.setValorHeuristic(heuristica.calcularValorHeuristic(node));
			}
			else {
				nodeARetornar = node.clone();
				if (nivell % 2 == 0) {
					nodeARetornar.setValorHeuristic(-20);
					node.setColorOrdinador(colorOrdinador);
					node.setColorOponent(colorOponent);
					node.setDireccio(direccioOrdinador);
				}
				else {
					nodeARetornar.setValorHeuristic(20);
					node.setColorOrdinador(colorOponent);
					node.setColorOponent(colorOrdinador);
					node.setDireccio(direccioOponent);
				}
				while (quedenNodesFills(node)) {
					nodeFill = seguentNodeFill(node);
					nodeNou = minimax(nodeFill, nivell + 1, heuristica);
					if (nivell % 2 == 0) {
						if (nodeNou.getValorHeuristic() >= nodeARetornar.getValorHeuristic()) {
							nodeARetornar = nodeFill.clone();
							nodeARetornar.setValorHeuristic(nodeNou.getValorHeuristic());
							
						}
					}
					else {
						if (nodeNou.getValorHeuristic() <= nodeARetornar.getValorHeuristic()) {
							nodeARetornar = nodeFill.clone();
							nodeARetornar.setValorHeuristic(nodeNou.getValorHeuristic());
						}
					}
				}
			}
		}
		return nodeARetornar;
	}
	
	@Override
	public Node calcularMoviment(Node node, int nivell, Heuristica heuristica) {
		return minimax(node, nivell, heuristica);
	}
}
