package br.com.fiap.mareco.model

data class Evento(
    val id: Int,
    val titulo: String,
    val descricao: String,
    val descricaoLocal: String,
    val pontoDeEncontro: String,
    val nomeOrganizador: String,
    val contatoOrganizador: String,
    val instrucaoEspecial: String,
//    val data: LocalDate,
//    val hora: LocalTime,
    val longitude: Double,
    val latitude: Double
)