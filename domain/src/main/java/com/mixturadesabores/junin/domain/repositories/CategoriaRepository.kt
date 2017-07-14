package com.mixturadesabores.junin.domain.repositories

import com.mixturadesabores.junin.domain.entities.Categoria
import io.reactivex.Observable

/**
 * Created by enzo on 10/07/17.
 */
interface CategoriaRepository {

    fun getAll(): Observable<List<Categoria>>
}