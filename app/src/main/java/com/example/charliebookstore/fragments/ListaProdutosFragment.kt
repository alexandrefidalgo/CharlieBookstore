package com.example.charliebookstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charliebookstore.R
import com.example.charliebookstore.databinding.FragmentListaProdutosBinding

class ListaProdutosFragment : Fragment() {

    lateinit var binding: FragmentListaProdutosBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListaProdutosBinding.inflate(inflater)

        return binding.root
    }
}