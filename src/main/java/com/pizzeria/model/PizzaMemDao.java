package com.pizzeria.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pizzeria.classe.CategoriePizza;
import com.pizzeria.classe.Pizza;
import com.pizzeria.exception.*;
import com.pizzeria.jdbc.ConnectionPizzeria;

public class PizzaMemDao implements IPizzaDao {
	
	
	public List<Pizza> findAllPizzas() throws SQLException
	{
		List<Pizza> pizzas = new ArrayList<Pizza>();
		
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
				
			conn = ConnectionPizzeria.getConnection();
			
			String query = "Select pizza.id,pizza.code,pizza.designation,pizza.prix,categorie.id as idCat,categorie.nom as nomCat from pizza "
							+ "join categorie on categorie.id = pizza.id_categorie ORDER BY pizza.id";
			
			prepareStatement = conn.prepareStatement(query);
			
			resultset = prepareStatement.executeQuery();
			
			while (resultset.next()) {
				
				Pizza p = new Pizza();
				
				p.setId(resultset.getInt("id"));
				p.setCode(resultset.getString("code"));
				p.setDesignation(resultset.getString("designation"));
				p.setPrice(resultset.getDouble("prix"));
				p.setCategoriepizza(new CategoriePizza(resultset.getInt("idCat"),resultset.getString("nomCat")));
				
				pizzas.add(p);
				
			}
							
			if (resultset != null) {
				
				resultset.close();
			}
			
			if (prepareStatement != null) {
				
				prepareStatement.close();
				
			}
			
			if (conn != null) {
				
				conn.close();
			}
		
		return pizzas;
	}



	public void saveNewPizza(Pizza pizza) throws SQLException, SavePizzaException,StockageException {
		
		Connection conn = null ;
		PreparedStatement prepareStatement = null;

			pizza.dataControl();
								
			conn = ConnectionPizzeria.getConnection();
			
			String query = "INSERT INTO pizza(code,designation,prix,id_categorie) VALUES(?,?,?,?)";
		
			prepareStatement = conn.prepareStatement(query);
			
			prepareStatement.setString(1, pizza.getCode());
			prepareStatement.setString(2, pizza.getDesignation());
			prepareStatement.setDouble(3, pizza.getPrice());
			prepareStatement.setInt(4, pizza.getCategoriepizza().getId());
			
			prepareStatement.executeUpdate();
			
			System.out.println("La pizza a été sauvegardée");
			
	
			
			if (prepareStatement != null) {
				
				prepareStatement.close();
				
			}
			
			if (conn != null) {
				
				conn.close();
				
			}			
				
	}



	public boolean pizzaExists(int idPizza) throws SQLException {
		
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		
		conn = ConnectionPizzeria.getConnection();
			
		String query = "Select pizza.id,pizza.code,pizza.designation,pizza.prix,categorie.id as idCat,categorie.nom as nomCat from pizza "
					+ "join categorie on categorie.id = pizza.id_categorie WHERE pizza.id = ?";
			
		prepareStatement = conn.prepareStatement(query);
			
		prepareStatement.setInt(1, idPizza);
			
		resultset = prepareStatement.executeQuery();
			
		if(resultset.isBeforeFirst()) {
			
			if (resultset != null) {
				
				resultset.close();
			}
			
			if (prepareStatement != null) {
				
				prepareStatement.close();
				
			}
			
			if (conn != null) {
				
				conn.close();
			}
			
			
				return true;
		}
			
		
		if (resultset != null) {
			
			resultset.close();
		}
		
		if (prepareStatement != null) {
			
			prepareStatement.close();
			
		}
		
		if (conn != null) {
			
			conn.close();
		}
				
		return false;
	}

	
	
	public void updatePizza(int id, Pizza pizza) throws SQLException, UpDatePizzaException,StockageException {
		
		if(pizzaExists(id)) {
			
				Connection conn = null;
				PreparedStatement prepareStatement = null;
			
				pizza.dataControl();
				
				conn = ConnectionPizzeria.getConnection();
				
				String query = "UPDATE pizza SET code = ?, designation = ?, prix = ?, id_categorie = ? WHERE id = ?";
				
				prepareStatement = conn.prepareStatement(query);
			
				prepareStatement.setString(1, pizza.getCode());
				prepareStatement.setString(2, pizza.getDesignation());
				prepareStatement.setDouble(3, pizza.getPrice());
				prepareStatement.setInt(4, pizza.getCategoriepizza().getId());
				prepareStatement.setInt(5, id);
			
				prepareStatement.executeUpdate();
			
				System.out.println("Update effectué");		
			
				if (prepareStatement != null) {
				
					prepareStatement.close();
				
				}
			
				if (conn != null) {
				
					conn.close();
				
				}
				
		}else {
			
			System.out.println("Cet id n'existe pas");
			
		}
				
	}
	
	
	
	public void deletePizza(int id) throws DeletePizzaException, SQLException {
		
		if (pizzaExists(id)) {
			
			Connection conn = null;
			PreparedStatement prepareStatement = null;
			
			try {
				
				conn = ConnectionPizzeria.getConnection();
				
				String query = "DELETE FROM pizza WHERE id = ?";
				
				prepareStatement = conn.prepareStatement(query);
				
				prepareStatement.setInt(1, id);
				
				prepareStatement.executeUpdate();
				
				System.out.println("La pizza a été supprimée");
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}finally {
				
				if (prepareStatement != null) {
					
					prepareStatement.close();
					
				}
				
				if (conn != null) {
					
					conn.close();
					
				}
				
			}
			
		}else {
			
			System.out.println("Cet id n'existe pas");
			
		}
		
		
				
		
	}


	public Pizza findPizzaById(int idPizza) throws SQLException {

		Pizza pizza = new Pizza();
		
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		
		
		conn = ConnectionPizzeria.getConnection();
			
		String query = "Select pizza.id,pizza.code,pizza.designation,pizza.prix,categorie.id as idCat,categorie.nom as nomCat from pizza "  
											+ "join categorie on categorie.id = pizza.id_categorie WHERE pizza.id = ?" ;
		
		prepareStatement = conn.prepareStatement(query);
		
		prepareStatement.setInt(1,idPizza);
		
		resultset = prepareStatement.executeQuery();
		
		while (resultset.next()) {
			
			pizza.setId(resultset.getInt("id"));
			pizza.setCode(resultset.getString("code"));
			pizza.setDesignation(resultset.getString("designation"));
			pizza.setPrice(resultset.getDouble("prix"));
			pizza.setCategoriepizza(new CategoriePizza(resultset.getInt("idCat"),resultset.getString("nomCat")));
			
		}
		
		if (resultset != null) {
			
			resultset.close();
		}
		
		if (prepareStatement != null) {
			
			prepareStatement.close();
			
		}
		
		if (conn != null) {
			
			conn.close();
		}
		
		
		return pizza;
		
	}
	
	/*public void displayAllPizza() {

		for (Pizza pizza : pizzas) {
			System.out.println(pizza.toString());

		}
	}*/

	
	public static void displayAllPizza(List<Pizza> pizzas) {

		
		
		for (Pizza pizza : pizzas) {
			System.out.println(pizza.toString());

		}
	}



	

}
