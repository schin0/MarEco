package com.gs.usuarioservice.controller;

import com.gs.usuarioservice.request.LoginRequest;
import com.gs.usuarioservice.service.LoginUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginUsuarioController {


    private LoginUsuarioService loginUsuarioService;

    @Autowired
    public LoginUsuarioController(LoginUsuarioService loginUsuarioService){
        this.loginUsuarioService = loginUsuarioService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    public boolean login(@RequestBody LoginRequest loginRequest){
        return loginUsuarioService.login(loginRequest);
    }

}
