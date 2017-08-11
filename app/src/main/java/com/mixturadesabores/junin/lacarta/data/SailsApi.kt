package com.mixturadesabores.junin.lacarta.data

import com.mixturadesabores.junin.lacarta.data.models.PlatoOfCartaApi
import com.mixturadesabores.junin.lacarta.data.models.CategoriaApi
import com.mixturadesabores.junin.lacarta.data.models.MesaApi
import com.mixturadesabores.junin.lacarta.data.models.OrderApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SailsApi {

    @GET("/carta")
    fun getFavoritePlates(): Call<List<PlatoOfCartaApi>>

    @GET("/categoria")
    fun getCategories(): Call<List<CategoriaApi>>

    @GET("/mesa")
    fun getTables(): Call<List<MesaApi>>

    @GET("pedido/{orderId}")
    fun getOrder(@Path("orderId") orderId: Int): Call<OrderApi>
}