package com.mixturadesabores.junin.domain.repositories

import com.mixturadesabores.junin.domain.entities.Plato

/**
 * Created by enzo on 10/07/17.
 */
interface PlatoRepository {

    fun getFavorites(): List<Plato>
}