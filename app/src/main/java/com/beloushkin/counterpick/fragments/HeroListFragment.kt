package com.beloushkin.counterpick.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.beloushkin.counterpick.R
import com.beloushkin.counterpick.adapters.HeroAdapter
import com.beloushkin.counterpick.models.Hero
import com.beloushkin.counterpick.presenters.HeroListPresenter
import com.beloushkin.counterpick.views.HeroListView
import kotlinx.android.synthetic.main.fragment_hero_list.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class HeroListFragment : MvpAppCompatFragment(),
    HeroListView
{

    private val mAdapter = HeroAdapter()

    @InjectPresenter
    lateinit var heroListPresenter:HeroListPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hero_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()

        heroListPresenter.fetchHeroes()
    }

    private fun setupAdapter() {
        val layoutManager = LinearLayoutManager(this.context)
        recyclerHeroList.layoutManager = layoutManager
        recyclerHeroList.adapter = mAdapter
    }

    // View implementation

    override fun presentHeroes(data: List<Hero>) {

        mAdapter.setData(newHeroes = data)
        recyclerHeroList.visibility = View.VISIBLE
        txtHeroListLoading.visibility = View.GONE
    }

    override fun presentLoading() {
        recyclerHeroList.visibility = View.GONE
        txtHeroListLoading.visibility = View.VISIBLE
    }
}
