package com.cletus.personapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isaac.personapp.data.Contact
import com.isaac.personapp.data.ContactDatabase


class ContactViewModel : ViewModel() {

    val contactLiveData = MutableLiveData<List<Contact>>()

    fun getContacts(database: ContactDatabase) {
        contactLiveData.postValue(database.contactDao().getAllContacts())
    }

    fun addContact(database: ContactDatabase, contact: Contact) {
        database.contactDao().addContact(contact)
        getContacts(database)}}