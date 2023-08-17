package com.example.opad.contacts

import android.os.Parcel
import android.os.Parcelable
import com.example.opad.R

data class Contact(
    var img: Int = R.drawable.user_icon, var name: String, var number: String,
    var discribtion: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(img)
        parcel.writeString(name)
        parcel.writeString(number)
        parcel.writeString(discribtion)
    }

    companion object CREATOR : Parcelable.Creator<Contact> {
        override fun createFromParcel(parcel: Parcel): Contact {
            return Contact(parcel)
        }

        override fun newArray(size: Int): Array<Contact?> {
            return arrayOfNulls(size)
        }
    }
}