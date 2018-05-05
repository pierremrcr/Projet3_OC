package com.projet3.jeuplusmoins;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class ModeDuelPlusMoins {
	
	byte nbCases;
	AttaquePlusMoins a;
	DefensePlusMoins d;
	static final Logger logger = LogManager.getLogger();
	Scanner sc = new Scanner(System.in);
	
	public ModeDuelPlusMoins(byte nbCases, boolean modedev) {
		
		byte [] solutionJoueur= new byte[nbCases];
		byte [] solutionOrdi= new byte[nbCases];
	
		if (modedev == true) {
			System.out.print("Solution : ");
			for (int i = 0; i < nbCases; i++) {
				Random r = new Random();
				// Chaque chiffre de la combinaison va recevoir une valeur aléatoire entre 0 et
				// 9
				System.out.print(solutionOrdi[i] = (byte) r.nextInt(10));
			}
			System.out.println();
			}
	
	
	int nb = 0;
	String str = null;
	
	do {
		
		System.out.println("Veuillez entrer une combinaison de " + nbCases + " chiffres");
			 
		    str = sc.nextLine();
		    
		   
		    if (!str.matches("[0-9]+") || str.length() != nbCases ) {
		    	System.out.println();
		    	System.out.println("Votre combinaison doit exclusivement être composé de "+ nbCases +" chiffres de 0 à 9 ");
		    	System.out.println();
		    }
		    
		    
			} while (!str.matches("[0-9]+") || str.length() != nbCases);
		

		for (int i = 0; i < nbCases; i++) {
			byte cmb = (byte) Character.getNumericValue(str.charAt(i));
//	
			solutionJoueur[i] = cmb;
			}
	
	
	// On crée un nouvel objet défense qui prend en paramètre la combinaison de
	// l'utilisateur
	d = new DefensePlusMoins(solutionJoueur, nbCases);
     a = new AttaquePlusMoins(solutionOrdi,nbCases);
        
	
	
} 
	
	public void jeu() {
	
		
		int gagnant = 0;
		
		do {
		//Méthode jeu() de la classe Attaque
		if(a.jeu()) {
			System.out.println();
			System.out.println("Bravo, vous avez battu l'ordinateur !");
			gagnant++;
		}
		//Méthode jeu() de la classe Defense
		else if(d.jeu()){
			System.out.println();
			System.out.println("L'ordinateur a trouvé avant vous !");
			gagnant++;
		}
		}
		while(gagnant == 0);
		
		
	} 
	

}




