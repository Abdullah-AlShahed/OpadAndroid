package com.example.opad.contacts

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.opad.databinding.ActivityContactsMainBinding

class ContactsMainActivity : AppCompatActivity() {
    lateinit var bind: ActivityContactsMainBinding
    lateinit var adapter: ContactsRecyclerAdapter
    lateinit var contactList: MutableList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityContactsMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        contactList = mutableListOf()
        adapter = ContactsRecyclerAdapter(contactList)
        bind.contactsRv.adapter = adapter

        bind.addContactCI.setOnClickListener() {
            val intent = Intent(this, AddContactActivity::class.java)
            addContactLauncher.launch(intent)
        }


    }

    private val addContactLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val newContact = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                data?.getParcelableExtra("contact", Contact::class.java)
            } else {
                data?.getParcelableExtra<Contact>("contact")
            }
            if (newContact != null) {
                Log.d("ContactsMainActivity", "Received new contact: $newContact")
                contactList.add(newContact)
                adapter.notifyDataSetChanged()
            }
        }
    }

}










