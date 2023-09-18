package com.leonargm.amobaprueba.People.Impl

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.leonargm.amobaprueba.People.Interface.PeopleActivityPresenter
import com.leonargm.amobaprueba.People.Interface.PeopleActivityView

class PeopleActivityPresenterImpl(var view: PeopleActivityView) : PeopleActivityPresenter {
    var iterator: PeopleActivityIteratorImpl
    
    override fun showPeople(firestore: FirebaseFirestore) {
        iterator.showPeople(firestore)
    }

    override fun doLogout(context: Context, firebase: FirebaseAuth) {
        iterator.doLogout(context, firebase)
    }

    override fun onSuccess(documents: MutableList<DocumentSnapshot>) {
        view.onSuccess(documents)
    }

    override fun onFail(errorMessage: String) {
        view.onFail(errorMessage)
    }

    override fun onSuccessLogout(result: String) {
        view.onSuccessLogout(result)
    }

    init {
        iterator = PeopleActivityIteratorImpl(this)
    }
}