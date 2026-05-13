package com.pedrodev.fieldops.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tenant")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor

public class Tenant extends BaseEntity{

    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "tipo_documento", length = 10, nullable = false)
    private String tipoDocumento;

    @Column(nullable = false, unique = true)
    private String documento;

    private String email;
    private String telefone;
    private Boolean ativo = true;

    // Endereço
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;

}
