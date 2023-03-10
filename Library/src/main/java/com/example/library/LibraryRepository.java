package com.example.library;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface LibraryRepository extends JpaRepository<Library, Long>{
    @Query("SELECT p FROM Library p WHERE CONCAT(p.book_name, ' ', p.publisher, ' ', p.student_name) LIKE %?1%")
    List<Library> search(String keyword);


}
