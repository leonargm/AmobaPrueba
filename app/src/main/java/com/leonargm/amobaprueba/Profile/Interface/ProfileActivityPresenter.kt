package com.leonargm.amobaprueba.Profile.Interface

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

interface ProfileActivityPresenter {
    fun onSuccess(documents: MutableList<DocumentSnapshot>)
    fun onFail(errorMessage: String)
    fun showInfoPeople(firestore: FirebaseFirestore)
}