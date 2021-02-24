package com.example.atomassignment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.component1
import androidx.activity.result.component2
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.atomassignment.R
import com.example.atomassignment.appComponent
import com.example.atomassignment.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private val loginComponent: LoginComponent by lazy {
        appComponent()
            .loginComponent()
            .create()
    }

    private val viewModel: LoginViewModel by viewModels {
        loginComponent.loginViewModelFactory()
    }

    private val signInLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        val (_, intent) = result
        if (intent != null) {
            viewModel.onLoginWithGoogleResponse(intent)
        }
    }

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginWithGoogle.setOnClickListener {
            viewModel.onLoginWithGoogleRequested(
                requireContext(),
                signInLauncher,
            )
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loginState.observe(viewLifecycleOwner) { state ->
            when (state) {
                AuthState.Unauthenticated -> {
                    Snackbar.make(
                        binding.root,
                        R.string.snackbarMessageLoginFailed,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                else -> Unit
            }
        }

        viewModel.navigationEvents.observe(viewLifecycleOwner) { navAction ->
            findNavController().navigate(navAction)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}