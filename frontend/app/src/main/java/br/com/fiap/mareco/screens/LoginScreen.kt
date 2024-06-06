package br.com.fiap.mareco.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mareco.api.RetrofitFactoryLogin
import br.com.fiap.mareco.api.RetrofitFactoryReporte
import br.com.fiap.mareco.components.BotaoComGradienteComponent
import br.com.fiap.mareco.components.TelaInicialComponent
import br.com.fiap.mareco.model.Login
import br.com.fiap.mareco.model.Reporte
import br.com.fiap.mareco.services.mostrarMensagemEmConstrucao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavController) {

    var senhaState by remember { mutableStateOf("") }

    var emailState by remember { mutableStateOf("") }



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

            Row() {
                OutlinedTextField(
                    value = emailState,
                    onValueChange = {emailState = it },
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
                    value = senhaState,
                    onValueChange = { senhaState = it},
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
                                            navController.navigate("reporte")
                                        }else{
                                            Toast.makeText(contexto, "Email ou senha Inválidos!", Toast.LENGTH_LONG).show()
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
                            // navController.navigate("registro")
                        },
                    textDecoration = TextDecoration.Underline
                )

            }
        }
    }
}

