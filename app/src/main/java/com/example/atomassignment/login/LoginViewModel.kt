package com.example.atomassignment.login

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.example.atomassignment.R
import com.example.atomassignment.utils.SingleLiveEvent
import com.example.atomassignment.utils.await
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

private const val Tag = "LoginViewModel"

class LoginViewModel(
    private val auth: FirebaseAuth,
) : ViewModel() {

    private val _loginState = MutableLiveData(AuthState.Unknown)
    val loginState: LiveData<AuthState> get() = _loginState

    private val _navigationEvents = SingleLiveEvent<NavDirections>()
    val navigationEvents: LiveData<NavDirections> get() = _navigationEvents

    fun onLoginWithGoogleRequested(
        context: Context,
        signInLauncher: ActivityResultLauncher<Intent>
    ) {
        val signInOptions = GoogleSignInOptions.Builder()
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .requestProfile()
            .build()
        val signInClient = GoogleSignIn.getClient(context, signInOptions)
        signInLauncher.launch(signInClient.signInIntent)
    }

    fun onLoginWithGoogleResponse(
        signInResultIntent: Intent,
    ) = viewModelScope.launch {
        try {
            val account = GoogleSignIn
                .getSignedInAccountFromIntent(signInResultIntent)
                .await()
            val authCredentials = GoogleAuthProvider.getCredential(account.idToken, null)
            auth.signInWithCredential(authCredentials).await()
            _loginState.postValue(AuthState.Authenticated)
        } catch (ex: Exception) {
            Log.e(Tag, "Failed to sign-in with Google", ex)
            _loginState.postValue(AuthState.Unauthenticated)
        }
    }

    class Factory @Inject constructor(
        private val firebaseAuth: Provider<FirebaseAuth>
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LoginViewModel(firebaseAuth.get()) as T
        }
    }
}