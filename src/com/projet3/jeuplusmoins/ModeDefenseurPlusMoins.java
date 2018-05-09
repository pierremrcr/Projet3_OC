package com.projet3.jeuplusmoins;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.projet3.Mode;

public class ModeDefenseurPlusMoins implements Mode {

	DefensePlusMoins d;
	byte nbEssais;
	byte nbCases;
	static final Logger logger = LogManager.getLogger();

	public ModeDefenseurPlusMoins(byte nbCases, byte nbEssais) {

		this.nbEssais = nbEssais;
		this.nbCases = nbCases;
		byte solutionJoueur[] = new byte[nbCases];

		Scanner sc = new Scanner(System.in);
		String str;
		do {

			System.out.println("Veuillez entrer une combinaison de " + nbCases + " chiffres");

			str = sc.nextLine();

			if (!str.matches("[0-9]+") || str.length() != nbCases) {
				System.out.println();
				System.out.println(
						"Votre combinaison doit exclusivement être composé de " + nbCases + " chiffres de 0 à 9 ");
				logger.warn("Soit l'utilisateur n'a pas respecté le nb de cases soit il n'a pas renseigné de chiffres");
				System.out.println();
			}

		} while (!str.matches("[0-9]+") || str.length() != nbCases);

		for (int i = 0; i < nbCases; i++) {
			byte cmb = (byte) Character.getNumericValue(str.charAt(i));
			//
			solutionJoueur[i] = cmb;

		}

		d = new DefensePlusMoins(solutionJoueur, nbCases);

	}

	public void jeu() {
		boolean test = false;
		int cpt = 0;
		do {
			// La méthode jeu renvoit un booléen donc si la méthode renvoit true
			// l'ordi à trouvé la solution donc le jeu s'arrête et on sort de la boucle
			test = d.jeu();
			cpt++;
		} while (test == false && cpt != nbEssais);
		System.out.println();
		if (test == true) {
			System.out.println();
			System.out.println("L'ordinateur a trouvé votre combinaison secrète ! ");
		} else {
			System.out.println();
			System.out.println("L'ordinateur n'a pas trouvé votre combinaison secrète ! ");
		}
		System.out.println();
	}

}
