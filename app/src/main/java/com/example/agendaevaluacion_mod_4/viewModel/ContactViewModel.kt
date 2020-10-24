package com.example.agendaevaluacion_mod_4.viewModel

import android.app.Application
import android.content.ClipData
import androidx.lifecycle.*
import com.example.agendaevaluacion_mod_4.Model.ContactDao
import com.example.agendaevaluacion_mod_4.Model.ContactRepository
import com.example.agendaevaluacion_mod_4.Model.Contacto
import com.example.agendaevaluacion_mod_4.Model.DataBaseContact
import kotlinx.coroutines.launch

class ContactViewModel(context: Application): AndroidViewModel(context) {

    private val myContactRepository: ContactRepository
    val viewListContact: LiveData<List<Contacto>>






    //LIVE DATA PARA PARA EL DETALLE
    val selected = MutableLiveData<Contacto>()

    fun select(item: Contacto) {
        selected.value = item
    }



    init {
        val dao=DataBaseContact.getDatabase(context).contactDao()
        myContactRepository= ContactRepository(dao)
        viewListContact=myContactRepository.allContactLiveData

    }


    fun ValidateUser(email:String, pass:String):LiveData<Contacto>{

        return myContactRepository.validateUser(email,pass)
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