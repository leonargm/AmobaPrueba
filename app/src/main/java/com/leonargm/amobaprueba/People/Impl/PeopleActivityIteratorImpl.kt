package com.leonargm.amobaprueba.People.Impl

import android.content.Context
import android.content.res.Resources
import com.google.firebase.auth.FirebaseAuth
import com.leonargm.amobaprueba.People.Interface.PeopleActivityIterator
import com.leonargm.amobaprueba.People.Interface.PeopleActivityPresenter
import com.leonargm.amobaprueba.R

class PeopleActivityIteratorImpl(presenter: PeopleActivityPresenterImpl) : PeopleActivityIterator {
    var presenter: PeopleActivityPresenter
    override fun showPeople(data: Map<String, Any>?) {
        this.presenter.onSuccess(data)
    }
    init {
        this.presenter = presenter
    }
}