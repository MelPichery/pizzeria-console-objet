package com.pizzeria.pizzeria;

public class Pizza {

	//attributs de la classe
	private int id;
	private String code;
	private String designation;
	private double prix;
	
	
	public static int compteur = 0;

	//Constructeur
	/**
	 * 
	 * @param code code pizza
	 * @param designation nom pizza
	 * @param prix prix de la pizza à l'unité
	 */
	public Pizza(String code, String designation, double prix) {
		
		this.id = ++compteur;
		this.code = code;
		this.designation = designation;
		this.prix = prix;
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

	
	public double getPrix() {
		return prix;
	}

	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	@Override
	public String toString() {
		return "id: " + id + "\ncode: " + code + "\ndesignation: " + designation + "\nprix : " + prix + " €";
	}

	
	
}
