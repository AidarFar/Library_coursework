package com.example.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**

 Controller for handling HTTP requests related to the books management application.
 @author Farkhutdinov Aidar
 */
@Controller
public class AppController {
    @Autowired
    private PhoneModelsService phoneModelsService;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        // get list of all phones and add it to the model
        List<PhoneModels> listPhones = phoneModelsService.listAllPhones(keyword);
        model.addAttribute("phonemodels", listPhones);
        model.addAttribute("keyword", keyword);
        PhoneModels phone = new PhoneModels();
        model.addAttribute("phone", phone);
        return "index";
    }
    /**

     Handles requests to display the "About the Author" page.
     @return the name of the view to be rendered
     */
    @RequestMapping("/aboutAuthor")
    public String viewAboutAuthor() {
        return "aboutAuthor";
    }

}