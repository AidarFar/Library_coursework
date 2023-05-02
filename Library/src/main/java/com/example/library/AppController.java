package com.example.library;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**

 Controller for handling HTTP requests related to the books management application.
 @author Farkhutdinov Aidar
 */
@Controller
public class AppController {

    @Autowired
    private BooksService service;

    /**

     Handles requests to display the home page with a list of all books.
     @param model the model object to be passed to the view
     @param keyword the search keyword for filtering books
     @return the name of the view to be rendered
     */
    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        String currentUserName = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            currentUserName = authentication.getName();
        }
        // get list of all books and add it to the model
        List<Books> listBooks = service.listAll(keyword);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);
        Books books = new Books();
        model.addAttribute("Books", books);
        model.addAttribute("currentUserName", currentUserName);
        return "index";
    }
    /**

     Handles requests to save a book and redirect to the admin page.
     @param books the book object to be saved
     @return the redirect URL to the admin page
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBooks(@ModelAttribute("Books") Books books) {
        // check if date values are empty and set them to null
        String dateOfIssue = books.getDate_of_issue();
        if (dateOfIssue.isEmpty()) {
            books.setDate_of_issue(null);
        }
        String dateOfReturn = books.getDate_of_return();
        if (dateOfReturn.isEmpty()) {
            books.setDate_of_return(null);
        }
        // save the book and redirect to the admin page
        service.save(books);
        return "redirect:/admin";
    }

    /**

     Handles requests to display the book edit form for a specific book ID.
     @param id the ID of the book to be edited
     @return the ModelAndView object for the book edit form view
     */
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBooksForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_books");
        // get the book object by ID and add it to the model
        Books books = service.get(id);
        String dateOfIssue = books.getDate_of_issue();
        if (dateOfIssue != null && dateOfIssue.isEmpty()) {
            books.setDate_of_issue(null);
        }
        String dateOfReturn = books.getDate_of_return();
        if (dateOfReturn != null && dateOfReturn.isEmpty()) {
            books.setDate_of_return(null);
        }
        mav.addObject("Books", books);
        return mav;
    }
    /**

     Handles requests to delete a book by its ID.
     @param id the ID of the book to be deleted
     @return the redirect URL to the admin page
     */
    @RequestMapping("/delete/{id}")
    public String deleteBooks(@PathVariable(name = "id") Long id) {
// delete the book by ID and redirect to the admin page
        service.delete(id);
        return "redirect:/admin";
    }
    /**

     Handles requests to display the "About the Author" page.
     @return the name of the view to be rendered
     */
    @RequestMapping("/aboutAuthor")
    public String viewAboutAuthor() {
        return "aboutAuthor";
    }

    /**

     Handles requests for the personal account page.
     @param model the model object to be passed to the view
     @param keyword the keyword for searching books
     @return the view name for the personal account page
     */
    @RequestMapping("/personalAccount")
    public String viewPersonalAccount(Model model, @Param("keyword") String keyword) {
// retrieves the current user's name from the authentication context
        String currentUserName = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            currentUserName = authentication.getName();
        }
// retrieves the books associated with the current user
        List<Books> listBooks = service.listBooksByUser(currentUserName);
// adds the books and the keyword to the model object
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);
// creates a new book object and adds it to the model object
        Books Books = new Books();
        model.addAttribute("Books", Books);
// returns the view name for the personal account page
        return "personalAccount";
    }
    /**

     Handles requests for the admin page.
     @param model the model object to be passed to the view
     @param keyword the keyword for searching books
     @return the view name for the admin page
     */
    @RequestMapping("/admin")
    public String viewAdminPage(Model model, @Param("keyword") String keyword) {
// retrieves all the books from the database
        List<Books> listBooks = service.listAll(keyword);
// adds the books and the keyword to the model object
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);
// creates a new book object and adds it to the model object
        Books Books = new Books();
        model.addAttribute("Books", Books);
// returns the view name for the admin page
        return "admin";
    }

    /**

     This method is responsible for adding the user's email address to a specific book in the library

     and updating the book's availability status, date of issue, and date of return.

     @param bookId the ID of the book to be borrowed

     @param userName the email address of the user who borrows the book

     @return the user is redirected to the home page after the book is borrowed
     */
    @PostMapping("/addEmail")
    public String addEmail(@RequestParam(name = "bookId") Long bookId,
                           @RequestParam(name = "userName") String userName) {
// Get the book from the service
        Books books = service.get(bookId);

// Set the user's email, update the book's status, and set the dates of issue and return
        books.setUserEmail(userName);
        books.setAvailable(false);
        books.setDate_of_issue(LocalDate.now().toString());
        books.setDate_of_return(LocalDate.now().plusWeeks(2).toString());

// Save the updated book to the database
        service.save(books);

// Redirect the user to the home page
        return "redirect:/";
    }

    /**

     This method is responsible for returning a borrowed book to the library.

     It updates the book's availability status, date of issue, date of return,

     and removes the email address of the user who borrowed the book.

     @param bookId the ID of the book to be returned

     @return the user is redirected to their personal account page after the book is returned
     */
    @PostMapping("/return")
    public String returnBook(@RequestParam("bookId") Long bookId) {
// Get the book from the service
        Books books = service.get(bookId);

// Remove the user's email, update the book's status, and remove the dates of issue and return
        books.setUserEmail(null);
        books.setDate_of_issue(null);
        books.setDate_of_return(null);
        books.setAvailable(true);

// Save the updated book to the database
        service.save(books);

// Redirect the user to their personal account page
        return "redirect:/personalAccount";
    }
}