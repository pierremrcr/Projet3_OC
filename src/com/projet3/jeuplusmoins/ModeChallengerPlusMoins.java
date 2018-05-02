package com.projet3.jeuplusmoins;

import java.io.FileInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class ModeChallengerPlusMoins {
	
	AttaquePlusMoins a;
	int nbEssais;
	static final Logger logger = LogManager.getLogger();
	
	// Constructeur pour générer une combinaison de manière aléatoire
	public ModeChallengerPlusMoins(int nbCases, int nbEssais, boolean modedev) {
		this.nbEssais = nbEssais;
		int solutionOrdi[] = new int[nbCases];
		if (modedev == true) {
		System.out.print("Solution : ");
		for (int i = 0; i < nbCases; i++) {
			Random r = new Random();
			// Chaque chiffre de la combinaison va recevoir une valeur aléatoire entre 0 et
			// 9
			System.out.print(solutionOrdi[i] = r.nextInt(9));
		}
		System.out.println();
		}
		// On crée un objet de la classe Attaque qui prend en paramètre la combinaison de l'ordi à deviner
		a = new AttaquePlusMoins(solutionOrdi,nbCases);
	}

	public void jeu() {
		boolean test = false;
		int compteur = 0;
		do {
			//La méthode jeu renvoit un booléen donc si la méthode renvoit true 
			//l'utilisateur a trouvé la solution donc le jeu s'arrête et on sort de la boucle
			test = a.jeu();
			compteur++;

		} while (test == false && compteur != nbEssais);
		System.out.println();
		if(test==true) {
		System.out.println("Bravo vous avez trouvé la combinaison secrète de l'ordinateur ! ");
		}
		else {
			System.out.println("Vous avez perdu !");
		}
		System.out.println();
	}

}
