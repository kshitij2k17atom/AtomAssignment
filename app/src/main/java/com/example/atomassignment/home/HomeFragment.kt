package com.example.atomassignment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.atomassignment.R
import com.example.atomassignment.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val args: HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.displayName.text = getString(R.string.loginDisplayNameMessage, args.name)
        return binding.root
    }
}