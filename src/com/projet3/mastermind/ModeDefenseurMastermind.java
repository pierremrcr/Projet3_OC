package com.projet3.mastermind;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

import com.projet3.jeuplusmoins.DefensePlusMoins;

public class ModeDefenseurMastermind {

	DefenseMastermind d;
	int nbEssais;
	int nbChiffres;
	static final Logger logger = LogManager.getLogger();

	public ModeDefenseurMastermind(int nbEssais, int nbChiffres, int nbCases) {
		this.nbEssais = nbEssais;
		this.nbChiffres = nbChiffres;
		int solutionJoueur[] = new int[nbCases];

		Scanner sc = new Scanner(System.in);
		int nb;
		String str;
		do {
			System.out.println("Veuillez entrer une combinaison de " + nbCases + " chiffres");
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
				if (n > 47 && n <= 47 + nbChiffres) {
					solutionJoueur[i] = Character.getNumericValue(c);
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
		while (nb != nbCases);
		// On crée un nouvel objet défense qui prend en paramètre la combinaison de
		// l'utilisateur
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
			System.out.println("L'ordinateur a trouvé votre combinaison secrète ! ");
		} else {
			System.out.println("L'ordinateur n'a pas trouvé votre combinaison secrète ! ");
		}
		System.out.println();
	}

}
