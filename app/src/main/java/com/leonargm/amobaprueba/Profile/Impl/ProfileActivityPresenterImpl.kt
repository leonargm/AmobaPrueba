package com.leonargm.amobaprueba.Profile.Impl

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityPresenter
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityView

class ProfileActivityPresenterImpl(var view: ProfileActivityView) : ProfileActivityPresenter {
    var iterator: ProfileActivityIteratorImpl

    override fun onSuccess(result: String) {
        view.onSuccess(result)
    }

    init {
        iterator = ProfileActivityIteratorImpl(this)
    }
}