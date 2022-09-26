package com.example.charliebookstore.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.charliebookstore.R

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
    }
    fun startFormCadastrar(view: View?) {
        val FormCadastrar = Intent(this, FormCadastrar::class.java)
        startActivity(FormCadastrar)
    }
    fun startFormRecuperarSenha(view: View?) {
        val FormRecuperarSenha = Intent(this, FormRecuperarSenha()::class.java)
        startActivity(FormRecuperarSenha)
    }
    fun startPoliticasPrivacidade(view: View?) {
        val PoliticasPrivacidade = Intent(this, PoliticasPrivacidade()::class.java)
        startActivity(PoliticasPrivacidade)
    }

}