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

    override fun onSuccess(data: Map<String, Any>?) {
        view.onSuccess(data)
    }

    init {
        iterator = PeopleActivityIteratorImpl(this)
    }
}