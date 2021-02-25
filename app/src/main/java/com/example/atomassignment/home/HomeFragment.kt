package com.example.atomassignment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.atomassignment.R
import com.example.atomassignment.appComponent
import com.example.atomassignment.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val homeComponent: HomeComponent by lazy {
        appComponent().homeComponent().create()
    }

    private val viewModel: HomeViewModel by viewModels {
        homeComponent.homeViewModelFactory()
    }

    private val args: HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.displayName.text = getString(R.string.loginDisplayNameMessage, args.name)

        binding.logout.setOnClickListener {
            viewModel.onLogout()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigationEvents.observe(viewLifecycleOwner) { directions ->
            findNavController().navigate(directions)
        }
    }
}