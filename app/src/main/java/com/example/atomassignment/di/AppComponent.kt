package com.example.atomassignment.di

import com.example.atomassignment.home.HomeComponent
import com.example.atomassignment.home.HomeModule
import com.example.atomassignment.login.LoginComponent
import com.example.atomassignment.login.LoginModule
import com.example.atomassignment.redirect.RedirectComponent
import com.example.atomassignment.redirect.RedirectModule
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        FirebaseModule::class,
        LoginModule::class,
        RedirectModule::class,
        HomeModule::class
    ],
)
@Singleton
interface AppComponent {
    fun loginComponent(): LoginComponent.Factory
    fun redirectComponent(): RedirectComponent.Factory
    fun homeComponent(): HomeComponent.Factory
}