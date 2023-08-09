package com.example.opad.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.opad.R

class ContactsMainActivity : AppCompatActivity() {

    lateinit var contactrv:RecyclerView
    lateinit var adapter: ContactsRecyclerAdapter
    var contactList:MutableList<Contact>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_main)
    }



}