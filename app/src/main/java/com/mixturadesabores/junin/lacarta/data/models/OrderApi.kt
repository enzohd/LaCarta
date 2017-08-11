package com.mixturadesabores.junin.lacarta.data.models

import java.sql.Timestamp

class OrderApi(val activo: Boolean,
               val mesero: Int,
               val mesa: Int,
               val id: Int,
               val detalle: List<OrderDetailApi>,
               val createdAt: String,
               val updatedAt: String) {
}