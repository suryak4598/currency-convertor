package com.webapp.currencyconverter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExchangeRateCountry {
	
	private String countryCode;
	
	private String countryName;
	
	private String currencyCode;
	
	private String population;
	
	private String capital;
	
	private String continentName;
	
}
	

	