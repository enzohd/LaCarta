package com.mixturadesabores.junin.lacarta.viewmodel

import android.databinding.ObservableField
import com.mixturadesabores.junin.domain.entities.Orden
import com.mixturadesabores.junin.domain.interactors.ObtenerOrdenUseCase
import com.mixturadesabores.junin.lacarta.data.ApiOrdenRepository
import com.mixturadesabores.junin.lacarta.utils.DateHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class OrderViewModel(mOrderId: Int) {

    var orderDate: ObservableField<String> = ObservableField<String>()

    private val obtenerOrdenUseCase by lazy { ObtenerOrdenUseCase(ApiOrdenRepository()) }

    init {
        orderDate.set(DateHelper.getSimpleFormat(DateHelper.getDateFromUTC("2017-08-08T19:22:37.000Z")))

        /*obtenerOrdenUseCase.execute(mOrderId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(fetchOrderObserver())*/
    }

    private inner class fetchOrderObserver: DisposableObserver<Orden>() {
        override fun onComplete() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onNext(t: Orden) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onError(e: Throwable) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}