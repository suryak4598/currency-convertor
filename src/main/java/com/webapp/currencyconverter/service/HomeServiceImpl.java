package com.webapp.currencyconverter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webapp.currencyconverter.dao.HomeDao;
import com.webapp.currencyconverter.dto.ExchangeRateCountry;
import com.webapp.currencyconverter.dto.HomeDto;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	HomeDao homeDao;
	
	@Override
	public void createCountryTable() {
		
		homeDao.createCountryTable();

	}

	@Override
	public void insertCountryTable(List<ExchangeRateCountry> countryList) {
		
		homeDao.insertCountryTable(countryList);
		
	}
	
	@Override
	public List<HomeDto> selectCountryTableList() {
		
		return homeDao.selectCountryTableList();
	}

	@Override
	public String getCountryCode(String countryName) {
		
		return homeDao.getCountryCode(countryName);
	}

}
