package br.com.fiap.mareco.model

import br.com.fiap.mareco.util.enum.TipoUsuario

data class Registro(var nome: String ="", val tipoUsuario: TipoUsuario, val email: String = "",val  senha: String = "")
