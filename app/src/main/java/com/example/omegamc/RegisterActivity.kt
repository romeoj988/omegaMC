package com.example.omegamc

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailInput = findViewById<EditText>(R.id.etRegEmail)
        val passwordInput = findViewById<EditText>(R.id.etRegPassword)
        val registerButton = findViewById<Button>(R.id.btnRegister)
        val backButton = findViewById<Button>(R.id.btnBack)

        // tombol daftar
        registerButton.setOnClickListener {

            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua data harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // simpan data sederhana
            DataUser.savedEmail = email
            DataUser.savedPassword = password

            Toast.makeText(this, "Akun berhasil dibuat", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // tombol kembali
        backButton.setOnClickListener {
            finish()
        }
    }
}