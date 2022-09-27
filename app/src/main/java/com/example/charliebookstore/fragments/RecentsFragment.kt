package com.example.charliebookstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charliebookstore.fragments.RecentsFragment
import com.example.charliebookstore.databinding.FragmentRecentsBinding

class RecentsFragment : Fragment() {

    lateinit var binding: FragmentRecentsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecentsBinding.inflate(inflater)

        return binding.root
    }

}