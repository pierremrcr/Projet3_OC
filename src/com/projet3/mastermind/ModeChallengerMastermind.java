package com.projet3.mastermind;

import java.util.Random;
import java.util.Scanner;

import com.projet3.jeuplusmoins.Defense;

public class ModeChallengerMastermind {
	
	// On déclare un tableau int de 4 chiffres
	private int tab[] = new int[4];
	Attaque a;

	// Constructeur pour générer une combinaison de maniière aléatoire
	public ModeChallengerMastermind() {
		for (int i = 0; i < 4; i++) {
			Random r = new Random();
			// Chaque chiffre de la combinaison va recevoir une valeur aléatoire entre 0 et
			// 9
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
	


