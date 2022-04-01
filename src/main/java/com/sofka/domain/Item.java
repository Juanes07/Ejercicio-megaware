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
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itm_id",unique = true, nullable = false)
    private Integer itemId;

    @Column(name = "itm_subcategoria_id", nullable = false)
    private Integer itemSubcategoryId;

    @Column(name = "itm_nombre")
    private  String itemName;

    @Column(name = "itm_created_at")
    private Date itemDate;
}
