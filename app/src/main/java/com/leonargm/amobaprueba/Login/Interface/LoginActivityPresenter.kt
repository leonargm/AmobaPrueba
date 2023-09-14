package com.leonargm.amobaprueba.Login.Interface

import com.google.firebase.auth.FirebaseAuth

interface LoginActivityPresenter {
    fun doLogin(email: String, pass: String, firebase: FirebaseAuth)
    fun onSuccess(result: String)
    fun onFail(errorMessage: String)
}