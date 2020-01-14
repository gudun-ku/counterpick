package com.beloushkin.counterpick.views

import com.beloushkin.counterpick.models.Hero
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface HeroListView: MvpView {
    fun presentHeroes(data: List<Hero>)
    fun presentLoading()
}