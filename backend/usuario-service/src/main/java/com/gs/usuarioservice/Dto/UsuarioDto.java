package com.gs.usuarioservice.Dto;

import com.gs.usuarioservice.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class UsuarioDto {

    private String nome;
    private String tipoUsuario;
    private String email;
    private String senha;

    public UsuarioDto(String nome, String tipoUsuario, String email, String senha) {
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
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
