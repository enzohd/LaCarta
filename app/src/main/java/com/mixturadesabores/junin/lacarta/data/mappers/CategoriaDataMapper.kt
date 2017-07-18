package com.mixturadesabores.junin.lacarta.data.mappers

import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.lacarta.data.models.CategoriaApi

/**
 * Created by enzo on 17/07/17.
 */
class CategoriaDataMapper {

    fun transformApiToEntity(categoriaApi: CategoriaApi): Categoria {
        return Categoria(categoriaApi.id, categoriaApi.nombre)
    }

    fun transformApiToEntity(categorias: List<CategoriaApi>): List<Categoria> {
        var categoriasList = mutableListOf<Categoria>()
        categorias.map { categoriasList.add(Categoria(it.id, it.nombre)) }
        return categoriasList
    }
}