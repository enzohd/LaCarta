package com.mixturadesabores.junin.domain.interactors

import com.mixturadesabores.junin.domain.entities.Plato
import com.mixturadesabores.junin.domain.repositories.NivelRepository
import com.mixturadesabores.junin.domain.repositories.PlatoRepository
import io.reactivex.Observable

class ObtenerPlatosFrecuentesUseCase(private val platoRepository: PlatoRepository) {

    fun execute(): Observable<List<Plato>> {
        return platoRepository.getFavorites()
    }
}