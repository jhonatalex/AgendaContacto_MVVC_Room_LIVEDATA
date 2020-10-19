package com.example.agendaevaluacion_mod_4.viewModel

import android.app.Application
import android.content.ClipData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.agendaevaluacion_mod_4.Model.ContactRepository
import com.example.agendaevaluacion_mod_4.Model.Contacto
import com.example.agendaevaluacion_mod_4.Model.DataBaseContact

class ContactViewModel(context: Application): AndroidViewModel(context) {

    private val myContactRepository: ContactRepository

    val viewListContact: LiveData<List<Contacto>>

    private val _result= MutableLiveData<Boolean>()
    val result: LiveData<Boolean> get()=_result


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

    fun ValidateUser(email:String, pass:String){
        val User= myContactRepository.validUser(email, pass)
                if (User==null){ _result.value=false
                }else{ _result.value= true }

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