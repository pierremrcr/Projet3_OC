package com.projet3.jeuplusmoins;

import java.util.Random;
import java.util.Scanner;

public class Attaque {
	private int solutionOrdi[] = new int[4];

	public Attaque(int solutionOrdi[]) {
		
		this.solutionOrdi = solutionOrdi;
		
	}
	
	public boolean jeu() {

			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez proposer une combinaison : ");
			String str = sc.nextLine();
			int [] tab = new int[4];
			// On caste la combinaison dans un entier puisque sc.nextLine() est un String
			for (int i = 0; i < 4; i++) {
				// Chaque caractère de la proposition est casté pour avoir un int
				int cmb = Character.getNumericValue(str.charAt(i));
				tab[i] = cmb;
			}
			if (compare(tab) == true) {
				return true;
			}
			else 
			return false;

	}

	// Méthode qui compare la proposition de l'utilisateur à la solution et qui
	// renvoit un booléen
	boolean compare(int[] proposition) {
		boolean combi = true;
		for (int i = 0; i < 4; i++) {
			// On isole chaque élément de la proposition de l'utilisateur afin d'obtenir la
			// valeur numérique de l'élément sous forme d'un Int
			
			int cmb = proposition[i];
			// chaque élement de la proposition est comparée à chaque élément de la solution
			// si les éléments à la même position sont identiques, combi reste à true
			// Sinon, combi passe à false
			if (cmb == solutionOrdi[i]) {
				System.out.print("=");
			} else if (cmb < solutionOrdi[i]) {
				System.out.print("+");
				combi = false;

			} else {
				System.out.print("-");
				combi = false;
			}
			

		}
		System.out.println();
		// Si combi renvoit vrai c'est qu'on a trouvé la bonne solution sinon
		// l'utlisateur devra renseigner une autre propostion jusqu'à ce que que combi
		// renvoit vrai
		return combi;
	}


}
