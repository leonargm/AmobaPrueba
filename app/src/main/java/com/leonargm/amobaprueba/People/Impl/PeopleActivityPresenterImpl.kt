package com.leonargm.amobaprueba.People.Impl

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.leonargm.amobaprueba.People.Interface.PeopleActivityPresenter
import com.leonargm.amobaprueba.People.Interface.PeopleActivityView

class PeopleActivityPresenterImpl(var view: PeopleActivityView) : PeopleActivityPresenter {
    var iterator: PeopleActivityIteratorImpl
    override fun showPeople(data: Map<String, Any>?) {
        iterator.showPeople(data)
    }

    override fun doLogout(context: Context, firebase: FirebaseAuth) {
        iterator.doLogout(context, firebase)
    }

    override fun onSuccess(data: Map<String, Any>?) {
        view.onSuccess(data)
    }

    override fun onSuccessLogout(result: String) {
        view.onSuccessLogout(result)
    }

    init {
        iterator = PeopleActivityIteratorImpl(this)
    }
}