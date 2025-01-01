package com.ecoactivity.calculadora_cientifica

import android.os.Bundle
import android.view.TextureView
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val visor = findViewById<TextView>(R.id.tvResultado)
        val buttons = mapOf(
            "0" to R.id.btn0, "1" to R.id.btn1, "2" to R.id.btn2,"3" to R.id.btn3,
            "4" to R.id.btn4, "5" to R.id.btn5, "6" to R.id.btn6, "7" to R.id.btn7,
            "8" to R.id.btn8, "9" to R.id.btn9, "+" to R.id.btnSoma, "÷" to R.id.btnDivisao,
            "-" to R.id.btnSubtracao, "x" to R.id.btnMultiplicacao
        )




    }



}