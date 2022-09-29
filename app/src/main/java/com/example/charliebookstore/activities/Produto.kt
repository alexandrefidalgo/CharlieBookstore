package com.example.charliebookstore.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.charliebookstore.R

class Produto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        val bt_decricao = findViewById<Button>(R.id.bt_decricao)

        bt_decricao.setOnClickListener {
            val intent = Intent(this, TelaDescricaoProduto::class.java)
            startActivity(intent)
        }
    }
}