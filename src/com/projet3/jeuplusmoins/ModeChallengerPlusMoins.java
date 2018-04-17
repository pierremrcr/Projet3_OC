package com.projet3.jeuplusmoins;

import java.util.Random;
import java.util.Scanner;

public class ModeChallengerPlusMoins {

	// On déclare un tableau d'entiers de 4 éléments
	private int tab[] = new int[4];
	Attaque a;
	
	// Constructeur pour générer une combinaison de maniière aléatoire
	public ModeChallengerPlusMoins() {
		for (int i = 0; i < 4; i++) {
			Random r = new Random();
			// On génère une combinaison aléatoire
			tab[i] = r.nextInt(9);
		}
		// On crée un objet de la classe Attaque qui prend en paramètre la combinaison de l'ordi à deviner
		a = new Attaque(tab);
	}

	public void jeu() {
		boolean test = false;
		do {
			//La méthode jeu renvoit un booléen donc si la méthode renvoit true 
			//l'utilisateur a trouvé la solution donc le jeu s'arrête et on sort de la boucle
			test = a.jeu();

		} while (test == false);
		System.out.println();
		System.out.println("Bravo vous avez trouvé la combinaison secrète de l'ordinateur ! ");
	}

}
