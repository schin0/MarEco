package com.gs.usuarioservice.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    private String senha;

    public Hash(String senha){
        gerarHash(this.senha = senha);
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
            return null;
        }
    }
}
