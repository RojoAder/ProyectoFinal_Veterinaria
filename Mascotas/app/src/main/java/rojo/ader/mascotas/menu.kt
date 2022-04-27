package rojo.ader.mascotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val button1: ImageView  = findViewById(R.id.btnForo)
        button1.setOnClickListener {
            val intent = Intent(this, foroMenu::class.java)
            startActivity(intent)
        }

        var button2:ImageView = findViewById(R.id.btnCalendario)
        button2.setOnClickListener {
            val intent = Intent(this, calendario::class.java)
            startActivity(intent)
        }

        var button3:ImageView = findViewById(R.id.btnEntrenamiento)
        button3.setOnClickListener {
            val intent = Intent(this, entrenamiento_menu::class.java)
            startActivity(intent)
        }

        var button4:ImageView = findViewById(R.id.btnCompras)
        button4.setOnClickListener {
            val intent = Intent(this, entrenamiento_menu::class.java)
            startActivity(intent)
        }

        var button5:ImageView = findViewById(R.id.btnMisMascotas)
        button5.setOnClickListener {
            val intent = Intent(this, mis_mascotas::class.java)
            startActivity(intent)
        }

        var button6:ImageView = findViewById(R.id.btnEmergencias)
        button6.setOnClickListener {
            val intent = Intent(this, mis_mascotas::class.java)
            startActivity(intent)
        }


    }









}