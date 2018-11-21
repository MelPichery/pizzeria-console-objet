package com.pizzeria.pizzeria;

public interface IPizzaDao {

	public Pizza[] findAllPizzas();
	public void updatePizza(String codePizza, Pizza pizza);
	public Pizza findPizzaByCode(String codePizza);
	public boolean isPizzaExists(String codePizza);
	
}
