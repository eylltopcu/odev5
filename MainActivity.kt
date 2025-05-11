package com.example.toplamamakinesi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private var currentInput = ""
    private var total = 0
    private var lastPressedEquals = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener {
                if (lastPressedEquals) {
                    currentInput = ""
                    total = 0
                    lastPressedEquals = false
                }
                currentInput += (it as Button).text
                tvResult.text = currentInput
            }
        }

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            addCurrentInput()
        }

        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            addCurrentInput()
            tvResult.text = total.toString()
            lastPressedEquals = true
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            total = 0
            tvResult.text = "0"
        }
    }

    private fun addCurrentInput() {
        if (currentInput.isNotEmpty()) {
            total += currentInput.toInt()
            currentInput = ""
            tvResult.text = total.toString()
        }
    }
}
