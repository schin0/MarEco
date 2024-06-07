package com.gs.ocorrenciaservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "t_gs_incidente_costeiro")
public class IncidenteCosteiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column

    private String descricao;

    @Column
    private String tipoDeDano;

    @Column
    private String localizacao;

    @Column

    private LocalDate data;

    @Column

    private byte[] imagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeDano() {
        return tipoDeDano;
    }

    public void setTipoDeDano(String tipoDeDano) {
        this.tipoDeDano = tipoDeDano;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
