package com.example.atomassignment.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.atomassignment.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRegistrationBinding.inflate(inflater, container, false)

        binding.nameField.addTextChangedListener { text ->
            binding.continueButton.isEnabled = !text.isNullOrBlank()
        }

        binding.continueButton.setOnClickListener {
            findNavController().navigate(
                RegistrationFragmentDirections.goToHome(
                    binding.nameField.text?.toString() ?: "Unknown"
                )
            )
        }

        return binding.root
    }
}