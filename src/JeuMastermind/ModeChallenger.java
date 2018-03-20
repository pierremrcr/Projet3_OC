package JeuMastermind;

import java.util.Random;
import java.util.Scanner;

public class ModeChallenger {
	private int nbChiffre = 4;
	private int tab[] = new int[nbChiffre]; // On déclare un tableau int de 4 chiffres

	public ModeChallenger() {
		for (int i = 0; i < nbChiffre; i++) {
			Random r = new Random();

			tab[i] = r.nextInt(9); // Chaque chiffre de la combinaison va recevoir une valeur aléatoire entre 0 et
									// 9
		}
	}

	public void jeu() {
		boolean test = true;
		for (int i = 0; i < 4; i++) {
			System.out.print(tab[i]); // On affiche la combinaison gagnante

		}
		System.out.println(" ");
		while (test == true) {

			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez entrer une combinaison");
			String str = sc.nextLine();

			int cmb = Integer.parseInt(str); // On caste la combinaison dans un entier puisque sc.nextLine() est un
												// String

			if (verif(str) == true) {
				test = false;

			}

		}
		
		System.out.println(" ");
		System.out.println("Bravo !");
	}

	boolean verif(String verif) {
		// boolean combi = true;
		int mal = 0, bien = 0;
		for (int i = 0; i < nbChiffre; i++) { // Première boucle parcourant la combinaison à deviner
			boolean bienPlace = false;
			boolean malPlace = false;

			for (int j = 0; j < nbChiffre; j++) { // Deuxième boucle parcourant la proposition
				// Chaque caractère de la proposition est casté pour avoir un int
				int cmb = Character.getNumericValue(verif.charAt(j));
				// Comparaison de la proposition par rapport à la combinaison
				if (cmb == tab[i]) {
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
		System.out.printf("Votre reponse : %d presents et %d bien places", mal, bien);

		if (bien == nbChiffre)
			return true;
		else
			return false;
	}

}
