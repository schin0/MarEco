package br.com.fiap.mareco.model

data class CardConfiguracao(
    val largura: Float,
    val altura: Float,
    val titulo: String,
    val descricao: String,
    val onClick: () -> Unit = { }
)