package com.shoeshop.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDao {
	public Connection connectionDao() throws IOException, SQLException {
		InputStream stream = getClass().getClassLoader().getResourceAsStream("db.properties");
		if(stream==null) {
			throw new FileNotFoundException("File db.properties not found");
		}
		
		Properties prop=new Properties();
		prop.load(stream);
		
		String url = prop.getProperty("db.url");
		String user = prop.getProperty("db.user");
		String password = prop.getProperty("db.password");
		
		Connection connection = DriverManager.getConnection(url,user,password);
		
		
		return connection;
		
	}

}
