package com.example.trabalhopdm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Exercicio5: AppCompatActivity() {

    lateinit var valores : EditText
    lateinit var btnAdicionarPrimeira : Button
    lateinit var btnAdicionarSegunda : Button
    lateinit var btnSomaMatriz : Button
    lateinit var btnImpimiMatriz : Button
    lateinit var btnAdicionaConstante : Button
    lateinit var btnSubtraiMatriz : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercicio5)

        val actionBar = supportActionBar

        actionBar!!.title = "Exercício 5"

        actionBar.setDisplayHomeAsUpEnabled(true)

        valores = findViewById(R.id.numVetor)
        btnAdicionarPrimeira = findViewById(R.id.adicionaValorPrimeira)
        btnAdicionarSegunda = findViewById(R.id.adicionaValorSegunda)
        btnSomaMatriz = findViewById(R.id.somaMatriz)
        btnImpimiMatriz = findViewById(R.id.imprimirMatriz)
        btnAdicionaConstante = findViewById(R.id.adicionaConstante)
        btnSubtraiMatriz = findViewById(R.id.subtrMatriz)

        val matriz1: Array<Array<Int?>> = Array(2) { arrayOfNulls<Int>(2) }
        val linha1 = IntArray(2)

        val matriz2: Array<Array<Int?>> = Array(2) { arrayOfNulls<Int>(2) }
        val linha2 = IntArray(2)

        var i = 0;
        var j = 0;

        btnAdicionarPrimeira.setOnClickListener{
            var valor = valores.text.toString().toInt()
            if(j == 2){
                Toast.makeText(this, "A matriz está cheia",
                    Toast.LENGTH_LONG).show()
            }
            else if(i < 2){
                linha1[i] = valor
                i++
            }else if(i == 2){
                for(i in 0..1){
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
            if(j == 2){
                Toast.makeText(this, "A matriz está cheia",
                    Toast.LENGTH_LONG).show()
            }
            else if(i < 2){
                linha2[i] = valor
                i++
            }else if(i == 2){
                for(i in 0..1){
                    matriz2[j][i] = linha2[i]
                }
                i = 0
                linha2[i] = valor
                j++
                i++
            }

            valores.text= null
        }

        btnSomaMatriz.setOnClickListener{
            somaMatriz(matriz1, matriz2)
        }

        btnImpimiMatriz.setOnClickListener{
            imprimiMatriz(matriz1, matriz2)
        }

        btnAdicionaConstante.setOnClickListener{
            var valor = valores.text.toString().toInt()

            adicionaConstante(valor, matriz1, matriz2)
        }

        btnSubtraiMatriz.setOnClickListener{
            subtraiMatriz(matriz1, matriz2)
        }
    }

    private fun somaMatriz(mat1: Array<Array<Int?>>, mat2: Array<Array<Int?>>){
        // Soma
        for(i in 0 until mat1.size){
            for(j in 0 until mat1[i].size){
                mat1[i][j] = mat1[i][j]!! + mat2[i][j]!!
            }
        }
    }

    private fun subtraiMatriz(mat1: Array<Array<Int?>>, mat2: Array<Array<Int?>>){
        // Subtração
        for(i in 0 until mat1.size){
            for(j in 0 until mat1[i].size){
                mat2[i][j] = mat2[i][j]!! - mat1[i][j]!!
            }
        }
    }

    private fun adicionaConstante(valor: Int, mat1: Array<Array<Int?>>, mat2: Array<Array<Int?>>){
        // Constante
        for(i in 0 until mat1.size){
            for(j in 0 until mat1[i].size){
                mat1[i][j] = mat1[i][j]!! + valor
                mat2[i][j] = mat2[i][j]!! + valor
            }
        }
    }

    private fun imprimiMatriz(mat1: Array<Array<Int?>>, mat2: Array<Array<Int?>>){
        // Imprimir matrizes
        for(i in 0 until mat1.size){
            for(j in 0 until mat1[i].size){
                Log.i("teste: ", ""+mat1[i][j])
                Log.i("teste: ", ""+mat2[i][j])
            }
        }
    }
}