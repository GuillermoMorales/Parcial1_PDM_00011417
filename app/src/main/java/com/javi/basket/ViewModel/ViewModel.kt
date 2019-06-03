package com.javi.basket.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.javi.basket.DataBase.PartidoDB
import com.javi.basket.Entities.ClasePartido
import com.javi.basket.Repositories.PartidoRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel (val app:Application):AndroidViewModel(app){
    private val partidoRepo:PartidoRepo
    var partido: LiveData<ClasePartido>?=null

    init {
        val partidoDao = PartidoDB.getInstance(app,viewModelScope).partidoDao()
        partidoRepo = PartidoRepo(partidoDao)

    }
    fun getAll() = partidoRepo.getAll()
    fun insertPartido(partido: ClasePartido) = viewModelScope.launch(Dispatchers.IO){
        partidoRepo.insert(partido)
    }
}