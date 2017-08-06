package com.mixturadesabores.junin.lacarta.viewmodel

import com.mixturadesabores.junin.domain.entities.Plato
import com.mixturadesabores.junin.domain.interactors.ObtenerPlatosFrecuentesUseCase
import com.mixturadesabores.junin.lacarta.data.ApiPlatoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class FavoritePlateViewModel {

    private val obtenerPlatosFrecuentesUseCase by lazy { ObtenerPlatosFrecuentesUseCase(ApiPlatoRepository()) }

    private var _compoSub = CompositeDisposable()
    private val compoSub: CompositeDisposable
        get() {
            if (_compoSub.isDisposed) {
                _compoSub = CompositeDisposable()
            }
            return _compoSub
        }

    protected fun manageSub(s: Disposable) = compoSub.add(s)

    fun fetchFavoritePlates(disposableObserver: DisposableObserver<List<Plato>>) {

        manageSub(
                obtenerPlatosFrecuentesUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(disposableObserver)
        )
    }

    fun dispose() {
        compoSub.dispose()
    }
}