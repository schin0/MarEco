package com.gs.usuarioservice.model;

import com.gs.usuarioservice.util.TipoUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "t_gs_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    @Column(unique = true)

    private String email;
    @Column
    private String senha;

    public Usuario(){}

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
