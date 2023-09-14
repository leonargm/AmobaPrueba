package com.leonargm.amobaprueba.Login.Interface

interface LoginActivityView {
    fun onSuccess(result: String)
    fun onFail(errorMessage: String)
}