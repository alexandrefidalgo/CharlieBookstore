package com.example.charliebookstore.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.charliebookstore.R
import com.example.charliebookstore.activities.TelaDescricaoProduto
import com.example.charliebookstore.activities.TelaInicial
import com.example.charliebookstore.databinding.FragmentGruposBinding
import com.example.charliebookstore.databinding.FragmentListaProdutosBinding



class GruposFragment : Fragment() {

    lateinit var binding: FragmentGruposBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGruposBinding.inflate(inflater)

        binding.btListaFragment.setOnClickListener {
            //val intent = Intent(context, ListaProdutosFragment::class.java)
             //startActivity(intent)

            val frag = ListaProdutosFragment()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, frag)?.commit()
          }

        return binding.root
    }

}