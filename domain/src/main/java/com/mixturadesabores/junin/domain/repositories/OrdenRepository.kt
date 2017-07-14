package com.mixturadesabores.junin.domain.repositories

import com.mixturadesabores.junin.domain.entities.DetalleOrden
import com.mixturadesabores.junin.domain.entities.Orden

/**
 * Created by enzo on 02/07/17.
 */
interface OrdenRepository {

    fun getAll(): List<Orden>
    fun create(orden: Orden): Orden
    fun update(orden: Orden): Orden
    fun delete(orden: Orden)
    fun getOrdenById(): Orden
}