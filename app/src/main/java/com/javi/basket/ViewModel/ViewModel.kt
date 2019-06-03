package com.javi.basket.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.javi.basket.DataBase.PartidoDB
import com.javi.basket.Repositories.PartidoRepo

class ViewModel (val app:Application):AndroidViewModel(app){
    private val partidoRepo:PartidoRepo

    init {
        val partidoDao = PartidoDB.getInstance(app,viewModelScope).partidoDao()
        partidoRepo = PartidoRepo(partidoDao)
    }
    fun getAll() = partidoRepo.getAll()
}