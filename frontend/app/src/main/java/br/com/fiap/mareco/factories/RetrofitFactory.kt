package br.com.fiap.mareco.factories

import br.com.fiap.mareco.services.interfaces.EventoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL = "http://192.168.2.165:8082/evento/";

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
        .build()

    fun eventoService() : EventoService {
        return retrofitFactory.create(EventoService::class.java)
    }
}