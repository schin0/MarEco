package com.gs.usuarioservice.controller;

import com.gs.usuarioservice.Dto.UsuarioDto;
import com.gs.usuarioservice.model.Usuario;
import com.gs.usuarioservice.service.LoginUsuarioService;
import com.gs.usuarioservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
 private UsuarioService usuarioService;
 private LoginUsuarioService loginUsuarioService;


 @Autowired
 public UsuarioController(UsuarioService usuarioService, LoginUsuarioService loginUsuarioService){
  this.usuarioService = usuarioService; this.loginUsuarioService = loginUsuarioService;
 }
 @CrossOrigin(origins = "*")
 @PostMapping("/cadastrar")
 public ResponseEntity cadastrarUsuario (@RequestBody Usuario usuario){
  return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(usuario));
 }

 @CrossOrigin(origins = "*")
 @GetMapping("/listar")
 public ResponseEntity listarUsuario(){
  return ResponseEntity.ok(usuarioService.listarUsuario());
 }
}
