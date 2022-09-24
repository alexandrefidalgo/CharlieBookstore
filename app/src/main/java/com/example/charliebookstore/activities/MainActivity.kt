package com.example.charliebookstore.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.charliebookstore.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun startActivityCadastrar(view: View?) {
        val ActivityCadastrar = Intent(this, ActivityCadastrar::class.java)
        startActivity(ActivityCadastrar)
    }

}