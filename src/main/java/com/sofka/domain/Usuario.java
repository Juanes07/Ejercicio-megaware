package com.sofka.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id", nullable = false)
    private Integer id;

    @Column(name = "usu_username", nullable = false, length = 80)
    private String usuUsername;

    @Column(name = "usu_password", nullable = false, length = 32)
    private String usuPassword;

    @Column(name = "usu_created_at", nullable = false)
    private Timestamp usuCreatedAt;

    @Column(name = "usu_updated_at")
    private Instant usuUpdatedAt;

    @OneToMany(mappedBy = "dwnUsuario")
    private Set<Descarga> descargas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sesUsuario")
    private Set<Session> sessions = new LinkedHashSet<>();

    private static final long serialVersionUID = 1L;
}