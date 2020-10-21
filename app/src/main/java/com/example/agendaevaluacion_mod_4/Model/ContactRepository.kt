package com.example.agendaevaluacion_mod_4.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.Optional.empty



class ContactRepository(private val myContactDao: ContactDao) {
    var flag:Boolean=false

    val allContactLiveData=myContactDao.getAllContact()


    fun validUser( emailL:String, contrasena:String):Boolean {

        CoroutineScope(Dispatchers.IO).launch {
            var User1: Contacto = myContactDao.validateUser(emailL, contrasena)

            if (User1==null){ flag=false } else {flag=true  }

        }

        return flag
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