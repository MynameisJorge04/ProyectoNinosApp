package com.example.proyectonios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.content.Intent
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import android.widget.ImageButton
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class juego1 : AppCompatActivity() {

    private val imageButtons = mutableListOf<ImageButton>()
    private var progresoSecuencia = 0
    private var mediaPlayer: MediaPlayer? = null
    var niveles = 0
    private var buttonsClicked = 0

    private val recursosDeSonido = listOf(
        R.raw.animal1,
        R.raw.animal2,
        R.raw.animal3,
        R.raw.animal4,
        R.raw.animal5,
        R.raw.animal6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.juego1)


        imageButtons.add(findViewById(R.id.chooseAnimal1Button))
        imageButtons.add(findViewById(R.id.chooseAnimal2Button))
        imageButtons.add(findViewById(R.id.chooseAnimal3Button))
        imageButtons.add(findViewById(R.id.chooseAnimal4Button))
        imageButtons.add(findViewById(R.id.chooseAnimal5Button))
        imageButtons.add(findViewById(R.id.chooseAnimal6Button))

        for (i in imageButtons.indices) {
            imageButtons[i].setOnClickListener {
                onAnimalButtonClick(i)
            }
        }
    }

    private fun onAnimalButtonClick(buttonIndex: Int) {
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
            niveles = 1
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
