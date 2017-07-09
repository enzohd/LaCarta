package com.mixturadesabores.junin.domain.interactors

import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.domain.repositories.NivelRepository

/**
 * Created by enzo on 08/07/17.
 */
class ObtenerNivelesUseCase(private val nivelRepository: NivelRepository) {

    fun execute(): List<Nivel> {
        return nivelRepository.getAll()
    }
}