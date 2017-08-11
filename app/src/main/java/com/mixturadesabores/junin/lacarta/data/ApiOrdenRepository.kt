package com.mixturadesabores.junin.lacarta.data

import com.mixturadesabores.junin.domain.entities.Orden
import com.mixturadesabores.junin.domain.repositories.OrdenRepository
import com.mixturadesabores.junin.lacarta.data.mappers.OrderDataMapper
import com.mixturadesabores.junin.lacarta.data.models.OrderApi
import io.reactivex.Observable
import retrofit2.Call

class ApiOrdenRepository: RestApi(), OrdenRepository {
    override fun create(orden: Orden): Orden {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(orden: Orden): Orden {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(orden: Orden) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOrdenById(orderId: Int): Observable<Orden> {
        return Observable.create { subscriber ->
            val call: Call<OrderApi> = sailsApi.getOrder(orderId)
            val response = call.execute()

            if (response.isSuccessful) {
                val order = OrderDataMapper().transformApiToEntity(response.body()!!)
                subscriber.onNext(order)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }


}