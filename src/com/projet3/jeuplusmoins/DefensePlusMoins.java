package com.projet3.jeuplusmoins;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class DefensePlusMoins {

	private byte nbCases;
	private byte[] solutionJoueur = new byte[nbCases];
	static final Logger logger = LogManager.getLogger();
	private ArrayList<byte[]> listeCombi = new ArrayList<>();
	private byte nbChiffres = 10;
	private byte[] combiNb;

	// Constructeur de la classe Defense prenant en pa ramètre la solution du joueur
	public DefensePlusMoins(byte[] solutionJoueur, byte nbCases) {
		this.nbCases = nbCases;
		this.solutionJoueur = solutionJoueur;
		this.combiNb = new byte[nbCases];

		// On génère ici la liste de toutes les combinaisons possibles

		genAllSolution((byte) 0);

	}

	public boolean jeu() {
		System.out.println();
		System.out.println("La solution du joueur est : ");
		for (int i = 0; i < nbCases; i++) {
			System.out.print(solutionJoueur[i]);
		}
		System.out.println();

		char[] gagnant = { '=', '=', '=', '=', '=', '=', '=', '=' };

		byte[] combi = null;

		char[] score;

		int indexAlea = (int) (Math.random() * (listeCombi.size()));
		// on utilise cet indice aléatoire pour piocher une des combinaisons de la liste
		// et la stocker dans la variable combi
		combi = listeCombi.get(indexAlea);
		// On utilise la méthode compare() pour comparer la solution et la proposition
		// de l'ordi et lui attribuer un score
		System.out.println("L'ordinateur propose : ");
		for (int i = 0; i < nbCases; i++) {
			System.out.print(combi[i]);
		}

		score = compare(combi, solutionJoueur);
		System.out.println();

		System.out.println("score : ");

		for (int i = 0; i < nbCases; i++) {
			System.out.print(score[i]);
		}

		if (isSame(score, gagnant)) {

			return true;

		}

		ArrayList<byte[]> listeCombiCopie = new ArrayList<>(listeCombi);

		for (byte[] combinaison : listeCombiCopie) {
			// On va ensuite comparer chaque combinaison restante de la liste à la
			// proposition de l'ordinateur et stocker le score dans la variable result
			char[] result = compare(combi, combinaison);
			// Si le score obtenu est différent de ce que nous avions obtenu précédemment on
			// enlève cette combinaison de la liste
			if (!isSame(result, score)) {
				listeCombi.remove(combinaison);

			}

		}

		return false;

	}

	// Méthode qui va comparer la solution et la proposition de l'ordinateur
	public char[] compare(byte proposition[], byte solution[]) {
		char[] ch = new char[nbCases];
		for (int i = 0; i < nbCases; i++) {
			if (solution[i] == proposition[i]) {
				ch[i] = '=';
			}
			if (proposition[i] > solution[i]) {
				ch[i] = '-';
			}
			if (proposition[i] < solution[i]) {
				ch[i] = '+';
			}
		}
		return ch;
	}

	public boolean isSame(char[] a, char[] b) {
		for (int i = 0; i < nbCases; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	// Méthode permettant de générer une arrayList comportant toutes les
	// combinaisons possibles
	/*
	 * public ArrayList<int[]> generate() { // on crée une ArrayList qui va
	 * comporter toutes les combinaisons ArrayList<int[]> combi = new ArrayList<>();
	 * // On crée 4 boucles afin de générer toutes les combinaisons de 4 chiffres //
	 * allant de 0 à 9 for (int i = 0; i <= 9; i++) { for (int j = 0; j <= 9; j++) {
	 * for (int k = 0; k <= 9; k++) { for (int l = 0; l <= 9; l++) { int tab[] = {
	 * i, j, k, l }; // Chaque combinaison généré par les boucles est stocké dans la
	 * ArrayList combi combi.add(tab);
	 * 
	 * } } } } return combi; }
	 */

	private void genAllSolution(byte j) {

		if (j >= nbCases) {
			listeCombi.add(combiNb.clone());
			return;
		}

		for (int i = 0; i <= nbChiffres; i++) {
			combiNb[j] = (byte) i;
			genAllSolution((byte) (j + 1));
		}

	}

}
