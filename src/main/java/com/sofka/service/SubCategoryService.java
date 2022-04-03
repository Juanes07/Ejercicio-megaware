package com.sofka.service;

import com.sofka.domain.Categoria;
import com.sofka.domain.Subcategoria;
import com.sofka.repositories.SubCategoriaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubCategoryService implements  ISubCategoryService{

    @Autowired
    SubCategoriaRespository subCategoriaRespository;

    public List<Subcategoria> getBySubCategoryAsc() {
        return subCategoriaRespository.getSubCategoriaOrderAsc();
    }

    public List<Subcategoria> getBySubCategorydesc() {
        return subCategoriaRespository.getSubCategoriaOrderDesc();
    }

    @Override
    @Transactional
    public void delete(Subcategoria subcategoria) {
        subCategoriaRespository.delete(subcategoria);
    }

    @Transactional
    public void updateSubCategory(Subcategoria subcategoria, Integer idCategory){
        subCategoriaRespository.updateCategory(idCategory, subcategoria.getNameSubCategory());
    }

}
