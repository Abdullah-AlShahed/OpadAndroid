package com.example.opad.contacts

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.opad.R
import com.example.opad.databinding.ActivityAddContactBinding

class AddContactActivity : AppCompatActivity() {
    lateinit var bind: ActivityAddContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.saveContactBtn.setOnClickListener() {
            if (bind.enterContactNameEt.text.isEmpty()) {
                bind.enterContactNameEt.error = "Please enter a name"
                return@setOnClickListener
            }
            if (bind.enterContactNumberEt.text.isEmpty()) {
                bind.enterContactNumberEt.error = "Please enter a number"
                return@setOnClickListener
            }
            if (bind.enterContactNameEt.text.length < 3 || bind.enterContactNameEt.text.length > 30) {
                bind.enterContactNameEt.error = "Name Must be between 3 and 30 characters"
                return@setOnClickListener
            }
            if (bind.enterContactNumberEt.text.length != 11) {
                bind.enterContactNumberEt.error = "Number Must be 11 Digit"
                return@setOnClickListener
            }
            if (bind.enterContactDiscriptionEt.text.length > 50) {
                bind.enterContactDiscriptionEt.error = "Discription Must be less than 50 characters"
                return@setOnClickListener
            }


            val name = bind.enterContactNameEt.text.toString()
            val number = bind.enterContactNumberEt.text.toString()
            val discription = bind.enterContactDiscriptionEt.text.toString()
            val contact = Contact(R.drawable.contact, name, number, discription)
            val intent = Intent()
            intent.putExtra("contact", contact)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        bind.cancelContactButton.setOnClickListener() {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }


}