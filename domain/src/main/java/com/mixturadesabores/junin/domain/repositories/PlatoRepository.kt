package com.mixturadesabores.junin.domain.repositories

import com.mixturadesabores.junin.domain.entities.Plato
import io.reactivex.Observable

/**
 * Created by enzo on 10/07/17.
 */
interface PlatoRepository {

    fun getFavorites(): Observable<List<Plato>>
}