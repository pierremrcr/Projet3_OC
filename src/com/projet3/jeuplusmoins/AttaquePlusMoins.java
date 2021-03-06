package com.projet3.jeuplusmoins;

import java.util.Random;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AttaquePlusMoins {
	private byte nbCases;
	private byte solutionOrdi[] = new byte[nbCases];
	static final Logger logger = LogManager.getLogger();
	Scanner sc = new Scanner(System.in);

	public AttaquePlusMoins(byte solutionOrdi[], byte nbCases) {

		this.solutionOrdi = solutionOrdi;
		this.nbCases = nbCases;

	}

	public boolean jeu() {

		String str = null;

		do {

			System.out.println("Veuillez proposer une combinaison de " + nbCases + " chiffres :");

			str = sc.nextLine();

			if (!str.matches("[0-9]+") || str.length() != nbCases) {
				System.out.println();
				System.out.println(
						"Votre combinaison doit exclusivement être composé de " + nbCases + " chiffres de 0 à 9 ");
				logger.warn("Soit l'utilisateur n'a pas respecté le nb de cases soit il n'a pas renseigné de chiffres");
				System.out.println();
			}

		} while (!str.matches("[0-9]+") || str.length() != nbCases);

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

	// Méthode qui compare la proposition de l'utilisateur à la solution et qui
	// renvoit un booléen
	boolean compare(byte[] proposition) {
		boolean combi = true;
		for (int i = 0; i < nbCases; i++) {
			// On isole chaque élément de la proposition de l'utilisateur afin d'obtenir la
			// valeur numérique de l'élément sous forme d'un Int

			byte cmb = proposition[i];
			// chaque élement de la proposition est comparée à chaque élément de la solution
			// si les éléments à la même position sont identiques, combi reste à true
			// Sinon, combi passe à false
			if (cmb == solutionOrdi[i]) {
				System.out.print("=");
			} else if (cmb < solutionOrdi[i]) {
				System.out.print("+");
				combi = false;

			} else {
				System.out.print("-");
				combi = false;
			}

		}
		System.out.println();
		// Si combi renvoit vrai c'est qu'on a trouvé la bonne solution sinon
		// l'utlisateur devra renseigner une autre propostion jusqu'à ce que que combi
		// renvoit vrai
		return combi;
	}

}
