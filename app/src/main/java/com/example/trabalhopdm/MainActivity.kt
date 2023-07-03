package com.example.trabalhopdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var ex1Button : Button
    lateinit var ex2Button : Button
    lateinit var ex3Button : Button
    lateinit var ex4Button : Button
    lateinit var ex5Button : Button
    lateinit var ex6Button : Button
    lateinit var ex7Button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ex1Button = findViewById(R.id.ex1)
        ex2Button = findViewById(R.id.ex2)
        ex3Button = findViewById(R.id.ex3)
        ex4Button = findViewById(R.id.ex4)
        ex5Button = findViewById(R.id.ex5)
        ex6Button = findViewById(R.id.ex6)
        ex7Button = findViewById(R.id.ex7)

        ex1Button.setOnClickListener {
            val intent = Intent(this, Exercicio1::class.java)
            startActivity(intent)
        }
        ex2Button.setOnClickListener {
            val intent = Intent(this, Exercicio2::class.java)
            startActivity(intent)
        }
        ex3Button.setOnClickListener {
            val intent = Intent(this, Exercicio3::class.java)
            startActivity(intent)
        }
        ex4Button.setOnClickListener {
            val intent = Intent(this, Exercicio4::class.java)
            startActivity(intent)
        }
        ex5Button.setOnClickListener {
            val intent = Intent(this, Exercicio5::class.java)
            startActivity(intent)
        }
        ex6Button.setOnClickListener {
            val intent = Intent(this, Exercicio6::class.java)
            startActivity(intent)
        }
        ex7Button.setOnClickListener {
            val intent = Intent(this, Exercicio7::class.java)
            startActivity(intent)
        }

        var vetorInt = intArrayOf(1, 2, 3, 4, 5)
        var matriz1 = arrayOf(intArrayOf(3, 2, 1), intArrayOf(3, 2, 1), intArrayOf(3, 2, 1))
        var matriz2 = arrayOf(intArrayOf(3, 2, 1), intArrayOf(3, 2, 1), intArrayOf(3, 2, 1))
        potenciaMatriz(matriz1)
    }

    private fun desvioPadrao(arr: DoubleArray) {
        val med = arr.average()
        var somatoria = 0.0

        arr.forEach {
            somatoria += (it - med).pow(2)
        }

        var desvio: Double = sqrt(somatoria / arr.size.toDouble())
    }

    private fun numPrimo(arr: IntArray) {

        var primos = mutableListOf<Int>()
        var indices = mutableListOf<Int>()

        arr.forEach {
            if(it % 2 == 1){
                primos.add(it)
                indices.add(arr.indexOf(it))
            }
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
    }

    private fun matrizes(mat: Array<IntArray>){
        var soma = 0
        var somaMed = 0
        var soma1e2 = 0

        // Soma
        for(i in 0 until mat.size){
            for(j in 0 until mat[i].size){
                if((j+1) % 2 != 0){
                    soma += mat[i][j]
                }
            }
        }

        // Média
        for(i in 0 until mat.size){
            for(j in 0 until mat[i].size){
                if((j+1) == 2 || (j+1) == 4){
                    somaMed += mat[i][j]
                }
            }
        }
        var med: Double = somaMed.toDouble() / 6

        // Media das colunas 1 e 2 e reposição na 6
        for(i in 0 until mat.size){
            for(j in 0 until mat[i].size){
                if((j+1) == 1 || (j+1) == 2){
                    soma1e2 += mat[i][j]
                }
            }
        }
        for(i in 0 until mat.size){
            for(j in 0 until mat[i].size){
                if((j+1) == 6){
                    mat[i][j] = soma1e2
                }
            }
        }

        // Mostar a matriz
        for(i in 0 until mat.size){
            for(j in 0 until mat[i].size){
                Log.i("teste: ", ""+mat[i][j])
            }
        }
    }

    private fun operacaoMatriz(mat1: Array<IntArray>, mat2: Array<IntArray>) {
        var matrizSumm = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        var matrizSub = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))

        // Soma
        for(i in 0 until mat1.size){
            for(j in 0 until mat1[i].size){
                matrizSumm[i][j] = mat1[i][j] + mat2[i][j]
            }
        }

        // Subtração
        for(i in 0 until mat1.size){
            for(j in 0 until mat1[i].size){
                matrizSub[i][j] = mat2[i][j] - mat1[i][j]
            }
        }

        // Constante
        for(i in 0 until mat1.size){
            for(j in 0 until mat1[i].size){
                mat1[i][j] = mat1[i][j] + 5
                mat2[i][j] = mat2[i][j] + 5
            }
        }

        // Imprimir matrizes
        for(i in 0 until mat1.size){
            for(j in 0 until mat1[i].size){
                Log.i("teste: ", ""+mat1[i][j])
                Log.i("teste: ", ""+mat2[i][j])
                Log.i("teste: ", ""+matrizSumm[i][j])
                Log.i("teste: ", ""+matrizSub[i][j])
            }
        }
    }

    private fun multiplicaMatriz(mat1: Array<IntArray>, mat2: Array<IntArray>) {
        var matrizMult = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))

        // Multiplicação
        for(i in mat1.indices) {
            for (j in 0 until mat1[0].size) {
                for (k in 0 until mat1[0].size) {
                    matrizMult[i][j] += mat1[i][k] * mat2[k][j]
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

    private fun potenciaMatriz(mat: Array<IntArray>) {
        var matrizPow = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))

        for(i in mat.indices) {
            for (j in 0 until mat[0].size) {
                for (k in 0 until mat[0].size) {
                    matrizPow[i][j] += mat[i][k] * mat[k][j]
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