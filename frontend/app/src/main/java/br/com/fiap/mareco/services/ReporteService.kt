package br.com.fiap.mareco.services

import android.content.Context
import br.com.fiap.mareco.model.CardConfiguracao
import br.com.fiap.mareco.model.Destaque

fun listarReportes(contexto: Context): List<Destaque> {
    return listOf(
        Destaque(
            "Reporte",
            { mostrarMensagemEmConstrucao(contexto) },
            cards = listOf(
                CardConfiguracao(
                    120f,
                    165f,
                    "CORAIS",
                    "Corais danificados"
                ),
                CardConfiguracao(
                    120f,
                    165f,
                    "ÓLEO",
                    "Vazamento de óleo"
                ),
                CardConfiguracao(
                    120f,
                    165f,
                    "ESGOTO",
                    "Vazamento de esgoto"
                ),
                CardConfiguracao(
                    120f,
                    165f,
                    "ESPÉCIES",
                    "Desaparecimento de espécies"
                ),
                CardConfiguracao(
                    120f,
                    165f,
                    "RESÍDUOS",
                    "Descarte de resíduos"
                )
            )
        )
    )
}