package com.example.proyectonios

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class juego2 : AppCompatActivity() {

    private val imageButtons = mutableListOf<ImageButton>()
    private var progresoSecuencia = 0
    private var mediaPlayer: MediaPlayer? = null
    var niveles = 1
    private var buttonsClicked = 0

    private val recursosDeSonido = listOf(
        R.raw.grabacion1,
        R.raw.grabacion2,
        R.raw.grabacion3,
        R.raw.grabacion4,
        R.raw.grabacion5,
        R.raw.grabacion6,
        R.raw.grabacion7,
        R.raw.grabacion8,
        R.raw.grabacion9
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.juego2)

        imageButtons.add(findViewById(R.id.imageButton1))
        imageButtons.add(findViewById(R.id.imageButton2))
        imageButtons.add(findViewById(R.id.imageButton3))
        imageButtons.add(findViewById(R.id.imageButton4))
        imageButtons.add(findViewById(R.id.imageButton5))
        imageButtons.add(findViewById(R.id.imageButton6))
        imageButtons.add(findViewById(R.id.imageButton7))
        imageButtons.add(findViewById(R.id.imageButton8))
        imageButtons.add(findViewById(R.id.imageButton9))

        for (i in imageButtons.indices) {
            imageButtons[i].setOnClickListener {
                onNumeroButtonClick(i)
            }
        }

    }

    private fun onNumeroButtonClick(buttonIndex: Int) {
        if (progresoSecuencia < imageButtons.size) {
            val botonEsperado = imageButtons[progresoSecuencia]

            if (buttonIndex == imageButtons.indexOf(botonEsperado)) {
                progresoSecuencia++

                val soundResource = recursosDeSonido[buttonIndex]
                playSound(soundResource)

                // Desactivar el botón tocado
                botonEsperado.isEnabled = false
            } else {
                progresoSecuencia = 0
                // Realiza alguna acción de reinicio o manejo de error
            }
        }

        buttonsClicked++

        if (buttonsClicked >= imageButtons.size) {
            stopMediaPlayer()
            niveles = 2
            val intent = Intent(this, secondpage::class.java)
            intent.putExtra("niveles", niveles) // Agrega el valor de niveles como un extra
            startActivity(intent)
        }
    }

    private fun playSound(soundResource: Int) {
        stopMediaPlayer()
        mediaPlayer = MediaPlayer.create(this, soundResource)
        mediaPlayer?.start()
    }

    private fun stopMediaPlayer() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onStop() {
        super.onStop()
        stopMediaPlayer()
    }

}