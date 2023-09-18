package com.leonargm.amobaprueba.Profile.Impl

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityIterator
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityPresenter
import com.leonargm.amobaprueba.R
import com.leonargm.amobaprueba.Utils.Constants

class ProfileActivityIteratorImpl(presenter: ProfileActivityPresenterImpl) : ProfileActivityIterator {
    var presenter: ProfileActivityPresenter

    override fun showInfoPeople(firestore: FirebaseFirestore) {

        var context: Context
        context = Constants.context
        firestore.collection("Personas")
            .get()
            .addOnSuccessListener {
                this.presenter.onSuccess(it.documents)
            }
            .addOnFailureListener{
                it.printStackTrace()
                var error: String = context.getResources().getString(R.string.text_firebase_fail)
                presenter.onFail(error)
            }
    }

    init {
        this.presenter = presenter
    }
}