package br.com.fiap.mareco.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mareco.R
import br.com.fiap.mareco.factories.RetrofitFactoryReporte
import br.com.fiap.mareco.model.Reporte
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CoralReporteScreen(navController: NavController) {
    val options = listOf("Opção 1", "Opção 2", "Opção 3", "Opção 4")

    var tipoDeDanoState by remember { mutableStateOf("selecione uma opção") }

    var expanded by remember { mutableStateOf(false) }

    var descricaoState by remember { mutableStateOf("") }

    var localizacaoState by remember { mutableStateOf("") }

    val contexto = LocalContext.current

    Log.d("RequestBody", descricaoState)
    Log.d("RequestBody", tipoDeDanoState)
    Log.d("RequestBody", localizacaoState)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)

    ) {
        IconButton(
            onClick = {
                navController.navigate("report")
            },
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .background(Color.Black),
                tint = Color.White,
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "icon"
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            text = "Coral Danificado",
            textAlign = TextAlign.Start,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Ajude a preservar os corais reportando qualquer dano ou problema observado.",
            fontSize = 16.sp
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Text(text = "Tipo de dano:", fontSize = 18.sp)

            Column(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = tipoDeDanoState,
                    onValueChange = {},
                    label = { Text("Escolha uma opção") },
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = { expanded = !expanded }) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Dropdown Icon"
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(onClick = {
                            tipoDeDanoState = option
                            expanded = false
                        }, text = { Text(text = option) })
                    }
                }
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Descrição do Incidente:", fontSize = 18.sp)

                OutlinedTextField(
                    value = descricaoState,
                    onValueChange = { descricaoState = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    )
                )
            }
            Column {
                Text(text = "Localização:", fontSize = 18.sp)

                OutlinedTextField(
                    value = localizacaoState,
                    onValueChange = { localizacaoState = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    )
                )
            }

            Button(onClick = {
                val call = RetrofitFactoryReporte()
                    .postReportService()
                    .postReporte(
                        Reporte(
                            descricao = descricaoState,
                            tipoDeDano = tipoDeDanoState,
                            localizacao = localizacaoState
                        )
                    )

                call.enqueue(object : Callback<Reporte> {
                    override fun onResponse(call: Call<Reporte>, response: Response<Reporte>) {
                        Log.i("fiap", "${response.headers()}")
                    }

                    override fun onFailure(call: Call<Reporte>, t: Throwable) {
                        Log.i("fiap", "${t.message}")
                    }
                })

                Toast.makeText(contexto, "Registrado com sucesso!", Toast.LENGTH_SHORT).show()

            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Enviar", fontSize = 18.sp)
            }

        }

    }

}