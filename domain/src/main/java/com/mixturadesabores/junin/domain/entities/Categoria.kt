package com.mixturadesabores.junin.domain.entities

import com.mixturadesabores.junin.domain.repositories.CategoriaRepository

/**
 * Created by enzo on 10/07/17.
 */
class Categoria(val nombre: String) {

    companion object {
        fun ObtenerCategorias(categoriaRepository: CategoriaRepository): List<Categoria> {
            return categoriaRepository.getAll()
        }
    }
}