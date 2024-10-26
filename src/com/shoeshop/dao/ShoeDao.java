package com.shoeshop.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shoeshop.Model.Customer;
import com.shoeshop.Model.Shoe;

public class ShoeDao {
	private ConnectionDao connectionDao;
	
	public ShoeDao() {
		connectionDao =new ConnectionDao();
	}
	
	public void insertValue(String name, int size, int price) throws IOException, SQLException {
		String query = "INSERT INTO shoes (name, size, price) VALUES (?, ?, ?)";
		Connection connection = connectionDao.connectionDao();
		PreparedStatement preparedStatment = connection.prepareStatement(query);
		
		preparedStatment.setString(1, name);
		preparedStatment.setInt(2, size);
		preparedStatment.setInt(3, price);
		
		int rowAffect = preparedStatment.executeUpdate();
		 System.out.println(rowAffect + " row(s) inserted.");

		preparedStatment.close();
		connection.close();	
	}
	
	public void deleteByID(int id) throws IOException, SQLException {
		String query = "DELETE FROM shoes where id =?";
		Connection connection = connectionDao.connectionDao();
		PreparedStatement preparedStatment = connection.prepareStatement(query);
		preparedStatment.setInt(1,id);
		
		int rowAffected = preparedStatment.executeUpdate();
		if(rowAffected > 0) {
			System.out.println("Delete "+ id + "row sucessful");
		}else {
			System.out.println("Delete "+ id + "row fail");
		}	
	}
	
	//Update Row
		public void updateRow(int id,String name,int size,int price) throws IOException, SQLException {
			String query = "UPDATE shoes SET name = ?,  size = ?, price =?  Where id = ?";
			Connection connection = connectionDao.connectionDao();
			
		    PreparedStatement preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setString(1, name);
		    preparedStatement.setInt(2, size);
		    preparedStatement.setInt(3, price);
		    preparedStatement.setInt(4, id);
		    
		    int rowsAffected = preparedStatement.executeUpdate();
		    
		    if (rowsAffected > 0) {
		        System.out.println("Row with ID " + id + " updated successfully.");
		    } else {
		        System.out.println("No row found with ID " + id);
		    }
		    
		    preparedStatement.close();
		    connection.close();

		}
		
		//Select by ID
		public Shoe selectById(int id) throws IOException, SQLException {
			String query = "SELECT * From shoes where id = ?";
			Connection connection= connectionDao.connectionDao();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			Shoe shoe = null;
			
			 if (resultSet.next()) {
			        int id1 = resultSet.getInt("id");
			        String name = resultSet.getString("name");
			        int size = resultSet.getInt("size");
			        int price = resultSet.getInt("price");
			        shoe = new Shoe(id, name, size, price);		   
			 }
			 resultSet.close();
			 preparedStatement.close();
			 connection.close();
			 if (shoe != null) {
			     System.out.println(shoe); 
			 } else {
			     System.out.println("Customer not found.");
			 }
			return shoe;	
		}
		
		  public double getShoePriceById(int id) throws SQLException, IOException {
		        String query = "SELECT price FROM shoes WHERE id = ?";
		        double price = 0.0;

		        try (Connection connection = connectionDao.connectionDao();
		             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		             
		            preparedStatement.setInt(1, id);
		            ResultSet resultSet = preparedStatement.executeQuery();

		            if (resultSet.next()) {
		                price = resultSet.getDouble("price");
		            } else {
		                System.out.println("Shoe with ID " + id + " not found.");
		            }
		            resultSet.close();
					 preparedStatement.close();
					 connection.close();
		        }
		        return price;
		    }

}
