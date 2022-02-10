import java.io.*;
import java.util.*;

public class ProvarJocDames {
	static final int MAX_FILES = 8;
	static final int MAX_COLUMNES = 8;
	
	static Scanner teclat = new Scanner(System.in);
	static char[][] taulell = new char[MAX_FILES][MAX_COLUMNES];
	static int nivellMaxim;
	
	public static void inicialitzarTaulell() {
		int fila, columna;
		boolean peça = false;
		
		for (fila = 0; fila < MAX_FILES; fila++) {
			for (columna = 0; columna < MAX_COLUMNES; columna++) {
				if (fila < 3) {
					if (peça) {
						taulell[fila][columna] = '-';
					}
					else {
						taulell[fila][columna] = 'N';
					}
					peça = !peça;
				}
				else {
					if (fila < 5) {
						taulell[fila][columna] = '-';
					}
					else {
						if (peça) {
							taulell[fila][columna] = '-';
						}
						else {
							taulell[fila][columna] = 'B';
						}
						peça = !peça;
					}
				}
			}
			peça = !peça;
		}
	}
	
	public static void mostrarOpcionsJoc() {
		System.out.println("Tria el tipus de joc: ");
		System.out.println("1 - Màquina contra màquina");
		System.out.println("2 - Màquina contra humà");
	}
	
	public static void mostrarOpcionsAlgorismes() {
		System.out.println("\t1 - Algorisme Minimax");
		System.out.println("\t2 - Algorisme Poda alfa-beta");
	}
	
	public static Algorisme seleccionarAlgorisme(int nivellMaxim, char primerColor, char segonColor, int direccio) {
		Algorisme algorisme = null;
		
		switch (teclat.nextInt()) {
			case 1:
				algorisme = new Minimax(nivellMaxim, primerColor, segonColor, direccio, -direccio);
				break;
			case 2:
				algorisme = new PodaAlfaBeta(nivellMaxim, primerColor, segonColor, direccio, -direccio);
				break;
		}
		return algorisme;
	}
	
	public static void mostrarOpcionsHeuristiques() {
		System.out.println("\t1 - Primera heurística");
		System.out.println("\t2 - Segona heurística");
		System.out.println("\t3 - Tercera heurística");
	}
	
	public static Heuristica seleccionarHeuristica(char primerColor, char segonColor) {
		Heuristica heuristica = null;
		
		switch (teclat.nextInt()) {
			case 1:
				heuristica = new PrimeraHeuristica(primerColor, segonColor);
				break;
			case 2:
				heuristica = new SegonaHeuristica(primerColor, segonColor);
				break;
			case 3:
				heuristica = new TerceraHeuristica(primerColor, segonColor);
				break;
		}
		return heuristica;
	}
	
	public static void mostrarTaulell() {
		int fila, columna;
		
		System.out.println("\tA B C D E F G H\n");
		for (fila = 0; fila < MAX_FILES; fila++) {
			System.out.print((9 - (fila + 1))+"\t");
			for (columna = 0; columna < MAX_COLUMNES; columna++) {
				System.out.print(taulell[fila][columna]+" ");
			}
			System.out.println("\t"+(9 - (fila + 1)));
		}
		System.out.println("\n\tA B C D E F G H\n");
	}
	
	public static void esperarFinsReturn() {
		try {
			System.in.read();
		}
		catch (IOException exception) {
			System.out.println("Exception: "+exception);
		}
		try {
			System.in.read();
		}
		catch (IOException exception) {
			System.out.println("Exception: "+exception);
		}
	}
	
