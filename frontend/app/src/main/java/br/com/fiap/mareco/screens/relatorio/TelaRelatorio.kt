package br.com.fiap.mareco.screens.relatorio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mareco.components.TelaHomeComponent

@Composable
fun TelaRelatorio() {
    Column {
        TelaHomeComponent()

        Column(
            modifier = Modifier
                .padding(top = 20.dp)
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

        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Card(
                colors = CardDefaults.cardColors(contentColor = Color.Gray),
                modifier = Modifier
                    .height(140.dp)
                    .width(140.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)


            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
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
                }

            }
            Card(
                colors = CardDefaults.cardColors(contentColor = Color.Gray),
                modifier = Modifier
                    .height(140.dp)
                    .width(140.dp),
                shape = RoundedCornerShape(8.dp),

                ) {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
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
                colors = CardDefaults.cardColors(contentColor = Color.Gray),
                modifier = Modifier
                    .height(140.dp)
                    .width(140.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)


            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
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
                }

            }
            Card(
                colors = CardDefaults.cardColors(contentColor = Color.Gray),
                modifier = Modifier
                    .height(140.dp)
                    .width(140.dp),
                shape = RoundedCornerShape(8.dp),

                ) {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
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
                colors = CardDefaults.cardColors(contentColor = Color.Gray),
                modifier = Modifier
                    .height(140.dp)
                    .width(140.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)


            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
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
                }

            }
            Card(
                colors = CardDefaults.cardColors(contentColor = Color.Gray),
                modifier = Modifier
                    .height(140.dp)
                    .width(140.dp),
                shape = RoundedCornerShape(8.dp),

                ) {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
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
                }
            }
        }
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaCoralRelatorioPreview() {
    TelaRelatorio()
}