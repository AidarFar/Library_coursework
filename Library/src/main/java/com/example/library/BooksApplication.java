package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**

 The main class for the Books application, which starts the web application.
 @author Farkhutdinov Aidar
 */
@SpringBootApplication
public class BooksApplication extends SpringBootServletInitializer{

    /**

     The main method to start the web application.
     @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
    }
}
