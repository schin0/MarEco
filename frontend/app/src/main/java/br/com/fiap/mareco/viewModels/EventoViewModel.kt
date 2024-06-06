package br.com.fiap.mareco.viewModels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.mareco.factories.RetrofitFactory
import br.com.fiap.mareco.model.Evento
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventoViewModel : ViewModel() {
    private val _eventos = mutableStateOf<List<Evento>>(emptyList())
    var eventos: State<List<Evento>> = _eventos

    fun listarEventos() {
        viewModelScope.launch {
            try {
                val call = RetrofitFactory().eventoService().listarEventos()

                call.enqueue(object : Callback<List<Evento>> {
                    override fun onResponse(
                        call: Call<List<Evento>>,
                        response: Response<List<Evento>>
                    ) {
                        if (response.isSuccessful) {
                            _eventos.value = response.body() ?: emptyList()
                        } else {
                            Log.e("Response Error", "Código: ${response.code()}, Mensagem: ${response.message()}")
                            response.errorBody()?.let { errorBody ->
                                Log.e("Error Body", errorBody.string())
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<Evento>>, t: Throwable) {
                        Log.e("Erro1", t.message ?: "Erro desconhecido")
                    }
                })

            } catch (e: Exception) {
                Log.e("Erro1", e.message ?: "Erro desconhecido")
            }
        }
    }

    private val _eventoUnico = mutableStateOf<Evento?>(null)
    var eventoUnico: State<Evento?> = _eventoUnico

    fun obterEventoPorId(id: Long) {
        viewModelScope.launch {
            try {
                val call = RetrofitFactory().eventoService().obterPorId(id)

                call.enqueue(object : Callback<Evento> {
                    override fun onResponse(
                        call: Call<Evento>,
                        response: Response<Evento>
                    ) {
                        if (response.isSuccessful) {
                            _eventoUnico.value = response.body()
                        } else {
                            Log.e("Response Error", "Código: ${response.code()}, Mensagem: ${response.message()}")
                            response.errorBody()?.let { errorBody ->
                                Log.e("Error Body", errorBody.string())
                            }
                        }
                    }

                    override fun onFailure(call: Call<Evento>, t: Throwable) {
                        Log.e("Erro1", t.message ?: "Erro desconhecido")
                    }
                })

            } catch (e: Exception) {
                Log.e("Erro1", e.message ?: "Erro desconhecido")
            }
        }
    }
}
