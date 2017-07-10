package com.mixturadesabores.junin.lacarta.data

import com.mixturadesabores.junin.domain.entities.Plato
import com.mixturadesabores.junin.domain.repositories.PlatoRepository

/**
 * Created by enzo on 10/07/17.
 */
class ApiPlatoRepository: PlatoRepository {

    override fun getFavorites(): List<Plato> {
        var platos: MutableList<Plato> = mutableListOf<Plato>()
        platos.add(Plato("pollo a la brasa 1/4", 34, 12.00))
        platos.add(Plato("pollo a la brasa 1/8", 12, 8.00))
        return platos.toList()
    }
}