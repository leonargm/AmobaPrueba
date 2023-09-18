package com.leonargm.amobaprueba.Profile.Interface

import com.google.firebase.firestore.FirebaseFirestore

interface ProfileActivityIterator {
    fun showInfoPeople(firestore: FirebaseFirestore)
}