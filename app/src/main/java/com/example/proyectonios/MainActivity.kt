package com.example.proyectonios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.content.Intent
import android.media.MediaPlayer
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var playBoton: ImageButton? = null
    var helpButton: ImageButton? = null
    var mediaPlayer: MediaPlayer? = null
    var manoImagen: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playBoton = findViewById(R.id.playButton)
        helpButton = findViewById(R.id.helpButton)

        // Inicializa el MediaPlayer si aún no lo está
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.bosquemagico)
        }

        // Verifica si el MediaPlayer está reproduciendo antes de iniciar
        if (!mediaPlayer!!.isPlaying) {
            mediaPlayer?.start()
        }

        manoImagen = findViewById(R.id.manoAnimada)

        val slideUpDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up_down)
        manoImagen?.startAnimation(slideUpDownAnimation)
    }

    override fun onPause() {
        super.onPause()
        // Pausa y libera el MediaPlayer cuando la actividad se detenga
        mediaPlayer?.pause()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    fun playButton(view: View) {
        val intent = Intent(this, secondpage::class.java)
        startActivity(intent)
    }

    fun helpButton(view: View) {
        val intent = Intent(this, helplayout::class.java)
        startActivity(intent)
    }
}
