package br.com.fiap.mareco.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.fiap.mareco.R
import br.com.fiap.mareco.viewModels.EventoViewModel

@Composable
fun EventosScreen(navController: NavController, eventoViewModel: EventoViewModel = viewModel()) {
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

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val eventos by eventoViewModel.eventos

            LaunchedEffect(Unit) {
                eventoViewModel.listarEventos()
            }

            if (eventos.isNotEmpty()) {
                eventos.forEach {
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(8.dp)
                            .height(116.dp)
                            .width(333.dp)
                            .clickable {
                                navController.navigate("detalhesEvento/${it.id}")
                            },
                        colors = CardDefaults.cardColors(
                            containerColor = colorResource(id = R.color.verde),
                            contentColor = Color.Black,
                            disabledContainerColor = Color.LightGray,
                            disabledContentColor = Color.LightGray
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 8.dp, end = 8.dp, bottom = 16.dp, top = 8.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = it.titulo,
                                    color = Color.Black,
                                    fontSize = 18.sp
                                )

                                Text(
                                    text = "2.5km",
                                    color = Color.Black,
                                    fontSize = 15.sp
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = it.descricao,
                                    color = Color.Black,
                                    fontSize = 15.sp
                                )
                            }
                        }

                    }
                }
            }
        }

    }

    MenuScreen(navController)
}