package com.mixturadesabores.junin.lacarta.view.OrderDetailView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.domain.entities.DetalleOrden

import com.mixturadesabores.junin.lacarta.view.OrderDetailView.DetalleOrdenFragment.OnListFragmentInteractionListener


class MyDetalleOrdenRecyclerViewAdapter(private val mValues: List<DetalleOrden>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyDetalleOrdenRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_detalleorden, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.mIdView.text = mValues[position].cantidad.toString()
        holder.mContentView.text = mValues[position].plato.nombre

        /*holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.mItem)
        }*/
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView
        val mContentView: TextView
        var mItem: DetalleOrden? = null

        init {
            mIdView = mView.findViewById<TextView>(R.id.text_quantity)
            mContentView = mView.findViewById<TextView>(R.id.text_name_plato)
        }

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
