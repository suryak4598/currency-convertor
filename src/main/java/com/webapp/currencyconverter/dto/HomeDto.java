package com.webapp.currencyconverter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HomeDto {

	private int id;
	private String countryCode;
	private String countryName;
	private String currencyCode;

}
