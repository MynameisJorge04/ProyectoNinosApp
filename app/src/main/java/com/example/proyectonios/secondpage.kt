package com.example.proyectonios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.content.Intent
import android.view.View
import android.widget.ImageView

class secondpage : AppCompatActivity() {

    var inicioButton: ImageButton? = null
    var returnButton : ImageButton? = null
    var tituloBoton : ImageButton? = null
    var juego1Boton : ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondpage)

        returnButton = findViewById(R.id.returnButton)
        inicioButton = findViewById(R.id.inicioButton)
        tituloBoton = findViewById(R.id.tituloButton)
        juego1Boton = findViewById(R.id.juego1Boton)
    }

    fun returnButton(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun inicioButton(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun tituloButton(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun juego1Boton(view: View) {
        val intent = Intent(this, juego1::class.java)
        startActivity(intent)
    }
}