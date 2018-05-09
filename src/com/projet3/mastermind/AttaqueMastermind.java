package com.projet3.mastermind;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AttaqueMastermind {
	private byte nbCases;
	private byte solutionOrdi[] = new byte[nbCases];
	byte nbChiffres;
	static final Logger logger = LogManager.getLogger();
	Scanner sc = new Scanner(System.in);

	public AttaqueMastermind(byte solutionOrdi[], byte nbCases, byte nbChiffres) {

		this.solutionOrdi = solutionOrdi;
		this.nbCases = nbCases;
		this.nbChiffres = nbChiffres;
	}

	public boolean jeu() {

		String str = null;

		do {

			System.out
					.println("Veuillez proposer une combinaison de " + nbCases + " chiffres entre 0 et " + nbChiffres);

			str = sc.nextLine();

			if (!str.matches("[0-" + nbChiffres + "]+") || str.length() != nbCases) {
				System.out.println();
				System.out.println("Votre combinaison doit exclusivement être composé de " + nbCases
						+ " chiffres de 0 à " + nbChiffres);
				logger.warn(
						"Soit l'utilisateur n'a pas respecté le nb de cases ou l'intervalle des chiffres soit il n'a pas renseigné de chiffres");
				System.out.println();
			}

		} while (!str.matches("[0-" + nbChiffres + "]+") || str.length() != nbCases);

		byte[] tab = new byte[nbCases];

		// On caste la combinaison dans un entier puisque sc.nextLine() est un String
		for (int i = 0; i < nbCases; i++) {
			// Chaque caractère de la proposition est casté pour avoir un int
			byte cmb = (byte) Character.getNumericValue(str.charAt(i));
			tab[i] = cmb;
		}

		if (compare(tab) == true) {
			return true;

		} else
			return false;

	}

	boolean compare(byte[] proposition) {
		// boolean combi = true;
		int mal = 0, bien = 0;
		// Première boucle parcourant la combinaison à deviner
		for (int i = 0; i < nbCases; i++) {
			boolean bienPlace = false;
			boolean malPlace = false;
			// Deuxième boucle parcourant la proposition
			for (int j = 0; j < nbCases; j++) {

				byte cmb = proposition[j];
				// Comparaison de la proposition par rapport à la combinaison
				if (cmb == solutionOrdi[i]) {
					if (i == j) {
						bienPlace = true;
					} else {
						malPlace = true;
					}
				}
			}

			if (bienPlace == true)
				bien++;
			else if (malPlace == true)
				mal++;
		}
		System.out.println(mal + " chiffres présents et " + bien + " bien placés");

		if (bien == nbCases)
			return true;
		else
			return false;
	}

}
