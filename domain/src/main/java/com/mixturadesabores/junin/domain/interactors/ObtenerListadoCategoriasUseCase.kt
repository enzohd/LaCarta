package com.mixturadesabores.junin.domain.interactors

import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.domain.repositories.CategoriaRepository
import io.reactivex.Observable

/**
 * Created by Enzo Huaricapcha on 12/07/2017.
 */
class ObtenerListadoCategoriasUseCase(private val categoryRepository: CategoriaRepository) {

    fun execute(): Observable<List<Categoria>> {
        return categoryRepository.getAll()
    }
}