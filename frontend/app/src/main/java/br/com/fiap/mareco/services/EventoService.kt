package br.com.fiap.mareco.services

import androidx.navigation.NavController
import br.com.fiap.mareco.model.CardConfiguracao
import br.com.fiap.mareco.model.Destaque
import br.com.fiap.mareco.model.Evento
import br.com.fiap.mareco.model.EventoDestaque

fun listarEventosDestaques(navController: NavController): List<Destaque> {
    val eventosSimples = listarEventosSimples()
    var cards = mutableListOf<CardConfiguracao>()

    eventosSimples.forEach {
        cards.add(
            CardConfiguracao(
                185f,
                116f,
                it.titulo,
                it.descricao
            )
        )
    }

    return listOf(
        Destaque(
            "Eventos",
            { navController.navigate("eventos") },
            cards
        )
    )
}

private fun listarEventosSimples(): List<EventoDestaque> {
    return listOf(
        EventoDestaque(
            1,
            "ILHABELA",
            "Ajude a monitorar as baleias jubarte em Ilhabela."
        ),
        EventoDestaque(
            2,
            "PRAIA DO TOMBO",
            "Monitoramento de Ninhos de Tartarugas."
        ),
        EventoDestaque(
            3,
            "PRAIA DE MARESIAS",
            "Participe da limpeza subaquática em Maresias."
        )
    )
}
