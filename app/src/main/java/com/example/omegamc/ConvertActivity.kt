package com.example.omegamc

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ConvertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)

        val etAmount = findViewById<EditText>(R.id.etAmount)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        
        btnConvert.setOnClickListener {
            val amount = etAmount.text.toString().toDoubleOrNull()

            if (amount != null) {
                tvResult.text = "Hasil: ${amount / 15000} USD"
            } else {
                Toast.makeText(this, "Input salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
