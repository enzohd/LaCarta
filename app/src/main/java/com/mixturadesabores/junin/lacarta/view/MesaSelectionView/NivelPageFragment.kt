package com.mixturadesabores.junin.lacarta.view.MesaSelectionView

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.lacarta.view.OrderDetailView.OrderActivity

/**
 * Created by enzo on 08/07/17.
 */
class NivelPageFragment(var aContext: Context, var nivel: Nivel): Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_mesas, container, false)
        val gridview = rootView.findViewById(R.id.gridview_mesas) as GridView
        gridview.adapter = MesaAdapter(aContext, nivel)
        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(context: Context, sectionNumber: Int, nivel: Nivel): NivelPageFragment {
            val fragment = NivelPageFragment(context, nivel)
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}