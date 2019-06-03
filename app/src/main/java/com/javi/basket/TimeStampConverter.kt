package com.javi.basket

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class TimeStampConverter {
    companion object {
        val dateFormat = SimpleDateFormat(" EE MM dd HH:mm:ss zzz yyy")

        @TypeConverter
        @JvmStatic
        fun fromTimeStamp(value:String):Date{
            return dateFormat.parse(value)
        }
        @TypeConverter
        @JvmStatic
        fun toTimeStam(value:Date):String = value.toString()
    }
}