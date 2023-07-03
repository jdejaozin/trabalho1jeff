package com.example.trabalhopdm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Exercicio3: AppCompatActivity() {

    lateinit var valores : EditText
    lateinit var btnAdicionar : Button
    lateinit var btnCalcular : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercicio3)

        val actionBar = supportActionBar
        actionBar!!.title = "Exercício 3"
        actionBar.setDisplayHomeAsUpEnabled(true)

        valores = findViewById(R.id.numVetor)
        btnAdicionar = findViewById(R.id.adicionaValor)
        btnCalcular = findViewById(R.id.calcBtn)

        var vetorValores = IntArray(10)
        var i = 0

        btnAdicionar.setOnClickListener{
            var valor = valores.text.toString().toInt()
            vetorValores[i] = valor
            i++
            valores.text= null
        }

        btnCalcular.setOnClickListener{
            separaVetor(vetorValores)
        }
    }

    private fun separaVetor(arr: IntArray) {

        var vetorPar = IntArray(10)
        var vetorImpar = IntArray(10)

        var i = 0
        var p = 0

        arr.forEach {
            if(it % 2 == 1){
                vetorImpar[i] = it
                i++
            }else{
                vetorPar[p] = it
                p++
            }
        }

        var imparNVazio = 0
        var parNVazio = 0

        for(num in vetorImpar){
            if(num != 0){
                imparNVazio++
            }
        }

        for(num in vetorPar){
            if(num != 0){
                parNVazio++
            }
        }

        Toast.makeText(this, "No vetor dos pares foram utilizadas " + parNVazio +
                " posições, e no vetor dos ímpares foram utilizadas " + imparNVazio +
                " posições", Toast.LENGTH_LONG).show()
    }
}