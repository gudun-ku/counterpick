package com.beloushkin.counterpick.presenters


import com.beloushkin.domain.models.Hero
import com.beloushkin.counterpick.views.HeroListView
import com.beloushkin.domain.converters.HeroConverterImpl
import com.beloushkin.domain.repositories.HeroRepository
import com.beloushkin.domain.repositories.implementations.HeroRepositoryImpl
import kotlinx.coroutines.*
import moxy.InjectViewState
import moxy.MvpPresenter
import java.lang.Exception

@InjectViewState
class HeroListPresenter: MvpPresenter<HeroListView>() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val heroRepository: HeroRepository = HeroRepositoryImpl(heroConverter = HeroConverterImpl())

    fun fetchHeroes() {
        viewState.presentLoading()

        coroutineScope.launch {
            try {
                val mockData: List<Hero> = heroRepository.fetchHeroes().await()
                withContext(Dispatchers.Main) {
                    viewState.presentHeroes(mockData)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }

}