package com.mixturadesabores.junin.domain.entities

import com.mixturadesabores.junin.domain.exceptions.InssuficientPlatesException
import com.mixturadesabores.junin.domain.repositories.OrdenRepository

/**
 * Created by enzo on 02/07/17.
 */
class Orden(var mesa: Mesa) {

    var id: Int? = null
    var hora: Double? = null
    var detalles: MutableList<DetalleOrden> = mutableListOf()

    fun registrar(ordenRepository: OrdenRepository) {
        val res = ordenRepository.create(this)
        id = res.id
        hora = res.hora
        mesa.ocupar()
    }

    fun agregarPlato(plato: Plato, cantidad: Int, observaciones: String) {
        try {
            plato.vender(cantidad)
        } catch (e: InssuficientPlatesException) {

        }
    }

    fun quitarPlato(detallePedidoId: Int) {
        detalles.removeIf { detalleOrden -> detalleOrden.id == detallePedidoId }
    }

    fun obtenerDetalles(): List<DetalleOrden> {
        return detalles
    }

    fun cerrarPedido() {
        mesa.liberar()
    }
}