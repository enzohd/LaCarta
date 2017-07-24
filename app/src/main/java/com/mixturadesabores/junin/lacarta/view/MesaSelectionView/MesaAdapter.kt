package com.mixturadesabores.junin.lacarta.view.MesaSelectionView

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.graphics.Color
import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.domain.entities.Mesa
import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.lacarta.view.OrderDetailView.OrderActivity
import com.mixturadesabores.junin.lacarta.view.PlatosView.PlatosActivity


class MesaAdapter(var context: Context, var mesas: MutableList<Mesa>): BaseAdapter() {

    val mInflator: LayoutInflater

    init {
        mInflator = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return mesas.size
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
        } else {
            button = convertView as Button
        }
        button.height = 140
        button.text = context.getString(R.string.button_table_text) + mesa.numero.toString()
        if (mesa.estado == "libre") {
            button.setBackgroundColor(Color.GREEN)
            button.setOnClickListener { context.startActivity(Intent(context, PlatosActivity::class.java)) }
        } else if (mesa.estado == "ocupada") {
            button.setBackgroundColor(Color.YELLOW)
            button.setOnClickListener { context.startActivity(Intent(context, OrderActivity::class.java)) }
        }
        return button
    }
}