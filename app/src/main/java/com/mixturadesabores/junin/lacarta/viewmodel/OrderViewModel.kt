package com.mixturadesabores.junin.lacarta.viewmodel

import android.databinding.ObservableField

class OrderViewModel(mOrderId: Int) {

    var orderId: ObservableField<String> = ObservableField<String>()
    var orderDate: ObservableField<String> = ObservableField<String>()

    init {
        orderId.set(mOrderId.toString())
        orderDate.set("12:45 pm")
    }
}