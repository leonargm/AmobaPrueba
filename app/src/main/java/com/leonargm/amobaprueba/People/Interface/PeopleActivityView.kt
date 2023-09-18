package com.leonargm.amobaprueba.People.Interface

import com.google.firebase.firestore.DocumentSnapshot

interface PeopleActivityView {
    fun onSuccess(documents: MutableList<DocumentSnapshot>)
    fun onFail(errorMessage: String)
    fun onSuccessLogout(result: String)
}