package com.example.contacts.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.Contact

class ContactAdapter(private val contactList: MutableList<Contact>) : RecyclerView.Adapter<ContactAdapter.ViewHolder>()  {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val phoneTextView: TextView
        init {
            nameTextView = view.findViewById(R.id.name_text_view)
            phoneTextView = view.findViewById(R.id.phone_text_view)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.contact, viewGroup, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.nameTextView.text = contactList[position].name
        viewHolder.phoneTextView.text = contactList[position].phone
    }

    override fun getItemCount() = contactList.size
}