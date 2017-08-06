package com.mixturadesabores.junin.lacarta.view.PlatosView

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.domain.entities.Plato
import com.mixturadesabores.junin.lacarta.R

import kotlinx.android.synthetic.main.activity_platos.*

class PlatosActivity: AppCompatActivity(), PlatosFavoritosFragment.OnListFragmentInteractionListener, CategoriaFragment.OnListFragmentInteractionListener {

    override fun onListFragmentInteraction(item: Plato) {
        val newDialog = PlatoSelectedDialogFragment.newInstance(item.nombre)
        newDialog.show(fragmentManager, "dialog")
    }

    override fun onListFragmentInteraction(item: Categoria) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platos)
    }

}
