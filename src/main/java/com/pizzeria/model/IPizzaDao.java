package com.pizzeria.model;

import java.sql.SQLException;
import java.util.List;

import com.pizzeria.classe.Pizza;
import com.pizzeria.exception.*;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas() throws SQLException;
	void saveNewPizza(Pizza pizza) throws SQLException, SavePizzaException, StockageException;
	void updatePizza(int id, Pizza pizza) throws SQLException, UpDatePizzaException, StockageException;
	void deletePizza(int id) throws DeletePizzaException, SQLException;
	Pizza findPizzaById(int idPizza) throws SQLException;
	boolean pizzaExists(int idPizza) throws SQLException;
	
	
}