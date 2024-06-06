package br.com.fiap.mareco.services.interfaces

import br.com.fiap.mareco.model.Reporte
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ReporteService {

    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("/incidenteCosteiro/cadastrar")
    fun postReporte(@Body reporte: Reporte): Call<Reporte>
}