	public static boolean hiHaMovimentsPossibles() {
		int fila = 0, columna;
		boolean trobat = false;
		
		while ((!trobat) && (fila < MAX_FILES)) {
			columna = 0;
			while ((!trobat) && (columna < MAX_COLUMNES)) {
				if ((taulell[fila][columna] == 'B') && (((fila - 1 >= 0) && (((columna - 1 >= 0) && (taulell[fila - 1][columna - 1] == '-'))  || ((columna + 1 < MAX_COLUMNES) && (taulell[fila - 1][columna + 1] == '-')))) || ((fila - 2 >= 0) && (((columna - 2 >= 0) && (taulell[fila - 2][columna - 2] == '-')) || ((columna + 2 < MAX_COLUMNES) && (taulell[fila - 2][columna + 2] == '-')))))) {
					trobat = true;
				}
				else {
					if ((taulell[fila][columna] == 'N') && (((fila + 1 < MAX_FILES) && (((columna - 1 >= 0) && (taulell[fila + 1][columna - 1] == '-'))  || ((columna + 1 < MAX_COLUMNES) && (taulell[fila + 1][columna + 1] == '-')))) || ((fila + 2 < MAX_COLUMNES) && (((columna - 2 >= 0) && (taulell[fila + 2][columna - 2] == '-')) || ((columna + 2 < MAX_COLUMNES) && (taulell[fila + 2][columna + 2] == '-')))))) {
						trobat = true;
					}
					else {
						columna++;
					}
				}
			}
			fila++;
		}
		return trobat;
	}
	
	public static void calcularMovimentUsuari(char coloUsuari, char coloOrdinador) {
		String posicioOrigen;
		String posicioFinal;
		int filaInicial, columnaInicial, filaFinal, columnaFinal;
		char aux;
		
		do {
			System.out.println("Introdueix la posició de la peça que vols moure: ");
			posicioOrigen = teclat.next();
			filaInicial = 8 - (posicioOrigen.charAt(1) - 48);
			columnaInicial = posicioOrigen.charAt(0) - 65;
		} while (((taulell[filaInicial][columnaInicial] != 'B') || (((filaInicial - 1 < 0) || (((columnaInicial - 1 < 0) || (taulell[filaInicial - 1][columnaInicial - 1] != '-')) && ((columnaInicial + 1 >= MAX_COLUMNES) || (taulell[filaInicial - 1][columnaInicial + 1] != '-')))) && ((filaInicial - 2 < 0) || (((columnaInicial - 2 < 0) || (taulell[filaInicial - 2][columnaInicial - 2] != '-') || (taulell[filaInicial - 1][columnaInicial - 1] != 'N')) && ((columnaInicial + 2 >= MAX_COLUMNES) || (taulell[filaInicial - 2][columnaInicial + 2] != '-') || (taulell[filaInicial - 1][columnaInicial + 1] != 'N')))))) && ((taulell[filaInicial][columnaInicial] != 'N') || (((filaInicial + 1 >= MAX_FILES) || (((columnaInicial - 1 < 0) || (taulell[filaInicial + 1][columnaInicial - 1] != '-')) && ((columnaInicial + 1 >= MAX_COLUMNES) || (taulell[filaInicial + 1][columnaInicial + 1] != '-')))) && ((filaInicial + 2 >= MAX_FILES) || (((columnaInicial - 2 < 0) || (taulell[filaInicial + 2][columnaInicial - 2] != '-') || (taulell[filaInicial + 1][columnaInicial - 1] != 'B')) && ((columnaInicial + 2 >= MAX_COLUMNES) || (taulell[filaInicial + 2][columnaInicial + 2] != '-') || (taulell[filaInicial + 1][columnaInicial + 1] != 'B')))))));
		aux = taulell[filaInicial][columnaInicial];
		taulell[filaInicial][columnaInicial] = '-';
		do {
			System.out.println("Introdueix la posició a on vols moure aquesta peça: ");
			posicioFinal = teclat.next();
			filaFinal = 8 - (posicioFinal.charAt(1) - 48);
			columnaFinal = posicioFinal.charAt(0) - 65;
		} while (((taulell[filaFinal][columnaFinal] != '-') || ( ((filaFinal - filaInicial != -1) || ((columnaFinal - columnaInicial != -1) && (columnaFinal - columnaInicial != 1))) && ((filaFinal - filaInicial != -2) || (((columnaFinal - columnaInicial != -2) || (taulell[filaFinal + 1][columnaFinal + 1] != 'N')) && ((columnaFinal - columnaInicial != 2) || (taulell[filaFinal + 1][columnaFinal - 1] != 'N')))))) && ((taulell[filaFinal][columnaFinal] != '-') || (((filaFinal - filaInicial != 1) || ((columnaFinal - columnaInicial != -1) && (columnaFinal - columnaInicial != 1))) && ((filaFinal - filaInicial != 2) || (((columnaFinal - columnaInicial != -2) || (taulell[filaFinal + 1][columnaFinal + 1] != 'B')) && ((columnaFinal - columnaInicial != 2) || (taulell[filaFinal + 1][columnaFinal - 1] != 'B')))))));
		taulell[filaFinal][columnaFinal] = aux;
		if (filaFinal - filaInicial == -2) {
			if (columnaFinal < columnaInicial) {
				taulell[filaInicial - 1][columnaInicial - 1] = '-';
			}
			else {
				taulell[filaInicial - 1][columnaInicial + 1] = '-';
			}
		}
		else {
			if (filaFinal - filaInicial == 2) {
				if (columnaFinal < columnaInicial) {
					taulell[filaInicial + 1][columnaInicial - 1] = '-';
				}
				else {
					taulell[filaInicial + 1][columnaInicial + 1] = '-';
				}
			}
		}
	}
	
