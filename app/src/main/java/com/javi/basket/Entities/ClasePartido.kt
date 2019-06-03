package com.javi.basket.Entities

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName= "Partido")
data class ClasePartido(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int?=0,
    @ColumnInfo(name = "local") val local: String,
    @ColumnInfo(name = "visitante") val visitante: String,
    @ColumnInfo(name="puntos_local") val puntos_local:Int,
    @ColumnInfo(name="puntos_visitante") val puntos_visitante:Int,
    @ColumnInfo(name="ganador")val ganador:String,
    @ColumnInfo(name="fecha")val fecha: Date,
    @ColumnInfo(name="hora") val time: Date
)