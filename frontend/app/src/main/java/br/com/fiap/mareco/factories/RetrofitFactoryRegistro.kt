package br.com.fiap.mareco.factories

import br.com.fiap.mareco.services.interfaces.RegistroService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactoryRegistro {
    private val URL = "http://10.0.2.2:8080"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(loggingInterceptor)
    }.build()

    private val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun postRegistroService(): RegistroService{
        return retrofitFactory.create(RegistroService::class.java)
    }
}