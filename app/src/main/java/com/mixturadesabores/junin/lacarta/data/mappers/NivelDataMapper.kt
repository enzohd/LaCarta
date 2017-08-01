package com.mixturadesabores.junin.lacarta.data.mappers

import com.mixturadesabores.junin.domain.entities.Mesa
import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.lacarta.data.models.MesaApi


class NivelDataMapper {

    fun transformApiToEntity(mesasApi: List<MesaApi>): List<Nivel> {
        var levels = mutableListOf<Nivel>()
        var levelsApi = mutableListOf<Int>()

        levelsApi.addAll(mesasApi.map { it.getLevelId() }.distinct())

        levels.addAll(levelsApi.map { level -> Nivel(level, level, mesasApi
                .filter { it.getLevelId() == level }
                .map { mesa -> Mesa(mesa.id, mesa.id, mesa.estado, null) }
                .toMutableList())
        })

        return levels
    }
}