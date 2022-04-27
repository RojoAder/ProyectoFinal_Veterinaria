package rojo.ader.mascotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class entrenamiento_menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrenamiento_menu)

        var button:ImageView = findViewById(R.id.backEntrenamiento)
        button.setOnClickListener {
            val intent = Intent(this, menu::class.java)
            startActivity(intent)
        }

        var buttonPatita:Button = findViewById(R.id.btnPatita)
        buttonPatita.setOnClickListener {
            val intent = Intent(this, entrenamiento_individual::class.java)
            startActivity(intent)
        }

        var buttonSentarse:Button = findViewById(R.id.btnSentar)
        buttonSentarse.setOnClickListener {
            val intent = Intent(this, entrenamiento_individual::class.java)
            startActivity(intent)
        }

        var buttonPelota:Button = findViewById(R.id.btnPelota)
        buttonPelota.setOnClickListener {
            val intent = Intent(this, entrenamiento_individual::class.java)
            startActivity(intent)
        }
    }


}