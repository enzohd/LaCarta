package com.mixturadesabores.junin.lacarta.data.models


class MesaApi(val pedido: List<PedidoApi>,
              val nombre: String,
              val estado: String,
              val ubicacion: String,
              val id: Int,
              val createdAt: String,
              val updatedAt: String) {

    fun getLevelId(): Int {
        return ubicacion.last().toInt() - 48
    }
}