package com.mixturadesabores.junin.lacarta.view.PlatosView

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.domain.entities.Plato
import com.mixturadesabores.junin.lacarta.databinding.FragmentPlatosFavoritosListBinding
import com.mixturadesabores.junin.lacarta.viewmodel.FavoritePlateViewModel
import io.reactivex.observers.DisposableObserver

class PlatosFavoritosFragment : Fragment() {

    private lateinit var fragmentPlatosFavoritosListBinding: FragmentPlatosFavoritosListBinding
    private lateinit var favoritePlateViewModel: FavoritePlateViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyPlatoFavoritoRecyclerViewAdapter
    private var mListener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MyPlatoFavoritoRecyclerViewAdapter(listOf<Plato>(), mListener)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentPlatosFavoritosListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_platos_favoritos_list, container, false)
        favoritePlateViewModel = FavoritePlateViewModel()
        fragmentPlatosFavoritosListBinding.favoritePlatesViewModel = favoritePlateViewModel
        recyclerView = fragmentPlatosFavoritosListBinding.list
        recyclerView.layoutManager = LinearLayoutManager(fragmentPlatosFavoritosListBinding.root.context)
        recyclerView.adapter = adapter
        favoritePlateViewModel.fetchFavoritePlates(fetchFavoritePlatesObserver())
        return fragmentPlatosFavoritosListBinding.root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is PlatosFavoritosFragment.OnListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        if (activity is PlatosFavoritosFragment.OnListFragmentInteractionListener) {
            mListener = activity
        } else {
            throw RuntimeException(activity!!.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    private inner class fetchFavoritePlatesObserver(): DisposableObserver<List<Plato>>() {
        override fun onComplete() {

        }

        override fun onNext(t: List<Plato>) {
            adapter.mValues = t
            adapter.notifyDataSetChanged()
        }

        override fun onError(e: Throwable) {
            println("holo")
        }

    }

    interface OnListFragmentInteractionListener {

        fun onListFragmentInteraction(item: Plato)
    }

    companion object {

        private val ARG_COLUMN_COUNT = "column-count"

        fun newInstance(columnCount: Int): PlatosFavoritosFragment {
            val fragment = PlatosFavoritosFragment()
            val args = Bundle()
            args.putInt(ARG_COLUMN_COUNT, columnCount)
            fragment.arguments = args
            return fragment
        }
    }
}
