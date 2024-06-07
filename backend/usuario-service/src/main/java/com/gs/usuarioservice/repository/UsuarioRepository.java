package com.gs.usuarioservice.repository;

import com.gs.usuarioservice.model.Usuario;
import com.gs.usuarioservice.request.LoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, Long > {
    @Query("SELECT new com.gs.usuarioservice.model.Usuario(c.email, c.senha) FROM Usuario c WHERE c.email = :email")
    Usuario findByEmail(String email);
}
