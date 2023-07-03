package com.example.trabalhopdm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Exercicio4: AppCompatActivity() {

    lateinit var valores : EditText
    lateinit var btnAdicionar : Button
    lateinit var btnSomaColuna : Button
    lateinit var btnImpimiMatriz : Button
    lateinit var btnSubstituiValores : Button
    lateinit var btnMedia : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercicio4)

        val actionBar = supportActionBar

        actionBar!!.title = "Exercício 4"

        actionBar.setDisplayHomeAsUpEnabled(true)

        valores = findViewById(R.id.numVetor)
        btnAdicionar = findViewById(R.id.adicionaValor)
        btnSomaColuna = findViewById(R.id.somaColunaImpar)
        btnImpimiMatriz = findViewById(R.id.imprimirMatriz)
        btnSubstituiValores = findViewById(R.id.substituirValores)
        btnMedia = findViewById(R.id.mediaAritmetica)

        val matriz: Array<Array<Int?>> = Array(3) { arrayOfNulls<Int>(6) }
        val linha = IntArray(6)

        var i = 0;
        var j = 0;

        btnAdicionar.setOnClickListener{
            var valor = valores.text.toString().toInt()
            if(j == 3){
                Toast.makeText(this, "A matriz está cheia",
                    Toast.LENGTH_LONG).show()
            }
            else if(i < 6){
                linha[i] = valor
                i++
            }else if(i == 6){
                for(i in 0..5){
                    matriz[j][i] = linha[i]
                }
                i = 0
                linha[i] = valor
                j++
                i++
            }

            valores.text= null
        }

        btnSomaColuna.setOnClickListener{
            soma(matriz)
        }
        btnImpimiMatriz.setOnClickListener{
            imprimirMatriz(matriz)
        }
        btnSubstituiValores.setOnClickListener{
            substituiValores(matriz)
        }
        btnMedia.setOnClickListener{
            media(matriz)
        }
    }

    private fun soma(mat: Array<Array<Int?>>){
        var soma = 0

        // Soma
        for(i in 0 until mat.size){
            for(j in 0 until mat[i].size){
                if((j+1) % 2 != 0){
                    soma += mat[i][j]!!
                }
            }
        }

        Toast.makeText(this, "A soma das colunas ímpares é ${soma}",
            Toast.LENGTH_LONG).show()
    }

    private fun media(mat: Array<Array<Int?>>){
        var somaMed = 0

        // Média
        for(i in 0 until mat.size){
            for(j in 0 until mat[i].size){
                if((j+1) == 2 || (j+1) == 4){
                    somaMed += mat[i][j]!!
                }
            }
        }

        var med: Double = somaMed.toDouble() / 6

        Toast.makeText(this, "A média das colunas 2 e 4 é ${med}",
            Toast.LENGTH_LONG).show()
    }

    private fun substituiValores(mat: Array<Array<Int?>>){
        var soma1e2 = 0

        // Soma das colunas 1 e 2 e reposição na 6
        for(i in 0 until mat.size){
            for(j in 0 until mat[i].size){
                if((j+1) == 1 || (j+1) == 2){
                    soma1e2 += mat[i][j]!!
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
    }

    private fun imprimirMatriz(mat: Array<Array<Int?>>){
        for(i in 0 until mat.size){
            for(j in 0 until mat[i].size){
                Toast.makeText(this, "matriz${i}${j} = ${mat[i][j]}",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}