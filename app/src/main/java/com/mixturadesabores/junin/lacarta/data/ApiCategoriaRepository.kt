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
            categorias.add(Categoria("Pollos"))
            categorias.add(Categoria("Pescados"))
            categorias.add(Categoria("Chifa"))
            categorias.add(Categoria("Menu"))
            categorias.add(Categoria("Extra"))
            categorias.add(Categoria("Postres"))
            subscriber.onNext(categorias)
            subscriber.onComplete()
        }

    }
}