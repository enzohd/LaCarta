package com.mixturadesabores.junin.lacarta.viewmodel

import android.content.Context
import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.domain.interactors.ObtenerNivelesUseCase
import com.mixturadesabores.junin.lacarta.data.ApiNivelRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class LevelViewModel(val context: Context) {

    private val obtenerNivelesUseCase by lazy { ObtenerNivelesUseCase(ApiNivelRepository()) }

    private var _compoSub = CompositeDisposable()
    private val compoSub: CompositeDisposable
        get() {
            if (_compoSub.isDisposed) {
                _compoSub = CompositeDisposable()
            }
            return _compoSub
        }

    protected fun manageSub(s: Disposable) = compoSub.add(s)

    fun fetchLevelList(consumer: Consumer<List<Nivel>>) {

        manageSub(
                obtenerNivelesUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(consumer)
        )
    }

    fun dispose() {
        compoSub.dispose()
    }
}