package br.com.fiap.mareco.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import br.com.fiap.mareco.services.obterEventoPorId

@Composable
fun DetalhesEventoScreen(navController: NavController, eventoId: Int) {
    val evento = obterEventoPorId(eventoId)

    if (evento != null) {
        MapaScreen(evento)
    }
}