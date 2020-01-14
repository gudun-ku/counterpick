package com.beloushkin.counterpick.presenters


import com.beloushkin.counterpick.models.Hero
import com.beloushkin.counterpick.views.HeroListView
import kotlinx.coroutines.*
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class HeroListPresenter: MvpPresenter<HeroListView>() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun fetchHeroes() {
        viewState.presentLoading()
        coroutineScope.launch {
            delay(1500L)
            val mockData = ArrayList<Hero>()
            mockData.add(Hero(0, "My first Hero", "", 0))
            mockData.add(Hero(1, "Anti-mage", "", 1))
            mockData.add(Hero(2, "Koldun", "", 1))
            mockData.add(Hero(3, "Dark Willow", "", 0))
            mockData.add(Hero(4, "Lion", "", 1))

            withContext(Dispatchers.Main) {
                viewState.presentHeroes(mockData)
            }

        }

    }

}