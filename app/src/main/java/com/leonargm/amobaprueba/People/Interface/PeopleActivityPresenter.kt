package com.leonargm.amobaprueba.People.Interface

import android.content.Context
import com.google.firebase.auth.FirebaseAuth

interface PeopleActivityPresenter {
    fun onSuccess(data: Map<String, Any>?)
    fun onSuccessLogout(result: String)
    fun showPeople(data: Map<String, Any>?)
    fun doLogout(context: Context, firebase: FirebaseAuth)
}