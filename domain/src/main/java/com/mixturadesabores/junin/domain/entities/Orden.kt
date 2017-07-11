package com.mixturadesabores.junin.domain.entities

import com.mixturadesabores.junin.domain.repositories.OrdenRepository

/**
 * Created by enzo on 02/07/17.
 */
class Orden {

    var detalles: MutableList<DetalleOrden> = mutableListOf()
    var hora: Double? = null

    fun agregarPlato(plato: Plato, cantidad: Int, observaciones: String) {
        detalles.add(DetalleOrden(plato, cantidad, observaciones))
    }

    fun cambiarOrden() {

    }

    fun obtenerDetalles(): List<DetalleOrden> {
        return detalles
    }
}