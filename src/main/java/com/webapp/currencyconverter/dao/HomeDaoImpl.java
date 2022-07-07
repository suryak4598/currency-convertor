package com.webapp.currencyconverter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.webapp.currencyconverter.dbconfig.MySqlDBConfig;
import com.webapp.currencyconverter.dto.ExchangeRateCountry;
import com.webapp.currencyconverter.dto.HomeDto;

@Component
public class HomeDaoImpl implements HomeDao {

	private String createCountryTable = "create table if not exists currency_details (id int not null auto_increment, country_name varchar(50), currency_code varchar(10), country_code varchar(10), primary key(id));";

	private String insertCountryTable = "insert into currency_details(country_name, currency_code, country_code) values(?, ?, ?);" ;
	
	private String selectCountryTableList = "SELECT * FROM currency.currency_details;" ;
	
	private String getCountryCode = "SELECT (country_code) FROM currency.currency_details where country_name = ?;" ;
	
	
	@Autowired
	MySqlDBConfig dbConfig;
	
	@Override
	public void createCountryTable() {
		
		Connection conn;
		
		PreparedStatement stmt;
		
		try {
			
			conn = dbConfig.createConnection();
			
			stmt = conn.prepareStatement(createCountryTable);
			
			stmt.execute();
			
			dbConfig.closeConnection(stmt, conn);
						
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

	}

	@Override
	public void insertCountryTable(List<ExchangeRateCountry> countryList) {
		
		Connection conn;
		
		PreparedStatement stmt;
		
		Iterator<ExchangeRateCountry> iter = countryList.iterator();
		
		try {
			conn = dbConfig.createConnection();
			
			stmt = conn.prepareStatement(insertCountryTable);
			
			while(iter.hasNext()){
				
				ExchangeRateCountry countryObject = iter.next();
				
				stmt.setString(1, countryObject.getCountryName());
				
				stmt.setString(2, countryObject.getCurrencyCode());
				
				stmt.setString(3, countryObject.getCountryCode());
				
				stmt.execute();
			}

			dbConfig.closeConnection(stmt, conn);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

	}

	@Override
	public List<HomeDto> selectCountryTableList() {
		
		Connection conn;
		
		Statement stmt;
		
		ResultSet rs = null;
		
		try {
			conn = dbConfig.createConnection();
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(selectCountryTableList);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return processCountryListData(rs);

	}
	
	public List<HomeDto> processCountryListData(ResultSet rs) {
		
		List<HomeDto> result = new ArrayList<>();
		
		try {
			
			while (rs.next()) {
				
				HomeDto hm = new HomeDto();
				
				hm.setId(rs.getInt("id"));
				
				hm.setCountryCode(rs.getString("country_code"));
				
				hm.setCountryName(rs.getString("country_name"));
				
				hm.setCurrencyCode(rs.getString("currency_code"));
				
				result.add(hm);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return result;
		
	}

	@Override
	public String getCountryCode(String countryName) {
		
        Connection conn;
		
        PreparedStatement stmt;
		
		ResultSet rs = null;
		
		String countryCode = null;
		
		try {
			
			conn = dbConfig.createConnection();
			
			stmt = conn.prepareStatement(getCountryCode);
			
			stmt.setString(1, countryName);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
			 
				countryCode = rs.getString("country_code");
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return countryCode;
		
	}

}
