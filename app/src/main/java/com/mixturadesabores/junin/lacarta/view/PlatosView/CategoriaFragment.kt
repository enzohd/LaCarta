package com.mixturadesabores.junin.lacarta.view.PlatosView

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.databinding.DataBindingUtil
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.domain.entities.Categoria
import com.mixturadesabores.junin.lacarta.databinding.FragmentCategoriaListBinding
import com.mixturadesabores.junin.lacarta.viewmodel.CategoriesViewModel
import io.reactivex.observers.DisposableObserver

class CategoriaFragment : Fragment() {

    private lateinit var fragmentCategoriaListBinding: FragmentCategoriaListBinding
    private lateinit var categoriesViewModel: CategoriesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyCategoriaRecyclerViewAdapter
    private var mColumnCount = 3
    private var mListener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MyCategoriaRecyclerViewAdapter(listOf<Categoria>(), mListener)

        if (arguments != null) {
            mColumnCount = arguments.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentCategoriaListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_categoria_list, container, false)
        categoriesViewModel = CategoriesViewModel()
        fragmentCategoriaListBinding.categoriesViewModel = categoriesViewModel
        recyclerView = fragmentCategoriaListBinding.list
        if (mColumnCount <= 1) {
            recyclerView.layoutManager = LinearLayoutManager(fragmentCategoriaListBinding.root.context)
        } else {
            recyclerView.layoutManager = GridLayoutManager(fragmentCategoriaListBinding.root.context, mColumnCount)
        }
        recyclerView.adapter = adapter
        categoriesViewModel.fetchCategories(fetchCategoriesObserver())
        return fragmentCategoriaListBinding.root
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

    private inner class fetchCategoriesObserver(): DisposableObserver<List<Categoria>>() {
        override fun onComplete() {

        }

        override fun onNext(t: List<Categoria>) {
            adapter.mValues = t
            adapter.notifyDataSetChanged()
        }

        override fun onError(e: Throwable) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
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
