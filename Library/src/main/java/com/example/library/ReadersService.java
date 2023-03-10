package com.example.library;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadersService {
    @Autowired
    private ReadersRepository repo;

    public List<Readers> listAll(String keyword){ //Коллекция и метод отвечающая за поиск и фильтр в нашей системе
        if (keyword != null){ // Если ключевое слово = null, то вызываем метод из первого return (вывод всех значений)
            return repo.search(keyword);
        }
        return repo.findAll(); // Ничего не выведется
    }

    public void save(Readers readers){
        repo.save(readers);
    }

    public Readers get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
