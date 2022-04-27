package rojo.ader.mascotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class entrenamiento_menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrenamiento_menu)
    }

    var button:Button = findViewById(R.id.backEntrenamiento)
    button.setOnClickListener {
        val intent = Intent(this@MainActivity, menu::class.java)
        startActivity(intent)
    }
}