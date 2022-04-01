package com.sofka.service;

import com.sofka.domain.Subcategoria;
import com.sofka.repositories.SubCategoriaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {

    @Autowired
    SubCategoriaRespository subCategoriaRespository;

    public List<Subcategoria> getBySubCategoryAsc() {
        return subCategoriaRespository.getSubCategoriaOrderAsc();
    }

    public List<Subcategoria> getBySubCategorydesc() {
        return subCategoriaRespository.getSubCategoriaOrderDesc();
    }

}
