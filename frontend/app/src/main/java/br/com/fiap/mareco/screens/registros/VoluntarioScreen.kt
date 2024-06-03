package br.com.fiap.mareco.screens.registros

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mareco.components.BotaoComGradienteComponent
import br.com.fiap.mareco.components.TelaInicialComponent

@Composable
fun VoluntarioScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TelaInicialComponent()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 0.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Registre-se",
                    color = Color.Black,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .drawBehind {
                        val larguraSombra = 2 * density
                        val y = size.height - larguraSombra / 2

                        drawLine(
                            Color.Black,
                            Offset(0f, y),
                            Offset(size.width, y),
                            larguraSombra
                        )
                    }
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(text = "Nome completo", color = Color.Black, fontSize = 18.sp)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    ),
                )
            }

            Row(
                modifier = Modifier
                    .drawBehind {
                        val larguraSombra = 2 * density
                        val y = size.height - larguraSombra / 2

                        drawLine(
                            Color.Black,
                            Offset(0f, y),
                            Offset(size.width, y),
                            larguraSombra
                        )
                    }
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(text = "E-mail", color = Color.Black, fontSize = 18.sp)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    ),
                )
            }

            Row(
                modifier = Modifier
                    .drawBehind {
                        val larguraSombra = 2 * density
                        val y = size.height - larguraSombra / 2

                        drawLine(
                            Color.Black,
                            Offset(0f, y),
                            Offset(size.width, y),
                            larguraSombra
                        )
                    }
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(text = "Crie uma senha", color = Color.Black, fontSize = 18.sp)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    ),
                )
            }

            Row(
                modifier = Modifier
                    .drawBehind {
                        val larguraSombra = 2 * density
                        val y = size.height - larguraSombra / 2

                        drawLine(
                            Color.Black,
                            Offset(0f, y),
                            Offset(size.width, y),
                            larguraSombra
                        )
                    }
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(text = "Confirme sua senha", color = Color.Black, fontSize = 18.sp)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    ),
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                BotaoComGradienteComponent(
                    "Registrar",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 0.dp, vertical = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Já possui uma conta? "
                )

                Text(
                    text = "Faça o login",
                    modifier = Modifier
                        .clickable {
                            navController.navigate("login")
                        },
                    textDecoration = TextDecoration.Underline
                )
            }

        }
    }
}