package br.com.fiap.mareco.services

import android.content.Context
import br.com.fiap.mareco.model.CardConfiguracao
import br.com.fiap.mareco.model.Destaque
import br.com.fiap.mareco.model.Evento
import br.com.fiap.mareco.model.EventoDestaque
import java.time.LocalDate
import java.time.LocalTime

fun listarEventos(): List<Evento> {
    return listOf(
        Evento(
            1,
            "ILHABELA",
            "Ajude a monitorar as baleias jubarte em Ilhabela.",
            "Praia do Curral, Ilhabela, SP",
            "Em frente ao Quiosque do Zé",
            "Júlio Souza",
            "11978451245",
            "Traga binóculos, caderno para anotações e protetor solar.",
            LocalDate.now(),
            LocalTime.now()
        ),
        Evento(
            2,
            "PRAIA DO TOMBO",
            "Monitoramento de Ninhos de Tartarugas.",
            "Praia do Tombo, Guarujá, SP",
            "Em frente ao Posto de Guarda-Vidas",
            "Rosana Pimentel",
            "17998563365",
            "Traga luvas, lanterna vermelha e um caderno para anotações.",
            LocalDate.now(),
            LocalTime.now()
        ),
    )
}

fun listarEventosDestaques(contexto: Context): List<Destaque> {
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
            { mostrarMensagemEmConstrucao(contexto) },
            cards
        )
    )
}

private fun listarEventosSimples() :List<EventoDestaque> {
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
