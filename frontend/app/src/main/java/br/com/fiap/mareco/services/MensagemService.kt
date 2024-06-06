package br.com.fiap.mareco.services

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

fun mostrarMensagemEmConstrucao(contexto: Context) {
    Toast.makeText(contexto, "Funcionalidade em construção :)", Toast.LENGTH_SHORT).show()
}

@Composable
fun mostrarToastSucesso(mensagem: String){
    var contexto = LocalContext.current
    Toast.makeText(contexto, mensagem, Toast.LENGTH_SHORT).show()
}