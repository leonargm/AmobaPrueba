package com.leonargm.amobaprueba.Login.Interface

import com.google.firebase.auth.FirebaseAuth

interface LoginActivityIterator {
    fun doLogin(email: String, pass: String, firebase: FirebaseAuth)
}