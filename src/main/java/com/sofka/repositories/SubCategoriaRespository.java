package com.sofka.repositories;

import com.sofka.domain.Subcategoria;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface SubCategoriaRespository extends CrudRepository<Subcategoria, Integer> {

    @Transactional
    @Modifying
    @Query(value = "SELECT * From subcategoria ORDER BY scat_created_at DESC ", nativeQuery = true)
    List<Subcategoria> getSubCategoriaOrderDesc();

    @Transactional
    @Modifying
    @Query(value = "SELECT * From subcategoria ORDER BY scat_created_at ASC ", nativeQuery = true)
    List<Subcategoria> getSubCategoriaOrderAsc();
}
