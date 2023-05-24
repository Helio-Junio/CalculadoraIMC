package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.text_result)
        val tvClassificação = findViewById<TextView>(R.id.text_Classificacao)

        val result = intent.getFloatExtra("Extra_Result", 0.1f)

        tvResult.text = result.toString()

        val classificacao = if (result < 18.5f) {
            "ABAIXO DO PESO"
        } else if (result in 18.5f..24.9f) {
            "NORMAL"
        } else if (result in 25.0f..29.9f) {
            "SOBREPESO"
        } else if (result in 30.0f..39.9f) {
            "OBESIDADE"
        } else if (result in 40.0f..99.9f) {
            "OBESIDADE GRAVE"
        } else {
            "Não foi possível achar sua classificação!"
        }


        tvClassificação.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}