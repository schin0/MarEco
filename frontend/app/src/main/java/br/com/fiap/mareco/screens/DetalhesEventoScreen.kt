package br.com.fiap.mareco.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.fiap.mareco.services.obterEventoPorId
import br.com.fiap.mareco.viewModels.EventoViewModel

@Composable
fun DetalhesEventoScreen(navController: NavController, eventoId: Long, eventoViewModel: EventoViewModel = viewModel()) {
    val evento by eventoViewModel.eventoUnico

    LaunchedEffect(Unit) {
        eventoViewModel.obterEventoPorId(eventoId)
    }

    evento?.let { MapaScreen(it) }
}