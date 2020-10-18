package com.example.agendaevaluacion_mod_4.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contacto (
@PrimaryKey (autoGenerate = true)
            val id:Int=0,
            val name:String,
            val lastName:String,
            val phone:String,
            val email:String,
            val career:String,
            val password:String

)