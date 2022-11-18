package com.example.charliebookstore.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//Classe para centralizar as chamadas a API
class API {

    //Instância do Retrofit usada pelas chamadas
    private val retrofit: Retrofit
        get() {
            return Retrofit
                .Builder()
                .baseUrl("http://10.0.2.2:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    //Retorna os serviços para possibilitar a chamada
    val produto: ProdutoService
        get() {
            return retrofit.create(ProdutoService::class.java)
        }

}
