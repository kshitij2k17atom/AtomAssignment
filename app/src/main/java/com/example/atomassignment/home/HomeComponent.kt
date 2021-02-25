package com.example.atomassignment.home

import dagger.Subcomponent

@Subcomponent
interface HomeComponent {
    fun homeViewModelFactory(): HomeViewModel.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }
}

