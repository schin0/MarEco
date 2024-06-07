package com.gs.usuarioservice.service;

import com.gs.usuarioservice.model.Usuario;
import com.gs.usuarioservice.repository.UsuarioRepository;
import com.gs.usuarioservice.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Service
public class LoginUsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public  LoginUsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public boolean login(LoginRequest loginRequest){
        Usuario usuario = usuarioRepository.findByEmail(loginRequest.getEmail());

        String hash = gerarHash(loginRequest.getSenha());

        return usuario != null && usuario.getSenha().equals(hash);
    }

    public String gerarHash(String senha) {
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] hash = sha1.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');

                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO: Tratar exceção
            return null;
        }
    }
}
