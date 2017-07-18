package com.mixturadesabores.junin.domain.entities


/**
 * Created by enzo on 04/07/17.
 */
class Nivel(val id: Int, val piso: Int, var mesas: MutableList<Mesa> = mutableListOf<Mesa>()) {

    fun obtenerNumerodeMesas(): Int {
        return mesas.size
    }
}