package com.mixturadesabores.junin.domain.entities

class Mesa(val id: Int, val numero: Int, var estado: String, var orden: Orden?) {

    private val estados = listOf<String>("libre", "ocupada")

    init {
        if (!estados.contains(estado)) {
            throw Exception("Estado de mesa no valido")
        }
    }

    fun liberar() {
        if (estado == "ocupada") {
            estado = "libre"
            orden = null
        } else {
            throw Exception("La mesa ya esta libre")
        }
    }

    fun ocupar(orden: Orden) {
        if (estado == "libre") {
            estado = "ocupada"
            this.orden = orden
        } else {
            throw Exception("La mesa ya esta ocupada")
        }
    }

    fun estaOcupado(): Boolean {
        if (estado == "ocupada") {
            return true
        } else {
            return false
        }
    }

    fun estaLibre(): Boolean {
        if (estado == "libre") {
            return true
        } else {
            return false
        }
    }
}