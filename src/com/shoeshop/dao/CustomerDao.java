package com.shoeshop.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shoeshop.Model.Customer;

public class CustomerDao {
	private ConnectionDao connectionDao;
	
	public CustomerDao() {
		connectionDao = new ConnectionDao();
	}

	//SELECT * FROM Customer
	public List<Customer> selectAll() throws IOException, SQLException {
		List<Customer> customerList = new ArrayList<>();
		String query = "SELECT * FROM customer";
		Connection connection = connectionDao.connectionDao();		
		Statement statment = connection.createStatement();
		ResultSet resultSet = statment.executeQuery(query);
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			String address = resultSet.getString("address");
			System.out.println(" Id: " + id + " Name: "+ name + " Email: "+email+" address: "+ address);
		}
		
		resultSet.close();
		statment.close();
		connection.close();
		return customerList;
		
	}
	
	
	//INSERT INTO Customer
	public void insertValue(String name,String email,String phone,String address) throws IOException, SQLException {
		String query = "INSERT INTO customer(name,email,phone,address) VALUEs (?,?,?,?)";
		Connection connection = connectionDao.connectionDao();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, phone);
		preparedStatement.setString(4, address);
		
		//execute
		int rowsAffected = preparedStatement.executeUpdate();
		
		 System.out.println(rowsAffected + " row(s) inserted.");
		 
		 preparedStatement.close();
		 connection.close();	
	}
	
	//Drop table
	public void dropTable(String tableName) throws IOException, SQLException {
		String query = "DROP TABLE customer";
		Connection connection = connectionDao.connectionDao();
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		if(result == 0) {
			System.out.println("Table: " + tableName +"droped");
		}else {
			System.out.println("Table: " + tableName +" fail to drop");
		}
		
		connection.close();
		statement.close();
		}
	
	//DElete Row
	public void deleteRow(int id) throws IOException, SQLException {
		String query = "DELETE FROM customer WHERE id = ?";
		Connection connection = connectionDao.connectionDao();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		int rowEffected = preparedStatement.executeUpdate();
		if(rowEffected > 0) {
	        System.out.println("Row with ID " + id + " deleted successfully.");	
		}else {
	        System.out.println("No row found with ID " + id);
			
		}
	}
	
	//Update Row
	public void updateRow(int id,String name,String email,String phone, String address) throws IOException, SQLException {
		String query = "UPDATE customer SET name = ?,  email = ?, phone =? , address = ? Where id = ?";
		Connection connection = connectionDao.connectionDao();
		
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setString(1, name);
	    preparedStatement.setString(2, email);
	    preparedStatement.setString(3, phone);
	    preparedStatement.setString(4, address);
	    preparedStatement.setInt(5, id);
	    
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
	public Customer selectById(int id) throws IOException, SQLException {
		String query = "SELECT * From customer where id = ?";
		Connection connection= connectionDao.connectionDao();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Customer customer = null;
		
		 if (resultSet.next()) {
		        int id1 = resultSet.getInt("id");
		        String name = resultSet.getString("name");
		        String email = resultSet.getString("email");
		        String phone = resultSet.getString("phone");
		        String address = resultSet.getString("address");
		        customer = new Customer(id, name, email, phone, address);		   
		 }
		 resultSet.close();
		 preparedStatement.close();
		 connection.close();
		 if (customer != null) {
		     System.out.println(customer); 
		 } else {
		     System.out.println("Customer not found.");
		 }
		return customer;	
	}
	
	
	}




















