package com.beloushkin.counterpick.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.beloushkin.counterpick.R
import com.beloushkin.domain.models.Hero

class HeroAdapter: RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    private val mHeroList:MutableList<Hero> = mutableListOf()

    fun setData(newHeroes: List<Hero>) {
        mHeroList.clear()
        mHeroList.addAll(newHeroes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_hero, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = mHeroList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mHeroList[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        private val txtAttackType = itemView.findViewById<TextView>(R.id.txtAttackType)
        private val imgAvatar = itemView.findViewById<ImageView>(R.id.imgAvatar)


        fun bind(model: Hero) {
            txtTitle.text = model.title
            txtAttackType.text = model.attackType.toString()

            if (model.attackType == 0) {
                txtAttackType.text = itemView.context.getString(R.string.attack_type_melee)
            } else {
                txtAttackType.text = itemView.context.getString(R.string.attack_type_ranged)
            }
        }
    }
}