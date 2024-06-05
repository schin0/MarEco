package br.com.fiap.mareco.api

import br.com.fiap.mareco.model.Reporte
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ReporteService {

    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("/incidenteCosteiro/cadastrar")
    fun postReporte(@Body reporte: Reporte): Call<Reporte>
}