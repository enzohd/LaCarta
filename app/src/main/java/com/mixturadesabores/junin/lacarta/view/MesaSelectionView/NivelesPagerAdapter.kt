package com.mixturadesabores.junin.lacarta.view.MesaSelectionView

import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import android.support.v13.app.FragmentPagerAdapter
import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.domain.entities.Nivel

class NivelesPagerAdapter(fm: FragmentManager, var levels: List<Nivel>, val context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return NivelPageFragment.newInstance(position + 1, levels[position])
    }

    override fun getCount(): Int {
        return levels.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val title = context.resources.getIdentifier("tab_title_level_" + levels[position].piso.toString(), "string", context.packageName)
        if (title != 0) {
            return context.getString(title)
        } else {
            return context.getString(R.string.tab_title_default) + " " + levels[position].piso.toString()
        }
    }
}