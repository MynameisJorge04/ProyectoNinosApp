package com.example.proyectonios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.media.MediaPlayer
import android.view.View
import android.content.Intent
import com.example.proyectonios.secondpage

class juego1 : AppCompatActivity() {

    private lateinit var chooseAnimal1Button: ImageButton
    private lateinit var chooseAnimal2Button: ImageButton
    private lateinit var chooseAnimal3Button: ImageButton
    private lateinit var chooseAnimal4Button: ImageButton
    private lateinit var chooseAnimal5Button: ImageButton
    private lateinit var chooseAnimal6Button: ImageButton
    private var mediaPlayer: MediaPlayer? = null
    private var buttonsClicked = 0 // Contador de botones tocados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.juego1)

        chooseAnimal1Button = findViewById(R.id.chooseAnimal1Button)
        chooseAnimal2Button = findViewById(R.id.chooseAnimal2Button)
        chooseAnimal3Button = findViewById(R.id.chooseAnimal3Button)
        chooseAnimal4Button = findViewById(R.id.chooseAnimal4Button)
        chooseAnimal5Button = findViewById(R.id.chooseAnimal5Button)
        chooseAnimal6Button = findViewById(R.id.chooseAnimal6Button)

        // Configura un listener común para todos los botones
        val buttons = listOf(
            chooseAnimal1Button, chooseAnimal2Button,
            chooseAnimal3Button, chooseAnimal4Button,
            chooseAnimal5Button, chooseAnimal6Button
        )

        for (button in buttons) {
            button.setOnClickListener {
                onAnimalButtonClick(button)
            }
        }
    }

    private fun onAnimalButtonClick(button: ImageButton) {
        // Detén la reproducción anterior si existe
        mediaPlayer?.stop()
        mediaPlayer?.release()

        // Inicializa el MediaPlayer con el sonido correspondiente al botón
        when (button) {
            chooseAnimal1Button -> mediaPlayer = MediaPlayer.create(this, R.raw.animal2)
            chooseAnimal2Button -> mediaPlayer = MediaPlayer.create(this, R.raw.animal1)
            chooseAnimal3Button -> mediaPlayer = MediaPlayer.create(this, R.raw.animal3)
            chooseAnimal4Button -> mediaPlayer = MediaPlayer.create(this, R.raw.animal4)
            chooseAnimal5Button -> mediaPlayer = MediaPlayer.create(this, R.raw.animal5)
            chooseAnimal6Button -> mediaPlayer = MediaPlayer.create(this, R.raw.animal6)
        }

        // Reproduce el sonido
        mediaPlayer?.start()

        // Incrementa el contador de botones tocados
        buttonsClicked++

        // Verifica si se han tocado todos los botones (en este caso, 6 botones)
        if (buttonsClicked >= 6) {
            // Regresa a la secondpage
            val intent = Intent(this, secondpage::class.java)
            startActivity(intent)
        }
    }
}
