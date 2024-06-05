package br.com.fiap.mareco.model

data class Destaque(
    val titulo: String,
    val onClickTitulo: () -> Unit = { },
    val cards: List<CardConfiguracao>
)