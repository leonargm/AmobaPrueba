package com.leonargm.amobaprueba.People.Interface

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

interface PeopleActivityIterator {
    fun showPeople(firestore: FirebaseFirestore)
    fun doLogout(context: Context, firebase: FirebaseAuth)
}