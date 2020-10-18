package com.example.agendaevaluacion_mod_4.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.agendaevaluacion_mod_4.Model.ContactRepository
import com.example.agendaevaluacion_mod_4.Model.Contacto
import com.example.agendaevaluacion_mod_4.Model.DataBaseContact

class ContactViewModel(context: Application): AndroidViewModel(context) {

    private val myContactRepository: ContactRepository

    val viewListContact: LiveData<List<Contacto>>

    init {
        val dao=DataBaseContact.getDatabase(context).contactDao()
        myContactRepository= ContactRepository(dao)
        viewListContact=myContactRepository.allContactLiveData
    }

    fun ValidateUser(email:String, pass:String){
        myContactRepository.validUser(email, pass)
    }



    fun insertContact(user :Contacto){
        myContactRepository.insertContact(user)

    }
    fun deleteContact(user:Contacto){
        myContactRepository.deleteContact(user)

    }

    fun deleteAllContact(){
        myContactRepository.deleteAllContacts()

    }

}