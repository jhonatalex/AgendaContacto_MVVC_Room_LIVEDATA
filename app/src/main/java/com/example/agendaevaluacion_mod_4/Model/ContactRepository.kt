package com.example.agendaevaluacion_mod_4.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactRepository(private val myContactDao: ContactDao) {

    val allContactLiveData=myContactDao.getAllContact()



    fun validUser( emailL:String, contrasena:String) {
       myContactDao.validateUser(emailL, contrasena)
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