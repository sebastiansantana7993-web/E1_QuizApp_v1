package com.example.e1_quizapp

import android.adservices.adid.AdId
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.e1_quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var currentIndex = 0

        val listapreguntas = listOf(
            Pregunta(R.string.pregunta1, true),
            Pregunta(R.string.pregunta2, false),
            Pregunta(R.string.pregunta3, false),
            Pregunta(R.string.pregunta4, true),
            Pregunta(R.string.pregunta5, false),
            Pregunta(R.string.pregunta6, true)

        )


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        fun updateQuestion(){
            val questionTextResId = listapreguntas[currentIndex].textResId
            binding.textView.setText(questionTextResId)
        }

        fun checkAnswer(userAnswer: Boolean){
            val respuestaCorrecta = listapreguntas[currentIndex].respuesta

            val messageResId = if (userAnswer == respuestaCorrecta){
                R.string.Verdadera
            }else{
                R.string.Falsa
            }
            Toast.makeText(this,messageResId, Toast.LENGTH_SHORT).show()
        }

        binding.btnsiguiente.setOnClickListener {
            currentIndex = (currentIndex+1)%listapreguntas.size
            updateQuestion()
        }

        binding.btnanterior.setOnClickListener {
            if (currentIndex == 0) {
                currentIndex = listapreguntas.size - 1
            } else {
                currentIndex--
            }
            updateQuestion()
        }

        binding.textView.setOnClickListener {
            currentIndex = (currentIndex+1)%listapreguntas.size
            updateQuestion()
        }

        updateQuestion()


        binding.btnT.setOnClickListener{
            checkAnswer(true)
        }

        binding.btnF.setOnClickListener{ 
            checkAnswer(false)           
        }

    }
    data class Pregunta(@StringRes val textResId: Int, val respuesta: Boolean) {

    }
}