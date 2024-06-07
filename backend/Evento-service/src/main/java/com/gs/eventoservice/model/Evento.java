package com.gs.eventoservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.spi.LocaleNameProvider;

@Entity
@Table(name = "t_gs_evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private String descricaoLocal;

    @Column
    private String pontoDeEncontro;

    @Column
    private String nomeOrganizador;

    @Column
    private String contatoOrganizador;

    @Column
    private String instrucaoEspecial;

    @Column
    private LocalDate data;

    @Column
    private LocalTime hora;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
    }

    public String getPontoDeEncontro() {
        return pontoDeEncontro;
    }

    public void setPontoDeEncontro(String pontoDeEncontro) {
        this.pontoDeEncontro = pontoDeEncontro;
    }

    public String getNomeOrganizador() {
        return nomeOrganizador;
    }

    public void setNomeOrganizador(String nomeOrganizador) {
        this.nomeOrganizador = nomeOrganizador;
    }

    public String getContatoOrganizador() {
        return contatoOrganizador;
    }

    public void setContatoOrganizador(String contatoOrganizador) {
        this.contatoOrganizador = contatoOrganizador;
    }

    public String getInstrucaoEspecial() {
        return instrucaoEspecial;
    }

    public void setInstrucaoEspecial(String instrucaoEspecial) {
        this.instrucaoEspecial = instrucaoEspecial;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
