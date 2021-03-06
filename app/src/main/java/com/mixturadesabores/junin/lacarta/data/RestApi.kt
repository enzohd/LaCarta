package com.mixturadesabores.junin.lacarta.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Enzo Huaricapcha on 12/07/2017.
 */
open class RestApi() {

    val sailsApi: SailsApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.1.39:1337/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        sailsApi = retrofit.create(SailsApi::class.java)
    }
}