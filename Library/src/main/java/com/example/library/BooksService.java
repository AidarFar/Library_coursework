package com.example.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**

 This class represents the service layer for the Books entity. It provides methods for performing CRUD operations

 on the books in the system, as well as searching and filtering based on a keyword and user email.

 @author Farkhutdinov Aidar
 */
@Service
public class BooksService {

    private BooksRepository repo;

    /**

     Constructor for BooksService class that takes in a BooksRepository instance.
     @param repo the BooksRepository instance used for accessing the database.
     */
    @Autowired
    public BooksService(BooksRepository repo) {
        this.repo = repo;
    }
    /**

     Returns a list of all books in the system, or a filtered list based on a keyword search.
     @param keyword the keyword to search for in the book data.
     @return a list of books matching the search criteria.
     */
    public List<Books> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
    /**

     Saves a new book to the database, or updates an existing book.
     @param books the book object to save or update.
     */
    public void save(Books books) {
        repo.save(books);
    }
    /**

     Retrieves a book from the database based on its id.
     @param id the id of the book to retrieve.
     @return the book with the specified id.
     */
    public Books get(Long id) {
        return repo.findById(id).get();
    }
    /**

     Deletes a book from the database based on its id.
     @param id the id of the book to delete.
     */
    public void delete(Long id) {
        repo.deleteById(id);
    }
    /**

     Returns a list of books that have been checked out by the specified user.
     @param username the email address of the user who has checked out the books.
     @return a list of books checked out by the specified user.
     */
    public List<Books> listBooksByUser(String username) {
        return repo.findBooksByUserEmail(username);
    }
}
