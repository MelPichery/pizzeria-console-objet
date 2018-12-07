package com.pizzeria.classe;

import com.pizzeria.exception.StockageException;


public class Pizza {
	/*
	 * Id (ou identifiant unique pour chaque Pizza) : 1 Code : MAR Désignation :
	 * MARGARITA Prix : 9,20 €
	 */
	private int id;
	private String code = null;
	private String designation = null;
	private Double price = null;
	private CategoriePizza categoriepizza = null;
	
	
	public static final double PRICE_MIN = 4;
	public static final double PRICE_MAX = 100;
	public static final double CODE_LENGTH = 3;
	
	

	private static int lastId = -1;

	
	public Pizza() {
		
	}
	
	/**
	 * 
	 * Constructeur de la classe Pizza
	 * 
	 * @param code        de la pizza (les trois premieres lettre en Maj)
	 * @param designation Nom de la pizza
	 * @param price       prix de la pizza
	 */
	
	
	

	public void setId(int id) {
		this.id = id;
	}

	public Pizza(String code, String designation, Double price, CategoriePizza categoriepizza) {
		super();
		this.code = code;
		this.designation = designation;
		this.price = price;
		this.categoriepizza = categoriepizza;
	}

	
	
	
	public CategoriePizza getCategoriepizza() {
		return categoriepizza;
	}

	public void setCategoriepizza(CategoriePizza categoriepizza) {
		this.categoriepizza = categoriepizza;
	}

	/**
	 * 
	 * @return retourne le code de la pizza
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @param code modifi le code de la pizza
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 
	 * @return retourne la designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * 
	 * @param designation modifie la designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * 
	 * @return retourne le prix de la pizza
	 */
	public Double getPrice() {
		return price;
	}
	
	

	
	

	/**
	 * 
	 * @param price modification du prix
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}


	public String toString() {

		return this.id + " : " + this.code + " -> " + this.designation + " - " + this.categoriepizza + "(" + this.price + " €)\n";
	}

	public void dataControl() throws StockageException
	{
		String message = "";
		
		if (id < 0)
		{
			message += "Le ID de la pizza est négatif\r\n";
		}
		
		if (code == null || code.trim().length() != CODE_LENGTH)
		{
			message += "Le code de la pizza n'est pas sur " + CODE_LENGTH + " caractères\r\n";
		}
		
		if (designation == null || designation.trim().length() <= 0)
		{
			message += "La désignation de la pizza doit être renseignée\r\n";
		}
		
		if (price == null || price.doubleValue() < PRICE_MIN || price.doubleValue() > PRICE_MAX)
		{
			message += "Le prix doit être renseigné et compris entre " + PRICE_MIN + " et " + PRICE_MAX + "\r\n";
		}
		
		if (message != null && message.trim().length() > 0)
		{
			throw new StockageException(message);
		}
	}

	
}
