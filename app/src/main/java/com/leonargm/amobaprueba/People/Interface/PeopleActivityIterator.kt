package com.leonargm.amobaprueba.People.Interface

import android.content.Context
import com.google.firebase.auth.FirebaseAuth

interface PeopleActivityIterator {
    fun showPeople(data: Map<String, Any>?)
}