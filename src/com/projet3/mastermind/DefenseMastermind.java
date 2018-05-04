package com.projet3.mastermind;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class DefenseMastermind {

	private int nbCases;
	private int[] solutionJoueur = new int[nbCases];
	private ArrayList<int[]> listeCombi = new ArrayList<>();
	private int nbChiffres;
	private int[] combiNb;
	static final Logger logger = LogManager.getLogger();
	

	public DefenseMastermind(int[] solutionJoueur, int nbCases, int nbChiffres) {
		this.solutionJoueur = solutionJoueur;
		this.nbCases = nbCases;
		this.combiNb = new int[nbCases];
		this.nbChiffres = nbChiffres;
		// On utilise la méthode generate() pour générer toutes les combinaisons et on
	    // les stock dans la arraylist
		//listeCombi = generate();
		genAllSolution(0);
		

	}

	public boolean jeu() {
		System.out.println();
		System.out.println("La solution du joueur est : ");
		for (int i = 0; i < nbCases; i++) {
			System.out.print(solutionJoueur[i]);
		}
		System.out.println();
		//Score que l'ordinateur doit obtenir pour avoir la bonne combinaison
		int[] gagnant = { nbCases, 0 };

		int[] combi = null;
		// On crée une arrayList pour stocker toutes les combinaisons


		int[] score = null;

	
		int indexAlea = (int) (Math.random() * (listeCombi.size()));
		// on utilise cet indice aléatoire pour piocher une des combinaisons de la liste
		// et la stocker dans la variable combi
		combi = listeCombi.get(indexAlea);
		
		System.out.println("L'ordinateur propose : ");
		for (int i = 0; i < nbCases; i++) {
			System.out.print(combi[i]);
		}
		
		// On utilise la méthode compare() pour comparer la solution et la proposition
		// de l'ordi et lui attribuer un score
		score = compare(combi, solutionJoueur);
		System.out.println();
		System.out.println("score : ");
		
		System.out.println("Présents : " + score[1]);
		System.out.println("Bien placés : " + score[0]);
		
		//Si le score obtenu est le même que le score gagnant, cela veut dire que l'ordi a trouvé la solution
		//La méthode s'arrête et renvoit true
		if (isSame(score, gagnant)) {
			return true;
		}
		
		System.out.println();


		ArrayList<int[]> listeCombiCopie = new ArrayList<>(listeCombi);

		for (int[] combinaison : listeCombiCopie) {
			// On va ensuite comparer chaque combinaison restante de la liste à la
			// proposition de l'ordinateur et stocker le score dans la variable result
			int[] result = compare(combi, combinaison);
			// Si le score obtenu est différent de ce que nous avions obtenu précédemment on
			// enlève cette combinaison de la liste
			if (!isSame(result, score)) {
				listeCombi.remove(combinaison);

			}

		}

		return false;

	}

	// Méthode qui va comparer la solution et la proposition de l'ordinateur
	public int[] compare(int proposition[], int solution[]) {

		int[] score = new int[2];
		int bienPlace = 0;
		int malPlace = 0;
		for (int i = 0; i < nbCases; i++) {

			// Deuxième boucle parcourant la proposition
			for (int j = 0; j < nbCases; j++) {
				
				int cmb = proposition[j];
				// Comparaison de la proposition par rapport à la combinaison
				if (cmb == solution[i]) {
					if (i == j) {
						bienPlace++;
					} else {
						malPlace++;
					}
				}
			}

		}
		//L'indice 0 du tableau score contient le nombre de bien placé
		//L'indice 1 du tableau score contient le nombre de présents mais mal placé
		score[0] = bienPlace;
		score[1] = malPlace;
		return score;
	}
//Méthode pour comparer le score de la proposition de l'ordinateur et la solution obtenu
// grâce à la méthode compare()
	public boolean isSame(int[] a, int[] b) {
		for (int i = 0; i < 2; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	// Méthode permettant de générer une arrayList comportant toutes les
	// combinaisons possibles
//	public ArrayList<int[]> generate() {
//		// on crée une ArrayList qui va comporter toutes les combinaisons
//		ArrayList<int[]> combi = new ArrayList<>();
//		// On crée 4 boucles afin de générer toutes les combinaisons de 4 chiffres
//		// allant de 0 à 9
//		for (int i = 0; i <= 9; i++) {
//			for (int j = 0; j <= 9; j++) {
//				for (int k = 0; k <= 9; k++) {
//					for (int l = 0; l <= 9; l++) {
//						int tab[] = { i, j, k, l };
//						// Chaque combinaison généré par les boucles est stocké dans la ArrayList combi
//						combi.add(tab);
//
//					}
//				}
//			}
//		}
//		return combi;
//	}
	
	private void genAllSolution(int j) {


		if (j >= nbCases) {
			listeCombi.add(combiNb.clone());
			return;
		}

		for (int i = 0; i < nbChiffres; i++) {
			combiNb[j] = (int) i;
			genAllSolution((int) (j + 1));
		}

	}

}
