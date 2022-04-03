package com.sofka.repositories;

import com.sofka.domain.Descarga;
import com.sofka.domain.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DescargaRepository extends CrudRepository<Descarga, Integer> {

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM descarga where dwn_usuario_id = :dwnUsuario", nativeQuery = true)
    List<Descarga> getDownloadByUser(@Param(value = "dwnUsuario")Descarga descarga);

}