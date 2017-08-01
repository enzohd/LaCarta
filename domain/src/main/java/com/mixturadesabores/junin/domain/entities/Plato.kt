package com.mixturadesabores.junin.domain.entities

import com.mixturadesabores.junin.domain.exceptions.InssuficientPlatesException

class Plato(val id: Int, val nombre: String, val precio: Double, val imagen: String, var existencias: Int) {

    fun vender(cantidad: Int){
        if(cantidad > existencias) {
            throw InssuficientPlatesException("Imposible vender mas platos que la existencia")
        } else {
            existencias = existencias - cantidad
        }
    }
}