package JeuPlusMoins;

import java.util.Random;
import java.util.Scanner;

public class ModeDefenseur {
	
	private int tab[] = new int[4];
	
	public ModeDefenseur() {
		
			Scanner sc = new Scanner(System.in);
			int nb;
			String str;
			do {
			System.out.println("Veuillez entrer une combinaison de 4 chiffres");
			 str = sc.nextLine();
			 nb=str.length();
			
			for (int i = 0; i < 4; i++) {
				char c;
				//On isole chaque élément de la chaine sous forme d'un caractère
				c = str.charAt(i);
				// On veut obtenir la valeur numérique de ce caractère
				int n = Character.valueOf(c);
				//Si la valeur num du caractère est comprise entre 47 et 58 (un chiffre entre 0 et 9), on intègre cette valeur à notre tableau d'entiers
				if(n>47 && n<58) {
				tab[i] = n;
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
	public void jeu()
	{
		// on initialise la combinaison de l'ordinateur à 5555
		int combiOrdinateur[] = {5,5,5,5};
		boolean b=true;
		while(b) {
			for (int i = 0; i<4; i++) {
			System.out.print(combiOrdinateur[i]);
			}
			System.out.println();
			Scanner sc = new Scanner(System.in);
			String str="";
			int nb=0;
			do {
				
				System.out.println("Veuillez repondre par + / - ou = ");
				str = sc.nextLine();
				nb=str.length();
				//on lance une boucle avec 4 itérations : une pour chaque élément de la combinaison
				for (int i =0; i<4; i++) {
					char c;
					//Etant donné que la combinaison avec les +/-/= est une chaine, on isole chaque élément dans un caractère
					c = str.charAt(i);
					// On vérifie que l'utilisateur rentre le bon caractère, c'est à dire soit +, soit - soit =
					if (c !='+' && c != '-' && c != '=') {
						nb=0;
						System.out.println("Pas bon caractere");
					}
				}
			}while(nb!=4);
			
			int compteur = 0;
			for (int i = 0; i<4; i++) {
				char c;
				//Si l'utilisateur répond +, l'élément à la position i de CombiOrdinateur s'incrémente de 1
				c = str.charAt(i);
				if (c == '+') {
					combiOrdinateur[i] ++;
				}
				if (c == '-') {
					combiOrdinateur[i] --;
				}
				if (c == '=') {
					compteur++;
				}
			}
			if (compteur == 4) {
				//On passe le booléen à false, ce qui nous fait sortir de la boucle while
				b = false;
			System.out.println("Bravo !");
			}
			
			
			
			
		}
	}

}
