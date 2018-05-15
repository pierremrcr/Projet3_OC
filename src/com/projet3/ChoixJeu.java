package com.projet3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import com.projet3.jeuplusmoins.ModeChallengerPlusMoins;
import com.projet3.jeuplusmoins.ModeDefenseurPlusMoins;
import com.projet3.jeuplusmoins.ModeDuelPlusMoins;
import com.projet3.mastermind.ModeChallengerMastermind;
import com.projet3.mastermind.ModeDefenseurMastermind;
import com.projet3.mastermind.ModeDuelMastermind;

public class ChoixJeu {

	int nbChiffres = 0;
	int nbCases = 0;
	int nbEssais = 0;
	boolean modedev = false;
	Properties prop = new Properties();
	InputStream input = null;

	public Mode getMode(int jeu, int mode) {

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

		if (jeu == 1) {
			System.out.println("Vous avez choisi le jeu du +/-");
			if (mode == 1) {
				System.out.println("Vous avez choisi le mode Challenger");
				System.out.println();
				return new ModeChallengerPlusMoins((byte) nbCases, (byte) nbEssais, modedev);
			} else if (mode == 2) {
				System.out.println("Vous avez choisi le mode Défenseur");
				System.out.println();
				return new ModeDefenseurPlusMoins((byte) nbCases, (byte) nbEssais);
			} else if (mode == 3) {
				System.out.println("Vous avez choisi le mode Duel");
				System.out.println();
				return new ModeDuelPlusMoins((byte) nbCases, modedev);
			}

		} else if (jeu == 2) {
			System.out.println("Vous avez choisi le jeu du Mastermind");
			if (mode == 1) {
				System.out.println("Vous avez choisi le mode Challenger");
				System.out.println();
				return new ModeChallengerMastermind((byte) nbCases, (byte) nbChiffres, modedev, (byte) nbEssais);
			} else if (mode == 2) {
				System.out.println("Vous avez choisi le mode Défenseur");
				System.out.println();
				return new ModeDefenseurMastermind((byte) nbCases, (byte) nbChiffres, (byte) nbEssais);
			} else if (mode == 3) {
				System.out.println("Vous avez choisi le mode Duel");
				System.out.println();
				return new ModeDuelMastermind((byte) nbCases, (byte) nbChiffres, modedev);
			}

		}
		return null;

	}

}
