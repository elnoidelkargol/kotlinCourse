package com.urialcurry.cursoandroid.superheroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.urialcurry.cursoandroid.databinding.ActivitySuperHeroListBinding
import com.urialcurry.cursoandroid.superheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit

    private lateinit var adapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI(){
        binding.svSearch.setOnQueryTextListener(object :SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        adapter = SuperHeroAdapter{navigateToDetail(it)}
        binding.rvSuperHero.setHasFixedSize(true)
        binding.rvSuperHero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperHero.adapter = adapter

    }

    private fun searchByName(query: String) {
        binding.progresBarr.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<superHeroDataResponse> = retrofit.create(ApiService::class.java).getSuperheroes(query)

            if (myResponse.isSuccessful){
                Log.i("CursoAndroid","SearchByname OK")
                val response: superHeroDataResponse? = myResponse.body()
                if (response != null){
                    Log.i("CursoAndroid",response.toString())
                    runOnUiThread {
                        adapter.updateList(response.superheroes)
                        binding.progresBarr.isVisible = false
                    }
                }
            }else{
                Log.i("CursoAndroid","SearchByname KO")
            }
        }
    }

    private fun getRetrofit():Retrofit {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit

    }

    private fun navigateToDetail(id:String){
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }
}