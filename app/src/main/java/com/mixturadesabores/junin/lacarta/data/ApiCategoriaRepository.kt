package com.mixturadesabores.junin.lacarta.data

import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.domain.repositories.CategoriaRepository
import io.reactivex.Observable

/**
 * Created by enzo on 10/07/17.
 */
class ApiCategoriaRepository: RestApi(), CategoriaRepository {

    override fun getAll(): Observable<List<Categoria>> {
        return Observable.create { subscriber ->
            val categorias = mutableListOf<Categoria>()
            categorias.add(Categoria(1, "Pollos"))
            categorias.add(Categoria(2, "Pescados"))
            categorias.add(Categoria(3, "Chifa"))
            categorias.add(Categoria(4, "Menu"))
            categorias.add(Categoria(5, "Extra"))
            categorias.add(Categoria(6, "Postres"))
            subscriber.onNext(categorias)
            subscriber.onComplete()
        }

    }
}