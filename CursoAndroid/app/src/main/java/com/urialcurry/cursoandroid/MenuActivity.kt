package com.urialcurry.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.urialcurry.cursoandroid.firstapp.FirstAppActivity
import com.urialcurry.cursoandroid.imcCalculatorApp.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludoApp = findViewById<Button>(R.id.btnSaludoApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)

        btnSaludoApp.setOnClickListener { navigateToSaludoApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this,ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludoApp(){
        val intent = Intent(this,FirstAppActivity::class.java)
        startActivity(intent)

    }
}