package com.pizzeria.pizzeria;

import java.util.List;

import com.pizzeria.exception.DeletePizzaException;
import com.pizzeria.exception.SavePizzaException;
import com.pizzeria.exception.UpDatePizzaException;

public interface IPizzaDao {

	 List<Pizza> findAllPizzas();
	 void saveNewPizza(Pizza pizza) throws SavePizzaException;
	 void updatePizza(String codePizza, Pizza pizza) throws UpDatePizzaException;
	 void deletePizza(String codePizza) throws DeletePizzaException;
	 Pizza findPizzaByCode(String codePizza);
	 boolean isPizzaExists(String codePizza);
	
}
