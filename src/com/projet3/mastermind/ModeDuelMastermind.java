package com.projet3.mastermind;

import java.util.Random;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ModeDuelMastermind {
	
	int nbCases;
	int nbChiffres;
	AttaqueMastermind a;
	DefenseMastermind d;
	static final Logger logger = LogManager.getLogger();
	
	
	
	public ModeDuelMastermind(int nbCases, int nbChiffres, boolean modedev) {
		
		int [] solutionJoueur= new int[nbCases];
		int [] solutionOrdi= new int[nbCases];
	
	
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
	
	Scanner sc = new Scanner(System.in);
	int nb;
	String str;
	do {
		System.out.println("Veuillez entrer votre combinaison secrète de " + nbCases + " chiffres : ");
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
			if (n > 47 && n < 47+nbChiffres) {
				solutionJoueur[i] = Character.getNumericValue(c);
			}
			//Sinon on recommence la boucle do/while et on demande une nouvelle combinaison 
			else{
				nb=0;
				break;
			}
		}
		}
		//Tant que la combinaison ne fait pas 4 chiffres, on reste dans la boucle et on redemande une nouvelle combinaison
		while (nb != nbCases);
	    a= new AttaqueMastermind(solutionOrdi, nbCases);
	    d= new DefenseMastermind(solutionJoueur, nbCases, nbChiffres);
	
	
	
} 
	
	public void jeu() {
	
	
		
		int gagnant = 0;
		
		do {
		if(a.jeu()) {
			System.out.println();
			System.out.println("Bravo, vous avez battu l'ordinateur !");
			gagnant++;
		}
		else if(d.jeu()){
			System.out.println();
			System.out.println("L'ordinateur a trouvé avant vous !");
			gagnant++;
		}
		}
		while(gagnant == 0);
		
		
	}
	

}




