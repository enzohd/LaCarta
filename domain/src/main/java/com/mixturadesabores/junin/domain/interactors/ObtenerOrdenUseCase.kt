package com.mixturadesabores.junin.domain.interactors

import com.mixturadesabores.junin.domain.entities.Orden
import com.mixturadesabores.junin.domain.repositories.OrdenRepository
import io.reactivex.Observable

class ObtenerOrdenUseCase(private val ordenRepository: OrdenRepository) {

    fun execute(orderId: Int): Observable<Orden> {
        return ordenRepository.getOrdenById(orderId)
    }
}