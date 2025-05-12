package com.example.equabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class LoginVM: ViewModel() {
    enum class AuthenticationState {
        AUTHENTICATED, UNAUTHENTICATED, INVALID_AUTHENTICATION
    }

    private val userLiveData = UserLiveDataFB()

    val authenticatedState = userLiveData.map { user ->
        if (user != null) {
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
        }
    }
}