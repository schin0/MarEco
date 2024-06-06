package br.com.fiap.mareco.services

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.fiap.mareco.model.CardConfiguracao
import br.com.fiap.mareco.model.Destaque
import br.com.fiap.mareco.model.EventoDestaque
import br.com.fiap.mareco.viewModels.EventoViewModel

@Composable
fun listarEventosDestaques(navController: NavController, eventoViewModel: EventoViewModel = viewModel()): List<Destaque> {
    val eventos by eventoViewModel.eventos

    LaunchedEffect(Unit) {
        eventoViewModel.listarEventos()
    }

    if (eventos.isNotEmpty()) {
        val eventosSimples: List<EventoDestaque> = eventos.map { evento ->
            val descricaoLimitada = if (evento.descricao.length > 50) {
                "${evento.descricao.take(35)}..."
            } else {
                evento.descricao
            }

            EventoDestaque(
                id = evento.id,
                titulo = evento.titulo,
                descricao = descricaoLimitada
            )
        }

        val cards = mutableListOf<CardConfiguracao>()

        eventosSimples.forEach {
            cards.add(
                CardConfiguracao(
                    185f,
                    116f,
                    it.titulo,
                    it.descricao,
                    { navController.navigate("detalhesEvento/${it.id}") }
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

    return emptyList()
}
