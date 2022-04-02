package com.sofka.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", unique = true, nullable = false)
    private Integer idCategory;

    @Column(name = "cat_nombre")
    private String nameCategory;

    @Column(name = "cat_created_at")
    private Date dateCategory;
}
