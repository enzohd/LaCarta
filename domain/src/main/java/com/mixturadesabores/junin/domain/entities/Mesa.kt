package com.mixturadesabores.junin.domain.entities

/**
 * Created by enzo on 02/07/17.
 */
class Mesa(var numero: Int, var estado:String) {

    fun liberar() {
        if (estado == "Ocupada") {
            estado = "Libre"
        } else {

        }
    }

    fun ocupar() {
        if (estado == "Libre") {
            estado = "Ocupada"
        } else {

        }
    }
}