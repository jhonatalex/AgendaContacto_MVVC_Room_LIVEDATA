package com.example.agendaevaluacion_mod_4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.agendaevaluacion_mod_4.Model.Contacto
import kotlinx.android.synthetic.main.item_contact.view.*


class AdapterContacts(val callback: passData ) :RecyclerView.Adapter<AdapterContacts.ViewHolderContact>(){

    private var listContact= emptyList<Contacto>()


    fun UpdateAdapter(list:List<Contacto>){
        listContact=list;
        notifyDataSetChanged()

    }


    inner class ViewHolderContact(itemVista: View):RecyclerView.ViewHolder(itemVista){
    val listName=itemVista.lista_name
    val listPhone=itemVista.lista_phone

    val click=itemVista.setOnClickListener{
        callback.passDetalle(listContact[adapterPosition])
        }

     // For pas the details
    val callContact=itemVista.setOnLongClickListener {
         callback.passContact(listContact[adapterPosition])
        true
    }

     // For make the call
    val longClick=itemVista.llamar_text.setOnClickListener {

        callback.passCall(listContact[adapterPosition])
    }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderContact {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return ViewHolderContact(view)

    }

    override fun onBindViewHolder(holder: ViewHolderContact, position: Int) {
        val contact=listContact[position]
        holder.listName.text = " ${contact.name}  ${contact.lastName} "
        holder.listPhone.text= "  ${contact.phone}"
    }

    override fun getItemCount()=listContact.size


    interface  passData{

        fun passContact(contacto:Contacto)
        fun passDetalle(contacto:Contacto)
        fun passCall(contacto:Contacto)
    }



}