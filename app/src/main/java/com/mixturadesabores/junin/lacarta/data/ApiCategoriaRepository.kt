package com.mixturadesabores.junin.lacarta.data

import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.domain.repositories.CategoriaRepository
import com.mixturadesabores.junin.lacarta.data.mappers.CategoriaDataMapper
import com.mixturadesabores.junin.lacarta.data.models.CategoriaApi
import io.reactivex.Observable
import retrofit2.Call

/**
 * Created by enzo on 10/07/17.
 */
class ApiCategoriaRepository: RestApi(), CategoriaRepository {

    override fun getAll(): Observable<List<Categoria>> {
        return Observable.create { subscriber ->
            val call: Call<List<CategoriaApi>> = sailsApi.getCategories()
            val response = call.execute()

            if (response.isSuccessful) {
                val categorias = response.body()!!.map {
                    CategoriaDataMapper().transformApiToEntity(it)
                }
                subscriber.onNext(categorias)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }

    }
}