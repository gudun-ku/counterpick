package com.beloushkin.data.remote.services

import com.beloushkin.data.remote.models.HeroApi
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface HeroService {

    @GET("heroes")
    fun getHeroes() : Deferred<List<HeroApi>>
}