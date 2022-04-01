package com.sofka.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.util.Date;


@Data
@Entity
@Table(name = "subcategoria")
public class Subcategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scat_id", unique = true, nullable = false)
    private Integer idSubCategory;

    @Column(name = "scat_nombre")
    private String nameSubCategory;

    @Column(name = "scat_created_at")
    private Date dateSubCategory;
}
