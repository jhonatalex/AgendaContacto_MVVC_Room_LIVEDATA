package com.example.agendaevaluacion_mod_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.agendaevaluacion_mod_4.Model.Contacto
import com.example.agendaevaluacion_mod_4.viewModel.ContactViewModel
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {




    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myViewModel: ContactViewModel by viewModels()




        view.findViewById<Button>(R.id.button_second).setOnClickListener {

            if (imput_Name.text.isEmpty()||imput_LastName.text.isEmpty()|| imput_email.text.isEmpty()
                ||imput_actividad.text.isEmpty() || input_Password.text.isEmpty() || input_Phone.text.isEmpty()) {

                Toast.makeText(context,"Rellene Todos Los campos ", Toast.LENGTH_LONG).show()

            } else{

                myViewModel.insertContact(Contacto(name="${imput_Name.text}",lastName = "${imput_LastName.text}",
                                            phone="${input_Phone.text}",email = "${imput_email.text}",
                                            career = "${imput_actividad.text}",password = "${input_Password.text}") )

                Toast.makeText(context,"Datos Registrados Correctamente ", Toast.LENGTH_LONG).show()

            }

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }







    }
}