package com.cletus.personapp.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isaac.personapp.databinding.ContactviewlayoutBinding

class ContactAdapter(var personList: List<Contact>, val clicker:(Contact) -> Unit)
    : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

        inner class ContactViewHolder(private val binding:ContactviewlayoutBinding)
            : RecyclerView.ViewHolder(binding.root){
                fun mybind(person: Contact){
                    binding.apply {
                        firstname.text = person.name
                        surname.text = person.surname
                        root.setOnClickListener { clicker(person) }
                    }

                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ContactviewlayoutBinding.inflate(LayoutInflater.from(parent.context))
        return ContactViewHolder(binding)

           }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
            holder.mybind(personList[position])
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}