package com.webapp.currencyconverter.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.currencyconverter.dto.ExchangeRateCountry;
import com.webapp.currencyconverter.dto.HomeDto;
import com.webapp.currencyconverter.service.HomeService;


@Controller
public class HomeController {
	
	String navbar_list[] = new String[] { "Home", "Country List"};
	
	@Autowired
	HomeService homeService;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	//Getting currency json file from resource folder
	public Resource loadExchangeRateCountry() {
	    return resourceLoader.getResource("classpath:exchange-rate.json");
	}
	
	@RequestMapping("/")
	public String displayHomePage(Model model) throws IOException, ParseException {
		
//		homeService.createCountryTable();
		
		//Get exchange rate currency json file from resource folder
		Resource resource = loadExchangeRateCountry();
		InputStream inputStream = resource.getInputStream();

		//Converting Json array to List object using ObjectMapper()
		ObjectMapper objectMapper = new ObjectMapper();
		List<ExchangeRateCountry> countryList = objectMapper.readValue(
				inputStream, 
		        new TypeReference<List<ExchangeRateCountry>>(){});

		//Adding country list to the model interface
		model.addAttribute("countryList", countryList);

//		homeService.insertCountryTable(countryList);
		
		List<HomeDto> countryDbList = homeService.selectCountryTableList();
		
		model.addAttribute("countryDbList", countryDbList);
		
		model.addAttribute("navbar_list", navbar_list);

		return "home-page";
	}
	
}
