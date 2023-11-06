package com.example.proyectonios

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class secondpage : AppCompatActivity() {

    var inicioButton: ImageButton? = null
    var returnButton : ImageButton? = null
    var tituloBoton : ImageButton? = null
    var juego1Boton : ImageView? = null
    var juego2Boton : ImageView? = null
    var juego3Boton : ImageView? = null
    var textView3 : TextView? = null // Agregado
    var manoImagen : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondpage)

        returnButton = findViewById(R.id.returnButton)
        inicioButton = findViewById(R.id.inicioButton)
        tituloBoton = findViewById(R.id.tituloButton)
        juego1Boton = findViewById(R.id.juego1Boton)
        manoImagen = findViewById(R.id.manoAnimada2)

        val slideUpDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up_down)
        manoImagen?.startAnimation(slideUpDownAnimation)

        val niveles = intent.getIntExtra("niveles", 0) // 0 es el valor por defecto si no se encuentra el extra

        if (niveles >= 1) {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_congratulations)
            textView3 = findViewById(R.id.textView3)
            // Actualiza el TextView
            textView3?.text = "Desbloqueaste nivel 2"
            dialog.setCancelable(false)

            val closeButton = dialog.findViewById<Button>(R.id.continuarButton)
            closeButton.setOnClickListener {
                dialog.dismiss()
            }

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            juego2Boton = findViewById(R.id.juego2Boton)
            juego2Boton?.setImageResource(R.drawable.group_7_abierto)


            if (niveles >= 2) {
                val dialog = Dialog(this)
                dialog.setContentView(R.layout.dialog_congratulations)
                // Actualiza el TextView
                textView3?.text = "Desbloqueaste nivel 3"
                dialog.setCancelable(false)

                val closeButton = dialog.findViewById<Button>(R.id.continuarButton)
                closeButton.setOnClickListener {
                    dialog.dismiss()
                }

                dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                dialog.show()

                juego3Boton = findViewById(R.id.juego3Boton)
                juego3Boton?.setImageResource(R.drawable.group_8_abierto)


            }
        }

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

    fun juego2Boton(view: View) {
        val intent = Intent(this, juego2::class.java)
        startActivity(intent)
    }
}