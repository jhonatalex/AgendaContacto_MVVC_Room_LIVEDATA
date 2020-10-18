package com.example.agendaevaluacion_mod_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendaevaluacion_mod_4.Model.Contacto
import kotlinx.android.synthetic.main.item_contact.view.*


class AdapterContacts() :RecyclerView.Adapter<AdapterContacts.ViewHolderContact>(){

    private var listContact= emptyList<Contacto>()


    fun UpdateAdapter(list:List<Contacto>){
        listContact=list;
        notifyDataSetChanged()

    }


    inner class ViewHolderContact(itemVista: View):RecyclerView.ViewHolder(itemVista){
    val listName=itemVista.lista_name
    val listLastName=itemVista.list_name2
    val listEmail=itemVista.lista_correo
    val listPhone=itemVista.lista_phone

    val click=itemVista.setOnClickListener{

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderContact {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return ViewHolderContact(view)

    }

    override fun onBindViewHolder(holder: ViewHolderContact, position: Int) {
        val contact=listContact[position]
        holder.listName.text = contact.name
        holder.listLastName.text = contact.lastName
        holder.listEmail.text = contact.email
        holder.listPhone.text=contact.phone
    }

    override fun getItemCount()=listContact.size



}