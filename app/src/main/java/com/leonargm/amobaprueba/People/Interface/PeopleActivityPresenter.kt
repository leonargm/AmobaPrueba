package com.leonargm.amobaprueba.People.Interface

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

interface PeopleActivityPresenter {
    fun onSuccess(documents: MutableList<DocumentSnapshot>)
    fun onFail(errorMessage: String)
    fun onSuccessLogout(result: String)
    fun showPeople(firestore: FirebaseFirestore)
    fun doLogout(context: Context, firebase: FirebaseAuth)
}