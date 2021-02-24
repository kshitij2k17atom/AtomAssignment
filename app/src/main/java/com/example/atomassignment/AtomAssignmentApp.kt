package com.example.atomassignment

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.atomassignment.di.AppComponent
import com.example.atomassignment.di.DaggerAppComponent

class AtomAssignmentApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

fun Context.appComponent(): AppComponent {
    return (applicationContext as AtomAssignmentApp).appComponent
}

fun Fragment.appComponent(): AppComponent {
    return requireContext().appComponent()
}