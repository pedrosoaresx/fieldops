package com.pedrodev.fieldops.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Classe base abstrata que fornece campos de auditoria e identificação para todas as entidades do sistema.
 *
 * <p>Esta classe utiliza o conceito de {@code @MappedSuperclass} para evitar a repetição de código
 * de infraestrutura (ID, datas de criação e atualização) em todas as tabelas do banco de dados.</p>
 *
 * @author Pedro
 * @version 1.0
 */

@MappedSuperclass
@Data

public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @PrePersist
    protected void onCreate() {
        criadoEm = LocalDateTime.now();
        atualizadoEm = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        atualizadoEm = LocalDateTime.now();
    }

}
