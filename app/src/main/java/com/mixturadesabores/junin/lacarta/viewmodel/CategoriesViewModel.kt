package com.mixturadesabores.junin.lacarta.viewmodel

import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.domain.interactors.ObtenerListadoCategoriasUseCase
import com.mixturadesabores.junin.lacarta.data.ApiCategoriaRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CategoriesViewModel {

    private val obtenerCategoriasUseCase by lazy { ObtenerListadoCategoriasUseCase(ApiCategoriaRepository()) }

    private var _compoSub = CompositeDisposable()
    private val compoSub: CompositeDisposable
    get() {
        if (_compoSub.isDisposed) {
            _compoSub = CompositeDisposable()
        }
        return _compoSub
    }

    protected fun manageSub(s: Disposable) = compoSub.add(s)

    fun fetchCategories(disposableObserver: DisposableObserver<List<Categoria>>) {

        manageSub(
                obtenerCategoriasUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(disposableObserver)
        )
    }

    fun dispose() {
        compoSub.dispose()
    }
}