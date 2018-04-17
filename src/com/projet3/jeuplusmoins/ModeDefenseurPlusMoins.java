package com.projet3.jeuplusmoins;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ModeDefenseurPlusMoins {

	private int tab[] = new int[4];
	Defense d;

	public ModeDefenseurPlusMoins() {

		Scanner sc = new Scanner(System.in);
		int nb;
		String str;
		do {
			System.out.println("Veuillez entrer une combinaison de 4 chiffres");
			str = sc.nextLine();
			nb = str.length();

			for (int i = 0; i < nb; i++) {
				char c;
				// On isole chaque élément de la chaine sous forme d'un caractère
				c = str.charAt(i);
				// On veut obtenir la valeur numérique de ce caractère
				int n = Character.valueOf(c);
				// Si la valeur num du caractère est comprise entre 47 et 58 (un chiffre entre 0
				// et 9), on intègre cette valeur à notre tableau d'entiers
				if (n > 47 && n < 58) {
					tab[i] = Character.getNumericValue(c);
				}
				// Sinon on recommence la boucle do/while et on demande une nouvelle combinaison
				else {
					nb = 0;
					break;
				}
			}
		}
		// Tant que la combinaison ne fait pas 4 chiffres, on reste dans la boucle et on
		// redemande une nouvelle combinaison
		while (nb != 4);
		// On crée un nouvel objet défense qui prend en paramètre la combinaison de l'utilisateur
		d=new Defense(tab);

	}

	public void jeu() {
		boolean test = false;
		do {
			//La méthode jeu renvoit un booléen donc si la méthode renvoit true 
			//l'ordi à trouvé la solution donc le jeu s'arrête et on sort de la boucle
			test=d.jeu();
		}
	while(test == false);
		System.out.println();
		System.out.println("L'ordinateur a trouvé votre combinaison secrète ! ");
	}

}
