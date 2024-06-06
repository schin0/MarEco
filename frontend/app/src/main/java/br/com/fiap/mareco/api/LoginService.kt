package br.com.fiap.mareco.api

import br.com.fiap.mareco.model.Login
import br.com.fiap.mareco.model.Reporte
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {

    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("/login")
    fun postLogin(@Body login: Login): Call<Boolean>
}
