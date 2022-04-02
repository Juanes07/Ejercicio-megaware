package com.sofka.service;

import com.sofka.repositories.CategoriaRepository;
import com.sofka.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    CategoriaRepository categoriaRepository;


    public List<Categoria> getByCategoryAsc() {
        return (List<Categoria>) categoriaRepository.getCategoriaOrderASC();
    }

    public List<Categoria> getByCategoryDesc() {
        return (List<Categoria>) categoriaRepository.getCategoriaOrderDesc();
    }


    @Transactional
    public void updateCategory(Categoria categoria){
        categoriaRepository.updateCategory(categoria.getNameCategory());
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
}
