package com.mixturadesabores.junin.lacarta.view.PlatosView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mixturadesabores.junin.domain.entities.Plato

import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.lacarta.view.PlatosView.PlatosFavoritosFragment.OnListFragmentInteractionListener


class MyPlatoFavoritoRecyclerViewAdapter(private val mValues: List<Plato>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyPlatoFavoritoRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_plato_favorito, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.mNameView.text = mValues[position].nombre
        holder.mPriceView.text = mValues[position].precio.toString()

        holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(mValues.get(position))
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mNameView: TextView
        val mPriceView: TextView
        var mItem: Plato? = null

        init {
            mNameView = mView.findViewById(R.id.text_name) as TextView
            mPriceView = mView.findViewById(R.id.text_price) as TextView
        }

        override fun toString(): String {
            return super.toString() + " '" + mPriceView.text + "'"
        }
    }
}
