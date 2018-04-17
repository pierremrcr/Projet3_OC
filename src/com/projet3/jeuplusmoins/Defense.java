package com.projet3.jeuplusmoins;

import java.util.ArrayList;
import java.util.Scanner;

public class Defense {
	
	int [] solutionJoueur= new int[4];
	Scanner sc = new Scanner(System.in);
	int nb;
	ArrayList<int[]> listeCombi = new ArrayList<>();
	String str;
	
	//Constructeur de la classe Defense prenant en pa	ramètre la solution du joueur
	public Defense(int [] solutionJoueur) {
		this.solutionJoueur= solutionJoueur;
		//On génère ici la liste de toutes les combinaisons possibles 
		
		listeCombi = generate();
		
	}
		
	
	
	public boolean jeu() {
		System.out.println();
		System.out.println("La solution du joueur est : ");
		for (int i = 0; i < 4; i++) {
			System.out.print(solutionJoueur[i]);
		}
		System.out.println();
		char[] gagnant = { '=', '=', '=', '=' };

		int[] combi = null;
		// On crée une arrayList pour stocker toutes les combinaisons
		
		// On utilise la méthode generate() pour générer toutes les combinaisons et on
		// les stock dans la arraylist
		
		char[] score;
		
		
		
			int indexAlea = (int) (Math.random() * (listeCombi.size()));
			// on utilise cet indice aléatoire pour piocher une des combinaisons de la liste
			// et la stocker dans la variable combi
			combi = listeCombi.get(indexAlea);
			// On utilise la méthode compare() pour comparer la solution et la proposition
			// de l'ordi et lui attribuer un score
			System.out.println("L'ordinateur propose : ");
			for (int i = 0; i < 4; i++) {
				System.out.print(combi[i]);
			}
			
			score = compare(combi, solutionJoueur);
			if (isSame(score, gagnant)) {
				return true;
			}
			
			System.out.println();
			
			//System.out.println(score);

			ArrayList<int[]> listeCombiCopie = new ArrayList<>(listeCombi);

			for (int[] combinaison : listeCombiCopie) {
				// On va ensuite comparer chaque combinaison restante de la liste à la
				// proposition de l'ordinateur et stocker le score dans la variable result
				char[] result = compare(combi, combinaison);
				// Si le score obtenu est différent de ce que nous avions obtenu précédemment on
				// enlève cette combinaison de la liste
				if (!isSame(result, score)) {
					listeCombi.remove(combinaison);
					//return false;
				}
				//return true;

			}
			
			return false;

	}
	
	// Méthode qui va comparer la solution et la proposition de l'ordinateur
		public char[] compare(int proposition[], int solution[]) {
			char[] ch = new char[4];
			for (int i = 0; i <= 3; i++) {
				if (solution[i] == proposition[i]) {
					ch[i] = '=';
				}
				if (proposition[i] > solution[i]) {
					ch[i] = '-';
				}
				if (proposition[i] < solution[i]) {
					ch[i] = '+';
				}
			}
			return ch;
		}

		public boolean isSame(char[] a, char[] b) {
			for (int i = 0; i < 4; i++) {
				if (a[i] != b[i]) {
					return false;
				}
			}
			return true;
		}

		// Méthode permettant de générer une arrayList comportant toutes les
		// combinaisons possibles
		public ArrayList<int[]> generate() {
			// on crée une ArrayList qui va comporter toutes les combinaisons
			ArrayList<int[]> combi = new ArrayList<>();
			// On crée 4 boucles afin de générer toutes les combinaisons de 4 chiffres
			// allant de 0 à 9
			for (int i = 0; i <= 9; i++) {
				for (int j = 0; j <= 9; j++) {
					for (int k = 0; k <= 9; k++) {
						for (int l = 0; l <= 9; l++) {
							int tab[] = { i, j, k, l };
							// Chaque combinaison généré par les boucles est stocké dans la ArrayList combi
							combi.add(tab);

						}
					}
				}
			}
			return combi;
		}

	}


	
	
