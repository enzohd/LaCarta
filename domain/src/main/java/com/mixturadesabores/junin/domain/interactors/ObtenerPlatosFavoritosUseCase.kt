package com.mixturadesabores.junin.domain.interactors

import com.mixturadesabores.junin.domain.entities.Plato
import com.mixturadesabores.junin.domain.repositories.NivelRepository
import com.mixturadesabores.junin.domain.repositories.PlatoRepository

/**
 * Created by enzo on 10/07/17.
 */
class ObtenerPlatosFavoritosUseCase(private val platoRepository: PlatoRepository) {

    fun execute(): List<Plato> {
        return platoRepository.getFavorites()
    }
}