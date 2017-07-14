package com.mixturadesabores.junin.domain.entities

import com.mixturadesabores.junin.domain.exceptions.BusyTableException
import com.mixturadesabores.junin.domain.exceptions.FreeTableException

/**
 * Created by enzo on 02/07/17.
 */
class Mesa(val id: Int, val numero: Int, var estado:String) {

    fun liberar() {
        if (estado == "Ocupada") {
            estado = "Libre"
        } else {
            throw FreeTableException("The table is libre already")
        }
    }

    fun ocupar() {
        if (estado == "Libre") {
            estado = "Ocupada"
        } else {
            throw BusyTableException("The table is busy already")
        }
    }
}