package com.mixturadesabores.junin.lacarta.view.MesaSelectionView

import android.annotation.SuppressLint
import android.app.Fragment
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.lacarta.databinding.FragmentMesasBinding
import com.mixturadesabores.junin.lacarta.viewmodel.TableViewModel

@SuppressLint("ValidFragment")
class NivelPageFragment(var nivel: Nivel): Fragment() {

    private lateinit var fragmentMesasBinding: FragmentMesasBinding
    private lateinit var tableViewModel: TableViewModel
    private lateinit var gridView: GridView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentMesasBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mesas, container, false)
        tableViewModel = TableViewModel(nivel.mesas)
        fragmentMesasBinding.tableViewModel = tableViewModel
        gridView = fragmentMesasBinding.gridviewMesas
        gridView.adapter = MesaAdapter(activity, nivel.mesas)
        return fragmentMesasBinding.root
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
        fun newInstance(sectionNumber: Int, nivel: Nivel): NivelPageFragment {
            val fragment = NivelPageFragment(nivel)
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}