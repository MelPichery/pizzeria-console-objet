package com.pizzeria.pizzeria;

import java.util.ArrayList;
import java.util.List;

import com.pizzeria.exception.DeletePizzaException;
import com.pizzeria.exception.SavePizzaException;
import com.pizzeria.exception.UpDatePizzaException;

public class PizzaMemDao implements IPizzaDao {
	
	List<Pizza> pizzas =  new ArrayList<Pizza>();
	
	{ 	
		pizzas.add(new Pizza("PEP","Pépéroni", 12.50));
		pizzas.add(new Pizza("MAR","Margherita",14.00));
		pizzas.add(new Pizza("REIN","La Reine",11.50));
		pizzas.add(new Pizza("FRO","La 4 Fromages",12.00));
		pizzas.add(new Pizza("CAN","Cannibale",12.50));
		pizzas.add(new Pizza("SAV","Savoyarde",13.00));
		pizzas.add(new Pizza("ORI","L'orientale",13.50));
		pizzas.add(new Pizza("IND","L'indienne",14.00));

	}


	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpDatePizzaException {
		
		
		if (isPizzaExists(codePizza)) {
			
			Pizza pizzaModif = findPizzaByCode(codePizza);
			
			pizzaModif.setCode(pizza.getCode());
			
			pizzaModif.setDesignation(pizza.getDesignation());
			
			pizzaModif.setPrix(pizza.getPrix());
			
		}else {
			
			throw new UpDatePizzaException("Pas de pizza pour ce code");
			
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

	@Override
	public List<Pizza> findAllPizzas() {
		
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {

		if (pizza.getCode().length()<4) {
			if (pizza.getDesignation().length()>4) {			
				if (pizza.getPrix()>8) {
					pizzas.add(pizza);
				}else {
					throw new SavePizzaException("le prix doit être supérieur à 8");
				}
			}else {
				throw new SavePizzaException("désignation inferieur a 3 caractères");
			}
			
		}else {
			throw new SavePizzaException("code supérieur a 3 caractères");
		}
		
										
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException{
	
		if (isPizzaExists(codePizza)) {
			
			Pizza pizza = findPizzaByCode(codePizza);
			
			pizzas.remove(pizza);
			
		}else {
			
			throw new DeletePizzaException("Pas de pizza pour ce code ");
						
		}
		
		
	}
			
}
