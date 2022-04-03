package com.sofka.service;

import com.sofka.domain.Descarga;
import com.sofka.domain.Usuario;
import com.sofka.repositories.DescargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class DescargaService implements  IDescargaService{
    @Autowired
    DescargaRepository descargaRepository;

    public List<Descarga> getDownloadByUser(Descarga descarga){
        return (List<Descarga>) descargaRepository.getDownloadByUser(descarga);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Descarga> list() {
        List<Descarga> usuarios = null;
        try {
            usuarios = (List<Descarga>) descargaRepository.findAll();
        } catch (Exception exc) {
            throw exc;
        }
        return usuarios;
    }
}
