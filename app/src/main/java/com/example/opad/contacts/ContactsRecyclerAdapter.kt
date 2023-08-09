package com.example.opad.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.opad.R
import de.hdodenhof.circleimageview.CircleImageView

class ContactsRecyclerAdapter(val items: List<Contact>) : RecyclerView.Adapter<ContactsRecyclerAdapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view =LayoutInflater.from(parent.context)
                .inflate(R.layout.contact_view,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item=items[position]
        holder.contactName.text="${item.name}"
        holder.contactImage.setImageResource(item.img)
        holder.contactNumber.text=item.number
    }


    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactImage: CircleImageView = itemView.findViewById(R.id.contact_avatar)
        val contactNumber: TextView = itemView.findViewById(R.id.contact_number)
        val contactName: TextView = itemView.findViewById(R.id.contact_name)

    }


}