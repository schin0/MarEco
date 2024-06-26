package br.com.fiap.mareco.services

import android.content.Context
import androidx.navigation.NavController
import br.com.fiap.mareco.model.CardConfiguracao
import br.com.fiap.mareco.model.Destaque

fun listarReportes(navController: NavController, contexto: Context): List<Destaque> {
    return listOf(
        Destaque(
            "Reporte",
            { mostrarMensagemEmConstrucao(contexto) },
            cards = listOf(
                CardConfiguracao(
                    120f,
                    165f,
                    "CORAIS",
                    "Corais danificados",
                    { navController.navigate("reportar/coral") }
                ),
                CardConfiguracao(
                    120f,
                    165f,
                    "ÓLEO",
                    "Vazamento de óleo",
                    { mostrarMensagemEmConstrucao(contexto) }
                ),
                CardConfiguracao(
                    120f,
                    165f,
                    "ESGOTO",
                    "Vazamento de esgoto",
                    { mostrarMensagemEmConstrucao(contexto) }
                ),
                CardConfiguracao(
                    120f,
                    165f,
                    "ESPÉCIES",
                    "Desaparecimento de espécies",
                    { mostrarMensagemEmConstrucao(contexto) }
                ),
                CardConfiguracao(
                    120f,
                    165f,
                    "RESÍDUOS",
                    "Descarte de resíduos",
                    { mostrarMensagemEmConstrucao(contexto) }
                )
            )
        )
    )
}