package com.example.library;

import jakarta.persistence.*;

/**

 The Books class represents a book in the library system.
 @author Farkhutdinov Aidar
 */
@Entity
@Table(name = "books")
public class Books {

    /**

     The unique identifier for the book.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**

     The title of the book.
     */
    @Column(name = "title", nullable = false)
    private String title;
    /**

     The author of the book.
     */
    @Column(name = "author_name", nullable = false)
    private String author_name;
    /**

     The genre of the book.
     */
    @Column(name = "genre", nullable = false)
    private String genre;
    /**

     The date the book was issued.
     */
    @Column(name = "date_of_issue")
    private String date_of_issue;
    /**

     The date the book is due to be returned.
     */
    @Column(name = "date_of_return")
    private String date_of_return;
    /**

     Whether the book is currently available.
     */
    @Column(name = "available", nullable = false)
    private boolean available;

    /**

     The email of the user to whom the book is currently issued.
     */
    @Column(name = "userEmail")
    private String userEmail;
    /**

     Creates a new instance of the Books class.
     */
    protected Books() {
    }


    /**

     Gets the user email associated with the book.
     @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }
    /**

     Sets the user email associated with the book.
     @param userEmail the user email to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    /**

     Gets the date of return for the book.
     @return the date of return
     */
    public String getDate_of_return() {
        return date_of_return;
    }
    /**

     Sets the date of return for the book.
     @param date_of_return the date of return to set
     */
    public void setDate_of_return(String date_of_return) {
        this.date_of_return = date_of_return;
    }
    /**

     Checks if the book is available.
     @return true if the book is available, false otherwise
     */
    public boolean isAvailable() {
        return available;
    }
    /**

     Sets the availability of the book.
     @param available true if the book is available, false otherwise
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
    /**

     Gets the ID of the book.
     @return the ID of the book
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    /**

     Sets the ID of the book.
     @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**

     Gets the date of issue for the book.
     @return the date of issue
     */
    public String getDate_of_issue() {
        return date_of_issue;
    }
    /**

     Sets the date of issue for the book.
     @param date_of_issue the date of issue to set
     */
    public void setDate_of_issue(String date_of_issue) {
        this.date_of_issue = date_of_issue;
    }
    /**

     Sets the title of the book.
     @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**

     Sets the author name of the book.
     @param author_name the author name to set
     */
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
    /**

     Sets the genre of the book.
     @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    /**

     Gets the title of the book.
     @return the title of the book
     */
    public String getTitle() {
        return title;
    }
    /**

     Gets the author name of the book.
     @return the author name of the book
     */
    public String getAuthor_name() {
        return author_name;
    }

    /**
     * Gets the genre of the book.
     * @return the genre of the book
     */
    public String getGenre() {
        return genre;
    }
    /**

     Returns a string representation of the book object, including its id, title, author name, genre, date of issue, date of return, availability status, and user email (if applicable).
     @return a string containing the book's attributes
     */
    @Override
    public String toString() {
        return "books [id=" + id + ", title=" + title + ", author name=" + author_name + ", genre=" + genre + ", date_of_issue=" + date_of_issue + ", date_of_return=" + date_of_return + ", available=" + available + ", user_email" + userEmail + "]";
    }
}

