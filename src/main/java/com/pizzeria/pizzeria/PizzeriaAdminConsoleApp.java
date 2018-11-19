package com.pizzeria.pizzeria;

import java.util.Scanner;
/**
 * 
 * @author Mélanie Pichery
 * test de la classe Pizza et affichage du menu
 *
 */
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		int option = 0;
		Scanner sc = new Scanner(System.in);
		Boolean continuer = true;
	
		//Tant que continuer est à vrai, affichage du menu
		while (continuer) {
			
			System.out.println("***** Pizzeria Administration *****\n1.\tLister des pizzas\n2.\tAjouter une nouvelle pizza\n"
					+ "3.\tMettre à jour une pizza\n4.\tSupprimer une pizza\n99.\tSortir");
			
			//affichage et sauvegarde de l'option donnée par l'utilisateur
			System.out.println("\nVeuillez faire un choix");
			option = sc.nextInt();

			//différents affichages suivant le choix utilisateur
			if (option == 1) {
				
				System.out.println("Liste des pizzas");
				Pizza pizza = new Pizza("MAR","MARGARITA", 9.20);
				System.out.println(pizza.toString());
			}
			
			if (option == 2) {
				
				System.out.println("Ajout d'une nouvelle pizza");
				
			}
			
			if (option == 3) {
				
				System.out.println("Mise à jour d'une pizza");
				
			}
			
			if (option == 4) {
				
				System.out.println("Suppression d'une pizza");
				
			}
			
			if (option == 99) {
				
				System.out.println("Au revoir");
				
				sc.close();
				//Pour sortir de la boucle, continuer passe à faux
				continuer = false ;
				
			}
			
		}
		
	}

}
