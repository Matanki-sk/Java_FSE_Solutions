package com.cognizant.spring_core_country;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cognizant.spring_core_country.model.Country;

@SpringBootApplication
public class SpringCoreCountryApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringCoreCountryApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(SpringCoreCountryApplication.class, args);
        displayCountry();
    }
    
    public static void displayCountry() {
        // Load the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Get the country bean
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
        
        // Get all country beans to show in dropdown
        Country us = context.getBean("us", Country.class);
        Country de = context.getBean("de", Country.class);
        Country jp = context.getBean("jp", Country.class);
        
        LOGGER.debug("All Countries:");
        LOGGER.debug("1. {}", us.toString());
        LOGGER.debug("2. {}", de.toString());
        LOGGER.debug("3. {}", jp.toString());
        LOGGER.debug("4. {}", country.toString());
    }
}