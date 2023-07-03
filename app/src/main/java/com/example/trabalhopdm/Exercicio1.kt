package com.example.trabalhopdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.pow
import kotlin.math.sqrt

class Exercicio1: AppCompatActivity() {

    lateinit var valores : EditText
    lateinit var btnAdicionar : Button
    lateinit var btnCalcular : Button
    lateinit var mostrarVetor : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercicio1)

        val actionBar = supportActionBar
//        if(actionBar != null){
//            actionBar.title = "Exercício 1"
//        }
        // Code above resumed below
        actionBar!!.title = "Exercício 1"
        actionBar.setDisplayHomeAsUpEnabled(true)

        var vetorValores = mutableListOf<Float>()

        valores = findViewById(R.id.numVetor)
        btnAdicionar = findViewById(R.id.adicionaValor)
        btnCalcular = findViewById(R.id.calcBtn)
        mostrarVetor = findViewById(R.id.mostraVetor)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mostrarVetor.layoutManager = layoutManager

        val adapter = FloatAdapter(vetorValores)
        mostrarVetor.adapter = adapter

        btnAdicionar.setOnClickListener{
            var valor = valores.text.toString().toFloat()

            vetorValores.add(valor)

            adapter.notifyDataSetChanged()
            valores.text= null
        }

        btnCalcular.setOnClickListener{
            desvioPadrao(vetorValores)
        }
    }

    private inner class FloatAdapter(private val numbers: MutableList<Float>) : RecyclerView.Adapter<FloatAdapter.FloatViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FloatViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.numbers, parent, false)
            return FloatViewHolder(view)
        }

        override fun onBindViewHolder(holder: FloatViewHolder, position: Int) {
            val number = numbers[position]
            holder.bind(number)
        }

        override fun getItemCount(): Int {
            return numbers.size
        }

        inner class FloatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val numberTextView: TextView = itemView.findViewById(R.id.itemNumber)

            fun bind(number: Float) {
                numberTextView.text = number.toString()
            }
        }
    }

    private fun desvioPadrao(arr: MutableList<Float>){
        val med = arr.average()
        var somatoria = 0.0

        arr.forEach {
            somatoria += (it - med).pow(2)
        }

        var desvio: Double = sqrt(somatoria / arr.size.toDouble())

        Toast.makeText(this, "O desvio padrão é de "+ desvio,Toast.LENGTH_LONG).show()
    }
}