package com.example.contacts.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM contact WHERE id IN (:contactsIds)")
    fun loadAllByIds(contactsIds: IntArray): List<Contact>

    @Insert
    fun insertAll(vararg contacts: Contact)

    @Delete
    fun delete(contact: Contact)
}