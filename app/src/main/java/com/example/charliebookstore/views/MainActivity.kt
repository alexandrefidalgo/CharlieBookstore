package com.example.charliebookstore.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.charliebookstore.R
import com.example.charliebookstore.databinding.ActivityMainBinding

//Atividade que lista os produtos
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    //Chamado quando a atividade é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Carrega o fragmento principal
        val fragment = ListaProdutosFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    //PARA PERMITIR O BOTÃO UP DE VOLTAR UM FRAGMENTO
    fun mostrarUp() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun esconderUp() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.getBackStackEntryCount() > 1) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            super.onBackPressed()
        }
    }
}