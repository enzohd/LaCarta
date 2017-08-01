package com.mixturadesabores.junin.domain.entities

class DetalleOrden(val id: Int?, val plato: Plato, var cantidad: Int, var nota: String?, var estado: String) {

    private val estados = listOf<String>("solicitado", "preparando", "servido")

    init {
        if (!estados.contains(estado)) {
            throw Exception("Estado de detalle no valido")
        }
    }
}