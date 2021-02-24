package com.example.atomassignment.di

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object FirebaseModule {
    @Provides
    @Singleton
    fun firebase(): FirebaseApp {
        return FirebaseApp.getInstance()
    }

    @Provides
    @Singleton
    fun firebaseAuth(app: FirebaseApp): FirebaseAuth {
        return FirebaseAuth.getInstance(app)
    }
}