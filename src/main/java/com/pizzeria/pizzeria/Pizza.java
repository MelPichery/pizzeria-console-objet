package com.pizzeria.pizzeria;

import com.pizerria.model.CategoriePizzaEnum;
import com.pizzeria.exception.StockageException;

public class Pizza {

	//attributs de la classe
	private int id;
	private String code;
	private String designation;
	private Double prix;
	private CategoriePizzaEnum categoriePizza ;
	
	private final int LONGUEUR_CODE = 3;
	private final int PRIX_MAX = 15;
	private final int PRIX_MIN = 4;
	
	
	
	public static int compteur = 0;

	//Constructeur
	/**
	 * 
	 * @param code code pizza
	 * @param designation nom pizza
	 * @param prix prix de la pizza à l'unité
	 */
	public Pizza(String code, String designation, Double prix) {
		
		this.id = ++compteur;
		this.code = code;
		this.designation = designation;
		this.prix = prix;
	}
	
	

	public Pizza( String code, String designation, Double prix, CategoriePizzaEnum categoriePizza) {
		super();
		this.id = ++compteur;
		this.code = code;
		this.designation = designation;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
	}



	//Les getters et setters
	public int getId() {
		return id;
	}
	

	public String getCode() {
		return code;
	}

	
	public void setCode(String code) {
		this.code = code;
	}

	
	public String getDesignation() {
		return designation;
	}

	
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
	public Double getPrix() {
		return prix;
	}

	
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
				
	public CategoriePizzaEnum getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizzaEnum categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

	
	public void dataControl() throws StockageException {
		
		if(code.length() != LONGUEUR_CODE || code.trim().length() == 0) {
			throw new StockageException("Pizza : Code pizza est vide ou ne contient pas 3 caractères");
		}
		
		else if (prix < PRIX_MIN || prix > PRIX_MAX) {
			
			throw new StockageException("Pizza : Le prix est trop bas ou trop élevé");			
			
		}
		
		else if(designation.trim().length() == 0) {
			
			throw new StockageException("Pizza : La désignation est vide");
			
		}
		
		/*else if (!categoriePizza.equals(CategoriePizzaEnum.values())) {
			
			throw new StockageException("Pizza : cette catégorie n'existe pas");
			
		}*/
		
	}
	
	
	@Override
	public String toString() {
		//return "id: " + id + "\ncode: " + code + "\ndesignation: " + designation + "\nprix : " + prix + " €";
		return code+"->"+designation+"("+prix+") Catégorie : "+categoriePizza+"\n" ; 
	}

	
	
}
