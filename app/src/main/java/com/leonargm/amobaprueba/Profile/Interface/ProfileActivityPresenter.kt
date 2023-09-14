package com.leonargm.amobaprueba.Profile.Interface

import android.content.Context
import com.google.firebase.auth.FirebaseAuth

interface ProfileActivityPresenter {
    fun doLogout(context: Context, firebase: FirebaseAuth)
    fun onSuccess(result: String)
}