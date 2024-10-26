package com.shoeshop.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseDao {
	private ConnectionDao connectionDao;
	private ShoeDao shoeDao;
	public PurchaseDao() {
		connectionDao = new ConnectionDao();
	     shoeDao = new ShoeDao();
	}
	
	//insertValue
	public void insertValue(int shoe_id,int customer_id,int qty) throws IOException, SQLException {
		String query = "INSERT INTO purchases ( shoe_id,customer_id, qty,total_price) VALUES (?, ?, ?,?)";

		Connection connection = connectionDao.connectionDao();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
        double total_price = shoeDao.getShoePriceById(shoe_id) * qty;

		preparedStatement.setInt(1, customer_id);         
		preparedStatement.setInt(2, shoe_id);      
		preparedStatement.setInt(3, qty);         
		preparedStatement.setDouble(4, total_price);


		int rowAffect = preparedStatement.executeUpdate();
		System.out.println(rowAffect + " row(s) inserted.");
		preparedStatement.close();
		connection.close();
		
	}
	

}
