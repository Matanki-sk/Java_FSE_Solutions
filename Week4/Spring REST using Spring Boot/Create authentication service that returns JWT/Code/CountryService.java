package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.exception.CountryNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // ✅ This is required
public class CountryService {

	

	public Country getCountry(String code) {
	    @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	    @SuppressWarnings("unchecked")
		List<Country> countryList = (List<Country>) context.getBean("countryList");

	    return countryList.stream()
	            .filter(c -> c.getCode().equalsIgnoreCase(code))
	            .findFirst()
	            .orElseThrow(() -> new CountryNotFoundException(code));
	}

}
