package com.projet3.mastermind;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.projet3.Mode;

public class ModeChallengerMastermind implements Mode {

	byte nbEssais;
	byte nbCases;
	AttaqueMastermind a;
	static final Logger logger = LogManager.getLogger();
	byte solutionOrdi[];

	// Constructeur pour générer une combinaison de maniière aléatoire
	public ModeChallengerMastermind(byte nbCases, byte nbChiffres, boolean modedev, byte nbEssais) {
		this.nbEssais = nbEssais;
		this.nbCases = nbCases;
		solutionOrdi = new byte[nbCases];

		for (int i = 0; i < nbCases; i++) {
			Random r = new Random();
			// Chaque chiffre de la combinaison va recevoir une valeur aléatoire entre 0 et
			// nbChiffres
			solutionOrdi[i] = (byte) r.nextInt(nbChiffres + 1);
		}
		if (modedev == true) {
			System.out.print("Solution : ");
			for (int i = 0; i < nbCases; i++) {
				System.out.print(solutionOrdi[i]);
			}
			System.out.println();
		}
		System.out.println();
		// On crée un objet de la classe Attaque qui prend en paramètre la combinaison
		// de l'ordi à deviner
		a = new AttaqueMastermind(solutionOrdi, nbCases, nbChiffres);

	}

	public void jeu() {
		boolean test = false;
		int compteur = 0;
		do {
			// La méthode jeu renvoit un booléen donc si la méthode renvoit true
			// l'utilisateur a trouvé la solution donc le jeu s'arrête et on sort de la
			// boucle
			test = a.jeu();
			compteur++;

		} while (test == false && compteur != nbEssais);
		System.out.println();
		if (test == true) {
			System.out.println("Bravo vous avez trouvé la combinaison secrète de l'ordinateur ! ");
		} else {
			System.out.println("Vous avez perdu !");
			System.out.println("La solution était ");
			for (int i = 0; i < nbCases; i++) {
				System.out.print(solutionOrdi[i]);
			}
		}
		System.out.println();
	}

}
