package com.urialcurry.cursoandroid.imcCalculatorApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.urialcurry.cursoandroid.R
import com.urialcurry.cursoandroid.imcCalculatorApp.GlobalData as Constants

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescripcion:TextView
    private lateinit var btnRecalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val IMCValue = intent.extras?.getDouble(Constants.IMC_KEY) ?: -1.0

        initComponents()
        initUI(IMCValue)
        initListeners()
    }

    private fun initComponents (){
        tvDescripcion = findViewById(R.id.tvDescription)
        tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initListeners(){
        btnRecalculate.setOnClickListener {
           onBackPressed()
        }
    }

    private fun initUI(result:Double){
        tvIMC.text = result.toString()
        when(result){
            in 0.00..18.50 -> { // Bajo peso
                tvDescripcion.text = getString(R.string.desc_bajo_peso)
                tvResult.text = getString(R.string.title_bajo_peso)
            }
            in 18.51..24.99 -> { // peso normal
                tvDescripcion.text = getString(R.string.desc_peso_normal)
                tvResult.text = getString(R.string.title_peso_normal)
            }
            in 25.00..29.99 -> { // Sobrepeso
                tvDescripcion.text = getString(R.string.title_sobrepeso)
                tvResult.text = getString(R.string.desc_sobrepeso)
            }
            in 30.00..99.00 -> { // Obesidad
                tvDescripcion.text = getString(R.string.title_obeso)
                tvResult.text = getString(R.string.desc_obeso)
            }
            else -> {
                tvIMC.text = getString(R.string.error)
                tvDescripcion.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
            }
        }
    }
}