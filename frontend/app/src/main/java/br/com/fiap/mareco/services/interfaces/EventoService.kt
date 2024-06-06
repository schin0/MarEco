package br.com.fiap.mareco.services.interfaces

import br.com.fiap.mareco.model.Evento
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EventoService {
    @GET("listar")
    fun listarEventos() : Call<List<Evento>>

    @GET("obterPorId/{id}")
    fun obterPorId(@Path("id") id: Long) : Call<Evento>
}