package br.com.fiap.mareco.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mareco.R

@Composable
fun RelatorioScreen(navController: NavController) {
    val scrollState = rememberScrollState(0)

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
                .padding(horizontal = 30.dp)
        ) {
            Text(
                text = "Relatórios e",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Monitoramentos",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(bottom = 130.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.verde),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .height(140.dp)
                        .width(140.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Acidentes",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = "Ambientais",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = R.drawable.terra),
                            contentDescription = "Terra",
                            modifier = Modifier
                                .size(45.dp)
                                .padding(top = 5.dp)
                        )
                    }

                }
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.verde),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .height(140.dp)
                        .width(140.dp),
                    shape = RoundedCornerShape(8.dp),

                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Estado dos",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = "Corais",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = R.drawable.coral),
                            contentDescription = "Coral",
                            modifier = Modifier
                                .size(45.dp)
                                .padding(top = 5.dp)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.verde),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .height(140.dp)
                        .width(140.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Text(
                            text = "Relato Sobre",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black

                        )
                        Text(
                            text = "Espécies",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = R.drawable.agua),
                            contentDescription = "Terra",
                            modifier = Modifier
                                .size(45.dp)
                                .padding(top = 5.dp)
                        )
                    }

                }
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.verde),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .height(140.dp)
                        .width(140.dp),
                    shape = RoundedCornerShape(8.dp),

                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Text(
                            text = "Inscrição Em",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = "Multirões",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = R.drawable.touch),
                            contentDescription = "Clique",
                            modifier = Modifier
                                .size(45.dp)
                                .padding(top = 5.dp)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.verde),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .height(140.dp)
                        .width(140.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Relatório de",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = "Doações",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = R.drawable.dolar),
                            contentDescription = "Dinheiro",
                            modifier = Modifier
                                .size(45.dp)
                                .padding(top = 5.dp)
                        )
                    }

                }
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.verde),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .height(140.dp)
                        .width(140.dp),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Text(
                            text = "Participação em",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = "Evento",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = R.drawable.pessoas),
                            contentDescription = "Pessoas",
                            modifier = Modifier
                                .size(45.dp)
                                .padding(top = 5.dp)
                        )
                    }
                }
            }
        }
    }

    MenuScreen(navController, itemSelecionado = "HOME")
}