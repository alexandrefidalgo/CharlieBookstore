package com.example.charliebookstore.service

import com.example.charliebookstore.model.Produto
import retrofit2.Call
import retrofit2.http.*

//Serviço visa centralizar os endpoints de determinado recurso
interface ProdutoService {

    //USADO NO PROJETO
    @GET("/produto")
    fun listar(): Call<List<Produto>>

    //OUTROS EXEMPLOS
    //Parâmetro de URL (ex: http://endereco.com.br/endpoint/valorId)
    @GET("/produto/{id}")
    fun get(@Path("id") id: Int): Call<Produto>

    //Outro exemplo de parâmetro de URL (ex: http://endereco.com.br/endpoint/valorNome)
    @GET("/produto/{nome}")
    fun pesquisar(@Path("nome") nome: String): Call<List<Produto>>

    //Outro exemplo de parâmetro de URL (ex: http://endereco.com.br/endpoint?nome=valorNome)
    @GET("/produto")
    fun pesquisar2(@Query("nome") nome: String): Call<List<Produto>>

    //Outro exemplo de parâmetro de corpo de requisição, normalmente utilizado
    //no envio por requisições de inserção
    @POST("/produto")
    fun inserir(@Body produto: Produto): Call<Produto>

    //Outro exemplo de parâmetro de corpo de requisição, normalmente utilizado
    //no envio por requisições de deleção
    @PUT("/produto")
    fun atualizar(@Body produto: Produto, @Query("id") id: Int): Call<Produto>

    //Requisição de deleção
    @DELETE("/produto")
    fun excluir(@Query("id") id: Int): Call<Produto>
}