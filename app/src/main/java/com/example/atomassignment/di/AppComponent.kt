package com.example.atomassignment.di

import com.example.atomassignment.login.LoginComponent
import com.example.atomassignment.login.LoginModule
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        FirebaseModule::class,
        LoginModule::class,
    ],
)
@Singleton
interface AppComponent {
    fun loginComponent(): LoginComponent.Factory
}