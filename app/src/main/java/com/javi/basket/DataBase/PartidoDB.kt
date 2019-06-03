package com.javi.basket.DataBase

import android.content.Context
import android.util.Log
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.javi.basket.DAO.PartidoDAO
import com.javi.basket.Entities.ClasePartido
import com.javi.basket.TimeStampConverter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


@Database(entities = [ClasePartido::class],version = 1,exportSchema = false)
@TypeConverters(TimeStampConverter::class)
abstract class PartidoDB:RoomDatabase() {

    abstract fun partidoDao():PartidoDAO

    companion object {
        @Volatile
        private var INSTANCE: PartidoDB? = null

        fun getInstance(appContext: Context,scope: CoroutineScope):PartidoDB{
            val tempInstance = INSTANCE
            if(tempInstance != null)return tempInstance
            synchronized(this)
            {
                val instance = Room
                    .databaseBuilder(appContext, PartidoDB::class.java, "partido_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(DatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class DatabaseCallback(private val scope: CoroutineScope):RoomDatabase.Callback(){
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {
                scope.launch(Dispatchers.IO){
                    populateDatabase(it.partidoDao())
                }
            }
        }

        suspend fun populateDatabase(partidoDao: PartidoDAO){

            val dateFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy")
            val ayawal = Calendar.getInstance()
            ayawal.add(Calendar.DATE,1)
            var partido = ClasePartido(1, "Golden State Warriors", "Miami Heat",109 , 100, "Golden State Warriors",dateFormat.parse(dateFormat.format(ayawal.time)) , dateFormat.parse(dateFormat.format(ayawal.time)))
            partidoDao.insert(partido)
            Log.d("CUSTOM",partido.toString())

        }
        }
    }
