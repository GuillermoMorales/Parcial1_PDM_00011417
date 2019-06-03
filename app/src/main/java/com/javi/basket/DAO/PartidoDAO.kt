package com.javi.basket.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.javi.basket.Entities.ClasePartido

@Dao
interface PartidoDAO {
    //Si encuentra un registro igual lo reemplaza
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partido:ClasePartido):Long

    @Query("SELECT * FROM 'partido' ")
    fun getAll():LiveData<List<ClasePartido>>

    @Query("DELETE FROM 'Partido' WHERE id=:id")
    suspend fun deletePartido(id:Int)
}