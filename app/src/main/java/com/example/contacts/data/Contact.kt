package com.example.contacts.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_data_table")
class Contact (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact_id")
    var id: Int,

    @ColumnInfo(name = "contact_image")
    val image: String,

    @ColumnInfo(name = "contact_name")
    val name: String,

    @ColumnInfo(name = "contact_number")
    val phoneNumber: String,

    @ColumnInfo(name = "contact_email")
    val email: String
)
