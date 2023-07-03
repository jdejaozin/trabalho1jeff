package com.example.trabalhopdm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Exercicio2: AppCompatActivity() {

    lateinit var valores : EditText
    lateinit var btnAdicionar : Button
    lateinit var btnCalcular : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercicio2)

        val actionBar = supportActionBar
        actionBar!!.title = "Exercício 2"
        actionBar.setDisplayHomeAsUpEnabled(true)

        valores = findViewById(R.id.numVetor)
        btnAdicionar = findViewById(R.id.adicionaValor)
        btnCalcular = findViewById(R.id.calcBtn)

        var vetorValores = mutableListOf<Int>()

        btnAdicionar.setOnClickListener{
            var valor = valores.text.toString().toInt()

            vetorValores.add(valor)
            valores.text= null
        }

        btnCalcular.setOnClickListener{
            numPrimo(vetorValores)
        }
    }

    private fun numPrimo(arr: MutableList<Int>) {
        var primos = mutableListOf<Int>()
        var indices = mutableListOf<Int>()

        arr.forEach {
            if(it % 2 == 1){
                primos.add(it)
                indices.add(arr.indexOf(it))
            }
        }

        Toast.makeText(this, "Os números primos são " + primos +
            ", nas posições " + indices + " da lista", Toast.LENGTH_LONG).show()
    }
}