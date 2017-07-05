package com.mixturadesabores.junin.domain.entities

/**
 * Created by enzo on 04/07/17.
 */
class Nivel(var cantidad: Int, var mesas: MutableList<Mesa>) {
    init {
        for (i in 1..cantidad) {
            mesas.add(Mesa(i, "Libre"))
        }
    }
}