package com.example.agendaevaluacion_mod_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendaevaluacion_mod_4.viewModel.ContactViewModel
import kotlinx.android.synthetic.main.fragment_principal.*


class Principal : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    lateinit var MYADATADOR:AdapterContacts



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("ARG_PARAM1")

        }

        MYADATADOR=AdapterContacts()

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

        val myViewModel: ContactViewModel by viewModels()

        // RECYCLER 1
        recicler_contact.layoutManager= LinearLayoutManager(context)
        recicler_contact.adapter=MYADATADOR
        

        myViewModel.viewListContact.observe(viewLifecycleOwner, Observer {

            MYADATADOR.UpdateAdapter(it)


        })



    }
}