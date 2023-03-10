package com.example.library;

import jakarta.persistence.Entity; // аннотация entity для указания на то, что класс является сущностью и относится к ORM JPA
import jakarta.persistence.GeneratedValue; // аннотация для работы сo столбцами в SQL
import jakarta.persistence.GenerationType; // класс, который отвечает за типы данных перечисления (метод identity)
import jakarta.persistence.Id; // для первичного ключа объекта

@Entity
public class Library {
    private Long id; //ID
    private String book_name; // Имя книги
    private String publisher; // Издатель
    private String date_of_issue; // Дата выдачи книги
    private String student_name; // ФИО студента
    private String date_of_delivery; // Дата возврата книги

    protected Library(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getBook_name(){
        return book_name;
    }

    public void setBook_name(String book_name){
        this.book_name = book_name;
    }

    public String getPublisher(){
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getDate_of_issue(){
        return date_of_issue;
    }

    public void setDate_of_issue(String date_of_issue){
        this.date_of_issue = date_of_issue;
    }

    public String getStudent_name(){
        return student_name;
    }

    public void setStudent_name(String student_name){
        this.student_name = student_name;
    }

    public String getDate_of_delivery(){
        return date_of_delivery;
    }

    public void setDate_of_delivery(String date_of_delivery){
        this.date_of_delivery = date_of_delivery;
    }

    @Override
    public String toString() {
        return "library [id=" + id + ", book_name=" + book_name +", publisher=" + publisher + ", date_of_issue=" + date_of_issue + ", student_name=" + student_name + ", date_of_delivery=" + date_of_delivery + "]";
    }



}

