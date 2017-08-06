package com.mixturadesabores.junin.lacarta.data.models

class PlatoOfCartaApi(val plato: PlatoApi,
                      val activo: Boolean,
                      val cantidad: Int,
                      val reserva: Int,
                      val id: Int,
                      val createdAt: String,
                      val updatedAt: String)