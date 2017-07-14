package com.mixturadesabores.junin.domain.interactors

import com.mixturadesabores.junin.domain.entities.Plato
import com.mixturadesabores.junin.domain.repositories.NivelRepository
import com.mixturadesabores.junin.domain.repositories.PlatoRepository
import io.reactivex.Observable

/**
 * Created by enzo on 10/07/17.
 */
class ObtenerPlatosFrecuentesUseCase(private val platoRepository: PlatoRepository) {

    fun execute(): Observable<List<Plato>> {
        return platoRepository.getFavorites()
    }
}