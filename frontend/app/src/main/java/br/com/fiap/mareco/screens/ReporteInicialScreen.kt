package br.com.fiap.mareco.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mareco.R
import br.com.fiap.mareco.services.mostrarMensagemEmConstrucao

@Composable
fun ReporteInicialScreen(navController: NavController) {
    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
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

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .padding(horizontal = 12.dp),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Encontrou um incidente?",
                textAlign = TextAlign.Start,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Reporte!",
                textAlign = TextAlign.Start,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                text = "Qual tipo de incidente!",
                textAlign = TextAlign.Start,
                fontSize = 20.sp
            )
            Column {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                        .padding(vertical = 5.dp),
                    onClick = {
                        navController.navigate("reportar/coral")
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = colorResource(id = R.color.verde)
                    )
                ) {
                    Text(
                        text = "Coral Danificado"
                    )
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                        .padding(vertical = 5.dp),
                    onClick = {
                          mostrarMensagemEmConstrucao(contexto)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = colorResource(id = R.color.verde)
                    )
                ) {
                    Text(
                        text = "Vazamento de Óleo"
                    )
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                        .padding(vertical = 5.dp),
                    onClick = {
                        mostrarMensagemEmConstrucao(contexto)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = colorResource(id = R.color.verde)
                    )
                ) {
                    Text(
                        text = "Esgoto"
                    )
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                        .padding(vertical = 5.dp),
                    onClick = {
                        mostrarMensagemEmConstrucao(contexto)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = colorResource(id = R.color.verde)
                    )
                ) {
                    Text(
                        text = "Desaparecimento de Espécie"
                    )
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                        .padding(vertical = 5.dp),
                    onClick = {
                        mostrarMensagemEmConstrucao(contexto)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = colorResource(id = R.color.verde)
                    )
                ) {
                    Text(
                        text = "Descarte de  Resíduo"
                    )
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                        .padding(vertical = 5.dp),
                    onClick = {
                        mostrarMensagemEmConstrucao(contexto)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = colorResource(id = R.color.verde)
                    )
                ) {
                    Text(
                        text = "Outros"
                    )
                }
            }
        }
    }

    MenuScreen(navController, itemSelecionado = "REPORT")
}