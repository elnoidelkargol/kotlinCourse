package com.urialcurry.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.urialcurry.cursoandroid.firstapp.FirstAppActivity
import com.urialcurry.cursoandroid.imcCalculatorApp.ImcCalculatorActivity
import com.urialcurry.cursoandroid.toDoApp.ToDoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludoApp = findViewById<Button>(R.id.btnSaludoApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnToDopp = findViewById<Button>(R.id.btnToDoApp)

        btnSaludoApp.setOnClickListener { navigateToSaludoApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnToDopp.setOnClickListener { navigateToDoApp() }
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this,ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludoApp(){
        val intent = Intent(this,FirstAppActivity::class.java)
        startActivity(intent)

    }

    private fun navigateToDoApp(){
        val intent = Intent(this,ToDoActivity::class.java)
        startActivity(intent)
    }
}