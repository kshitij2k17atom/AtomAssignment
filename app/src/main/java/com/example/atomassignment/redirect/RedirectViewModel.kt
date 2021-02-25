package com.example.atomassignment.redirect

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.atomassignment.utils.SingleLiveEvent
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class RedirectViewModel(
    private val auth: FirebaseAuth
) : ViewModel() {

    private val _navigationEvents = SingleLiveEvent<NavDirections>()
    val navigationEvents: LiveData<NavDirections> get() = _navigationEvents

    init {
        viewModelScope.launch {
            auth.currentUser?.let { user ->
                val name = user.displayName ?: "Unknown"
                _navigationEvents.postValue(RedirectFragmentDirections.goToHome(name))
            } ?: run {
                _navigationEvents.postValue(RedirectFragmentDirections.goToLogin())
            }
        }
    }

    class Factory @Inject constructor(
        private val firebaseAuth: Provider<FirebaseAuth>
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RedirectViewModel(firebaseAuth.get()) as T
        }
    }
}