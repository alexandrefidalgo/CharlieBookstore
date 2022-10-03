package com.example.charliebookstore.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charliebookstore.R
import com.example.charliebookstore.activities.FormLogin
import com.example.charliebookstore.databinding.FragmentInicialBinding

class InicialFragment : Fragment() {

    lateinit var binding: FragmentInicialBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentInicialBinding.inflate(inflater)


        //binding.btLogin.setOnClickListener {
        //    val intent = Intent(context, FormLogin::class.java)
        //    startActivity(intent)
        //}

        //binding.btGrupo.setOnClickListener {
        //    //val intent = Intent(context, ListaProdutosFragment::class.java)
            //startActivity(intent)

        //    val frag = GruposFragment()
        //    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, frag)?.commit()
        //}

        return binding.root
    }

}