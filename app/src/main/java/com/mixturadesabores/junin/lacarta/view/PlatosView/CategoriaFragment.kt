package com.mixturadesabores.junin.lacarta.view.PlatosView

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.domain.interactors.ObtenerListadoCategoriasUseCase
import com.mixturadesabores.junin.lacarta.data.ApiCategoriaRepository
import io.reactivex.schedulers.Schedulers


class CategoriaFragment : Fragment() {
    private var mColumnCount = 3
    private var mListener: OnListFragmentInteractionListener? = null
    private val apiCategoriaRepository by lazy { ApiCategoriaRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mColumnCount = arguments.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_categoria_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            val recyclerView = view
            if (mColumnCount <= 1) {
                recyclerView.layoutManager = LinearLayoutManager(context)
            } else {
                recyclerView.layoutManager = GridLayoutManager(context, mColumnCount)
            }

            val suscription = ObtenerListadoCategoriasUseCase(apiCategoriaRepository).execute()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            {
                                categorias -> recyclerView.adapter = MyCategoriaRecyclerViewAdapter(categorias, mListener)
                            },
                            {
                                error -> Throwable(error.message)
                            }
                    )
        }
        return view
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Categoria)
    }

    companion object {

        private val ARG_COLUMN_COUNT = "column-count"

        fun newInstance(columnCount: Int): CategoriaFragment {
            val fragment = CategoriaFragment()
            val args = Bundle()
            args.putInt(ARG_COLUMN_COUNT, columnCount)
            fragment.arguments = args
            return fragment
        }
    }
}
