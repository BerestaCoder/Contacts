package com.example.contacts.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {
    @Insert
    suspend fun insertContact(word: Contact): Long

    @Update
    suspend fun updateContact(word: Contact)

    @Delete
    suspend fun deleteContact(word: Contact)

    @Query("DELETE FROM contacts_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM contacts_data_table")
    fun getAllContacts(): LiveData<List<Contact>>
}