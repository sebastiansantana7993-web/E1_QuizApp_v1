package com.example.e1_quizapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var btnTrue: Button;
        var btnFalse: Button;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnTrue = findViewById<Button>(R.id.btnT)
        btnFalse = findViewById<Button>(R.id.btnF)

        btnTrue.setOnClickListener {
            Toast.makeText(this, "¡Respuesta Verdadera!", Toast.LENGTH_SHORT).show()
        }

        btnFalse.setOnClickListener {
            Toast.makeText(this, "¡Respuesta Incorrecta!", Toast.LENGTH_SHORT).show()
        }

    }
}