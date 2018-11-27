package com.pizerria.model;


public enum CategoriePizzaEnum {

	FROMAGE("Fromage"),
	VIANDE("Viande"),
	POISSON("Poisson"),
	AUTRE("Autre");
	
	private String name = "";
	
	CategoriePizzaEnum(String name){
				
			this.name = name ;
					
	}
	
	public String toString() {
		
		return name;
		
	}
	
}
