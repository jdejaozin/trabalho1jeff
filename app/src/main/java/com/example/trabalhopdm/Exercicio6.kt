package com.example.trabalhopdm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Exercicio6: AppCompatActivity() {

    lateinit var valores : EditText
    lateinit var btnAdicionarPrimeira : Button
    lateinit var btnAdicionarSegunda : Button
    lateinit var btnMultiplicaMatriz : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercicio6)

        val actionBar = supportActionBar

        actionBar!!.title = "Exercício 6"

        actionBar.setDisplayHomeAsUpEnabled(true)

        valores = findViewById(R.id.numVetor)
        btnAdicionarPrimeira = findViewById(R.id.adicionaValorPrimeira)
        btnAdicionarSegunda = findViewById(R.id.adicionaValorSegunda)
        btnMultiplicaMatriz = findViewById(R.id.calcBtn)

        val matriz1: Array<Array<Int?>> = Array(3) { arrayOfNulls<Int>(3) }
        val linha1 = IntArray(3)

        val matriz2: Array<Array<Int?>> = Array(3) { arrayOfNulls<Int>(3) }
        val linha2 = IntArray(3)

        var i = 0;
        var j = 0;

        btnAdicionarPrimeira.setOnClickListener{
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

        btnAdicionarSegunda.setOnClickListener{
            var valor = valores.text.toString().toInt()
            if(j == 3){
                Toast.makeText(this, "A matriz está cheia",
                    Toast.LENGTH_LONG).show()
            }
            else if(i < 3){
                linha2[i] = valor
                i++
            }else if(i == 3){
                for(i in 0..2){
                    matriz2[j][i] = linha2[i]
                }
                i = 0
                linha2[i] = valor
                j++
                i++
            }

            valores.text= null
        }

        btnMultiplicaMatriz.setOnClickListener{
            multiplicar(matriz1, matriz2)
        }
    }

    private fun multiplicar(mat1: Array<Array<Int?>>, mat2: Array<Array<Int?>>){
        var matrizMult = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))

        // Multiplicação
        for(i in mat1.indices) {
            for (j in 0 until mat1[0].size) {
                for (k in 0 until mat1[0].size) {
                    matrizMult[i][j] += mat1[i][k]!! * mat2[k][j]!!
                }
            }
        }

        // Mostrar matriz
        for(i in mat1.indices){
            for(j in 0 until mat1[0].size){
                Log.i("teste: ", "" + matrizMult[i][j])
            }
        }
    }
}