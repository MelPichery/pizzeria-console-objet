package com.pizzeria.appli;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.Scanner;

import com.pizzeria.classe.CategoriePizza;
import com.pizzeria.classe.Pizza;
import com.pizzeria.model.PizzaMemDao;
import com.pizzeria.exception.*;
import com.pizzeria.model.PizzaPrixCroissantComparator;
import com.pizzeria.model.PizzaPrixDecroissantComparator;
import com.pizzeria.model.PizzaPrixCroissantComparator;


public class PizzeriaAdminConsoleApp {

	
	private static Scanner sc = new Scanner(System.in);
	private static Scanner sc1 = new Scanner(System.in);
	private static Scanner sc2 = new Scanner(System.in);
	private static Scanner sc3 = new Scanner(System.in);
	
	public static void main(String[] args)  {
		
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		
		//pour mettre fin au programme
		boolean stopP = false;
		
		// affichage du menu 
		displayMenu();
		
		
		String code = null;
		String name = null;
		Double price = null;
		
		
		
		/**
		 * boucle tant pour afficher le menu tant que l'utilisateur ne tape pas 99 
		 * */
		//scan.nextLine();
		while(!stopP) {
			
			System.out.println("----------------------");
			
			// saisie de l'utilisateur
			int value = sc.nextInt();
			
			// affiche la liste des pizzas
			if (value == 1) {
			
				System.out.println("Affichage des pizzas:");
				try {
					System.out.println(pizzaMemDao.findAllPizzas());
				} catch (SQLException e) {

					e.printStackTrace();
				}
				displayMenu();
			}
			// ajoute une nouvelle pizza
			else if (value == 2)
			{
				
					System.out.println("Ajout d’une nouvelle pizza");
					sc.nextLine();
					System.out.println("Veuillez saisir le code");
					code = sc.nextLine();
					System.out.println("Veuillez saisir le nom (sans espace) :");
					name = sc.nextLine();
					System.out.println("Veuillez saisir le prix:");
					price = Double.valueOf(sc.nextLine());
					
					
					System.out.println("Veuillez saisir la catégorie :");
					int id_categorie=sc.nextInt();	
					
					CategoriePizza cp = new CategoriePizza();
				
					cp.setId(id_categorie);
					
					Pizza newPizza = new Pizza(code, name, price, cp);
					
						
					try {
						
						pizzaMemDao.saveNewPizza(newPizza);
						
					} catch (SavePizzaException e) {
						
						System.out.println(e.getMessage());
						
					} catch (SQLException e) {	
						
						System.out.println(e.getMessage());
						
					} catch (StockageException e) {

						System.out.println(e.getMessage());
					}															
					finally
					{
						displayMenu();
					}
			}
			// mise a jour d'une pizza	
			else if (value == 3)
			{
				
					System.out.println("Mise à jour d’une pizza");
					try {
						System.out.println(pizzaMemDao.findAllPizzas());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sc.nextLine();
					System.out.println("Veuillez saisir l'id de la pizza à modifier");
					int id = sc.nextInt();
					System.out.println("Veuillez saisir le nouveau code");
					code = sc1.nextLine();
					System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
					name = sc2.nextLine();
					System.out.println("Veuillez saisir le nouveau prix:");
					price = Double.valueOf(sc3.nextLine());
					System.out.println("Veuillez saisir l'id de la catégorie :\r\n");
					int id_categorie = sc.nextInt();
										
					CategoriePizza cp = new CategoriePizza();
					
					cp.setId(id_categorie);
					
					Pizza newPizza = new Pizza(code, name, price, cp);
												
					try {
						
						pizzaMemDao.updatePizza(id, newPizza);
						
					} catch (UpDatePizzaException e) {
		
						System.out.println(e.getMessage());
						
					} catch (SQLException e) {
						
						System.out.println(e.getMessage());
		
					} catch (StockageException e) {
						
						System.out.println(e.getMessage());

					}															
					finally
					{
						displayMenu();
					}
			}
			// suppression d'une pizza
			else if (value == 4)
			{
								
					System.out.println("Suppression d’une pizza");
					try {
						pizzaMemDao.findAllPizzas();
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					sc.nextLine();
					System.out.println("Veuillez saisir l'id de la pizza à supprimer");
					int id = sc.nextInt();
	
					try {
						
						pizzaMemDao.deletePizza(id);
						
					} catch (DeletePizzaException e) {
						
						System.out.println(e.getMessage());
						
					} catch (SQLException e) {

						System.out.println(e.getMessage());
					}						
					finally
					{
						displayMenu();
					}
			}
			else if (value == 5)
			{
				System.out.println("Affichage des pizzas par prix croissants");
				List<Pizza> pizzas;
				try {
					pizzas = pizzaMemDao.findAllPizzas();
					Collections.sort(pizzas, new PizzaPrixCroissantComparator());
					PizzaMemDao.displayAllPizza(pizzas);
					displayMenu();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (value == 6)
			{
				System.out.println("Affichage des pizzas par prix décroissants");
				List<Pizza> pizzas;
				try {
					pizzas = pizzaMemDao.findAllPizzas();
					Collections.sort(pizzas, new PizzaPrixDecroissantComparator());
					PizzaMemDao.displayAllPizza(pizzas);
					displayMenu();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			// demande de sortie du programme
			else if (value == 99)
			{
				System.out.println("Au revoir");
				
				stopP = true;
			}
			
		}
	}
	
	
	public static void displayMenu() {
		String menu = "\r\n\r\n====================================="
				+ "\r\n\r\n***** Pizzeria Administration *****\r\n" 
				+ "1. Afficher les pizzas\r\n"
				+ "2. Ajouter une nouvelle pizza\r\n" 
				+ "3. Mettre à jour une pizza\r\n" 
				+ "4. Supprimer une pizza\r\n"
				+ "5. Afficher les pizzas par prix croissants\r\n"
				+ "6. Afficher les pizzas par prix décroissants\r\n"
				+ "99. Sortir\r\n"
				+ "=====================================\r\n\r\n";
		
		
		System.out.println(menu);
		
		
		
	}

}
