package com.mixturadesabores.junin.lacarta.data

import com.mixturadesabores.junin.domain.entities.Plato
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Enzo Huaricapcha on 12/07/2017.
 */
interface SailsApi {

    @GET("/platos")
    fun getFavoritePlates(): Call<Plato>
}