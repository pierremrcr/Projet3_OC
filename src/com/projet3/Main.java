package com.projet3;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.projet3.jeuplusmoins.ModeChallengerPlusMoins;
import com.projet3.jeuplusmoins.ModeDefenseurPlusMoins;
import com.projet3.jeuplusmoins.ModeDuelPlusMoins;
import com.projet3.mastermind.ModeChallengerMastermind;
import com.projet3.mastermind.ModeDefenseurMastermind;
import com.projet3.mastermind.ModeDuelMastermind;

public class Main {

	public static void main(String[] args) {

		Properties prop = new Properties();
		InputStream input = null;
		int nbChiffres = 0;
		int nbCases = 0;
		int nbEssais = 0;
		boolean modedev = false;
		Logger logger = LogManager.getLogger();

		if ((args.length > 0 && args[0].equals("dev")) || modedev) {
			modedev = true;
		} else {
			modedev = false;
		}

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			nbChiffres = Integer.valueOf(prop.getProperty("nbChiffres"));
			nbCases = Integer.valueOf(prop.getProperty("nbCases"));
			nbEssais = Integer.valueOf(prop.getProperty("nbEssais"));
			modedev = Boolean.parseBoolean((prop.getProperty("modedev")));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int jeu = 0;
		int modePlusmoins = 0;
		int modeMastermind = 0;
		int answerChallenger = 0;
		int answerDefenseur = 0;
		int answerDuel = 0;
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

			System.out.print("Veuillez choisir un jeu : ");
			if (modedev == true) {
				System.out.println("(Mode Développeur activé)");
			}
			System.out.println();
			System.out.println("1 pour le jeu du +/-");
			System.out.println("2 pour le jeu du Mastermind");
			System.out.println("3 pour quitter");
			System.out.println();
			System.out.print("Votre choix : ");

			if (!sc.hasNextInt()) {

				System.out.println();
				System.out.println("Vous n'avez pas sélectionné la bonne touche.");
				System.out.println("Veuillez choisir parmi les propositions :");
				System.out.println();

				sc.next();

				continue;
			}

			jeu = sc.nextInt();

			logger.trace("l'utilisateur a choisi le jeu " + jeu);

			System.out.println();

			if (jeu == 1) {
				System.out.println("Vous avez choisi le jeu du +/-");
				System.out.println();
			} else if (jeu == 2) {
				System.out.println("Vous avez choisi le jeu du Mastermind");
				System.out.println();
			} else if (jeu == 3) {
				System.out.println("A bientôt");
				System.out.println();
			}

			else {
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

					if (!sc.hasNextInt()) {

						System.out.println();
						System.out.println("Vous n'avez pas sélectionné la bonne touche.");
						System.out.println("Veuillez choisir parmi les propositions :");
						System.out.println();

						sc.next();

						continue;
					}

					modePlusmoins = sc.nextInt();

					logger.trace("l'utilisateur a choisi le mode " + modePlusmoins);

					switch (modePlusmoins) {
					case 1:

						do {
							System.out.println();
							System.out.println("Vous avez choisi le mode Challenger ");
							System.out.println();

							ModeChallengerPlusMoins chal = new ModeChallengerPlusMoins((byte) nbCases, (byte) nbEssais,
									modedev);
							chal.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");

								if (!sc.hasNextInt()) {

									System.out.println();
									System.out.println("Vous n'avez pas sélectionné la bonne touche.");
									System.out.println("Veuillez choisir parmi les propositions :");
									System.out.println();

									sc.next();

									continue;
								}

								answerChallenger = sc.nextInt();

								logger.trace("l'utilisateur a choisi la réponse" + answerChallenger);
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

							ModeDefenseurPlusMoins defplusmoins = new ModeDefenseurPlusMoins((byte) nbEssais,
									(byte) nbCases);
							defplusmoins.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");

								if (!sc.hasNextInt()) {

									System.out.println();
									System.out.println("Vous n'avez pas sélectionné la bonne touche.");
									System.out.println("Veuillez choisir parmi les propositions :");
									System.out.println();

									sc.next();

									continue;
								}
								answerDefenseur = sc.nextInt();
								logger.trace("l'utilisateur a choisi la réponse" + answerDefenseur);
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

							ModeDuelPlusMoins duelPlusMoins = new ModeDuelPlusMoins((byte) nbCases, modedev);
							duelPlusMoins.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");

								if (!sc.hasNextInt()) {

									System.out.println();
									System.out.println("Vous n'avez pas sélectionné la bonne touche.");
									System.out.println("Veuillez choisir parmi les propositions :");
									System.out.println();

									sc.next();

									continue;
								}

								answerDuel = sc.nextInt();
								logger.trace("l'utilisateur a choisi la réponse" + answerDuel);
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

					if (!sc.hasNextInt()) {

						System.out.println();
						System.out.println("Vous n'avez pas sélectionné la bonne touche.");
						System.out.println("Veuillez choisir parmi les propositions :");
						System.out.println();

						sc.next();

						continue;
					}

					answer2 = sc.nextInt();
					logger.trace("l'utilisateur a choisi la réponse" + answer2);
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

					if (!sc.hasNextInt()) {

						System.out.println();
						System.out.println("Vous n'avez pas sélectionné la bonne touche.");
						System.out.println("Veuillez choisir parmi les propositions :");
						System.out.println();

						sc.next();

						continue;
					}

					modeMastermind = sc.nextInt();
					logger.trace("l'utilisateur a choisi le mode" + modeMastermind);

					switch (modeMastermind) {
					case 1:

						do {
							System.out.println();
							System.out.println("Vous avez choisi le mode Challenger ");
							System.out.println();

							ModeChallengerMastermind chal = new ModeChallengerMastermind((byte) nbCases,
									(byte) nbChiffres, modedev, (byte) nbEssais);
							chal.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");

								if (!sc.hasNextInt()) {

									System.out.println();
									System.out.println("Vous n'avez pas sélectionné la bonne touche.");
									System.out.println("Veuillez choisir parmi les propositions :");
									System.out.println();

									sc.next();

									continue;
								}

								answerChallenger = sc.nextInt();
								logger.trace("l'utilisateur a choisi la réponse" + answerChallenger);
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

							ModeDefenseurMastermind defMastermind = new ModeDefenseurMastermind((byte) nbEssais,
									(byte) nbChiffres, (byte) nbCases);
							defMastermind.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");

								if (!sc.hasNextInt()) {

									System.out.println();
									System.out.println("Vous n'avez pas sélectionné la bonne touche.");
									System.out.println("Veuillez choisir parmi les propositions :");
									System.out.println();

									sc.next();

									continue;
								}

								answerDefenseur = sc.nextInt();
								logger.trace("l'utilisateur a choisi la réponse" + answerDefenseur);
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

							ModeDuelMastermind duel = new ModeDuelMastermind((byte) nbCases, (byte) nbChiffres,
									modedev);
							duel.jeu();

							do {
								System.out.println("Voulez vous rejouer ? 1 : Oui 2 : Non");
								System.out.println();
								System.out.print("Votre choix : ");

								if (!sc.hasNextInt()) {

									System.out.println();
									System.out.println("Vous n'avez pas sélectionné la bonne touche.");
									System.out.println("Veuillez choisir parmi les propositions :");
									System.out.println();

									sc.next();

									continue;
								}

								answerDuel = sc.nextInt();
								logger.trace("l'utilisateur a choisi la réponse" + answerDuel);
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

					if (!sc.hasNextInt()) {

						System.out.println();
						System.out.println("Vous n'avez pas sélectionné la bonne touche.");
						System.out.println("Veuillez choisir parmi les propositions :");
						System.out.println();

						sc.next();

						continue;
					}

					answer2 = sc.nextInt();
					logger.trace("l'utilisateur a choisi la réponse" + answer2);
					System.out.println();
				} while (answer2 != 1 && answer2 != 2);
				if (answer2 == 2) {
					System.out.println("A bientôt");
				}

			}

		} while (jeu != 1 && jeu != 2 && jeu != 3 || answer2 == 1);
	}

}
