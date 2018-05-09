package com.projet3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int nbChiffres = 0;
		int nbCases = 0;
		int nbEssais = 0;
		boolean modedev = false;
		int answer = 0;
		int answer2 = 0;
		int mode = 0;
		int jeu = 0;

		Logger logger = LogManager.getLogger();

		if ((args.length > 0 && args[0].equals("dev")) || modedev == true) {
			modedev = true;
		} else {
			modedev = false;
		}
		
		

		
		System.out.print("----------------------");
		System.out.print("MASTERMIND");
		System.out.print("----------------------");
		System.out.println();
		System.out.println();

		do {

			System.out.println("Veuillez choisir un jeu : ");
			System.out.println();
			System.out.println("1 pour le jeu du +/-");
			System.out.println("2 pour le jeu du Mastermind");
			System.out.println("3 pour quitter");
			System.out.println();
			System.out.print("Votre choix : ");
			
			if (!sc.hasNextInt()) {

				System.out.println();
				System.out.println("Vous n'avez pas sélectionné la bonne touche.");
				logger.warn("L'utilisateur n'a pas rentré de chiffres entre 1 et 3 compris");
				System.out.println("Veuillez choisir parmi les propositions :");
				System.out.println();
				sc.next();

				continue;
			}

			jeu = sc.nextInt();

			if (jeu == 1 || jeu == 2) {

				do {

					System.out.println("Veuillez choisir un mode pour le jeu :");
					System.out.println();
					System.out.println("1 pour le mode Challenger");
					System.out.println("2 pour le mode Défenseur");
					System.out.println("3 pour le mode Duel");
					System.out.println();
					System.out.print("Votre choix : ");
					
					if (!sc.hasNextInt()) {

						System.out.println();
						System.out.println("Vous n'avez pas sélectionné la bonne touche.");
						logger.warn("L'utilisateur n'a pas rentré de chiffres entre 1 et 3 compris");
						System.out.println("Veuillez choisir parmi les propositions :");
						System.out.println();
						sc.next();

						continue;
					}

					mode = sc.nextInt();

					if (mode != 1 && mode != 2 && mode != 3) {
						System.out.println();
						System.out.println("Aucun mode sélectionné");
						System.out.println();
					}

				} while (mode != 1 && mode != 2 && mode != 3);

				do {

					ChoixJeu choix = new ChoixJeu();
					Mode modeJoueur = choix.GetMode(jeu, mode);
					modeJoueur.jeu();

					do {

						System.out.println("Voulez vous rejouer ? 1 : OUI 2 : NON");
						
						if (!sc.hasNextInt()) {

							System.out.println();
							System.out.println("Vous n'avez pas sélectionné la bonne touche.");
							logger.warn("L'utilisateur n'a pas rentré de chiffres entre 1 et 2 compris");
							System.out.println("Veuillez choisir parmi les propositions :");
							System.out.println();
							sc.next();

							continue;
						}

						answer = sc.nextInt();

					} while (answer != 1 && answer != 2);

				} while (answer == 1);

				if (answer == 2) {
					System.out.println("Voulez vous jouer à un autre jeu ? 1 : OUI 2 : NON");
					if (!sc.hasNextInt()) {

						System.out.println();
						System.out.println("Vous n'avez pas sélectionné la bonne touche.");
						logger.warn("L'utilisateur n'a pas rentré de chiffres entre 1 et 3 compris");
						System.out.println("Veuillez choisir parmi les propositions :");
						System.out.println();
						sc.next();

						continue;
					}
					answer2 = sc.nextInt();
				}
				if (answer2 ==2) {
					System.out.println("A bientôt");
					System.out.println();
				}
			} else if (jeu == 3 || answer2==2) {
				System.out.println("A bientôt");
				System.out.println();
			} else {
				System.out.println();
				System.out.println("Aucun jeu Sélectionné");
				System.out.println();
			}
		} while ((jeu != 1 && jeu != 2 && jeu != 3) || answer2 == 1);

	}

	
}
	
	