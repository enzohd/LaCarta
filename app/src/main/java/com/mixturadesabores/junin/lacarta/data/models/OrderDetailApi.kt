package com.mixturadesabores.junin.lacarta.data.models

class OrderDetailApi(val cantidad: Int,
                     val nota: String,
                     val estado: String,
                     val plato: PlatoApi,
                     val id: Int,
                     val producto: Any?,
                     val pedido: Int,
                     val createdAt: String,
                     val updatedAt: String)