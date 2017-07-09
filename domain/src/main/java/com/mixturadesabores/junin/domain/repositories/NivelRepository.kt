package com.mixturadesabores.junin.domain.repositories

import com.mixturadesabores.junin.domain.entities.Nivel

/**
 * Created by enzo on 08/07/17.
 */
interface NivelRepository {

    fun getAll(): List<Nivel>
}