package com.example.equabase

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class UserLiveDataFB: LiveData<FirebaseUser?>() {
    private val firebaseAuth = FirebaseAuth.getInstance()

    private val authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth -> value = firebaseAuth.currentUser }

    override fun onActive() {
        //Log.d("MainTest", "LiveData активовано")
        value = firebaseAuth.currentUser //зроблено для того що б LoginVM встиг роздуплитися ще до моменту коли функція onViewCreated в MAIN дійде кінця
        firebaseAuth.addAuthStateListener { authStateListener }
    }

    override fun onInactive() {
        firebaseAuth.removeAuthStateListener { authStateListener }
    }
}