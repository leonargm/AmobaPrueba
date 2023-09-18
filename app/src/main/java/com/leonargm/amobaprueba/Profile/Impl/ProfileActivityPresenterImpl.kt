package com.leonargm.amobaprueba.Profile.Impl

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityPresenter
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityView

class ProfileActivityPresenterImpl(var view: ProfileActivityView) : ProfileActivityPresenter {
    var iterator: ProfileActivityIteratorImpl

    override fun onSuccess(documents: MutableList<DocumentSnapshot>) {
        view.onSuccess(documents)
    }

    override fun onFail(errorMessage: String) {
        view.onFail(errorMessage)
    }

    override fun showInfoPeople(firestore: FirebaseFirestore) {
        iterator.showInfoPeople(firestore)
    }

    init {
        iterator = ProfileActivityIteratorImpl(this)
    }
}