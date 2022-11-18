package com.example.charliebookstore.views.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.charliebookstore.R
import com.example.charliebookstore.databinding.FragmentListaProdutosBinding
import com.example.charliebookstore.databinding.ItemListaProdutoBinding
import com.example.charliebookstore.model.Produto
import com.example.charliebookstore.service.API
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//O parâmetro indica o id do produto a exibir
class ListaProdutosFragment() : Fragment() {
    //binding do fragmento
    lateinit var binding: FragmentListaProdutosBinding

    //Executado quando o fragmento for criado
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaProdutosBinding.inflate(inflater)

        //Chama a função para customizar o visual da atividade
        alterarVisual()
        //Chama a função para obter o produto e mostrar na tela
        obterDadosDoProduto()

        //Volta o layout inflado pelo binding
        return binding.root
    }

    //Executado quando o fragmento for aberto novamente
    override fun onResume() {
        super.onResume()
    }

    //Customiza o visual da atividade e habilita o pressionamento do botão up
    fun alterarVisual() {
        activity?.title = "Lista de Produtos"
        setHasOptionsMenu(true)
    }

    //Obtpem dados do produto indicado
    fun obterDadosDoProduto() {

        //Callback acionado quando a execução da API concluir
        val callback = object : Callback<List<Produto>> {

            //Chamada quando o endpoint responder
            override fun onResponse(call: Call<List<Produto>>, response: Response<List<Produto>>) {

                //Verifica se a resposta teve sucesso
                if (response.isSuccessful) {
                    //Obtém os dados do produto em formato de modelo
                    val produtos = response.body()
                    //Chama a função para atualizar a tela
                    atualizarUI(produtos)
                } else {
                    //Mostra uma mensagem de falha de carregamento para o usuário
                    Snackbar.make(
                        binding.root, "Não é possível obter dados de produto",
                        Snackbar.LENGTH_LONG
                    ).show()

                    //Registra possíveis erros no console
                    Log.e("ERROR", response.errorBody().toString())
                }
            }

            //Chamada caso aconteça algum problema e não seja possível bater no endpoint
            //Ou a resposta seja incompatível
            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {

                //Mostra uma mensagem de falha de carregamento para o usuário
                Snackbar.make(
                    binding.root, "Não foi possível se conectar ao servidor",
                    Snackbar.LENGTH_LONG
                ).show()

                //Registra possíveis erros no console
                Log.e("ERROR", "Falha ao executar serviço", t)
            }
        }

        //Faz a chamada a API para obter um produto
        API().produto.listar().enqueue(callback)
    }


    //Utilizado para atualizar a tela quando a resposta voltar
    fun atualizarUI(produtos: List<Produto>?) {

        //Atualiza a tela com os dados do produto
        produtos?.forEach {
            val cardBinding = ItemListaProdutoBinding.inflate(layoutInflater)

            cardBinding.textTitulo.text = it.nome

            //Solicita o carregamento da imagem
            Picasso.get().load(
                it.urlImagem
            ).into(cardBinding.imagem)


            cardBinding.root.setOnClickListener { cardView ->
                val descProdFrag = DescricaoFragment(it.id)
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, descProdFrag)?.addToBackStack("Detalhe")?.commit()
            }

            binding.container.addView(cardBinding.root)
        }

    }
}