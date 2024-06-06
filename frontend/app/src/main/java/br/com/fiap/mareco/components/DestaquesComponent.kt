package br.com.fiap.mareco.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mareco.R
import br.com.fiap.mareco.model.Destaque

@Composable
fun DestaqueComponent(destaque: Destaque) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 0.dp, bottom = 0.dp, top = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp, start = 0.dp, bottom = 0.dp, top = 0.dp)
                .clickable {
                    destaque.onClickTitulo()
                },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = destaque.titulo,
                color = Color.Black,
                fontSize = 20.sp
            )

            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                contentDescription = "Seta para direita"
            )
        }

        val scrollState = rememberScrollState(0)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp, start = 0.dp, bottom = 0.dp, top = 0.dp)
                .horizontalScroll(scrollState),
        ) {
            destaque.cards.forEach { configuracao ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .height(configuracao.altura.dp)
                        .width(configuracao.largura.dp)
                        .clickable {
                            if (configuracao.onClick != { }) {
                                configuracao.onClick()
                            }
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
                            .padding(8.dp, 16.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = configuracao.titulo,
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = configuracao.descricao,
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