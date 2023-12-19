package com.example.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneModelsService {

    private PhoneModelsRepository repo;

    @Autowired
    public PhoneModelsService(PhoneModelsRepository repo) {
        this.repo = repo;
    }

    public List<PhoneModels> listAllPhones(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(PhoneModels phoneModels) {
        repo.save(phoneModels);
    }

    public PhoneModels get(String id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }



    // Дополнительные методы, если необходимо
}
