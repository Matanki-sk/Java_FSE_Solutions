package com.cognizant.hello_world_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class HelloWorldServiceApplication {

    public static void main(String[] args) {
        // Solution 1: Ensure port configuration is applied
        System.setProperty("server.port", "8083"); // Force port 8083
        
        // Enhanced Spring Application launch
        var app = new SpringApplication(HelloWorldServiceApplication.class);
        
        // Solution 2: Add environment verification
        Environment env = app.run(args).getEnvironment();
        
        // Log startup information
        String protocol = env.getProperty("server.ssl.key-store") != null ? "https" : "http";
        String port = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path", "");
        
        System.out.printf("\n----------------------------------------------------------\n" +
                        "Application '%s' is running! Access URLs:\n" +
                        "Local: \t\t%s://localhost:%s%s/hello\n" +
                        "Profile(s): \t%s\n" +
                        "----------------------------------------------------------\n",
                env.getProperty("spring.application.name"),
                protocol,
                port,
                contextPath,
                env.getActiveProfiles().length == 0 ? env.getDefaultProfiles() : env.getActiveProfiles());
    }
}