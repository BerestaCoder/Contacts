package com.example.contacts.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 2)
abstract class ContactsDatabase : RoomDatabase(){
    abstract fun contactDAO(): ContactDAO
}