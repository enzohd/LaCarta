package com.mixturadesabores.junin.lacarta.data

import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.domain.repositories.CategoriaRepository

/**
 * Created by enzo on 10/07/17.
 */
class ApiCategoriaRepository: CategoriaRepository {

    override fun getAll(): List<Categoria> {
        var categorias: MutableList<Categoria> = mutableListOf()
        categorias.add(Categoria("Pollos"))
        categorias.add(Categoria("Pescados"))
        categorias.add(Categoria("Chifa"))
        categorias.add(Categoria("Menu"))
        categorias.add(Categoria("Extra"))
        return categorias.toList()
    }
}