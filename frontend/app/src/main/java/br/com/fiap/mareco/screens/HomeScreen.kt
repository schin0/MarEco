package br.com.fiap.mareco.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import br.com.fiap.mareco.R
import br.com.fiap.mareco.components.DestaqueComponent
import br.com.fiap.mareco.services.listarEventosDestaques
import br.com.fiap.mareco.services.listarReportes

@Composable
fun HomeScreen(navController: NavController) {
    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.fundohome),
                    contentDescription = "Fundo",
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }
        }

        val listaReporte = listarReportes(contexto)

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            listaReporte.forEach {
                DestaqueComponent(destaque = it)
            }
        }

        val listaEvento = listarEventosDestaques(navController)

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            listaEvento.forEach {
                DestaqueComponent(destaque = it)
            }
        }
    }

    MenuScreen(navController, "HOME")
}