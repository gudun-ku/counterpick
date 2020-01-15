package com.beloushkin.domain.converters

import com.beloushkin.data.remote.models.HeroApi
import com.beloushkin.domain.models.Hero

class HeroConverterImpl {
    fun fromApiToUI(model: HeroApi):Hero {
        return Hero(
            id = model.id
            , title = model.name.replace("npc_dota_hero_", "").replace("_", " ")
            , attackType =  (if(model.attack_type == "Melee") 0 else 1)
            , icon = "")
    }
}