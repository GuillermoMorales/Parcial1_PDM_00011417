package com.javi.basket.Repositories

import com.javi.basket.DAO.PartidoDAO
import com.javi.basket.Entities.ClasePartido

class PartidoRepo (private val partidoDao:PartidoDAO)
    {
        suspend fun insert(partido: ClasePartido) = partidoDao.insert(partido)
        fun getAll() = partidoDao.getAll()
    }
