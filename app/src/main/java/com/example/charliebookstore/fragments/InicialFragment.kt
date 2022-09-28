package com.example.charliebookstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charliebookstore.databinding.FragmentInicialBinding

class InicialFragment : Fragment() {

    lateinit var binding: FragmentInicialBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentInicialBinding.inflate(inflater)

        return binding.root
    }

}