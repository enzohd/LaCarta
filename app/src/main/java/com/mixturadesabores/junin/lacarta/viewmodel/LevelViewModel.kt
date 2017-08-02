package com.mixturadesabores.junin.lacarta.viewmodel

import android.content.Context
import android.util.Log
import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.domain.interactors.ObtenerNivelesUseCase
import com.mixturadesabores.junin.lacarta.data.ApiNivelRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LevelViewModel(val context: Context) {

    private var levels = mutableListOf<Nivel>()
    private val apiNivelRepository by lazy { ApiNivelRepository() }
    private val obtenerNivelesUseCase by lazy { ObtenerNivelesUseCase(apiNivelRepository) }

    interface MainActivityViewModel { fun endCallProgress(any: Any?) }

    private var _compoSub = CompositeDisposable()
    private val compoSub: CompositeDisposable
        get() {
            if (_compoSub.isDisposed) {
                _compoSub = CompositeDisposable()
            }
            return _compoSub
        }

    protected fun manageSub(s: Disposable) = compoSub.add(s)

    fun fetchLevelList(callback: MainActivityViewModel) {

        manageSub(
                obtenerNivelesUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {
                                    callback.endCallProgress(it)
                                    levels = it as MutableList<Nivel>
                                },
                                {
                                    callback.endCallProgress(it)
                                    Log.e("network failed", it.message)
                                }
                        )
        )
    }

    fun dispose() {
        compoSub.dispose()
    }
}