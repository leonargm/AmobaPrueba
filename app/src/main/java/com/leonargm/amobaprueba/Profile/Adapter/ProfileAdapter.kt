package com.leonargm.amobaprueba.Profile.Adapter

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import com.google.firebase.firestore.DocumentSnapshot
import com.leonargm.amobaprueba.databinding.ActivityPeopleBinding

class ProfileAdapter (var mCtx: Context) {
    fun ProfileAdapter(binding: ActivityPeopleBinding, documents: MutableList<DocumentSnapshot>) {
        val people: ArrayList<String> = ArrayList()
        for (name in documents) {
            people.add(name.data?.get("nombre").toString())
        }
        val arrayAdapter = ArrayAdapter(mCtx, R.layout.simple_spinner_item, people)
    }
}