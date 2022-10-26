package com.example.charliebookstore.views

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBarDrawerToggle
import android.os.Bundle
import android.view.MenuItem
import com.example.charliebookstore.R
import com.example.charliebookstore.databinding.ActivityTelaInicialBinding
import com.example.charliebookstore.fragments.InicialFragment
import com.example.charliebookstore.fragments.ListaProdutosFragment

class TelaInicial : AppCompatActivity() {
    lateinit var binding: ActivityTelaInicialBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Ativa o menu do canto superior
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Ativa o botão do menu
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.abrir_menu, R.string.fechar_menu)

        //Faz com que o menu abra e feche de acordo com o estado do botão
        binding.drawerLayout.addDrawerListener(toggle)

        //Sincroniza o estado de abertura do botão com o menu
        toggle.syncState()

        //Configura um listener para tratar o clique nas opções do menu
        binding.nv.setNavigationItemSelectedListener {
            //Fecha todos os menus
            binding.drawerLayout.closeDrawers()

            //Trata as opções de menu

            when(it.itemId) {
                //Se clicou no menu com ID "inicial"
                R.id.login -> {
                    //Cria uma nova instância do fragmento de inicial
                    val frag = InicialFragment()
                    //Faz o gestor de fragmentos trocar o fragmento
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }
                R.id.listaProduto -> {
                    //Cria uma nova instância do fragmento de lista
                    val frag = ListaProdutosFragment()
                    //Faz o gestor de fragmentos trocar o fragmento
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }

                R.id.listaGrupo -> {
                    //Cria uma nova instância do fragmento de lista
                    val frag = GruposFragment()
                    //Faz o gestor de fragmentos trocar o fragmento
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }

                R.id.imgCategorias -> {
                    //Cria uma nova instância do fragmento de lista
                    val frag = GruposFragment()
                    //Faz o gestor de fragmentos trocar o fragmento
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }

            }
            true
        }
    }
    //Função chamada quando uma opção de menu é clicada
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Repassa a opçao selecionada para o listener acima
        toggle.onOptionsItemSelected(item)
        return super.onOptionsItemSelected(item)
    }
}