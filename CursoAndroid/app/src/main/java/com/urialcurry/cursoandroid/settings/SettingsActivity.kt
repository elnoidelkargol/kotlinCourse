package com.urialcurry.cursoandroid.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.urialcurry.cursoandroid.R
import com.urialcurry.cursoandroid.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}