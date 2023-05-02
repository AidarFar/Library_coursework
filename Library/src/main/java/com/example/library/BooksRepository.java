package com.example.library;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**

 A repository interface for performing CRUD operations on Books entity in the database.
 @author Farkhutdinov Aidar
 */
public interface BooksRepository extends JpaRepository<Books, Long> {

    /**

     Searches the database for books that match the given keyword in any of the fields.
     @param keyword the keyword to search for
     @return a list of books that match the keyword
     */
    @Query("SELECT p FROM Books p WHERE CONCAT_WS(p.id, ' ',p.title, ' ', p.author_name, ' ', p.genre, ' ', p.date_of_issue, ' ', p.date_of_return, ' ', p.available, ' ', p.userEmail) LIKE %?1%")
    List<Books> search(String keyword);
    /**

     Returns a list of books that have been borrowed by the user with the specified email.
     @param userEmail the email of the user who borrowed the books
     @return a list of books that have been borrowed by the user
     */
    List<Books> findBooksByUserEmail(String userEmail);
}