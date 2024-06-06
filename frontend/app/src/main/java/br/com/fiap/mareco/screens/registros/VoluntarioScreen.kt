package br.com.fiap.mareco.screens.registros

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mareco.components.BotaoComGradienteComponent
import br.com.fiap.mareco.components.TelaInicialComponent
import br.com.fiap.mareco.factories.RetrofitFactoryRegistro
import br.com.fiap.mareco.model.Registro
import br.com.fiap.mareco.util.enum.TipoUsuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun VoluntarioScreen(navController: NavController) {

    var nomeState by remember { mutableStateOf("") }
    var emailState by remember { mutableStateOf("") }
    var senhaState by remember { mutableStateOf("") }
    var confirmarSenhaState by remember { mutableStateOf("") }

    val contexto = LocalContext.current


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
                    value = nomeState,
                    onValueChange = { nomeState = it },
                    placeholder = {
                        Text(text = "Nome completo", color = Color.Black, fontSize = 18.sp)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    ),
                    textStyle = TextStyle(color = Color.Black)
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
                    value = emailState,
                    onValueChange = { emailState = it },
                    placeholder = {
                        Text(text = "E-mail", color = Color.Black, fontSize = 18.sp)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    ),
                    textStyle = TextStyle(color = Color.Black)
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
                    value = senhaState,
                    onValueChange = { senhaState = it },
                    placeholder = {
                        Text(text = "Crie uma senha", color = Color.Black, fontSize = 18.sp)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    ),
                    textStyle = TextStyle(color = Color.Black)
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
                    value = confirmarSenhaState,
                    onValueChange = { confirmarSenhaState = it },
                    placeholder = {
                        Text(text = "Confirme sua senha", color = Color.Black, fontSize = 18.sp)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    ),
                    textStyle = TextStyle(color = Color.Black)
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
                        .padding(horizontal = 0.dp, vertical = 10.dp),
                    onClick = {
                        if (senhaState == confirmarSenhaState) {
                            val call = RetrofitFactoryRegistro()
                                .postRegistroService()
                                .postRegistro(
                                    Registro(
                                        nome = nomeState,
                                        tipoUsuario = TipoUsuario.VOLUNTARIO,
                                        email = emailState,
                                        senha = senhaState
                                    )
                                )
                            call.enqueue(object : Callback<Registro> {
                                override fun onResponse(
                                    call: Call<Registro>,
                                    response: Response<Registro>
                                ) {
                                    Log.i("fiap", "${response.headers()}")
                                    Toast.makeText(
                                        contexto,
                                        "Registrado com sucesso!",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    navController.navigate("home")

                                }

                                override fun onFailure(call: Call<Registro>, t: Throwable) {
                                    Log.i("fiap", "${t.message}")
                                }
                            })
                        } else {
                            Toast.makeText(
                                contexto,
                                "Digite a senha corretamente!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
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

