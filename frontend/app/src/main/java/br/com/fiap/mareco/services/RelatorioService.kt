package br.com.fiap.mareco.services

import android.content.Context
import androidx.navigation.NavController
import br.com.fiap.mareco.model.CardConfiguracao
import br.com.fiap.mareco.model.Destaque

fun listarRelatorios(navController: NavController, contexto: Context): List<Destaque> {
    return listOf(
        Destaque(
            "Relatórios",
            { navController.navigate("relatorios") },
            cards = listOf(
                CardConfiguracao(
                    120f,
                    165f,
                    "ACIDENTES AMBIETAIS",
                    "",
                    { mostrarMensagemEmConstrucao(contexto) }
                ),
                CardConfiguracao(
                    120f,
                    165f,
                    "ESTADO DOS CORAIS",
                    "",
                    { mostrarMensagemEmConstrucao(contexto) }
                ),
                CardConfiguracao(
                    120f,
                    165f,
                    "RELATO SOBRE ESPÉCIES",
                    "",
                    { mostrarMensagemEmConstrucao(contexto) }
                ),
                CardConfiguracao(
                    120f,
                    165f,
                    "INSCRIÇÃO EM MULTIRÕES",
                    "",
                    { mostrarMensagemEmConstrucao(contexto) }
                )
            )
        )
    )
}