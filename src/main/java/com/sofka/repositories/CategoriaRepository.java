package com.sofka.repositories;

import com.sofka.domain.Categoria;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

    @Transactional
    @Modifying
    @Query(value = "SELECT * From categoria ORDER BY cat_created_at DESC ", nativeQuery = true)
    List<Categoria> getCategoriaOrderDesc();

    @Transactional
    @Modifying
    @Query(value = "SELECT * From categoria ORDER BY cat_created_at ASC ", nativeQuery = true)
    List<Categoria> getCategoriaOrderASC();


    @Modifying
    @Query("UPDATE Categoria cat set cat.nameCategory = :nameCategory where cat.idCategory = :id")
    public void updateCategory(
            @Param(value = "nameCategory") String nameCategory
    );

}
