package com.urialcurry.cursoandroid.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.urialcurry.cursoandroid.R

class SuperHeroAdapter(
    var superheroList: List<superHeroItemResponse> = emptyList(),
    private val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<SuperHeroViewHolder>() {

    fun updateList(superheroList: List<superHeroItemResponse>) {
        this.superheroList = superheroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(
            layoutInflater.inflate(
                R.layout.item_superhero_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: SuperHeroViewHolder, position: Int) {
        viewHolder.bind(superheroList[position],onItemSelected)
    }

    override fun getItemCount() = superheroList.count()

}