package com.example.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReadersRepository extends JpaRepository<Readers, Long> {
    @Query("SELECT p FROM Readers p WHERE CONCAT(p.full_name, ' ', p.email, ' ', p.address) LIKE %?1%")
    List<Readers> search(String keyword);
}
