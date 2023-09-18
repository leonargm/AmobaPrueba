package com.leonargm.amobaprueba.People.Impl

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.leonargm.amobaprueba.People.Interface.PeopleActivityIterator
import com.leonargm.amobaprueba.People.Interface.PeopleActivityPresenter
import com.leonargm.amobaprueba.R
import com.leonargm.amobaprueba.Utils.Constants

class PeopleActivityIteratorImpl(presenter: PeopleActivityPresenterImpl) : PeopleActivityIterator {
    var presenter: PeopleActivityPresenter
    private lateinit var firebaseAuth: FirebaseAuth

    override fun showPeople(firestore: FirebaseFirestore) {

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

    override fun doLogout(context: Context, firebase: FirebaseAuth) {
        var context: Context
        context = Constants.context
        firebaseAuth = firebase
        firebaseAuth.signOut();
        this.presenter.onSuccessLogout(context.getResources().getString(R.string.text_logout))
    }

    init {
        this.presenter = presenter
    }
}