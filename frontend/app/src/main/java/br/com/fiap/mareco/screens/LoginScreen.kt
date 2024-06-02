package br.com.fiap.mareco.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mareco.components.BotaoComGradienteComponent
import br.com.fiap.mareco.components.TelaInicialComponent
import br.com.fiap.mareco.services.mostrarMensagemEmConstrucao

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val contexto = LocalContext.current

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
                    text = "Entrar",
                    color = Color.Black,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row {
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(text = "Digite seu email")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        disabledTextColor = Color.Black,
                        disabledBorderColor = Color.Black,
                        disabledLabelColor = Color.Black,
                    )
                )
            }

            Row {
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(text = "Digite sua senha")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        disabledTextColor = Color.Black,
                        disabledBorderColor = Color.Black,
                        disabledLabelColor = Color.Black,
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Esqueceu sua senha?",
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            mostrarMensagemEmConstrucao(contexto)
                        }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                BotaoComGradienteComponent(
                    "Acessar",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 0.dp, vertical = 10.dp),
                    onClick = {
                        mostrarMensagemEmConstrucao(contexto)
                    }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ainda não possui conta? "
                )

                Text(
                    text = "Cadastre-se",
                    modifier = Modifier
                        .clickable {
                            navController.navigate("registro")
                        },
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}