package com.leonargm.amobaprueba.Profile.Impl

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityIterator
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityPresenter
import com.leonargm.amobaprueba.R

class ProfileActivityIteratorImpl(presenter: ProfileActivityPresenterImpl) : ProfileActivityIterator {
    var presenter: ProfileActivityPresenter
    init {
        this.presenter = presenter
    }
}