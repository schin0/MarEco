package br.com.fiap.mareco.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun MostrarToastSucesso(menssagem: String){

    var contexto = LocalContext.current
    Toast.makeText(contexto, "${menssagem}", Toast.LENGTH_SHORT).show()

}
