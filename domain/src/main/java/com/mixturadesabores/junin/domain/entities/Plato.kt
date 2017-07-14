package com.mixturadesabores.junin.domain.entities

import com.mixturadesabores.junin.domain.exceptions.InssuficientPlatesException

/**
 * Created by enzo on 02/07/17.
 */
class Plato(val id: Int, val nombre: String, val precio: Double, val imagen: String, var existencias: Int) {

    fun vender(cantidad: Int){
        if(cantidad > existencias) {
            throw InssuficientPlatesException("Operation impossible")
        } else {
            existencias = existencias - cantidad
        }
    }
}