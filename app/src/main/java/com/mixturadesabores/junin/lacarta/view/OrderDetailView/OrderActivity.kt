package com.mixturadesabores.junin.lacarta.view.OrderDetailView

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mixturadesabores.junin.domain.entities.DetalleOrden
import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.lacarta.databinding.ActivityOrderBinding
import com.mixturadesabores.junin.lacarta.viewmodel.OrderViewModel

import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    private lateinit var activityOrderBinding: ActivityOrderBinding
    private lateinit var orderViewModel: OrderViewModel
    private var orderId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        orderId = intent.getIntExtra("orderId", 0)
        activityOrderBinding = DataBindingUtil.setContentView(this, R.layout.activity_order)
        orderViewModel = OrderViewModel(orderId)
        activityOrderBinding.orderViewModel = orderViewModel
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: DetalleOrden)
    }

}
