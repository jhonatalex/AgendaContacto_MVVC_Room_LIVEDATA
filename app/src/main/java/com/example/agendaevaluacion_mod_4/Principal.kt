package com.example.agendaevaluacion_mod_4

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendaevaluacion_mod_4.Model.Contacto
import com.example.agendaevaluacion_mod_4.viewModel.ContactViewModel
import kotlinx.android.synthetic.main.fragment_principal.*
import kotlinx.android.synthetic.main.fragment_second.*


class Principal : Fragment(), AdapterContacts.passData {

    private var param1: String? = null

    lateinit var MYADATADOR: AdapterContacts

    val myViewModel: ContactViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("ARG_PARAM1")

        }
        MYADATADOR = AdapterContacts(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_principal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        // RECYCLER 1
        recicler_contact.layoutManager = LinearLayoutManager(context)
        recicler_contact.adapter = MYADATADOR


        myViewModel.viewListContact.observe(viewLifecycleOwner, Observer {

            MYADATADOR.UpdateAdapter(it)

        })

        bt_eliminar.setOnClickListener {

            imput_Name?.setText("")
            imput_LastName?.setText("")
            imput_email?.setText("")
            imput_actividad?.setText("")
            input_Password?.setText("")
            input_Phone?.setText("")

            findNavController().navigate(R.id.action_principal_to_SecondFragment)

        }


        bt_eliminarAll.setOnClickListener {
            myViewModel.deleteAllContact()

        }


    }

    override fun passContact(contacto: Contacto) {

        AlertDialog.Builder(context)
            .setTitle("Confirmacion Contacto")
            .setMessage("Que Desea Hacer ?.")
            .setPositiveButton("ELIMINAR",
                DialogInterface.OnClickListener { dialog, which ->
                    myViewModel.deleteContact(contacto)
                })
            .setNegativeButton("ACTUALIZAR",
                DialogInterface.OnClickListener { dialog, which ->

                    myViewModel.select(contacto)
                    myViewModel.deleteContact(contacto)
                    findNavController().navigate(R.id.action_principal_to_SecondFragment)

                })
            .show()


    }

    override fun passDetalle(contacto: Contacto) {
        myViewModel.select(contacto)
    }

    override fun passCall(contacto: Contacto) {
       Toast.makeText(context,contacto.phone, Toast.LENGTH_LONG).show()
    }


}