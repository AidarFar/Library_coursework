package com.example.library;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository repo;

    public List<Library> listAll(String keyword){ //Коллекция и метод отвечающая за поиск и фильтр в нашей системе
        if (keyword != null){ // Если ключевое слово = null, то вызываем метод из первого return (вывод всех значений)
            return repo.search(keyword);
        }
        return repo.findAll(); // Ничего не выведется
    }

    public void save(Library library){
        repo.save(library);
    }

    public Library get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
