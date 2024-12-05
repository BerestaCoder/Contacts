package com.example.contacts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.contacts.R
import com.example.contacts.data.Contact
import com.example.contacts.data.ContactDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            // База данных
            val db = Room.databaseBuilder(
                applicationContext,
                ContactDatabase::class.java, "contacts-database"
            ).build()
            val contactDao = db.contactDao()
            contactDao.insertAll(Contact(name="Иван", phone = "+79999999999", email = "example@mail.com"))
            val contacts: List<Contact> = contactDao.getAll()


            val contactAdapter = ContactAdapter(contacts.toMutableList())
            val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = contactAdapter
        }
    }
}