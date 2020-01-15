package com.beloushkin.domain.repositories.implementations

import com.beloushkin.data.remote.providers.HeroProviderImpl
import com.beloushkin.domain.converters.HeroConverterImpl
import com.beloushkin.domain.models.Hero
import com.beloushkin.domain.repositories.HeroRepository
import kotlinx.coroutines.*

class HeroRepositoryImpl(val heroConverter: HeroConverterImpl): HeroRepository {

    private val heroProvider: HeroProviderImpl = HeroProviderImpl()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)


    override suspend fun fetchHeroes(): Deferred<List<Hero>> {

        val heroesListFromApi = heroProvider.getHeroList().await()
        return coroutineScope.async {
            heroesListFromApi.map{ hero -> heroConverter.fromApiToUI(model = hero)}
        }
    }

    private suspend fun fetchMockHeroes(): Deferred<List<Hero>> {

        val mockData = ArrayList<Hero>()

        delay(3500L)

        mockData.add(Hero(0, "My first Hero", "", 0))
        mockData.add(Hero(1, "Anti-mage", "", 1))
        mockData.add(Hero(2, "Koldun", "", 1))
        mockData.add(Hero(3, "Dark Willow", "", 0))
        mockData.add(Hero(4, "Lion", "", 1))
        mockData.add(Hero(5, "Black Elf", "", 0))

        return coroutineScope.async { mockData }
    }

}