package br.com.fiap.mareco.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mareco.R
import br.com.fiap.mareco.model.MenuItem

@Composable
fun BotaoMenuComponente(item: MenuItem, selecionado: Boolean, navController: NavController) {
    Button(onClick = { navController.navigate(item.nome) }, colors = ButtonDefaults.buttonColors(
        containerColor = colorResource(id = R.color.azul_agua)
    )) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = if (selecionado) item.iconeIdSelecionado else item.iconeId),
                contentDescription = item.descricaoIcone
            )

            Text(
                text = item.nome,
                fontSize = 20.sp,
                color = if (selecionado) Color.Black else colorResource(
                    id = R.color.cinza
                ),
                fontWeight = if (selecionado) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier.padding(top = 5.dp)
            )
        }

    }
}