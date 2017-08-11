package com.mixturadesabores.junin.lacarta.data.mappers

import com.mixturadesabores.junin.domain.entities.DetalleOrden
import com.mixturadesabores.junin.domain.entities.Orden
import com.mixturadesabores.junin.domain.entities.Plato
import com.mixturadesabores.junin.lacarta.data.models.OrderApi
import java.util.Date
import java.util.Calendar

class OrderDataMapper {

    fun transformApiToEntity(orderApi: OrderApi): Orden {
        val order = Orden(orderApi.id, Date(2015), orderApi.activo)
        orderApi.detalle.map {
            //val plato = PlatoDataMapper().transformApiToEntity(it.plato)
            val plato = Plato(13,"Carapulcra", 12.5, "", 15)
            order.agregarDetalle(DetalleOrden(it.id, plato, it.cantidad, it.nota, it.estado))
        }
        return order
    }
}