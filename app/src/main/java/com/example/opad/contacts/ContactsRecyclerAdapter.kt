package com.example.opad.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.opad.R
import de.hdodenhof.circleimageview.CircleImageView

class ContactsRecyclerAdapter(var items: List<Contact>) :
    RecyclerView.Adapter<ContactsRecyclerAdapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_view, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = items[position]
        holder.contactName.text = "${item.name}"
        holder.contactNumber.text = item.number
        holder.contactImage.setImageResource(item.img)

    }

    override fun getItemCount(): Int {
        return items.size ?: 0
    }

    var oncontactclick: OnItemClicklisner? = null

    fun interface OnItemClicklisner {
        fun onItemClick(position: Int, contact: Contact)
    }

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactImage: CircleImageView = itemView.findViewById(R.id.contact_avatar)
        val contactNumber: TextView = itemView.findViewById(R.id.contact_number)
        val contactName: TextView = itemView.findViewById(R.id.contact_name)
    }


}