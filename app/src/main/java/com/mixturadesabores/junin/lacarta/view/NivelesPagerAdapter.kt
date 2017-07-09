package com.mixturadesabores.junin.lacarta.view

import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentPagerAdapter
import com.mixturadesabores.junin.domain.interactors.ObtenerNivelesUseCase
import com.mixturadesabores.junin.lacarta.data.ApiNivelRepository
import com.mixturadesabores.junin.domain.entities.Nivel

/**
 * Created by enzo on 08/07/17.
 */
class NivelesPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var niveles: List<Nivel> = ObtenerNivelesUseCase(ApiNivelRepository()).execute()

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return NivelPageFragment.newInstance(position + 1, niveles[position])
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return niveles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Nivel " + niveles[position].piso.toString()
    }
}