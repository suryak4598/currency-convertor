package com.webapp.currencyconverter.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.webapp.currencyconverter.service.HomeService;

@Configurable
@WebServlet("/GetCountryCodeServlet")
public class GetCountryCodeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	HomeService homeService;
	
	String result;
	
	private WebApplicationContext springContext;
	
	public void init(final ServletConfig config) throws ServletException {
		
        super.init(config);
        
        springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        
        final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
        
        beanFactory.autowireBean(this);
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String countryName = request.getParameter("countryName");

		result = homeService.getCountryCode(countryName).toLowerCase();
		
		response.getWriter().write(result);
	}

}
