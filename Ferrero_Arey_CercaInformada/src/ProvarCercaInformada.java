import java.io.*;
import java.util.*;

public class ProvarCercaInformada{

	static final int MAX_FILES = 10;
	static final int MAX_COLUMNES = 10;
	
	static Scanner teclat = new Scanner(System.in);
	static int[][] mapa = new int[MAX_FILES][MAX_COLUMNES];
	static Tractats tractats;
	static Pendents pendents;
	static Cami cami;
	static Heuristica heuristica;
	static Casella casellaInicial, casellaFinal;
	static int exploracions;
	
	public static void llegirFitxer(String nomFitxer) {
		BufferedReader fitxer;
		StringTokenizer tokenizer;
		String linia;
		int columna, fila = 0;
		
		try {
			fitxer = new BufferedReader(new FileReader(nomFitxer));
			linia = fitxer.readLine();
			while ((linia != null) && (fila < MAX_FILES)) {
				tokenizer = new StringTokenizer(linia, " ");
				columna = 0;
				while ((tokenizer.hasMoreTokens()) && (columna < MAX_COLUMNES)) {
					mapa[fila][columna] = Integer.parseInt(tokenizer.nextToken());
					columna++;
				}
				fila++;
				linia = fitxer.readLine();
			}
			fitxer.close();
		}
		catch (FileNotFoundException exception) {
			System.out.println("L'arxiu d'entrada no existeix");
		}
		catch (IOException exception) {
			System.out.println("S'ha produït un error en la lectura de l'arxiu");
		}
	}
	
	public static void InicialitzarPosicions() {
		StringTokenizer tokenizer;
		String posicio;
		int filaInicial, columnaInicial, filaFinal, columnaFinal;
		
		System.out.println("Introdueix la posició inicial: ");
		posicio = teclat.nextLine();
		tokenizer = new StringTokenizer(posicio, ", ");
		filaInicial = Integer.parseInt(tokenizer.nextToken());
		columnaInicial = Integer.parseInt(tokenizer.nextToken());
		
		System.out.println("Introdueix la posició final: ");
		posicio = teclat.nextLine();
		tokenizer = new StringTokenizer(posicio, ", ");
		filaFinal = Integer.parseInt(tokenizer.nextToken());
		columnaFinal = Integer.parseInt(tokenizer.nextToken());
		
		casellaInicial = new Casella(mapa[filaInicial][columnaInicial], filaInicial, columnaInicial);
		casellaFinal = new Casella(mapa[filaFinal][columnaFinal], filaFinal, columnaFinal);
	}
	
	public static void opcionsAlgorismes() {
		System.out.println("Tria l'algorisme que vols utilitzar: ");
		System.out.println("1 - Algorisme best first");
		System.out.println("2 - Algorisme A*");
	}
	
	public static void opcionsHeuristiques() {
		System.out.println("Tria l'heurística que vols utilitzar: ");
		System.out.println("1 - Heurística bona.");
		System.out.println("2 - Heurística molt bona.");
		System.out.println("3 - Heurística admissible.");
	}
	
	public static void obtenirSuccessor(Casella casellaActual, int fila, int columna) {
		if ((fila >= 0) && (fila < MAX_FILES) && (columna >= 0) && (columna < MAX_COLUMNES) && (mapa[fila][columna] != -1)) {
			Casella casellaSuccessora = new Casella(mapa[fila][columna], fila, columna);
			
			if ((!tractats.casellaContinguda(casellaSuccessora)) && (!pendents.casellaContinguda(casellaSuccessora))) {
				casellaSuccessora.calcularCami(casellaActual.getCami(), casellaActual);
				casellaSuccessora.calcularCostAcumulat(casellaActual);
				casellaSuccessora.calcularValorHeuristic(heuristica);
				pendents.afegirCasella(casellaSuccessora);
			}
		}
	}
	
	public static void cercarCami(Casella casellaActual, Casella casellaFinal) {
		cami = null;
		boolean trobat = false;
		
		exploracions = 0;
		pendents.afegirCasella(casellaActual);
		while ((!trobat) && (pendents.hiHaCaselles())) {
			casellaActual = pendents.agafarCasella();
			pendents.esborrarCasella(casellaActual);
			if (casellaActual.equals(casellaFinal)) {
				trobat = true;
				casellaFinal.setCostAcumulat(casellaActual.getCostAcumulat());
				cami = new Cami(casellaActual.getCami());
				cami.afegirCasella(casellaActual);
			}
			else {
				obtenirSuccessor(casellaActual, casellaActual.getFila(), casellaActual.getColumna() - 1);
				obtenirSuccessor(casellaActual, casellaActual.getFila() - 1, casellaActual.getColumna());
				obtenirSuccessor(casellaActual, casellaActual.getFila(), casellaActual.getColumna() + 1);
				obtenirSuccessor(casellaActual, casellaActual.getFila() + 1, casellaActual.getColumna());
				tractats.afegirCasella(casellaActual);
				exploracions++;
			}
		}
	}
	
	public static void mostrarCami() {
		int fila, columna;
		
		System.out.print("\n");
		for (fila = 0; fila < MAX_FILES; fila++) {
			for (columna = 0; columna < MAX_COLUMNES; columna++) {
				if (cami.casellaContinguda(new Casella(mapa[fila][columna], fila, columna)))	{
					System.out.print("*\t");
				}
				else {
					System.out.print(mapa[fila][columna]+"\t");
				}
			}
			System.out.print("\n");
		}
		System.out.println("\nPassos: "+(cami.dimensio() - 1));
		System.out.println("Cost: "+casellaFinal.getCostAcumulat());
		System.out.println("Exploracions: "+exploracions);
	}
	
	public static void main(String[] args) {		
		llegirFitxer("Mapa.txt");
		InicialitzarPosicions();
		
		tractats = new Tractats();
		opcionsAlgorismes();
		switch (teclat.nextInt()) {
			case 1:
				pendents = new PendentsBestFirst();
				break;
			case 2:
				pendents = new PendentsAEstrella();
				break;
		}
		opcionsHeuristiques();
		switch (teclat.nextInt()) {
			case 1:
				heuristica = new PrimeraHeuristica(casellaFinal);
				break;
			case 2:
				heuristica = new SegonaHeuristica(casellaFinal);
				break;
			case 3:
				heuristica = new TerceraHeuristica(casellaFinal);
				break;
		}
		teclat.close();
		
		cercarCami(casellaInicial, casellaFinal);
		
		mostrarCami();
	}
}
