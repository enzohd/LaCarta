package com.mixturadesabores.junin.domain.interactors

import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.domain.repositories.NivelRepository
import io.reactivex.Observable

/**
 * Created by enzo on 08/07/17.
 */
class ObtenerNivelesUseCase(private val nivelRepository: NivelRepository) {

    fun execute(): Observable<List<Nivel>> {
        return nivelRepository.getAll()
    }
}