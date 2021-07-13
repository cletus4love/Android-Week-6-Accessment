package com.cletus.personapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Contact(
    @PrimaryKey( autoGenerate = true)
    val id: Int = 0,
    val name : String ,
    val surname : String,
    val phonenumber: Int
) {
}