package com.webapp.currencyconverter.dao;

import java.util.List;
import com.webapp.currencyconverter.dto.ExchangeRateCountry;
import com.webapp.currencyconverter.dto.HomeDto;

public interface HomeDao {
	
	public void createCountryTable();

	public void insertCountryTable(List<ExchangeRateCountry> countryList);
	
	public List<HomeDto> selectCountryTableList();

	public String getCountryCode(String countryName);

}
