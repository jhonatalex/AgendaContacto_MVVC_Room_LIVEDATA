package com.example.agendaevaluacion_mod_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.agendaevaluacion_mod_4.viewModel.ContactViewModel
import kotlinx.android.synthetic.main.fragment_detalle_contact.*


class DetalleContact : Fragment() {

    val myViewModel: ContactViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.selected.observe(viewLifecycleOwner, Observer {

            if (it==null) {
                txt_name.text = " "
                txt_lastname.text =" "
                txt_email.text = " "
                txt_profe.text = " "
                txt_phone.text = " "


            }else{
                txt_name.text = it.name
                txt_lastname.text = it.lastName
                txt_email.text = it.email
                txt_profe.text = it.career
                txt_phone.text = it.phone

            }


        })


    }



}
