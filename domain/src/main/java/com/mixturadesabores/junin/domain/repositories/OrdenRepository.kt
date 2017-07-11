package com.mixturadesabores.junin.domain.repositories

import com.mixturadesabores.junin.domain.entities.DetalleOrden

/**
 * Created by enzo on 02/07/17.
 */
interface OrdenRepository {

    fun getDetails(): List<DetalleOrden>
}