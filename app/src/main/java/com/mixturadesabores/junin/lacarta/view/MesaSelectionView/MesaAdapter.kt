package com.mixturadesabores.junin.lacarta.view.MesaSelectionView

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.graphics.Color
import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.domain.entities.Mesa
import com.mixturadesabores.junin.lacarta.view.OrderDetailView.OrderActivity
import com.mixturadesabores.junin.lacarta.view.PlatosView.PlatosActivity

/**
 * Created by enzo on 09/07/17.
 */
class MesaAdapter(var context: Context, var nivel: Nivel): BaseAdapter() {

    val mInflator: LayoutInflater
    private var mesas: MutableList<Mesa> = nivel.mesas

    init {
        mInflator = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return nivel.obtenerNumerodeMesas()
    }

    override fun getItem(position: Int): Mesa {
        return mesas[position]
    }

    override fun getItemId(position: Int): Long {
        return mesas[position].numero.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var mesa = mesas[position]
        var button: Button
        if (convertView == null) {
            button = Button(context)
            button.setPadding(16, 16, 16, 16)
        } else {
            button = convertView as Button
        }
        button.text = mesa.numero.toString()
        if (mesa.estado == "Libre") {
            button.setBackgroundColor(Color.GREEN)
            button.setOnClickListener { l -> context.startActivity(Intent(context, PlatosActivity::class.java)) }
        } else if (mesa.estado == "Ocupado") {
            button.setBackgroundColor(Color.YELLOW)
            button.setOnClickListener { l -> context.startActivity(Intent(context, OrderActivity::class.java)) }
        }
        return button
    }
}