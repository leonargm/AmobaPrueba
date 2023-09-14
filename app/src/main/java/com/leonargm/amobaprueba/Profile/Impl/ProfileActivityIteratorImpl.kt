package com.leonargm.amobaprueba.Profile.Impl

import android.content.Context
import android.content.res.Resources
import com.google.firebase.auth.FirebaseAuth
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityIterator
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityPresenter
import com.leonargm.amobaprueba.R

class ProfileActivityIteratorImpl(presenter: ProfileActivityPresenterImpl) : ProfileActivityIterator {
    var presenter: ProfileActivityPresenter
    private lateinit var firebaseAuth: FirebaseAuth
    override fun doLogout(context: Context, firebase: FirebaseAuth) {
        firebaseAuth = firebase
        firebaseAuth.signOut();
        this.presenter.onSuccess(context.getResources().getString(R.string.text_logout))
    }
    init {
        this.presenter = presenter
    }
}