package com.mixturadesabores.junin.domain.entities


/**
 * Created by enzo on 04/07/17.
 */
class Nivel(val id: Int, val piso: Int, var mesas: MutableList<Mesa> = mutableListOf<Mesa>()) {

    constructor(id: Int, piso: Int, nMesas: Int): this(id, piso) {
        for (i in 1..nMesas) {
            this.mesas.add(Mesa(i, i, "Libre"))
        }
    }

    fun obtenerNumerodeMesas(): Int {
        return mesas.size
    }
}