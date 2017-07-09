package com.mixturadesabores.junin.domain.entities

import javafx.scene.Parent

/**
 * Created by enzo on 04/07/17.
 */
class Nivel(val piso: Int, var mesas: MutableList<Mesa> = mutableListOf<Mesa>()) {

    constructor(piso: Int, nMesas: Int): this(piso) {
        for (i in 1..nMesas) {
            this.mesas.add(Mesa(i,"Libre"))
        }
    }

    fun obtenerNumerodeMesas(): Int {
        return mesas.size
    }
}