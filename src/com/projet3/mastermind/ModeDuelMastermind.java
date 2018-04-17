package com.projet3.mastermind;

import java.util.Random;
import java.util.Scanner;

public class ModeDuelMastermind {
	
	
	int [] solutionJoueur= new int[4];
	int [] solutionOrdi= new int[4];
	
	public ModeDuelMastermind() {
	
	for (int i = 0; i < 4; i++) {
		Random r = new Random();
		// On génère une combinaison aléatoire
		solutionOrdi[i] = r.nextInt(9);
	}
	
	Scanner sc = new Scanner(System.in);
	int nb;
	String str;
	do {
		System.out.println("Veuillez entrer votre combinaison secrète de 4 chiffres : ");
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
		while (nb != 4);
	
	
	
} 
	
	public void jeu() {
	
	
		Attaque a= new Attaque(solutionOrdi);
		Defense d= new Defense(solutionJoueur);
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




