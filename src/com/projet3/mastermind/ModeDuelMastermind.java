package com.projet3.mastermind;

import java.util.Random;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.projet3.Mode;

public class ModeDuelMastermind implements Mode {

	byte nbCases;
	byte nbChiffres;
	AttaqueMastermind a;
	DefenseMastermind d;
	static final Logger logger = LogManager.getLogger();
	byte[] solutionJoueur;
	byte[] solutionOrdi;

	public ModeDuelMastermind(byte nbCases, byte nbChiffres, boolean modedev) {

		solutionJoueur = new byte[nbCases];
		solutionOrdi = new byte[nbCases];

		for (int i = 0; i < nbCases; i++) {
			Random r = new Random();
			solutionOrdi[i] = (byte) r.nextInt(nbChiffres + 1);
		}
		if (modedev == true) {
			System.out.print("Solution : ");
			for (int i = 0; i < nbCases; i++) {
				System.out.print(solutionOrdi[i]);
			}
			System.out.println();
		}

		Scanner sc = new Scanner(System.in);

		String str;
		do {

			System.out
					.println("Veuillez entrer une combinaison de " + nbCases + " chiffres allant de 0 à " + nbChiffres);

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

		for (int i = 0; i < nbCases; i++) {
			byte cmb = (byte) Character.getNumericValue(str.charAt(i));
			//
			solutionJoueur[i] = cmb;
		}

		// On crée un nouvel objet défense qui prend en paramètre la combinaison de
		// l'utilisateur
		a = new AttaqueMastermind(solutionOrdi, nbCases, nbChiffres);
		d = new DefenseMastermind(solutionJoueur, nbCases, nbChiffres);

	}

	public void jeu() {

		int gagnant = 0;

		do {
			if (a.jeu()) {
				System.out.println();
				System.out.println("Bravo, vous avez battu l'ordinateur !");
				gagnant++;
			} else if (d.jeu()) {
				System.out.println();
				System.out.println("L'ordinateur a trouvé avant vous !");
				System.out.println("La solution de l'ordinateur était ");
				for (int i = 0; i < nbCases; i++) {
					System.out.println(solutionOrdi[i]);
				}
				gagnant++;
			}
		} while (gagnant == 0);

	}

}
