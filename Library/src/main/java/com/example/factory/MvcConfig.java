package com.example.factory;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**

 Configuration class for Spring MVC.
 @author Farkhutdinov Aidar
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**

     Method to add view controllers to the registry.
     @param registry the registry to add view controllers to
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
    }
}
