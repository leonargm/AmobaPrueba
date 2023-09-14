package com.leonargm.amobaprueba.Login.Impl

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.leonargm.amobaprueba.Login.Interface.LoginActivityIterator
import com.leonargm.amobaprueba.Login.Interface.LoginActivityPresenter
import com.leonargm.amobaprueba.R
import com.leonargm.amobaprueba.Utils.Constants

class LoginActivityIteratorImpl(presenter: LoginActivityPresenterImpl) : LoginActivityIterator {
    var presenter: LoginActivityPresenter
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var constants :Constants

    override fun doLogin(email: String, pass: String, firebase: FirebaseAuth) {
        firebaseAuth = firebase
        var error: String
        var context: Context
        context = Constants.context
        if (email.isNotEmpty() && pass.isNotEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                if (it.isSuccessful) {
                    presenter.onSuccess("")
                } else {
                    error = context.getResources().getString(R.string.text_error_fail)
                    presenter.onFail(error)
                }
            }
        } else {
            error = context.getResources().getString(R.string.text_error_null)
            presenter.onFail(error)
        }
    }
    init {
        this.presenter = presenter
    }
}