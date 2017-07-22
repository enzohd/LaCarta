package com.mixturadesabores.junin.lacarta.data

import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.domain.repositories.NivelRepository
import com.mixturadesabores.junin.lacarta.data.mappers.NivelDataMapper
import com.mixturadesabores.junin.lacarta.data.models.MesaApi
import io.reactivex.Observable
import retrofit2.Call


class ApiNivelRepository: RestApi(), NivelRepository {

    override fun getAll(): Observable<List<Nivel>> {
        return Observable.create{ subscriber ->
            val call: Call<List<MesaApi>> = sailsApi.getTables()
            val response = call.execute()

            if (response.isSuccessful) {
                val levels = NivelDataMapper().transformApiToEntity(response.body()!!)
                subscriber.onNext(levels)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}