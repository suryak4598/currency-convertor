package com.webapp.currencyconverter.servlet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/getExchangeDataServlet")
public class GetExchangeRate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		JSONParser parser = new JSONParser();
		
		JSONObject json;
		
		URL url;
		
		Scanner scan;
		
		double exchageAmount = 1.0;
		
		HttpURLConnection conn;
		
		Double convertedAmount = Double.parseDouble(request.getParameter("amount"));
		
		String fromCurrency = request.getParameter("fromCountry");
		
		String toCurrency = request.getParameter("toCountry");
		
		String sampleUrl = "https://free.currconv.com/api/v7/convert?q="+fromCurrency+"_"+toCurrency+"&compact=ultra&apiKey=b8142eed33b3ec7784b2";
				
		try{
			
			url = new URL(sampleUrl);
			
			conn = (HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("GET");
			
			conn.connect();
			
			if(conn.getResponseCode() == 200) {
				
				scan = new Scanner(url.openStream());
				
				while(scan.hasNext()) {
					
					String temp = scan.nextLine();
					
					json = (JSONObject) parser.parse(temp); 
					
					exchageAmount = Double.parseDouble(json.get(fromCurrency+"_"+toCurrency)+"") ;
					
                }
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}

		response.getWriter().write(exchageAmount*convertedAmount+"");
	}

}
