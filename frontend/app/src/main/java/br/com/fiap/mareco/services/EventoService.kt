package br.com.fiap.mareco.services

import androidx.navigation.NavController
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
            "oi",
            "Participe do monitoramento das baleias jubarte em Ilhabela, contribuindo para a preservação e estudos científicos dessas majestosas criaturas.",
            "Praia do Curral, Ilhabela, SP",
            "Em frente ao Quiosque do Zé",
            "Júlio Souza",
            "11978451245",
            "Traga binóculos, caderno para anotações e protetor solar.",
//            LocalDate.now(),
//            LocalTime.now(),
            (-23.51296927426321),
            (-46.69478687364815)
        ),
        Evento(
            2,
            "teste",
            "Ajude a monitorar ninhos de tartarugas na Praia do Tombo, protegendo ovos e garantindo a chegada segura das tartaruguinhas ao mar.",
            "Praia do Tombo, Guarujá, SP",
            "Em frente ao Posto de Guarda-Vidas",
            "Rosana Pimentel",
            "17998563365",
            "Traga luvas, lanterna vermelha e um caderno para anotações.",
//            LocalDate.now(),
//            LocalTime.now(),
            (-23.51296927426321),
            (-46.69478687364815)
        ),
    )
}

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
