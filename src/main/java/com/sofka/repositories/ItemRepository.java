package com.sofka.repositories;

import com.sofka.domain.Categoria;
import com.sofka.domain.Item;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
    @Transactional
    @Modifying
    @Query(value = "SELECT * From item ORDER BY itm_nombre DESC ", nativeQuery = true)
    List<Item> getItemDesc();

    @Transactional
    @Modifying
    @Query(value = "SELECT * From item ORDER BY itm_nombre ASC ", nativeQuery = true)
    List<Item> getItemAsc();
}
