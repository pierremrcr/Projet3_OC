package com.projet3.mastermind;

import java.util.Scanner;

public class Attaque {
	private int solutionOrdi[] = new int[4];
	int nbChiffre = 4;

	public Attaque(int solutionOrdi[]) {
		
		this.solutionOrdi = solutionOrdi;
		
	}
	
	public boolean jeu() {
	
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez proposer une combinaison : ");
			String str = sc.nextLine();
			int [] tab = new int[nbChiffre];
			
			// On caste la combinaison dans un entier puisque sc.nextLine() est un String
			for (int i = 0; i < nbChiffre; i++) {
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



	boolean compare(int[]proposition) {
		// boolean combi = true;
		int mal = 0, bien = 0;
		// Première boucle parcourant la combinaison à deviner
		for (int i = 0; i < nbChiffre; i++) {
			boolean bienPlace = false;
			boolean malPlace = false;
			// Deuxième boucle parcourant la proposition
			for (int j = 0; j < nbChiffre; j++) {
				
				int cmb = proposition[j];
				// Comparaison de la proposition par rapport à la combinaison
				if (cmb == solutionOrdi[i]) {
					if (i == j) {
						bienPlace = true;
					} else {
						malPlace = true;
					}
				}
			}

			if (bienPlace == true)
				bien++;
			else if (malPlace == true)
				mal++;
		}
		System.out.println(mal + " chiffres présents et " + bien + " bien placés");

		if (bien == nbChiffre)
			return true;
		else
			return false;
	}

}


