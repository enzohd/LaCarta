package com.mixturadesabores.junin.lacarta.data

import com.mixturadesabores.junin.domain.entities.Mesa
import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.domain.repositories.NivelRepository

/**
 * Created by enzo on 08/07/17.
 */
class ApiNivelRepository: NivelRepository {

    override fun getAll(): List<Nivel> {
        var niveles: MutableList<Nivel> = mutableListOf<Nivel>()
        niveles.add(Nivel(1, nMesas = 6))
        niveles.add(Nivel(2, mutableListOf<Mesa>(Mesa(1, "Ocupado"), Mesa(2, "Libre"))))
        return niveles.toList()
    }
}