package com.mixturadesabores.junin.domain.entities

import com.mixturadesabores.junin.domain.repositories.OrdenRepository
import java.util.*

class Orden(var id: Int?, var hora: Date?, var estado: Boolean?) {

    var detalles: MutableList<DetalleOrden> = mutableListOf<DetalleOrden>()

    fun registrar(ordenRepository: OrdenRepository) {
        val res = ordenRepository.create(this)
        id = res.id
        hora = res.hora
    }

    fun agregarDetalle(detalle: DetalleOrden) {
        detalles.add(detalle)
    }

    fun cambiarDetalle(detalle: DetalleOrden) {
        var index = 0
        detalles.map {
            if (it.id == detalle.id) {
                index = detalles.indexOf(it)
            }
        }
        detalles.removeAt(index)
        detalles.add(index, detalle)
    }

    fun quitarDetalle(detallePedidoId: Int) {
        detalles = detalles.filter { it.id != detallePedidoId }.toMutableList()
    }

    fun obtenerDetalles(): List<DetalleOrden> {
        return detalles
    }

    fun cerrar() {
        estado = false
    }
}