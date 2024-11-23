package com.example.contacts.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room

interface ContactsRepository {
    fun getContacts(): LiveData<List<Contact>>
    suspend fun insert(word: Contact): Long
    suspend fun update(word: Contact)
    suspend fun delete(word: Contact)
    suspend fun deleteAll()

    class Base(context: Context) : ContactsRepository {
        /*private val room = Room.databaseBuilder(
            context,
            ContactsDatabase::class.java,
            DATABASE_NAME
        ).build()*/

        private val room = Room.databaseBuilder(context, ContactsDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .createFromAsset("database/test.db")
            .build()

        private val dao = room.contactDAO()
        override fun getContacts() = dao.getAllContacts()
        override suspend fun insert(contact: Contact) = dao.insertContact(contact)
        override suspend fun update(contact: Contact) = dao.updateContact(contact)
        override suspend fun delete(contact: Contact) = dao.deleteContact(contact)
        override suspend fun deleteAll() = dao.deleteAll()

        companion object {
            private const val DATABASE_NAME = "test"
        }
    }
}