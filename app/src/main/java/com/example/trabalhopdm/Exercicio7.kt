package com.example.trabalhopdm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Exercicio7: AppCompatActivity() {

    lateinit var valores : EditText
    lateinit var btnAdicionaValor : Button
    lateinit var btnMatrizQuadrada : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercicio7)

        val actionBar = supportActionBar

        actionBar!!.title = "Exercício 7"

        actionBar.setDisplayHomeAsUpEnabled(true)

        valores = findViewById(R.id.numVetor)
        btnAdicionaValor = findViewById(R.id.adicionaValor)
        btnMatrizQuadrada = findViewById(R.id.calcBtn)

        val matriz1: Array<Array<Int?>> = Array(3) { arrayOfNulls<Int>(3) }
        val linha1 = IntArray(3)

        var i = 0;
        var j = 0;

        btnAdicionaValor.setOnClickListener{
            var valor = valores.text.toString().toInt()
            if(j == 3){
                Toast.makeText(this, "A matriz está cheia",
                    Toast.LENGTH_LONG).show()
            }
            else if(i < 3){
                linha1[i] = valor
                i++
            }else if(i == 3){
                for(i in 0..2){
                    matriz1[j][i] = linha1[i]
                }
                i = 0
                linha1[i] = valor
                j++
                i++
            }

            valores.text= null
        }

        btnMatrizQuadrada.setOnClickListener{
            potencia(matriz1)
        }
    }

    private fun potencia(mat: Array<Array<Int?>>){
        var matrizPow = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))

        for(i in mat.indices) {
            for (j in 0 until mat[0].size) {
                for (k in 0 until mat[0].size) {
                    matrizPow[i][j] += mat[i][k]!! * mat[k][j]!!
                }
            }
        }

        // Mostrar matriz
        for(i in mat.indices){
            for(j in 0 until mat[0].size){
                Log.i("teste: ", "" + matrizPow[i][j])
            }
        }
    }
}