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
		
		for(int i = 0; i<15; i++) {
			System.out.print("-");
		}
		System.out.print("MASTERMIND");
		for(int i = 0; i<15; i++) {
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
						ModeChallengerPlusMoins chal = new ModeChallengerPlusMoins();
						chal.jeu();
						do {
							System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
							answerChallenger = sc.nextInt();
							if (answerChallenger != 1 && answerChallenger != 2) {
								System.out.println("Réponse incorrecte");
							} else if (answerChallenger == 1) {
								ModeChallengerPlusMoins chal2 = new ModeChallengerPlusMoins();
								chal2.jeu();
							}
						}

						while (answerChallenger == 1 || answerChallenger != 2);
						break;

					case 2:
						ModeDefenseurPlusMoins def = new ModeDefenseurPlusMoins();
						def.jeu();
						do {
							System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
							answerDefenseur = sc.nextInt();
							if (answerDefenseur != 1 && answerDefenseur != 2) {
								System.out.println("Réponse incorrecte");
							} else if (answerDefenseur == 1) {
								ModeDefenseurPlusMoins def2 = new ModeDefenseurPlusMoins();
								def2.jeu();
								System.out.println("Vous avez choisi le mode Défenseur");
							}
						}

						while (answerDefenseur == 1 || answerDefenseur != 2);
						break;

					case 3:
						ModeDuelPlusMoins duel = new ModeDuelPlusMoins();
						duel.jeu();
						do {
							System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
							answerDuel = sc.nextInt();
							if (answerDuel != 1 && answerDuel != 2) {
								System.out.println("Réponse incorrecte");
							} else if (answerDuel == 1) {
								ModeDuelPlusMoins duel2 = new ModeDuelPlusMoins();
								duel2.jeu();
							}
						}

						while (answerDuel == 1 || answerDuel != 2);

						break;
					default:
						System.out.println("Aucun mode sélectionné. Veuillez sélectionner un mode");

					}

				}

				while (modePlusmoins != 1 && modePlusmoins != 2 && modePlusmoins != 3);
				
				do {
					System.out.println("Voulez-vous jouer à un autre jeu ? 1 : Oui 2 : Non");
					answer2 = sc.nextInt();
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
						ModeChallengerMastermind chal = new ModeChallengerMastermind();
						chal.jeu();
						do {
							System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
							answerChallenger = sc.nextInt();
							if (answerChallenger != 1 && answerChallenger != 2) {
								System.out.println("Réponse incorrecte");
							} else if (answerChallenger == 1) {
								ModeChallengerMastermind chal2 = new ModeChallengerMastermind();
								chal2.jeu();
							}
						}

						while (answerChallenger == 1 || answerChallenger != 2);
						break;

					case 2:
						ModeDefenseurMastermind def = new ModeDefenseurMastermind();
						def.jeu();
						do {
							System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
							answerDefenseur = sc.nextInt();
							if (answerDefenseur != 1 && answerDefenseur != 2) {
								System.out.println("Réponse incorrecte");
							} else if (answerDefenseur == 1) {
								ModeDefenseurMastermind def2 = new ModeDefenseurMastermind();
								def2.jeu();
								
							}
						}

						while (answerDefenseur == 1 || answerDefenseur != 2);
						break;

					case 3:
						ModeDuelMastermind duel = new ModeDuelMastermind();
						duel.jeu();
						do {
							System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
							answerDuel = sc.nextInt();
							if (answerDuel != 1 && answerDuel != 2) {
								System.out.println("Réponse incorrecte");
							} else if (answerDuel == 1) {
								ModeDuelMastermind duel2 = new ModeDuelMastermind();
								duel2.jeu();
							}
						}

						while (answerDuel == 1 || answerDuel != 2);

						break;
					default:
						System.out.println("Aucun mode sélectionné. Veuillez sélectionner un mode : ");

					}

					do {
						System.out.println("Voulez-vous jouer à un autre jeu ? 1 : Oui 2 : Non");
						answer2 = sc.nextInt();
					} while (answer2 != 1 && answer2 != 2);
					if (answer2 == 2) {
						System.out.println("A bientôt");
					}

				}

				while (modeMastermind != 1 && modeMastermind != 2 && modeMastermind != 3);
				
				do {
					System.out.println("Voulez-vous jouer à un autre jeu ? 1 : Oui 2 : Non");
					answer2 = sc.nextInt();
				} while (answer2 != 1 && answer2 != 2);
				if (answer2 == 2) {
					System.out.println("A bientôt");
				}

			}

		} while (jeu != 1 && jeu != 2 || answer2 == 1);
	}

}
