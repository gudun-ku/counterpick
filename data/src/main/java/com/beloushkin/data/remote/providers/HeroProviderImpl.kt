package com.beloushkin.data.remote.providers

import com.beloushkin.data.remote.helpers.RetrofitFactory
import com.beloushkin.data.remote.models.HeroApi
import kotlinx.coroutines.Deferred

class HeroProviderImpl {

    fun getHeroList() : Deferred<List<HeroApi>> {
        return RetrofitFactory.getHeroService().getHeroes()
    }
}