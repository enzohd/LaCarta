package com.mixturadesabores.junin.domain.entities

import com.mixturadesabores.junin.domain.repositories.CategoriaRepository

/**
 * Created by enzo on 10/07/17.
 */
class Categoria(val id: Int, val nombre: String, val imagen: String, val platos: List<Plato>) {
}