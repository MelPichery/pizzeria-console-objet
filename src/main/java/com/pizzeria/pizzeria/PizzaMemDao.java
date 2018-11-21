package com.pizzeria.pizzeria;

import java.util.Arrays;

public class PizzaMemDao implements IPizzaDao {
	
	Pizza[] pizzas =  new Pizza[8];
	
	{ 			
		pizzas[0] = new Pizza("PEP","Pépéroni", 12.50);
		pizzas[1] = new Pizza("MAR","Margherita",14.00);
		pizzas[2] = new Pizza("REIN","La Reine",11.50);
		pizzas[3] = new Pizza("FRO","La 4 Fromages",12.00);
		pizzas[4] = new Pizza("CAN","Cannibale",12.50);
		pizzas[5] = new Pizza("SAV","Savoyarde",13.00);
		pizzas[6] = new Pizza("ORI","L'orientale",13.50);
		pizzas[7] = new Pizza("IND","L'indienne",14.00);
	}

	@Override
	public Pizza[] findAllPizzas() {
		
		return pizzas ;
		
	}

	public void addPizza(String codePizza, String nom, double prix) {
		
		Pizza pizza = new Pizza(codePizza,nom, prix);
		
		//création d'un tableau temporaire avec un taille incrémenté de 1 du tableau pizza
		Pizza[] pizzasTemp = new Pizza[pizzas.length+1];
		
		//boucle pour donner les valeurs du tableau pizzas au tableau temporaire pizzasTemp
		for (int i = 0; i < pizzasTemp.length-1; i++) {
			pizzasTemp[i] = pizzas[i];
		}
		
		//redimension du tableau pizzas à la taille du tableau pizzasTemp
		pizzas = new Pizza[pizzasTemp.length];
		
		//réaffectation des valeurs de pizzasTemp à pizzas
		for (int i = 0; i < pizzas.length; i++) {
			pizzas[i] = pizzasTemp[i];
		}
		
		//au dernier index du tableau prend la valeur du nouvel objet pizza
		pizzas[pizzas.length - 1] = pizza ;	
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		if (isPizzaExists(codePizza)) {
			
			Pizza pizzaModif = findPizzaByCode(codePizza);
			
			pizzaModif.setCode(pizza.getCode());
			
			pizzaModif.setDesignation(pizza.getDesignation());
			
			pizzaModif.setPrix(pizza.getPrix());
			
		}else {
			
			System.out.println("Pas de pizza pour ce code");
			
		}
		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		
		Pizza result = null ;
		
		for (Pizza pizza : pizzas) {
			
			if (codePizza.equals(pizza.getCode())) {
				
				result = pizza;
				
			}
			
		}
		
		return result ;
		
	}

	@Override
	public boolean isPizzaExists(String codePizza) {
		
		boolean result = false;
		
		for (Pizza pizza : pizzas) {
			
			if (codePizza.equals(pizza.getCode())) {
				
				result = true;
			}
			
		}
		
		return result;
	}
	
	
	
}
