package com.leonargm.amobaprueba.Profile.Interface

import android.content.Context
import com.google.firebase.auth.FirebaseAuth

interface ProfileActivityPresenter {
    fun onSuccess(result: String)
}