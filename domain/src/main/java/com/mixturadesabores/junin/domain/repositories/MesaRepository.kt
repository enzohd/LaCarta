package com.mixturadesabores.junin.domain.repositories

import com.mixturadesabores.junin.domain.entities.Mesa

/**
 * Created by enzo on 02/07/17.
 */
interface MesaRepository {

    fun saveMesa(mesa: Mesa): Mesa
}