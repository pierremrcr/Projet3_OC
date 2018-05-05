package com.projet3.mastermind;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

import com.projet3.jeuplusmoins.DefensePlusMoins;

public class ModeDefenseurMastermind {

	DefenseMastermind d;
	byte nbEssais;
	byte nbChiffres;
	static final Logger logger = LogManager.getLogger();

	public ModeDefenseurMastermind(byte nbEssais, byte nbChiffres, byte nbCases) {
		this.nbEssais = nbEssais;
		this.nbChiffres = nbChiffres;
		byte solutionJoueur[] = new byte[nbCases];

		Scanner sc = new Scanner(System.in);
		String str;
		do {

			System.out.println("Veuillez entrer une combinaison de " + nbCases + " chiffres de 0 à "+nbChiffres);

			str = sc.nextLine();

			if (!str.matches("[0-"+nbChiffres+"]+") || str.length() != nbCases) {
				System.out.println();
				System.out.println("Votre combinaison doit exclusivement être composé de " + nbCases + " chiffres de 0 à "+nbChiffres);
				System.out.println();
			}

		} while (!str.matches("[0-"+nbChiffres+"]+") || str.length() != nbCases);

		for (int i = 0; i < nbCases; i++) {
			byte cmb = (byte) Character.getNumericValue(str.charAt(i));
		
			solutionJoueur[i] = cmb;
		}
	
		d = new DefenseMastermind(solutionJoueur, nbCases, nbChiffres);

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
