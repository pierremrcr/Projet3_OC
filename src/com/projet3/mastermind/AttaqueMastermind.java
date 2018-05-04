package com.projet3.mastermind;


import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AttaqueMastermind {
	int nbCases;
	private int solutionOrdi[] = new int[nbCases];
	int nbChiffres;
	static final Logger logger = LogManager.getLogger();
	Scanner sc = new Scanner(System.in);

	public AttaqueMastermind(int solutionOrdi[], int nbCases) {
		
		this.solutionOrdi = solutionOrdi;
		this.nbCases = nbCases;
	}
	
	public boolean jeu() {
	
		String str = null;
		int nb = 0;

	do {
				
			
			System.out.println("Veuillez proposer une combinaison de " + nbCases + " chiffres :");
			 
		    str = sc.nextLine();
		    
		   
		    if (!str.matches("[0-9]+") || str.length() != nbCases ) {
		    	System.out.println();
		    	System.out.println("Votre combinaison doit exclusivement être composé de "+ nbCases +" chiffres de 0 à 9 ");
		    	System.out.println();
		    }
		    
		    
			} while (!str.matches("[0-9]+") || str.length() != nbCases);
			
			int [] tab = new int[nbCases];
			
			// On caste la combinaison dans un entier puisque sc.nextLine() est un String
			for (int i = 0; i < nbCases; i++) {
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
		for (int i = 0; i < nbCases; i++) {
			boolean bienPlace = false;
			boolean malPlace = false;
			// Deuxième boucle parcourant la proposition
			for (int j = 0; j < nbCases; j++) {
				
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

		if (bien == nbCases)
			return true;
		else
			return false;
	}

}


