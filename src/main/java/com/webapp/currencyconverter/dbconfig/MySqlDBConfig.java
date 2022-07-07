package com.webapp.currencyconverter.dbconfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.webapp.currencyconverter")
public class MySqlDBConfig {
	
	private DriverManagerDataSource dataSource = null;

	@Bean
	public void mysqlDataSource() {

		if (dataSource == null) {
			
			dataSource = new DriverManagerDataSource();
			
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			
			dataSource.setUrl("jdbc:mysql://localhost:3306/currency");
			
			dataSource.setUsername("root");
			
			dataSource.setPassword("root");
			
			
		}

	}

	public Connection createConnection() throws SQLException {
		
		mysqlDataSource();
		
		return dataSource.getConnection();
		
	}

	public void closeConnection(PreparedStatement statement, Connection connection) throws SQLException {
		
		statement.close();
		
		connection.close();
		
	}

}
