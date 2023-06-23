package com.urialcurry.cursoandroid.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.urialcurry.cursoandroid.databinding.ItemSuperheroRowBinding


class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroRowBinding.bind(view)

    fun bind(superHeroResponse: superHeroItemResponse, onItemSelected: (String) -> Unit) {
        binding.superHeroName.text = superHeroResponse.superheroName
        Picasso.get().load(superHeroResponse.superheroImage.url).into(binding.ivSuperHero);
        binding.root.setOnClickListener { onItemSelected(superHeroResponse.superheroId) }
    }
}