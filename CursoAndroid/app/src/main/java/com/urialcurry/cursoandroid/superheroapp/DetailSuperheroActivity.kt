package com.urialcurry.cursoandroid.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.squareup.picasso.Picasso
import com.urialcurry.cursoandroid.R
import com.urialcurry.cursoandroid.databinding.ActivityDetailSuperheroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailSuperheroBinding

    companion object{
        const val EXTRA_ID = "superHeroId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperheroInfo(id)
    }

    private fun getSuperheroInfo(id:String){
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail = getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)
            if(superheroDetail.body() != null){
                runOnUiThread{
                    createUI(superheroDetail.body()!!)
                }
                
                
            }
        }
    }

    private fun createUI(superHeroDetail: SuperHeroDetailResponse) {
        Picasso.get().load(superHeroDetail.image.url).into(binding.ivSuperHeroImage)
        binding.tvSuperheroName.text = superHeroDetail.name
        binding.tvSuperheroFullName.text = superHeroDetail.biography.fullName
        binding.tvSuperheroPublisher.text = superHeroDetail.biography.publisher
        prepareStats(superHeroDetail.powerStats)
    }

    private fun prepareStats(powerStats: PowerStatsResponse){
        updateHeight(binding.vIntelligence,powerStats.intelligence)
        updateHeight(binding.vCombat,powerStats.combat)
        updateHeight(binding.vDurability,powerStats.durability)
        updateHeight(binding.vSpeed,powerStats.speed)
        updateHeight(binding.vStrenght,powerStats.strength)
        updateHeight(binding.vPower,powerStats.power)

    }

    private fun pixelToDp(pixel:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,pixel, resources.displayMetrics).roundToInt()
    }

    private fun updateHeight(view:View, stat:String){
        val params = view.layoutParams
        params.height = pixelToDp(stat.toFloat())
        binding.vIntelligence.layoutParams = params
    }
    private fun getRetrofit():Retrofit {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}