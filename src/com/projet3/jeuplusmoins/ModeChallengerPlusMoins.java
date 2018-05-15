package com.projet3.jeuplusmoins;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.projet3.Mode;

public class ModeChallengerPlusMoins implements Mode {

	AttaquePlusMoins a;
	byte nbEssais;
	byte nbCases;
	static final Logger logger = LogManager.getLogger();
	byte solutionOrdi[];

	// Constructeur pour générer une combinaison de manière aléatoire
	public ModeChallengerPlusMoins(byte nbCases, byte nbEssais, boolean modedev) {
		this.nbEssais = nbEssais;
		this.nbCases = nbCases;
		solutionOrdi = new byte[nbCases];

		// Chaque chiffre de la combinaison va recevoir une valeur aléatoire entre 0 et
		// 9
		for (int i = 0; i < nbCases; i++) {
			Random r = new Random();
			solutionOrdi[i] = (byte) r.nextInt(10);
		}
		if (modedev == true) {
			System.out.print("Solution : ");
			for (int i = 0; i < nbCases; i++) {
				System.out.print(solutionOrdi[i]);
			}
			System.out.println();
		}
		// On crée un objet de la classe Attaque qui prend en paramètre la combinaison
		// de l'ordi à deviner
		a = new AttaquePlusMoins(solutionOrdi, nbCases);
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
