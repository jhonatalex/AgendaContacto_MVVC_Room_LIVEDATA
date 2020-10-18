package com.example.agendaevaluacion_mod_4.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contacto::class], version =1)

abstract class DataBaseContact:RoomDatabase(){

    abstract fun contactDao():ContactDao

    companion object {
        @Volatile
        private var INSTANCE : DataBaseContact? = null

        fun getDatabase(context: Context): DataBaseContact {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                    DataBaseContact::class.java,
                    "task_db")
                    .build()
                INSTANCE = instance
                return  instance
            }
        }
    }


}