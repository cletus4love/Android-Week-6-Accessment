package com.cletus.personapp.data

import androidx.room.*


@Dao
interface ContactDao {

    @Insert
    fun addContact( contact: Contact)

    @Delete
    fun deleteContact( contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Query("SELECT * FROM contact ")
    fun getAllContacts() : List<Contact>

    @Query("SELECT * FROM contact WHERE id = :id")
    fun getContactId(id: Int): Contact
}

