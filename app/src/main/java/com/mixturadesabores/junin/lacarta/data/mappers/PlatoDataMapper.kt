package com.mixturadesabores.junin.lacarta.data.mappers

import com.mixturadesabores.junin.domain.entities.Plato
import com.mixturadesabores.junin.lacarta.data.models.PlatoApi
import com.mixturadesabores.junin.lacarta.data.models.PlatoOfCartaApi

/**
 * Created by enzo on 17/07/17.
 */
class PlatoDataMapper {

    fun transformApiToEntity(platoOfCartaApi: PlatoOfCartaApi): Plato {
        return Plato(platoOfCartaApi.plato.id,
                platoOfCartaApi.plato.nombre,
                platoOfCartaApi.plato.precio,
                "",
                platoOfCartaApi.cantidad - platoOfCartaApi.reserva)
    }

    fun transformApiToEntity(platos: List<PlatoOfCartaApi>): List<Plato> {
        var platosList = mutableListOf<Plato>()
        platos.map { platosList.add(transformApiToEntity(it)) }
        return platosList.toList()
    }
}