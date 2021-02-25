package com.example.atomassignment.redirect

import dagger.Subcomponent

@Subcomponent
interface RedirectComponent {
    fun redirectViewModelFactory(): RedirectViewModel.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(): RedirectComponent
    }
}