package com.mixturadesabores.junin.lacarta.data

import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.domain.entities.Plato
import com.mixturadesabores.junin.domain.repositories.PlatoRepository
import io.reactivex.Observable

/**
 * Created by enzo on 10/07/17.
 */
class ApiPlatoRepository(): RestApi(), PlatoRepository {

    /*override fun getFavorites(): List<Plato> {
        var platos: MutableList<Plato> = mutableListOf<Plato>()
        platos.add(Plato("pollo a la brasa 1/4", 34, 12.00))
        platos.add(Plato("pollo a la brasa 1/8", 12, 8.00))
        return platos.toList()
    }*/

    override fun getFavorites(): Observable<List<Plato>> {
        return Observable.create{ subscriber ->
            val platos = mutableListOf<Plato>()
            platos.add(Plato(1, "pollo a la brasa 1/4", 12.0, "", 25))
            platos.add(Plato(2, "pollo a la brasa 1/8", 8.0, "", 42))
            subscriber.onNext(platos)
            subscriber.onComplete()
        }
    }

    override fun getFrequents(): Observable<List<Plato>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCategories(): Observable<List<Categoria>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getByCategory(categoriaId: Int): Observable<List<Plato>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}