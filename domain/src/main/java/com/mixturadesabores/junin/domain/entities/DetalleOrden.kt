package com.mixturadesabores.junin.domain.entities

/**
 * Created by enzo on 02/07/17.
 */
class DetalleOrden(val id: Int, val plato: Plato, var cantidad: Int, var observaciones: String) {

    var precio: Double = 0.0
    var estado: String = ""

    init {
        precio = plato.precio * cantidad
        estado = "Pedido"
    }
}