package com.leonargm.amobaprueba.People.Interface

interface PeopleActivityPresenter {
    fun onSuccess(data: Map<String, Any>?)
    fun showPeople(data: Map<String, Any>?)
}