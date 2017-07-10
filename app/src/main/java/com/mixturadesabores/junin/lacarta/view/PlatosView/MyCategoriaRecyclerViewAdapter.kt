package com.mixturadesabores.junin.lacarta.view.PlatosView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mixturadesabores.junin.domain.entities.Categoria

import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.lacarta.view.PlatosView.CategoriaFragment.OnListFragmentInteractionListener


class MyCategoriaRecyclerViewAdapter(private val mValues: List<Categoria>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyCategoriaRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_categoria, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.mNameView.text = mValues[position].nombre

        /*holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.mItem)
        }*/
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mNameView: TextView
        var mItem: Categoria? = null

        init {
            mNameView = mView.findViewById(R.id.text_name_category) as TextView
        }

        override fun toString(): String {
            return super.toString() + " '" + mNameView.text + "'"
        }
    }
}
