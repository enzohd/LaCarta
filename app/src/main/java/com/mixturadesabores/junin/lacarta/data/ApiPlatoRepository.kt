package com.mixturadesabores.junin.lacarta.data

import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.domain.entities.Plato
import com.mixturadesabores.junin.domain.repositories.PlatoRepository
import com.mixturadesabores.junin.lacarta.data.mappers.PlatoDataMapper
import com.mixturadesabores.junin.lacarta.data.models.PlatoOfCartaApi
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback

class ApiPlatoRepository(): RestApi(), PlatoRepository {

    override fun getFavorites(): Observable<List<Plato>> {
        return Observable.create{ subscriber ->
            val call: Call<List<PlatoOfCartaApi>> = sailsApi.getFavoritePlates()
            val response = call.execute()

            if (response.isSuccessful) {
                val platos = response.body()!!.map {
                    PlatoDataMapper().transformApiToEntity(it)
                }
                subscriber.onNext(platos)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
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