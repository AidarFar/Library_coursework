package com.example.library;

import jakarta.persistence.Entity; // аннотация entity для указания на то, что класс является сущностью и относится к ORM JPA
import jakarta.persistence.GeneratedValue; // аннотация для работы сo столбцами в SQL
import jakarta.persistence.GenerationType; // класс, который отвечает за типы данных перечисления (метод identity)
import jakarta.persistence.Id; // для первичного ключа объекта

@Entity
public class Readers {
    private Long id;
    private String full_name;
    private String email;
    private String address;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        full_name = full_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "readers [id=" + id + ", Full name=" + full_name + ", email=" + email + ", address=" + address + "]";
    }
}
