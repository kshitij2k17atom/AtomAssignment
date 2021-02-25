package com.example.atomassignment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import com.example.atomassignment.utils.SingleLiveEvent
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import javax.inject.Provider

class HomeViewModel(
    private val auth: FirebaseAuth
) : ViewModel() {

    private val _navigationEvents = SingleLiveEvent<NavDirections>()
    val navigationEvents: LiveData<NavDirections> get() = _navigationEvents

    fun onLogout() {
        auth.signOut()
        _navigationEvents.postValue(HomeFragmentDirections.logout())
    }

    class Factory @Inject constructor(
        private val firebaseAuth: Provider<FirebaseAuth>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(firebaseAuth.get()) as T
        }
    }
}