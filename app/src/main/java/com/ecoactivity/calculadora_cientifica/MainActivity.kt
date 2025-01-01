package com.ecoactivity.calculadora_cientifica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder

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
            "-" to R.id.btnSubtracao, "x" to R.id.btnMultiplicacao, "%" to R.id.btnPorcentagem
        )

        buttons.forEach { (symbol, id) ->
            findViewById<Button>(id).setOnClickListener{visor.append(symbol)}
        }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            val leght = visor.text.length
            if (leght > 0) {
                visor.text = visor.text.subSequence(0, leght - 1)
            }
        }

        findViewById<Button>(R.id.btnLimparTudo).setOnClickListener {
            val leght = visor.text.length
            if (leght > 0){
                visor.text = " "
            }
        }

        findViewById<Button>(R.id.btnIgual).setOnClickListener {
            val resultado = calcular(visor.text.toString())
            visor.text = resultado.toString()
        }

        findViewById<Button>(R.id.btnAbreFecha).setOnClickListener {
            val texto = visor.text.toString()
            if (texto.isNotEmpty() && texto.last() == '(') {
                visor.append(")")
            } else {
                visor.append("(")
            }
        }

    }

    private  fun calcular(expressao: String): Double {
        return try {
            var valores = expressao.replace("x","*")
                .replace("÷","/")

            valores = valores.replace("([0-9]+)%".toRegex()) { matchResult ->
                val valor = matchResult.value.dropLast(1)
                "${valor.toDouble() * 0.01}"
            }
            val expression = ExpressionBuilder(valores).build()
            expression.evaluate()
        }
        catch (e: Exception){
            0.0
        }
    }

}