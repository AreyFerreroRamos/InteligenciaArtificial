
public class PodaAlfaBeta extends Algorisme{
	
	public PodaAlfaBeta(int nivellMaxim, char colorOrdinador, char colorOponent, int direccioOrdinador, int direccioOponent) {
		this.nivellMaxim = nivellMaxim;
		this.colorOrdinador = colorOrdinador;
		this.colorOponent = colorOponent;
		this.direccioOrdinador = direccioOrdinador;
		this.direccioOponent = direccioOponent;
	}

	public Node podaAlfaBeta(Node node, int nivell, int alfa, int beta,  Heuristica heuristica) {
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
				while ((quedenNodesFills(node)) && (alfa < beta)) {
					nodeFill = seguentNodeFill(node);
					nodeNou = podaAlfaBeta(nodeFill, nivell + 1, alfa, beta, heuristica);
					if (nivell % 2 == 0) {
						if (nodeNou.getValorHeuristic() >= alfa) {
							alfa = nodeNou.getValorHeuristic();
							nodeARetornar = nodeFill.clone();
						}
					}
					else {
						if (nodeNou.getValorHeuristic() <= beta) {
							beta = nodeNou.getValorHeuristic();
							nodeARetornar = nodeFill.clone();
						}
					}
				}
				if (nivell % 2 == 0) {
					nodeARetornar.setValorHeuristic(alfa);
				}
				else {
					nodeARetornar.setValorHeuristic(beta);
				}
			}
		}
		return nodeARetornar;
	}
	
	@Override
	public Node calcularMoviment(Node node, int nivell, Heuristica heuristica) {
		return (podaAlfaBeta(node, nivell, -20, 20, heuristica));
	}
}
