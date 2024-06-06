package br.com.fiap.mareco.services

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun formatarDataHora(dataHora: String): String {
    val formatoRecebido = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val formatoFinal = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm")

    val dateTime = LocalDateTime.parse(dataHora, formatoRecebido)

    return dateTime.format(formatoFinal)
}
