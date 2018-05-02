package com.projet3.mastermind;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.projet3.jeuplusmoins.DefensePlusMoins;

public class ModeChallengerMastermind {
	
	int nbEssais;
	AttaqueMastermind a;
	static final Logger logger = LogManager.getLogger();
	

	// Constructeur pour générer une combinaison de maniière aléatoire
	public ModeChallengerMastermind(int nbCases, int nbChiffres, boolean modedev, int nbEssais) {
		this.nbEssais = nbEssais;
	    int solutionOrdi[] = new int[nbCases];
	    
		if (modedev == true) {
			System.out.print("Solution : ");
			for (int i = 0; i < nbCases; i++) {
				Random r = new Random();
				// Chaque chiffre de la combinaison va recevoir une valeur aléatoire entre 0 et
				// 9
				System.out.print(solutionOrdi[i] = r.nextInt(nbChiffres));
			}
			System.out.println();
			}
		System.out.println();
		// On crée un objet de la classe Attaque qui prend en paramètre la combinaison de l'ordi à deviner
		a = new AttaqueMastermind(solutionOrdi, nbCases);
		
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
	


