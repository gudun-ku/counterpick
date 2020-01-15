package com.beloushkin.domain.repositories

import com.beloushkin.domain.models.Hero
import kotlinx.coroutines.Deferred

interface HeroRepository {

    suspend fun fetchHeroes(): Deferred<List<Hero>>
}