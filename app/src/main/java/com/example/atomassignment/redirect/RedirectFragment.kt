package com.example.atomassignment.redirect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.atomassignment.appComponent
import com.example.atomassignment.databinding.FragmentRedirectBinding

class RedirectFragment : Fragment() {

    private val redirectComponent by lazy {
        appComponent().redirectComponent().create()
    }

    private val viewModel: RedirectViewModel by viewModels {
        redirectComponent.redirectViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentRedirectBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigationEvents.observe(viewLifecycleOwner) { directions ->
            findNavController().navigate(directions)
        }
    }
}