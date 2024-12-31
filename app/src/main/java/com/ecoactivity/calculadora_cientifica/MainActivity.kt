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
        var visor = findViewById<TextView>(R.id.tvResultado)
        var num0 = findViewById<Button>(R.id.btn0)
        var num1 = findViewById<Button>(R.id.btn1)
        var num2 = findViewById<Button>(R.id.btn2)
        var num3 = findViewById<Button>(R.id.btn3)
        var num4 = findViewById<Button>(R.id.btn4)
        var num5 = findViewById<Button>(R.id.btn5)
        var num6 = findViewById<Button>(R.id.btn6)
        var num7 = findViewById<Button>(R.id.btn7)
        var num8 = findViewById<Button>(R.id.btn8)
        var num9 = findViewById<Button>(R.id.btn9)
        var parenteses = findViewById<Button>(R.id.btnAbreFecha)
        var virgula = findViewById<Button>(R.id.btnDecimal)
        var igual = findViewById<Button>(R.id.btnIgual)
        var divisao = findViewById<Button>(R.id.btnDivisao)
        var multiplicacao = findViewById<Button>(R.id.btnMultiplicacao)
        var subtrair = findViewById<Button>(R.id.btnSubtracao)
        var somar = findViewById<Button>(R.id.btnSoma)
        var backspace = findViewById<Button>(R.id.btnBack)
        var porcentagem = findViewById<Button>(R.id.btnPorcentagem)
        var limpar = findViewById<Button>(R.id.btnLimparTudo)

        divisao.setOnClickListener { visor.append("÷") }
        multiplicacao.setOnClickListener { visor.append("×") }
        subtrair.setOnClickListener { visor.append("-") }
        somar.setOnClickListener { visor.append("+") }

        backspace.setOnClickListener {
            val legth = visor.text.length
            if (legth > 0){
                visor.text = visor.text.subSequence(0,legth-1)
            }
        }

        limpar.setOnClickListener {
            val leght = visor.text.length
            if(leght > 0){
                visor.text = visor.text.subSequence(0,leght-leght)
            }
        }

        igual.setOnClickListener {  }

        num0.setOnClickListener { visor.append("0") }
        num1.setOnClickListener { visor.append("1") }
        num2.setOnClickListener { visor.append("2") }
        num3.setOnClickListener { visor.append("3") }
        num4.setOnClickListener { visor.append("4") }
        num5.setOnClickListener { visor.append("5") }
        num6.setOnClickListener { visor.append("6") }
        num7.setOnClickListener { visor.append("7") }
        num8.setOnClickListener { visor.append("8") }
        num9.setOnClickListener { visor.append("9") }
        parenteses.setOnClickListener { visor.append("()") }
        virgula.setOnClickListener { visor.append(",") }
    }



}