	public static void jugadaUsuari(char colorUsuari, char colorOrdinador) {
		if (hiHaMovimentsPossibles()) {
			calcularMovimentUsuari(colorUsuari, colorOrdinador);
			mostrarTaulell();
			esperarFinsReturn();
		}
		else {
			System.out.println("No pots efectuar cap moviment perquè totes les teves peces estan bloquejades.");
		}
	}
	
	public static void jugadaOrdinador(Algorisme algorisme, Heuristica heuristica) {
		Node node = new Node();
		double temps;
		long inici, fi;
		
		node.setTaulell(taulell);
		inici = System.currentTimeMillis();
		node = algorisme.calcularMoviment(node, 0, heuristica);
		fi = System.currentTimeMillis();
		taulell = node.getTaulell();
		mostrarTaulell();
		temps = ((double)(fi - inici) / 1000);
		System.out.println("Temps d'execució algorisme: "+temps);
		esperarFinsReturn();
	}
	
	public static boolean finalJoc() {
		int fila = 0, columna;
		boolean finalJocBlanques = true, finalJocNegres = true;
		
		while ((finalJocBlanques && finalJocNegres) && (fila < MAX_FILES)) {
			columna = 0;
			while ((finalJocBlanques && finalJocNegres) && (columna < MAX_COLUMNES)) {
				if (taulell[fila][columna] == 'B') {
					if (finalJocNegres == false) {
						finalJocBlanques = false;
					}
					else {
						if (((fila - 1 >= 0) && (((columna - 1 >= 0) && (taulell[fila - 1][columna - 1] == '-')) || ((columna + 1 < MAX_COLUMNES) && (taulell[fila - 1][columna + 1] == '-')))) || ((fila - 2 >= 0) && (((columna - 2 >= 0) && (taulell[fila - 2][columna - 2] == '-') && (taulell[fila - 1][columna - 1] == 'B')) || ((columna + 2 < MAX_COLUMNES) && (taulell[fila - 2][columna + 2] == '-') && (taulell[fila - 1][columna + 1] == 'B'))))) {
							finalJocBlanques = false;
						}
					}
				}
				else {
					if (taulell[fila][columna] == 'N') {
						if (finalJocBlanques == false) {
							finalJocNegres = false;
						}
						else {
							if (((fila + 1 < MAX_FILES) && (((columna - 1 >= 0) && (taulell[fila + 1][columna - 1] == '-')) || ((columna + 1 < MAX_COLUMNES) && (taulell[fila + 1][columna + 1] == '-')))) || ((fila + 2 < MAX_FILES) && (((columna - 2 >= 0) && (taulell[fila + 2][columna - 2] == '-') && (taulell[fila + 1][columna - 1] == 'N')) || ((columna + 2 < MAX_COLUMNES) && (taulell[fila + 2][columna + 2] == '-') && (taulell[fila + 1][columna + 1] == 'N'))))) {
								finalJocNegres = false;
							}
						}
					}
				}
				columna++;
			}
			fila++;
		}
		return (finalJocBlanques && finalJocNegres);
	}
	
	public static void seleccionarGuanyador() {
		int fila = 0, columna, contadorBlanques = 0, contadorNegres = 0;
		
		while ((contadorBlanques == contadorNegres) && (fila < MAX_FILES)) {
			for (columna = 0; columna < MAX_COLUMNES; columna++) {
				if (taulell[fila][columna] == 'B') {
					contadorBlanques++;
				}
				if (taulell[MAX_FILES - fila - 1][columna] == 'N')	{
					contadorNegres++;
				}
			}
			fila++;
		}
		if (contadorBlanques > contadorNegres) {
			System.out.println("Han guanyat les peces blanques.");
		}
		else {
			if (contadorBlanques < contadorNegres) {
				System.out.println("Han guanyat les peces negres.");
			}
			else {
				System.out.println("S'ha produït un empat.");
			}
		}
	}
	
