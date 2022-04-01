package com.sofka.service;

import com.sofka.repositories.CategoriaRepository;
import com.sofka.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoriaRepository categoriaRepository;


    public List<Categoria> getByCategoryAsc() {
        return (List<Categoria>) categoriaRepository.getCategoriaOrderASC();
    }

    public List<Categoria> getByCategoryDesc() {
        return (List<Categoria>) categoriaRepository.getCategoriaOrderDesc();
    }
}
