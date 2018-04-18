package com.projet3;

import java.util.Scanner;

import com.projet3.jeuplusmoins.ModeChallengerPlusMoins;
import com.projet3.jeuplusmoins.ModeDefenseurPlusMoins;
import com.projet3.jeuplusmoins.ModeDuelPlusMoins;
import com.projet3.mastermind.ModeChallengerMastermind;
import com.projet3.mastermind.ModeDefenseurMastermind;
import com.projet3.mastermind.ModeDuelMastermind;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int jeu;
		int modePlusmoins;
		int modeMastermind;
		int answerChallenger;
		int answerDefenseur;
		int answerDuel;
		int answer2 = 0;

		for (int i = 0; i < 15; i++) {
			System.out.print("-");
		}
		System.out.print("MASTERMIND");
		for (int i = 0; i < 15; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println();

		do {

			System.out.println("Veuillez choisir un jeu :");
			System.out.println();
			System.out.println("1 pour le jeu du +/-");
			System.out.println("2 pour le jeu du Mastermind");
			System.out.println();
			System.out.print("Votre choix : ");

			jeu = sc.nextInt();

			System.out.println();

			if (jeu == 1) {
				System.out.println("Vous avez choisi le jeu du +/-");
				System.out.println();
			} else if (jeu == 2) {
				System.out.println("Vous avez choisi le jeu du Mastermind");
				System.out.println();
			} else {
				System.out.println("Aucun jeu sélectionné. Veuillez sélectionner un jeu");
				System.out.println();
			}

			if (jeu == 1) {

				do {
					System.out.println("Veuillez choisir un mode pour le jeu :");
					System.out.println();
					System.out.println("1 pour le mode Challenger");
					System.out.println("2 pour le mode Défenseur");
					System.out.println("3 pour le mode Duel");
					System.out.println();
					System.out.print("Votre choix : ");

					modePlusmoins = sc.nextInt();

					switch (modePlusmoins) {
					case 1:

						do {
							System.out.println();
							System.out.println("Vous avez choisi le mode Challenger ");
							System.out.println();

							// ModeChallengerPlusMoins chal = new ModeChallengerPlusMoins();
							// chal.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");
								answerChallenger = sc.nextInt();
								if (answerChallenger != 1 && answerChallenger != 2) {
									System.out.println();
									System.out.println("Réponse incorrecte");
									System.out.println();
								}
							} while (answerChallenger != 1 && answerChallenger != 2);
						}

						while (answerChallenger == 1);
						break;

					case 2:

						do {
							System.out.println();
							System.out.println("Vous avez choisi le mode Défenseur ");
							System.out.println();

							// ModeDefenseurPlusMoins def = new ModeDefenseurPlusMoins();
							// def.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");
								answerDefenseur = sc.nextInt();
								if (answerDefenseur != 1 && answerDefenseur != 2) {
									System.out.println();
									System.out.println("Réponse incorrecte");
									System.out.println();
								}
							} while (answerDefenseur != 1 && answerDefenseur != 2);

						}

						while (answerDefenseur == 1);
						break;

					case 3:

						do {
							System.out.println();
							System.out.println("Vous avez choisi le mode Duel ");
							System.out.println();

							// ModeDuelPlusMoins duel = new ModeDuelPlusMoins();
							// duel.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");
								answerDuel = sc.nextInt();
								if (answerDuel != 1 && answerDuel != 2) {
									System.out.println();
									System.out.println("Réponse incorrecte");
									System.out.println();
								}

							} while (answerDuel != 1 && answerDuel != 2);
						}

						while (answerDuel == 1);

						break;

					default:
						System.out.println();
						System.out.println("Aucun mode sélectionné. Veuillez sélectionner un mode");
						System.out.println();

					}

				}

				while (modePlusmoins != 1 && modePlusmoins != 2 && modePlusmoins != 3);

				do {
					System.out.println();
					System.out.println("Voulez-vous jouer à un autre jeu ? 1 : Oui 2 : Non");
					System.out.println();
					System.out.print("Votre choix : ");
					answer2 = sc.nextInt();
					System.out.println();
				} while (answer2 != 1 && answer2 != 2);
				if (answer2 == 2) {
					System.out.println("A bientôt");
				}

			}

			else if (jeu == 2) {

				do {
					System.out.println("Veuillez choisir un mode pour le jeu : ");
					System.out.println();
					System.out.println("1 pour le mode Challenger");
					System.out.println("2 pour le mode Défenseur");
					System.out.println("3 pour le mode Duel");
					System.out.println();
					System.out.print("Votre choix : ");

					modeMastermind = sc.nextInt();

					switch (modeMastermind) {
					case 1:

						do {
							System.out.println();
							System.out.println("Vous avez choisi le mode Challenger ");
							System.out.println();

							// ModeChallengerMastermind chal = new ModeChallengerMastermind();
							// chal.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");
								answerChallenger = sc.nextInt();
								if (answerChallenger != 1 && answerChallenger != 2) {
									System.out.println();
									System.out.println("Réponse incorrecte");
									System.out.println();
								}
							} while (answerChallenger != 1 && answerChallenger != 2);
						}

						while (answerChallenger == 1);
						break;

					case 2:
						do {
							System.out.println();
							System.out.println("Vous avez choisi le mode Défenseur ");
							System.out.println();

							// ModeDefenseurMastermind def = new ModeDefenseurMastermind();
							// def.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");
								answerDefenseur = sc.nextInt();
								if (answerDefenseur != 1 && answerDefenseur != 2) {
									System.out.println();
									System.out.println("Réponse incorrecte");
									System.out.println();
								}
							} while (answerDefenseur != 1 && answerDefenseur != 2);

						}

						while (answerDefenseur == 1);
						break;

					case 3:
						do {
							System.out.println();
							System.out.println("Vous avez choisi le mode Duel ");
							System.out.println();

							// ModeDuelMastermind duel = new ModeDuelMastermind();
							// duel.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");
								answerDuel = sc.nextInt();
								if (answerDuel != 1 && answerDuel != 2) {
									System.out.println();
									System.out.println("Réponse incorrecte");
									System.out.println();
								}

							} while (answerDuel != 1 && answerDuel != 2);
						}

						while (answerDuel == 1);

						break;
					default:
						System.out.println("Aucun mode sélectionné. Veuillez sélectionner un mode : ");

					}

				}

				while (modeMastermind != 1 && modeMastermind != 2 && modeMastermind != 3);

				do {
					System.out.println();
					System.out.println("Voulez-vous jouer à un autre jeu ? 1 : Oui 2 : Non");
					System.out.println();
					System.out.print("Votre choix : ");
					answer2 = sc.nextInt();
					System.out.println();
				} while (answer2 != 1 && answer2 != 2);
				if (answer2 == 2) {
					System.out.println("A bientôt");
				}

			}

		} while (jeu != 1 && jeu != 2 || answer2 == 1);
	}

}
