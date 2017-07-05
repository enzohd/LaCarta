package com.mixturadesabores.junin.domain.entities

/**
 * Created by enzo on 02/07/17.
 */
class DetalleOrden(plato: Plato, cantidad: Int, observaciones: String) {
    var plato: Plato = plato
    var cantidad: Int = cantidad
    var precio: Double = plato.precio * cantidad
    var estado: String = "Pedido"
    var observaciones: String = observaciones
}