	public static void jocMaquinaContraMaquina() {
		Algorisme primerAlgorisme, segonAlgorisme;
		Heuristica primeraHeuristica, segonaHeuristica;
		char colorPrimerJugador = 'N', colorSegonJugador = 'B';
		int direccio = 1;
		
		System.out.println("Tria l'algorisme que utilitzarà el primer jugador: ");
		mostrarOpcionsAlgorismes();
		primerAlgorisme = seleccionarAlgorisme(nivellMaxim, colorPrimerJugador, colorSegonJugador, direccio);
		System.out.println("Tria l'heurística del primer jugador: ");
		mostrarOpcionsHeuristiques();
		primeraHeuristica = seleccionarHeuristica(colorPrimerJugador, colorSegonJugador);
		System.out.println("Tria l'algorisme que utilitzarà el segon jugador: ");
		mostrarOpcionsAlgorismes();
		segonAlgorisme = seleccionarAlgorisme(nivellMaxim, colorSegonJugador, colorPrimerJugador, -direccio);
		System.out.println("Tria l'heurística del segon jugador: ");
		mostrarOpcionsHeuristiques();
		segonaHeuristica = seleccionarHeuristica(colorSegonJugador, colorPrimerJugador);
		mostrarTaulell();
		System.out.println("Prem ENTER per inicar el joc.");
		esperarFinsReturn();
		do {
			jugadaOrdinador(primerAlgorisme, primeraHeuristica);
			jugadaOrdinador(segonAlgorisme, segonaHeuristica);
		} while (!finalJoc());
	}
	
	public static void jocMaquinaContraHuma() {
		Algorisme algorisme = null;
		Heuristica heuristica = null;
		char colorUsuari, colorOrdinador;
		int direccio;
		
		do {
			System.out.println("Introdueix el color amb el que vols jugar: ");
			colorUsuari = teclat.next().charAt(0);
		} while ((colorUsuari != 'B') && (colorUsuari != 'b') && (colorUsuari != 'N') && (colorUsuari != 'n'));
		if ((colorUsuari == 'B') || (colorUsuari == 'b')) {
			colorUsuari = 'B';
			colorOrdinador = 'N';
			direccio = 1;
		}
		else {
			colorUsuari = 'N';
			colorOrdinador = 'B';
			direccio = -1;
		}
		System.out.println("Tria l'algorisme que utilitzarà l'ordinador: ");
		mostrarOpcionsAlgorismes();
		algorisme = seleccionarAlgorisme(nivellMaxim, colorOrdinador, colorUsuari, direccio);
		System.out.println("Tria l'heurística que utilitzarà l'ordinador: ");
		mostrarOpcionsHeuristiques();
		heuristica = seleccionarHeuristica(colorOrdinador, colorUsuari);
		mostrarTaulell();
		System.out.println("Prem ENTER per inicar el joc.");
		esperarFinsReturn();
		if (colorUsuari == 'B') {
			do {
				jugadaOrdinador(algorisme, heuristica);
				jugadaUsuari(colorUsuari, colorOrdinador);
			} while (!finalJoc());
		}
		else {
			if (colorUsuari == 'N') {
				do {		
					jugadaUsuari(colorUsuari, colorOrdinador);
					jugadaOrdinador(algorisme, heuristica);
				} while (!finalJoc());
			}
		}
	}
		
	public static void main(String[] args) {
		inicialitzarTaulell();
		System.out.println("Introdueix el nombre màxim de nivells d'exploració que vols que tingui l'algorisme o algorismes de cerca utilitzats: ");
		nivellMaxim = teclat.nextInt();
		mostrarOpcionsJoc();
		switch (teclat.nextInt()) {
			case 1:
				jocMaquinaContraMaquina();
				break;
			case 2:
				jocMaquinaContraHuma();
				break;
		}
		seleccionarGuanyador();
		teclat.close();
	}
}
