package br.com.fiap.mareco.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mareco.R

@Composable
fun BotaoMenuComponente(nomeItem: String, navController: NavController) {
    Button(onClick = { navController.navigate(nomeItem) }, colors = ButtonDefaults.buttonColors(
        containerColor = colorResource(id = R.color.azul_agua)
    )) {
        Text(text = nomeItem, fontSize = 20.sp)
    }
}