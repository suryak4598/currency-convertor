package com.webapp.currencyconverter.service;

import java.util.List;
import com.webapp.currencyconverter.dto.ExchangeRateCountry;
import com.webapp.currencyconverter.dto.HomeDto;

public interface HomeService {
	
	public void createCountryTable();

	public void insertCountryTable(List<ExchangeRateCountry> countryList);

	public List<HomeDto> selectCountryTableList();

	public String getCountryCode(String countryName);

}
