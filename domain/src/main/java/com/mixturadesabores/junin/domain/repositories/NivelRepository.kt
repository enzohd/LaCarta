package com.mixturadesabores.junin.domain.repositories

import com.mixturadesabores.junin.domain.entities.Nivel
import io.reactivex.Observable

/**
 * Created by enzo on 08/07/17.
 */
interface NivelRepository {

    fun getAll(): Observable<List<Nivel>>
}