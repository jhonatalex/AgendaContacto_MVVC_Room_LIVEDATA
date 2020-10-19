package com.example.agendaevaluacion_mod_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.agendaevaluacion_mod_4.Model.Contacto
import com.example.agendaevaluacion_mod_4.viewModel.ContactViewModel
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*


class FirstFragment : Fragment() {

    val myViewModel: ContactViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        view.findViewById<Button>(R.id.btn_login).setOnClickListener {

            if (username.text.isEmpty()||password_login.text.isEmpty()) {

                Toast.makeText(context,"Rellene Todos Los campos ", Toast.LENGTH_LONG).show()

            } else{

                myViewModel.ValidateUser("${username.text}","${password_login.text}")


                myViewModel.result.observe(viewLifecycleOwner, Observer {
                    if (it) {
                        findNavController().navigate(R.id.action_FirstFragment_to_principal)
                    }else {
                        Toast.makeText(context,"DATOS INCORRECTOS ",Toast.LENGTH_LONG).show()
                    }

                })


            }


        }

        btn_login2.setOnClickListener {   findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment) }







    }
}