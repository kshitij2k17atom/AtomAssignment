package com.example.atomassignment.login

import dagger.Subcomponent

@Subcomponent
interface LoginComponent {
    fun loginViewModelFactory(): LoginViewModel.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }
}