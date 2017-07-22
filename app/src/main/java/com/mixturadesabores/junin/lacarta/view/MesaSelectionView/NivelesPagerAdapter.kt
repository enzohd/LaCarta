package com.mixturadesabores.junin.lacarta.view.MesaSelectionView

import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentPagerAdapter
import com.mixturadesabores.junin.domain.entities.Nivel


class NivelesPagerAdapter(fm: FragmentManager, var levels: List<Nivel>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return NivelPageFragment.newInstance(position + 1, levels[position])
    }

    override fun getCount(): Int {
        return levels.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Nivel " + levels[position].piso.toString()
    }

    override fun notifyDataSetChanged() {
        super.notifyDataSetChanged()
    }
}