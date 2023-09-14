package com.leonargm.amobaprueba.Login.Impl

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.leonargm.amobaprueba.Login.Interface.LoginActivityView
import com.leonargm.amobaprueba.Login.Interface.LoginActivityPresenter

class LoginActivityPresenterImpl(var view: LoginActivityView) : LoginActivityPresenter {
    var iterator: LoginActivityIteratorImpl
    override fun doLogin(email: String, pass: String, firebase: FirebaseAuth) {
        iterator.doLogin(email, pass, firebase)
    }

    override fun onSuccess(result: String) {
        view.onSuccess(result)
    }

    override fun onFail(errorMessage: String) {
        view.onFail(errorMessage)
    }

    init {
        iterator = LoginActivityIteratorImpl(this)
    }
}