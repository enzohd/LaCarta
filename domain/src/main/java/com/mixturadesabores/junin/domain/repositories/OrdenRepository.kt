package com.mixturadesabores.junin.domain.repositories

import com.mixturadesabores.junin.domain.entities.Orden
import io.reactivex.Observable

interface OrdenRepository {

    fun create(orden: Orden): Orden
    fun update(orden: Orden): Orden
    fun delete(orden: Orden)
    fun getOrdenById(ordenId: Int): Observable<Orden>
}