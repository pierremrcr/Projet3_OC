package JeuPlusMoins;

import java.util.Random;
import java.util.Scanner;

public class ModeChallenger {

	private int tab[] = new int[4];

	public ModeChallenger() {
		for (int i = 0; i < 4; i++) {
			Random r = new Random();

			tab[i] = r.nextInt(9);
		}
	}

	public void jeu() {
		boolean test = true;
		for (int i = 0; i < 4; i++) {
			System.out.print(tab[i]);

		}
		System.out.println(" ");
		while (test == true) {

			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez entrer une combinaison");
			String str = sc.nextLine();
			int cmb = Integer.parseInt(str);
			System.out.println(cmb);

			if (verif(str) == true) {
				test = false;
			}

		}
		System.out.println(" ");
		System.out.println("Bravo !");
	}

	boolean verif(String verif) {
		boolean combi = true;
		for (int i = 0; i < 4; i++) {
			char c =verif.charAt(i);
			int cmb = Character.getNumericValue(c);
			if (cmb == tab[i]) {
				System.out.print("=");
			} else if (cmb < tab[i]) {
				System.out.print("+");
				combi = false;

			} else {
				System.out.print("-");
				combi = false;
			}

		}
		return combi;
	}

}
