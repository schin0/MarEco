package br.com.fiap.mareco.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
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
import br.com.fiap.mareco.factories.RetrofitFactoryLogin
import br.com.fiap.mareco.model.Login
import br.com.fiap.mareco.services.mostrarMensagemEmConstrucao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val contexto = LocalContext.current
        var senhaState by remember { mutableStateOf("") }
        var emailState by remember { mutableStateOf("") }

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

            Spacer(modifier = Modifier.height(32.dp))

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
                    value = emailState,
                    onValueChange = { emailState = it },
                    placeholder = {
                        Text(text = "Digite seu email", color = Color.Black, fontSize = 20.sp)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    )
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
                    value = senhaState,
                    onValueChange = { senhaState = it },
                    placeholder = {
                        Text(text = "Digite sua senha", color = Color.Black, fontSize = 18.sp)
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

            Spacer(modifier = Modifier.height(8.dp))

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

            Spacer(modifier = Modifier.height(16.dp))

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
                        var call = RetrofitFactoryLogin()
                            .postLoginService()
                            .postLogin(
                                Login(
                                    email = emailState,
                                    senha = senhaState
                                )
                            )

                        call.enqueue(object : Callback<Boolean> {
                            override fun onResponse(
                                call: Call<Boolean>,
                                response: Response<Boolean>
                            ) {
                                if (response.isSuccessful) {
                                    val responseBody = response.body()
                                    responseBody?.let {
                                        var resposta = it

                                        if (resposta) {
                                            navController.navigate("home")
                                        } else {
                                            Toast.makeText(
                                                contexto,
                                                "Email ou senha Inválidos!",
                                                Toast.LENGTH_LONG
                                            ).show()
                                        }
                                    }
                                } else {
                                    println("Response error: ${response.errorBody()}")
                                }
                            }

                            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                                Log.i("fiap", "${t.message}")
                            }
                        })
                    }
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