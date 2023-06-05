package com.urialcurry.cursoandroid.imcCalculatorApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.urialcurry.cursoandroid.R
import java.text.DecimalFormat
import com.urialcurry.cursoandroid.imcCalculatorApp.GlobalData as Constants

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var cardViewMale: CardView
    private lateinit var cardViewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var btnIncreaseWeight: FloatingActionButton
    private lateinit var btnDecreaseWeight: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnIncreaseAge: FloatingActionButton
    private lateinit var btnDecreaseAge: FloatingActionButton
    private lateinit var btnCalculate: Button

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var weightValue: Int = 50
    private var ageValue: Int = 25
    private var heightValue: Int = 120


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        initComponents()
        initListeners()
        initUI()
    }

    /* region Initializers */
    private fun initComponents() {
        cardViewMale = findViewById(R.id.cardViewMale)
        cardViewFemale = findViewById(R.id.cardViewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnIncreaseWeight = findViewById(R.id.btnIncreaseWeight)
        btnDecreaseWeight = findViewById(R.id.btnDecreaseWeight)
        tvAge = findViewById(R.id.tvAge)
        btnIncreaseAge = findViewById(R.id.btnIncreaseAge)
        btnDecreaseAge = findViewById(R.id.btnDecreaseAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        cardViewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        cardViewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            //  Define Format
            val valueFormat = DecimalFormat("#.##")

            // Format value
            val result = valueFormat.format(value)
            heightValue = value.toInt()
            tvHeight.text = "$value cm"
        }
        btnIncreaseWeight.setOnClickListener {
            weightValue += 1
            setWeight()
        }

        btnDecreaseWeight.setOnClickListener {
            weightValue -= 1
            setWeight()
        }
        btnIncreaseAge.setOnClickListener {
            ageValue += 1
            setAge()
        }

        btnDecreaseAge.setOnClickListener {
            ageValue -= 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }


    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }
    /* endregion */

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = (weightValue) / (heightValue.toDouble() / 100 * heightValue.toDouble() / 100)
        return df.format(imc).toDouble()
    }

    private fun navigateToResult(result:Double){
        val intent = Intent(this,ResultIMCActivity::class.java)
        intent.putExtra(Constants.IMC_KEY,result)
        startActivity(intent)
    }
    /* region CarViewHelpers */
    private fun setGenderColor() {
        cardViewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cardViewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun setWeight() {
        tvWeight.text = "$weightValue kg"
    }

    private fun setAge() {
        tvAge.text = "$ageValue yrs"
    }

    private fun getBackgroundColor(isSelected: Boolean): Int {
        val bgColor = when (isSelected) {
            true -> R.color.background_component_selected
            false -> R.color.background_component
        }

        return ContextCompat.getColor(this, bgColor)
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    /* endregion */
}