package com.example.agendaevaluacion_mod_4.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.Optional.empty



class ContactRepository(private val myContactDao: ContactDao) {


    val allContactLiveData=myContactDao.getAllContact()



    fun validateUser(email:String,pass:String):LiveData<Contacto>{
        return myContactDao.validateUser(email,pass)
    }





    fun insertContact(cContact:Contacto)= CoroutineScope(Dispatchers.IO).launch {
        myContactDao.insertContact(cContact)
    }

    fun deleteContact(contact:Contacto)= CoroutineScope(Dispatchers.IO).launch {
        myContactDao.delete(contact)
    }

    fun deleteAllContacts()= CoroutineScope(Dispatchers.IO).launch {
        myContactDao.deleteAllContacts()
    }



}