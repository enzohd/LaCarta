package com.mixturadesabores.junin.domain.repositories

import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.domain.entities.Plato
import io.reactivex.Observable

/**
 * Created by enzo on 10/07/17.
 */
interface PlatoRepository {

    fun getFrequents(): Observable<List<Plato>>
    fun getFavorites(): Observable<List<Plato>>
    fun getCategories(): Observable<List<Categoria>>
    fun getByCategory(categoriaId: Int): Observable<List<Plato>>
}