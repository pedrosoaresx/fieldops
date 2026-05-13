package com.pedrodev.fieldops.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor

public class Cliente extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    private String documento;
    private String email;
    private String telefone;

    @Column(name = "nome_contato")
    private String nomeContato;

    private Boolean ativo = true;

}
