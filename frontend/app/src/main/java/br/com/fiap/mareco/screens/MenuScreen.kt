package br.com.fiap.mareco.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.mareco.components.BotaoMenuComponente
import br.com.fiap.mareco.R
import br.com.fiap.mareco.model.MenuItem

@Composable
fun MenuScreen(navController: NavController, itemSelecionado: String) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.azul_agua))
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 25.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val botoesMenu = listOf(
                MenuItem(
                    "HOME",
                    R.drawable.baseline_home_24_gray,
                    R.drawable.baseline_home_24,
                    "Home"
                ),
                MenuItem(
                    "EVENTOS",
                    R.drawable.baseline_calendar_today_24_gray,
                    R.drawable.baseline_calendar_today_24,
                    "Eventos"
                ),
                MenuItem(
                    "REPORT",
                    R.drawable.baseline_report_gmailerrorred_24_gray,
                    R.drawable.baseline_report_gmailerrorred_24,
                    "Report"
                )
            )

            botoesMenu.forEach {item ->
                BotaoMenuComponente(item, item.nome == itemSelecionado, navController)
            }
        }

    }
}