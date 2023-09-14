package com.leonargm.amobaprueba.People.Impl

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.leonargm.amobaprueba.People.Interface.PeopleActivityIterator
import com.leonargm.amobaprueba.People.Interface.PeopleActivityPresenter
import com.leonargm.amobaprueba.R
import com.leonargm.amobaprueba.Utils.Constants

class PeopleActivityIteratorImpl(presenter: PeopleActivityPresenterImpl) : PeopleActivityIterator {
    var presenter: PeopleActivityPresenter
    private lateinit var firebaseAuth: FirebaseAuth
    override fun showPeople(data: Map<String, Any>?) {
        this.presenter.onSuccess(data)
    }
    override fun doLogout(context: Context, firebase: FirebaseAuth) {
        var context: Context
        context = Constants.context
        firebaseAuth = firebase
        firebaseAuth.signOut();
        this.presenter.onSuccessLogout(context.getResources().getString(R.string.text_error_fail))
    }
    init {
        this.presenter = presenter
    }
}