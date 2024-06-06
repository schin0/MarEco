package br.com.fiap.mareco.services.interfaces

import br.com.fiap.mareco.model.Login
import br.com.fiap.mareco.model.Registro
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RegistroService {

    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("/usuario/cadastrar")
    fun postRegistro(@Body registro: Registro): Call<Registro>
}