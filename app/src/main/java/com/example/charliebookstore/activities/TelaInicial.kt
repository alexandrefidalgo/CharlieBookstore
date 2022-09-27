package com.example.charliebookstore.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBarDrawerToggle
import android.os.Bundle
import android.view.MenuItem
import com.example.charliebookstore.R
import com.example.charliebookstore.databinding.ActivityTelaInicialBinding
import com.example.charliebookstore.fragments.RecentsFragment

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
                //Se licou no menu com ID "recentes"
                R.id.recentes -> {
                    //Cria uma nova instância do fragmento de artistas
                    val frag = RecentsFragment()
                    //Faz o gestor de fragmentos trocar o fragmento atualmente em exibição
                    //pelo fragmento de artistas
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