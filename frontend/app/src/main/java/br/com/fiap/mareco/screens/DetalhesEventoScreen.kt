package br.com.fiap.mareco.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.fiap.mareco.R
import br.com.fiap.mareco.components.BotaoComGradienteComponent
import br.com.fiap.mareco.services.formatarDataHora
import br.com.fiap.mareco.services.mostrarMensagemEmConstrucao
import br.com.fiap.mareco.viewModels.EventoViewModel

@Composable
fun DetalhesEventoScreen(
    navController: NavController,
    eventoId: Long,
    eventoViewModel: EventoViewModel = viewModel()
) {
    val evento by eventoViewModel.eventoUnico

    LaunchedEffect(Unit) {
        eventoViewModel.obterEventoPorId(eventoId)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(225.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                evento?.let { MapaScreen(it) }

                Button(
                    onClick = { navController.navigate("eventos") },
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp)
                        .align(Alignment.TopStart)
                        .width(65.dp)
                        .shadow(5.dp, CircleShape),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "Seta voltar"
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            evento?.let {
                val scrollState = rememberScrollState(0)
                val contexto = LocalContext.current

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, top = 16.dp, bottom = 100.dp, end = 32.dp)
                        .verticalScroll(scrollState)
                ) {
                    Text(text = it.titulo, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = it.descricao, fontSize = 18.sp)

                    Spacer(modifier = Modifier.height(32.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_calendar_today_24),
                            contentDescription = "Ícone calendário",
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        val dataHoraOriginal = "${it.data} ${it.hora}"
                        val dataHoraFormatada = formatarDataHora(dataHoraOriginal)

                        Text(text = dataHoraFormatada, fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_person_pin_circle_24),
                            contentDescription = "Ícone Localização",
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(text = it.descricaoLocal, fontSize = 18.sp)
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(text = "Ponto de encontro:", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = it.pontoDeEncontro, fontSize = 18.sp)

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(text = "Organizador:", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Nome: ${it.nomeOrganizador}", fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Contato: ${it.contatoOrganizador}", fontSize = 20.sp)

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BotaoComGradienteComponent(
                            "Participar",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 5.dp, vertical = 10.dp)
                                .weight(1f),
                            onClick = {
                                mostrarMensagemEmConstrucao(contexto)
                            }
                        )

                        BotaoComGradienteComponent(
                            "Doar",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 0.dp, vertical = 10.dp)
                                .weight(1f),
                            onClick = {
                                mostrarMensagemEmConstrucao(contexto)
                            }
                        )
                    }

                }
            }
        }
    }

    MenuScreen(navController, "EVENTOS")

}