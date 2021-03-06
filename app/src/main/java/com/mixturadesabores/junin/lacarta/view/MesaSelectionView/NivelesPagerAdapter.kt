package com.mixturadesabores.junin.lacarta.view.MesaSelectionView

import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import android.support.v13.app.FragmentPagerAdapter
import com.mixturadesabores.junin.domain.interactors.ObtenerNivelesUseCase
import com.mixturadesabores.junin.lacarta.data.ApiNivelRepository
import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.lacarta.view.MesaSelectionView.NivelPageFragment
import io.reactivex.schedulers.Schedulers

/**
 * Created by enzo on 08/07/17.
 */
class NivelesPagerAdapter(context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var context: Context = context
    val apiNivelRepository by lazy { ApiNivelRepository() }
    var niveles = mutableListOf<Nivel>()
    val suscription = ObtenerNivelesUseCase(apiNivelRepository).execute()
            .subscribeOn(Schedulers.io())
            .subscribe(
                    { res ->
                        niveles = res.toMutableList()
                        this.notifyDataSetChanged()
                    }
            )

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return NivelPageFragment.newInstance(context, position + 1, niveles[position])
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return niveles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Nivel " + niveles[position].piso.toString()
    }

    override fun notifyDataSetChanged() {
        super.notifyDataSetChanged()
    }
}