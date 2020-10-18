package com.example.agendaevaluacion_mod_4.Model

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ContactDao {

    @Query ("SELECT * FROM  Contacto")
    fun getAllContact():LiveData<List<Contacto>>

    @Query ("SELECT * FROM Contacto WHERE id=:id")
    suspend fun getById(id:Int): Contacto

    @Query ("SELECT * FROM Contacto WHERE email =:emailL AND password =:contrasena")
    suspend fun validateUser( emailL:String, contrasena:String):Contacto


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(people:Contacto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContactList(list:List<Contacto>)

    @Query("DELETE FROM Contacto")
    fun deleteAllContacts()
    @Delete
    suspend fun delete(person: Contacto)

    @Update
    suspend fun update(person: Contacto)



}