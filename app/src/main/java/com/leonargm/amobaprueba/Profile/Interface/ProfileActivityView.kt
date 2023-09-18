package com.leonargm.amobaprueba.Profile.Interface

import com.google.firebase.firestore.DocumentSnapshot

interface ProfileActivityView {
    fun onSuccess(documents: MutableList<DocumentSnapshot>)
    fun onFail(errorMessage: String)
}